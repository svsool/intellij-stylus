/*!
 * Stylus plugin for Intellij IDEA
 *
 * Copyright 2013, svsool <svsool@bk.ru>
 */

package com.intellij.lang.stylus.editor;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.SyntaxHighlighterColors;
import com.intellij.openapi.editor.colors.CodeInsightColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.stylus.StylusParserDefinition;
import com.intellij.lang.stylus.parser.StylusLexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.XmlHighlighterColors;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

import com.intellij.lang.stylus.StylusTypes;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class StylusSyntaxHighlighter extends SyntaxHighlighterBase {

    public static final TextAttributesKey STYL_IDENT = TextAttributesKey.createTextAttributesKey("STYL.IDENT", XmlHighlighterColors.HTML_TAG_NAME);

    public static final TextAttributesKey STYL_COMMENT = TextAttributesKey.createTextAttributesKey("STYL.COMMENT", XmlHighlighterColors.HTML_COMMENT);

    public static final TextAttributesKey STYL_PROPERTY_NAME = TextAttributesKey.createTextAttributesKey("STYL.PROPERTY_NAME", XmlHighlighterColors.HTML_ATTRIBUTE_NAME);

    public static final TextAttributesKey STYL_PROPERTY_VALUE = TextAttributesKey.createTextAttributesKey("STYL.PROPERTY_VALUE", XmlHighlighterColors.HTML_ATTRIBUTE_VALUE);

    public static final TextAttributesKey STYL_TAG_NAME = TextAttributesKey.createTextAttributesKey("STYL.TAG_NAME", XmlHighlighterColors.HTML_TAG_NAME);

    public static final TextAttributesKey STYL_STRING = TextAttributesKey.createTextAttributesKey("STYL.STRING", DefaultLanguageHighlighterColors.STRING);

    public static final TextAttributesKey STYL_NUMBER = TextAttributesKey.createTextAttributesKey("STYL.NUMBER", DefaultLanguageHighlighterColors.NUMBER);

    public static final TextAttributesKey STYL_KEYWORD = TextAttributesKey.createTextAttributesKey("STYL.KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);

    public static final TextAttributesKey STYL_IMPORTANT = TextAttributesKey.createTextAttributesKey("STYL.IMPORTANT", DefaultLanguageHighlighterColors.KEYWORD);

    public static final TextAttributesKey STYL_FUNCTION = TextAttributesKey.createTextAttributesKey("STYL.FUNCTION", XmlHighlighterColors.HTML_TAG_NAME);

    public static final TextAttributesKey STYL_URL = TextAttributesKey.createTextAttributesKey("STYL.URL", XmlHighlighterColors.HTML_ATTRIBUTE_VALUE);

    public static final TextAttributesKey STYL_COLOR = TextAttributesKey.createTextAttributesKey("STYL.COLOR", STYL_IDENT);

    public static final TextAttributesKey ILLEGAL = createTextAttributesKey("STYL.ILLEGAL", SyntaxHighlighterColors.INVALID_STRING_ESCAPE.getDefaultAttributes());


    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new StylusLexer();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (StylusParserDefinition.COMMENTS.contains(tokenType)) {
            return pack(STYL_COMMENT);
        } else if (tokenType.equals(StylusTypes.STYL_SELECTOR_STRING)) {
            return pack(STYL_TAG_NAME);
        } else if (tokenType.equals(StylusTypes.STYL_IDENT)) {
            return pack(STYL_PROPERTY_NAME);
        } else if (tokenType.equals(StylusTypes.STYL_UNIT)) {
            return pack(STYL_STRING);
        } else if (tokenType.equals(StylusTypes.STYL_NUMBER)) {
            return pack(STYL_NUMBER);
//        } else if (tokenType.equals(STYL_CURLY_LEFT) || tokenType.equals(STYL_CURLY_RIGHT)) {
//            return pack(BRACKETS);
        } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return pack(ILLEGAL);
        }
        return EMPTY;
    }
}