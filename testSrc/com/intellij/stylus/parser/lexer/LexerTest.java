package com.intellij.stylus.parser.lexer;

import com.intellij.lang.stylus.parser.StylusLexer;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.tree.IElementType;

/**
 * @author VISTALL
 * @since 19:15/26.06.13
 */
public class LexerTest
{
	public static void main(String[] args)
	{
		String text =
				"body\n" +
				"  font 12px Helvetica, Arial, sans-serif\n" +
				"  border-radius 5px\n" +
				"a.button\n" +
				"  -webkit-border-radius 5px\n" +
				"  -moz-border-radius 5px\n" +
				"  border-radius 5px";

		StylusLexer lexer = new StylusLexer();
		lexer.start(text);

		IElementType type = null;
		while((type = lexer.getTokenType()) != null)
		{
			System.out.println(type + "[" + StringUtil.escapeStringCharacters(lexer.getTokenText()) + "] " /*+ (lexer.getTokenEnd() - lexer.getTokenStart())*/);
			lexer.advance();
		}
	}
}
