package com.intellij.lang.stylus.psi;

import com.intellij.psi.tree.IElementType;

public interface StylusTokenTypes
{
	IElementType COMMENT = new StylusTokenType("COMMENT");
	IElementType BLOCK_COMMENT = new StylusTokenType("BLOCK_COMMENT");

	IElementType NEWLINE = new StylusTokenType("NEWLINE");
	IElementType WHITESPACE = new StylusTokenType("WHITESPACE");
	IElementType TAB = new StylusTokenType("TAB");
	IElementType KEYWORD = new StylusTokenType("KEYWORD");

	IElementType AMP = new StylusTokenType("&");
	IElementType SHARP = new StylusTokenType("SHARP");
	IElementType BRACKET_LEFT = new StylusTokenType("[");
	IElementType BRACKET_RIGHT = new StylusTokenType("]");
	IElementType COLON = new StylusTokenType(":");
	IElementType COLOR = new StylusTokenType("color");
	IElementType COMMA = new StylusTokenType("COMMA");
	IElementType CURLY_LEFT = new StylusTokenType("{");
	IElementType CURLY_RIGHT = new StylusTokenType("}");
	IElementType DOLLAR = new StylusTokenType("$");
	IElementType DOT = new StylusTokenType("DOT");
	IElementType HAT = new StylusTokenType("^");

	IElementType IDENTIFIER = new StylusTokenType("IDENTIFIER");

	IElementType INDENT = new StylusTokenType("INDENT");

	IElementType NUMBER = new StylusTokenType("NUMBER");

	IElementType OP_AR_DIV = new StylusTokenType("/");
	IElementType OP_AR_MUL = new StylusTokenType("*");
	IElementType OP_EQ = new StylusTokenType("=");
	IElementType OP_EXL = new StylusTokenType("!");
	IElementType OP_GT = new StylusTokenType(">");
	IElementType OP_MINUS = new StylusTokenType("-");
	IElementType OP_PLUS = new StylusTokenType("PLUS");
	IElementType OUTDENT = new StylusTokenType("outdent");
	IElementType PAR_LEFT = new StylusTokenType("(");
	IElementType PAR_RIGHT = new StylusTokenType(")");
	IElementType RADIX = new StylusTokenType("#");
	IElementType SELECTOR_STRING = new StylusTokenType("selector_string");
	IElementType SEMI = new StylusTokenType(";");
	IElementType UNIT = new StylusTokenType("unit");
}
