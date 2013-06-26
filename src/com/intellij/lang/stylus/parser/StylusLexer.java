/*!
 * Stylus plugin for Intellij IDEA
 *
 * Copyright 2013, svsool <svsool@bk.ru>
 */

package com.intellij.lang.stylus.parser;

import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.LookAheadLexer;
import com.intellij.lexer.MergingLexerAdapter;
import com.intellij.psi.tree.IElementType;

import static com.intellij.lang.stylus.StylusParserDefinition.COMMENTS;

public class StylusLexer extends LookAheadLexer {
  public StylusLexer() {
    super(new MergingLexerAdapter(new FlexAdapter(new _StylusLexer() {
        @Override
        public IElementType advance() throws java.io.IOException {
//            System.out.println("advance method used");
//            if (super.isLookAhead)
//            {
//                super.isLookAhead = false;
//                return super.advance();
//            }
//            return !super.isStashEmpty() ? super.stashed() : super.advance();
            return super.advance();
        }
    }), COMMENTS));
  }
}
