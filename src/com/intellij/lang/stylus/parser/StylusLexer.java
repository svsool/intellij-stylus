/*!
 * Stylus plugin for Intellij IDEA
 *
 * Copyright 2013, svsool <svsool@bk.ru>
 */

package com.intellij.lang.stylus.parser;

import com.intellij.lang.stylus.psi.StylusTokenTypes;
import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.Lexer;
import com.intellij.lexer.LookAheadLexer;
import com.intellij.psi.tree.IElementType;

public class StylusLexer extends LookAheadLexer implements StylusTokenTypes
{
	private static final int NONE = 0;
	private static final int SELECTOR_ENTERED = 1;
	private static final int SELECTOR_ENDED = 2;
	private static final int PROPERTY_NAME_WAIT = 3;
	private static final int PROPERTY = 4;

	private int myState = NONE;

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
				if(tokenType == IDENTIFIER)
				{
					advanceAs(baseLexer, SELECTOR_TAG_NAME);
					myState = SELECTOR_ENTERED;
					return;
				}
				break;
			case SELECTOR_ENTERED:
				if(tokenType == NEWLINE)
				{
					myState = SELECTOR_ENDED;
				}
				break;
			case SELECTOR_ENDED:
				boolean found = false;
				while(true)
				{
					IElementType temp = baseLexer.getTokenType();
					if(temp == WHITESPACE)
					{
						baseLexer.advance();
						found = true;
					}
					else
					{
						break;
					}
				}

				if(found)
				{
					myState = PROPERTY_NAME_WAIT;
					addToken(baseLexer.getTokenStart(), INDENT);
					return;
				}
				break;
			case PROPERTY_NAME_WAIT:
				if(tokenType == IDENTIFIER)
				{
					advanceAs(baseLexer, PROPERTY_NAME);
					myState = PROPERTY;
					return;
				}
				break;
			case PROPERTY:
				if(tokenType == NEWLINE)
				{
					myState = SELECTOR_ENDED;
				}
				break;
		}

		super.lookAhead(baseLexer);
	}
}
