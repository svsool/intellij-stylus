
package com.intellij.lang.stylus.parser;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;

import java.util.*;
import java.util.regex.*;
import org.jetbrains.annotations.Nullable;

import static com.intellij.lang.stylus.psi.StylusTokenTypes.*;
import static com.intellij.lang.stylus.StylusParserDefinition.*;

%%

%{
  public _StylusLexer() {
    this((java.io.Reader)null);
  }
%}

%class _StylusLexer
%implements FlexLexer
%unicode
%public

%function advance
%type IElementType

%table

ControlCharacter = [\000 - \037]
CommentLine = "//"[^\r\n]*
CommentBlockLine = "/*" !([^]* "*/" [^]*) ("*/")?

Comment = {CommentLine} {CommentLine}*
CommentBlock = {CommentBlockLine} {CommentBlockLine}*

Uppercase = [A-Z]
Lowercase = [a-z]
Letter = {Uppercase} | {Lowercase}

Digit = [0-9]
Integer = {Digit}+
FloatAlias = '.' {Integer}
Float = {Integer} {FloatAlias}
Number = {FloatAlias} | {Float} | {Integer}

RRGGBBAA = #([a-fA-F0-9]{6})
RRGGBB = #([a-fA-F0-9]{4})
RGB = #([a-fA-F0-9]{3})
NN = #([a-fA-F0-9]{2})
N = #([a-fA-F0-9]{1})

Color = {RRGGBBAA} | {RRGGBB} | {RGB} | {NN} | {N}

TAB = \t
NL = \n
WS = [ ]

Identifier = ({Letter} | @ | -) ({Letter} | {Digit} | @ | -)*

%%
{Comment}                     { return COMMENT; }
{CommentBlock}                { return BLOCK_COMMENT; }
{Number} {return NUMBER;}

{WS} {return WHITESPACE; }
{TAB} {return TAB; }
{NL} { return NEWLINE; }
{Identifier} {return IDENTIFIER;}


"+"                            { return OP_PLUS; }
"-"                            { return OP_MINUS; }
"*"                            { return OP_AR_MUL; }
"/"                            { return OP_AR_DIV; }
">"                            { return OP_GT; }
"="                            { return OP_EQ; }
"!"                            { return OP_EXL; }

"("                           { return PAR_LEFT; }
")"                           { return PAR_RIGHT; }
"{"                           { return LBRACE; }
"}"                           { return RBRACE; }
"["                           { return BRACKET_LEFT; }
"]"                           { return BRACKET_RIGHT; }
"#"                           { return SHARP; }
"."                           { return DOT; }
":"                           { return COLON; }
";"                           { return SEMI; }
","                           { return COMMA; }
"#"                           { return RADIX; }
"$"                           { return DOLLAR; }
"&"                           { return AMP; }
"^"                           { return HAT; }

. { return com.intellij.psi.TokenType.BAD_CHARACTER; }

