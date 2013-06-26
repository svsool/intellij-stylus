
package com.intellij.lang.stylus.parser;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;

import java.util.*;
import java.util.regex.*;
import org.jetbrains.annotations.Nullable;
import com.intellij.lang.stylus.parser.IndentUtil;
import com.intellij.util.containers.Stack;

import static com.intellij.lang.stylus.StylusTypes.*;
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

// see http://www.unicode.org/unicode/reports/tr18/
WSP        = [ \t\b]
WSPNL      = [\u2028\u2029\u000A\u000B\u000C\u000D\u0085\t\b\ ]
NL         = [\u2028\u2029\u000A\u000B\u000C\u000D\u0085] | \u000D\u000A
NNL        = [^\u2028\u2029\u000A\u000B\u000C\u000D\u0085]

Tabs = ([\t]*)[ \t]*
Spaces = ([ \t]*)
IndentParts = {Tabs} | {Spaces}
Indent = {NL} {WSP}+

Unit = em|ex|ch|rem|vw|vh|vmin|cm|mm|in|pt|pc|px|%

Ident = ({Letter} | @ | -) ({Letter} | {Digit} | @ | -)*
Selector = ('.' | '#')? {Ident}


%%
  {Comment}                     { return STYL_COMMENT; }
  {CommentBlock}                { return STYL_BLOCK_COMMENT; }
  {Number} {return STYL_NUMBER;}
  {Unit} {return STYL_UNIT;}
  {Color} {return STYL_COLOR;}

 {Indent} { return newline(); }
 {WSP}* {return com.intellij.psi.TokenType.WHITE_SPACE; }
 {NL} {return com.intellij.psi.TokenType.WHITE_SPACE; }

  {Selector} / {WSP}* {Indent} {return STYL_SELECTOR_STRING;}
  {Selector} / {WSP}* ({Comment} | {CommentBlock}) {WSPNL}* {return STYL_SELECTOR_STRING;}
  {Selector} / {WSP}* "{" {return STYL_SELECTOR_STRING;}
  {Selector} / {WSP}* "," {WSP}* {NL}? {return STYL_SELECTOR_STRING;}
  {Ident} {return STYL_IDENT;}

  /* Literals */
       //{Number}                      { return STYL_NUMBER; }

        /* operators */
         "+"                            { return STYL_OP_PLUS; }
         "-"                            { return STYL_OP_MINUS; }
         "*"                            { return STYL_OP_AR_MUL; }
         "/"                            { return STYL_OP_AR_DIV; }
         ">"                            { return STYL_OP_GT; }
         "="                            { return STYL_OP_EQ; }
         "!"                            { return STYL_OP_EXL; }

       /*separators*/
         "("                           { return STYL_PAR_LEFT; }
         ")"                           { return STYL_PAR_RIGHT; }
         "{"                           {return STYL_CURLY_LEFT; }
         "}"                           { return STYL_CURLY_RIGHT; }
         "["                           { return STYL_BRACKET_LEFT; }
         "]"                           { return STYL_BRACKET_RIGHT; }
         "."                           { return STYL_DOT; }
         ":"                           { return STYL_COLON; }
         ";"                           { return STYL_SEMI; }
         ","                           { return STYL_COMMA; }
         "#"                           { return STYL_RADIX; }
         "$"                           { return STYL_DOLLAR; }
         "&"                           { return STYL_AMP; }
         "^"                           { return STYL_HAT; }


. { return com.intellij.psi.TokenType.BAD_CHARACTER; }

