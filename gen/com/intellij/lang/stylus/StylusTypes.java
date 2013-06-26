// This is a generated file. Not intended for manual editing.
package com.intellij.lang.stylus;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.lang.stylus.psi.StylusElementType;
import com.intellij.lang.stylus.psi.StylusTokenType;
import com.intellij.lang.stylus.psi.impl.*;

public interface StylusTypes {

  IElementType STYL_PROPERTY = new StylusElementType("STYL_PROPERTY");
  IElementType STYL_PROPERTY_NAME = new StylusElementType("STYL_PROPERTY_NAME");
  IElementType STYL_PROPERTY_VALUE = new StylusElementType("STYL_PROPERTY_VALUE");
  IElementType STYL_SELECTOR = new StylusElementType("STYL_SELECTOR");
  IElementType STYL_SELECTOR_CLASS = new StylusElementType("STYL_SELECTOR_CLASS");
  IElementType STYL_SELECTOR_ID = new StylusElementType("STYL_SELECTOR_ID");
  IElementType STYL_SELECTOR_PSEUDO = new StylusElementType("STYL_SELECTOR_PSEUDO");
  IElementType STYL_SELECTOR_TAG = new StylusElementType("STYL_SELECTOR_TAG");

  IElementType STYL_AMP = new StylusTokenType("&");
  IElementType STYL_BRACKET_LEFT = new StylusTokenType("[");
  IElementType STYL_BRACKET_RIGHT = new StylusTokenType("]");
  IElementType STYL_COLON = new StylusTokenType(":");
  IElementType STYL_COLOR = new StylusTokenType("color");
  IElementType STYL_COMMA = new StylusTokenType(",");
  IElementType STYL_CURLY_LEFT = new StylusTokenType("{");
  IElementType STYL_CURLY_RIGHT = new StylusTokenType("}");
  IElementType STYL_DOLLAR = new StylusTokenType("$");
  IElementType STYL_DOT = new StylusTokenType(".");
  IElementType STYL_HAT = new StylusTokenType("^");
  IElementType STYL_IDENT = new StylusTokenType("ident");
  IElementType STYL_INDENT = new StylusTokenType("indent");
  IElementType STYL_NUMBER = new StylusTokenType("number");
  IElementType STYL_OP_AR_DIV = new StylusTokenType("/");
  IElementType STYL_OP_AR_MUL = new StylusTokenType("*");
  IElementType STYL_OP_EQ = new StylusTokenType("=");
  IElementType STYL_OP_EXL = new StylusTokenType("!");
  IElementType STYL_OP_GT = new StylusTokenType(">");
  IElementType STYL_OP_MINUS = new StylusTokenType("-");
  IElementType STYL_OP_PLUS = new StylusTokenType("+");
  IElementType STYL_OUTDENT = new StylusTokenType("outdent");
  IElementType STYL_PAR_LEFT = new StylusTokenType("(");
  IElementType STYL_PAR_RIGHT = new StylusTokenType(")");
  IElementType STYL_RADIX = new StylusTokenType("#");
  IElementType STYL_SELECTOR_STRING = new StylusTokenType("selector_string");
  IElementType STYL_SEMI = new StylusTokenType(";");
  IElementType STYL_UNIT = new StylusTokenType("unit");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == STYL_PROPERTY) {
        return new StylusPropertyImpl(node);
      }
      else if (type == STYL_PROPERTY_NAME) {
        return new StylusPropertyNameImpl(node);
      }
      else if (type == STYL_PROPERTY_VALUE) {
        return new StylusPropertyValueImpl(node);
      }
      else if (type == STYL_SELECTOR) {
        return new StylusSelectorImpl(node);
      }
      else if (type == STYL_SELECTOR_CLASS) {
        return new StylusSelectorClassImpl(node);
      }
      else if (type == STYL_SELECTOR_ID) {
        return new StylusSelectorIdImpl(node);
      }
      else if (type == STYL_SELECTOR_PSEUDO) {
        return new StylusSelectorPseudoImpl(node);
      }
      else if (type == STYL_SELECTOR_TAG) {
        return new StylusSelectorTagImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
