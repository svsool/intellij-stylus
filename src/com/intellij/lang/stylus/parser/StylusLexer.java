/*!
 * Stylus plugin for Intellij IDEA
 *
 * Copyright 2013, svsool <svsool@bk.ru>
 */

package com.intellij.lang.stylus.parser;

import java.util.ArrayList;
import java.util.List;

import com.intellij.lang.stylus.psi.StylusTokenTypes;
import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.Lexer;
import com.intellij.lexer.LookAheadLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;

public class StylusLexer extends LookAheadLexer implements StylusTokenTypes
{
	private static class TokenInfo
	{
		private IElementType myElementType;
		private int myTokenStart;

		private TokenInfo(IElementType elementType, int tokenStart)
		{
			myElementType = elementType;
			myTokenStart = tokenStart;
		}

		@Override
		public boolean equals(Object obj)
		{
			return obj instanceof TokenInfo && myElementType == ((TokenInfo) obj).myElementType;
		}
	}

	private static final TokenSet INDENT_ELEMENTS = TokenSet.create(TAB, WHITESPACE);

	private static final int NONE = 0;
	private static final int INDENT_ENTERED = 1;

	private int myState = NONE;

	private List<TokenInfo> myPrevIndent;

	public StylusLexer()
	{
		super(new FlexAdapter(new _StylusLexer()));
	}

	@Override
	protected void lookAhead(Lexer baseLexer)
	{
		final IElementType tokenType = baseLexer.getTokenType();
		switch(myState)
		{
			case NONE:
				if(INDENT_ELEMENTS.contains(tokenType))
				{
					List<TokenInfo> currentIndent = new ArrayList<TokenInfo>(5);
					while(true)
					{
						IElementType temp = baseLexer.getTokenType();
						if(INDENT_ELEMENTS.contains(temp))
						{
							baseLexer.advance();

							currentIndent.add(new TokenInfo(temp, baseLexer.getTokenStart()));
						}
						else
						{
							break;
						}
					}

					// no prev indent
					if(myPrevIndent == null)
					{
						myPrevIndent = currentIndent;
						addToken(baseLexer.getTokenStart(), INDENT);
						myState = INDENT_ENTERED;
						return;
					}
					else
					{
						if(indentValidation(baseLexer, currentIndent, myPrevIndent, currentIndent, false))
						{
							myState = INDENT_ENTERED;
							return;
						}
					}
				}
				break;
			case INDENT_ENTERED:
				if(tokenType == NEWLINE)
				{
					myState = NONE;
				}
				break;
		}

		super.lookAhead(baseLexer);
	}

	private boolean indentValidation(Lexer baseLexer, List<TokenInfo> currentIndent, List<TokenInfo> prevIndentItems, List<TokenInfo> currentIndentItems, boolean thisIsChild)
	{
		// if prev indent equal - current
		if(prevIndentItems.equals(currentIndentItems))
		{
			if(!thisIsChild)
			{
				myPrevIndent = currentIndent;
			}
			addToken(baseLexer.getTokenStart(), INDENT);
			return true;
		}
		else
		{
			if(prevIndentItems.size() < currentIndentItems.size())
			{
				// check if current indent is like prev indent
				boolean currentIndentStartWithPrevIndent = true;
				for(int i = 0; i < prevIndentItems.size(); i++)
				{
					TokenInfo prevTokenInfo = prevIndentItems.get(i);
					TokenInfo currentTokenInfo = currentIndentItems.get(i);

					if(prevTokenInfo.myElementType != currentTokenInfo.myElementType)
					{
						currentIndentStartWithPrevIndent = false;
						break;
					}
				}

				// return only one indent - if not like
				if(!currentIndentStartWithPrevIndent)
				{
					myPrevIndent = currentIndent;
					addToken(baseLexer.getTokenStart(), INDENT);
					return true;
				}
				else
				{
					final TokenInfo tokenInfo = currentIndentItems.get(prevIndentItems.size() - 1);

					// add to lexer - indent depend by prev line
					addToken(tokenInfo.myTokenStart, INDENT);

					List<TokenInfo> newCurrentTokens = currentIndentItems.subList(prevIndentItems.size(), currentIndentItems.size());
					return indentValidation(baseLexer, currentIndent, prevIndentItems, newCurrentTokens, true);
				}
			}
			else
			{
				myPrevIndent = currentIndent;
				addToken(baseLexer.getTokenStart(), INDENT);
				return true;
			}
		}
	}
}
