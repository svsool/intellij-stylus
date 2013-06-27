/*!
 * Stylus plugin for Intellij IDEA
 *
 * Copyright 2013, svsool <svsool@bk.ru>
 */

package com.intellij.lang.stylus.editor;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

import java.util.HashMap;
import java.util.Map;

import org.jetbrains.annotations.NotNull;
import com.intellij.lang.stylus.parser.StylusLexer;
import com.intellij.lang.stylus.psi.StylusTokenTypes;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.SyntaxHighlighterColors;
import com.intellij.openapi.editor.XmlHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;

public class StylusSyntaxHighlighter extends SyntaxHighlighterBase implements StylusTokenTypes
{

	public static final TextAttributesKey STYLUS_IDENTIFIER = TextAttributesKey.createTextAttributesKey("STYLUS.IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER);

	public static final TextAttributesKey STYLUS_COMMENT = TextAttributesKey.createTextAttributesKey("STYLUS.COMMENT", XmlHighlighterColors.HTML_COMMENT);

	public static final TextAttributesKey STYLUS_PROPERTY_NAME = TextAttributesKey.createTextAttributesKey("STYLUS.PROPERTY_NAME", XmlHighlighterColors.HTML_ATTRIBUTE_NAME);

	public static final TextAttributesKey STYLUS_PROPERTY_VALUE = TextAttributesKey.createTextAttributesKey("STYLUS.PROPERTY_VALUE", XmlHighlighterColors.HTML_ATTRIBUTE_VALUE);

	public static final TextAttributesKey STYLUS_TAG_NAME = TextAttributesKey.createTextAttributesKey("STYLUS.TAG_NAME", XmlHighlighterColors.HTML_TAG_NAME);

	public static final TextAttributesKey STYLUS_STRING = TextAttributesKey.createTextAttributesKey("STYLUS.STRING", DefaultLanguageHighlighterColors.STRING);

	public static final TextAttributesKey STYLUS_NUMBER = TextAttributesKey.createTextAttributesKey("STYLUS.NUMBER", DefaultLanguageHighlighterColors.NUMBER);

	public static final TextAttributesKey STYLUS_KEYWORD = TextAttributesKey.createTextAttributesKey("STYLUS.KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);

	public static final TextAttributesKey STYLUS_SELECTOR_NAME = TextAttributesKey.createTextAttributesKey("STYLUS.SELECTOR_NAME", DefaultLanguageHighlighterColors.KEYWORD);

	public static final TextAttributesKey STYLUS_FUNCTION = TextAttributesKey.createTextAttributesKey("STYLUS.FUNCTION", XmlHighlighterColors.HTML_TAG_NAME);

	public static final TextAttributesKey STYLUS_URL = TextAttributesKey.createTextAttributesKey("STYLUS.URL", XmlHighlighterColors.HTML_ATTRIBUTE_VALUE);

	public static final TextAttributesKey STYLUS_COLOR = TextAttributesKey.createTextAttributesKey("STYLUS.COLOR", STYLUS_IDENTIFIER);

	public static final TextAttributesKey ILLEGAL = createTextAttributesKey("STYLUS.ILLEGAL", SyntaxHighlighterColors.INVALID_STRING_ESCAPE);

	private static Map<IElementType, TextAttributesKey> ourTextAttributesKeys = new HashMap<IElementType, TextAttributesKey>();

	static
	{
		fillMap(ourTextAttributesKeys, STYLUS_KEYWORD, KEYWORD);
	}

	@NotNull
	@Override
	public Lexer getHighlightingLexer()
	{
		return new StylusLexer();
	}

	@NotNull
	@Override
	public TextAttributesKey[] getTokenHighlights(IElementType tokenType)
	{
		return pack(ourTextAttributesKeys.get(tokenType));
	}
}