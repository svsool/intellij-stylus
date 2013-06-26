// This is a generated file. Not intended for manual editing.
package com.intellij.lang.stylus.parser;

import org.jetbrains.annotations.*;
import com.intellij.lang.LighterASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import com.intellij.openapi.diagnostic.Logger;
import static com.intellij.lang.stylus.StylusTypes.*;
import static com.intellij.lang.stylus.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class StylusParser implements PsiParser {

  public static Logger LOG_ = Logger.getInstance("com.intellij.lang.stylus.parser.StylusParser");

  @NotNull
  public ASTNode parse(IElementType root_, PsiBuilder builder_) {
    int level_ = 0;
    boolean result_;
    builder_ = adapt_builder_(root_, builder_, this);
    if (root_ == STYL_PROPERTY) {
      result_ = property(builder_, level_ + 1);
    }
    else if (root_ == STYL_PROPERTY_NAME) {
      result_ = property_name(builder_, level_ + 1);
    }
    else if (root_ == STYL_PROPERTY_VALUE) {
      result_ = property_value(builder_, level_ + 1);
    }
    else if (root_ == STYL_SELECTOR) {
      result_ = selector(builder_, level_ + 1);
    }
    else if (root_ == STYL_SELECTOR_CLASS) {
      result_ = selector_class(builder_, level_ + 1);
    }
    else if (root_ == STYL_SELECTOR_ID) {
      result_ = selector_id(builder_, level_ + 1);
    }
    else if (root_ == STYL_SELECTOR_PSEUDO) {
      result_ = selector_pseudo(builder_, level_ + 1);
    }
    else if (root_ == STYL_SELECTOR_TAG) {
      result_ = selector_tag(builder_, level_ + 1);
    }
    else {
      Marker marker_ = builder_.mark();
      enterErrorRecordingSection(builder_, level_, _SECTION_RECOVER_, null);
      result_ = parse_root_(root_, builder_, level_);
      exitErrorRecordingSection(builder_, level_, result_, true, _SECTION_RECOVER_, TOKEN_ADVANCER);
      marker_.done(root_);
    }
    return builder_.getTreeBuilt();
  }

  protected boolean parse_root_(final IElementType root_, final PsiBuilder builder_, final int level_) {
    return stylus_file(builder_, level_ + 1);
  }

  /* ********************************************************** */
  // indent property_parts outdent
  public static boolean property(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "property")) return false;
    if (!nextTokenIs(builder_, STYL_INDENT)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, STYL_INDENT);
    result_ = result_ && property_parts(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, STYL_OUTDENT);
    if (result_) {
      marker_.done(STYL_PROPERTY);
    }
    else {
      marker_.rollbackTo();
    }
    return result_;
  }

  /* ********************************************************** */
  // ident ':'?
  public static boolean property_name(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "property_name")) return false;
    if (!nextTokenIs(builder_, STYL_IDENT)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, STYL_IDENT);
    result_ = result_ && property_name_1(builder_, level_ + 1);
    if (result_) {
      marker_.done(STYL_PROPERTY_NAME);
    }
    else {
      marker_.rollbackTo();
    }
    return result_;
  }

  // ':'?
  private static boolean property_name_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "property_name_1")) return false;
    consumeToken(builder_, STYL_COLON);
    return true;
  }

  /* ********************************************************** */
  // property_name property_value
  static boolean property_parts(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "property_parts")) return false;
    if (!nextTokenIs(builder_, STYL_IDENT)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = property_name(builder_, level_ + 1);
    result_ = result_ && property_value(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // ((number unit) | color | number | unit | ',' | ident | '$' | '-' | "\"" | "\\")* ';'?
  public static boolean property_value(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "property_value")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<property value>");
    result_ = property_value_0(builder_, level_ + 1);
    result_ = result_ && property_value_1(builder_, level_ + 1);
    if (result_) {
      marker_.done(STYL_PROPERTY_VALUE);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  // ((number unit) | color | number | unit | ',' | ident | '$' | '-' | "\"" | "\\")*
  private static boolean property_value_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "property_value_0")) return false;
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!property_value_0_0(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "property_value_0");
        break;
      }
      offset_ = next_offset_;
    }
    return true;
  }

  // (number unit) | color | number | unit | ',' | ident | '$' | '-' | "\"" | "\\"
  private static boolean property_value_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "property_value_0_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = property_value_0_0_0(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, STYL_COLOR);
    if (!result_) result_ = consumeToken(builder_, STYL_NUMBER);
    if (!result_) result_ = consumeToken(builder_, STYL_UNIT);
    if (!result_) result_ = consumeToken(builder_, STYL_COMMA);
    if (!result_) result_ = consumeToken(builder_, STYL_IDENT);
    if (!result_) result_ = consumeToken(builder_, STYL_DOLLAR);
    if (!result_) result_ = consumeToken(builder_, STYL_OP_MINUS);
    if (!result_) result_ = consumeToken(builder_, "\"");
    if (!result_) result_ = consumeToken(builder_, "\\");
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // number unit
  private static boolean property_value_0_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "property_value_0_0_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeTokens(builder_, 0, STYL_NUMBER, STYL_UNIT);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // ';'?
  private static boolean property_value_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "property_value_1")) return false;
    consumeToken(builder_, STYL_SEMI);
    return true;
  }

  /* ********************************************************** */
  // selector_
  public static boolean selector(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "selector")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<selector>");
    result_ = selector_(builder_, level_ + 1);
    if (result_) {
      marker_.done(STYL_SELECTOR);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  /* ********************************************************** */
  // selector_id
  //   | selector_class
  //   | selector_pseudo
  //   | selector_tag
  static boolean selector_(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "selector_")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = selector_id(builder_, level_ + 1);
    if (!result_) result_ = selector_class(builder_, level_ + 1);
    if (!result_) result_ = selector_pseudo(builder_, level_ + 1);
    if (!result_) result_ = selector_tag(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // '.'selector_string
  public static boolean selector_class(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "selector_class")) return false;
    if (!nextTokenIs(builder_, STYL_DOT)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, STYL_DOT);
    result_ = result_ && consumeToken(builder_, STYL_SELECTOR_STRING);
    if (result_) {
      marker_.done(STYL_SELECTOR_CLASS);
    }
    else {
      marker_.rollbackTo();
    }
    return result_;
  }

  /* ********************************************************** */
  // '#'selector_string
  public static boolean selector_id(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "selector_id")) return false;
    if (!nextTokenIs(builder_, STYL_RADIX)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, STYL_RADIX);
    result_ = result_ && consumeToken(builder_, STYL_SELECTOR_STRING);
    if (result_) {
      marker_.done(STYL_SELECTOR_ID);
    }
    else {
      marker_.rollbackTo();
    }
    return result_;
  }

  /* ********************************************************** */
  // (selector_id | selector_class | selector_tag)'['selector_string "^"? "=" "\"" selector_string "\"" "]"
  public static boolean selector_pseudo(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "selector_pseudo")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<selector pseudo>");
    result_ = selector_pseudo_0(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, STYL_BRACKET_LEFT);
    result_ = result_ && consumeToken(builder_, STYL_SELECTOR_STRING);
    result_ = result_ && selector_pseudo_3(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, STYL_OP_EQ);
    result_ = result_ && consumeToken(builder_, "\"");
    result_ = result_ && consumeToken(builder_, STYL_SELECTOR_STRING);
    result_ = result_ && consumeToken(builder_, "\"");
    result_ = result_ && consumeToken(builder_, STYL_BRACKET_RIGHT);
    if (result_) {
      marker_.done(STYL_SELECTOR_PSEUDO);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  // selector_id | selector_class | selector_tag
  private static boolean selector_pseudo_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "selector_pseudo_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = selector_id(builder_, level_ + 1);
    if (!result_) result_ = selector_class(builder_, level_ + 1);
    if (!result_) result_ = selector_tag(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // "^"?
  private static boolean selector_pseudo_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "selector_pseudo_3")) return false;
    consumeToken(builder_, STYL_HAT);
    return true;
  }

  /* ********************************************************** */
  // selector_string
  public static boolean selector_tag(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "selector_tag")) return false;
    if (!nextTokenIs(builder_, STYL_SELECTOR_STRING)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, STYL_SELECTOR_STRING);
    if (result_) {
      marker_.done(STYL_SELECTOR_TAG);
    }
    else {
      marker_.rollbackTo();
    }
    return result_;
  }

  /* ********************************************************** */
  // selector
  //  | property
  static boolean statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statement")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = selector(builder_, level_ + 1);
    if (!result_) result_ = property(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // !<<eof>> stylus_entry*
  static boolean stylus_entries(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "stylus_entries")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = stylus_entries_0(builder_, level_ + 1);
    result_ = result_ && stylus_entries_1(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // !<<eof>>
  private static boolean stylus_entries_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "stylus_entries_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_NOT_, null);
    result_ = !eof(builder_, level_ + 1);
    marker_.rollbackTo();
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_NOT_, null);
    return result_;
  }

  // stylus_entry*
  private static boolean stylus_entries_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "stylus_entries_1")) return false;
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!stylus_entry(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "stylus_entries_1");
        break;
      }
      offset_ = next_offset_;
    }
    return true;
  }

  /* ********************************************************** */
  // statement
  //   | '{' | '}' | '(' | ')' | '[' | ']' | ':' | '.' | ';' | ','  | '$' | '#' | '>' | '&' | '+' | '-' | '*' | '/' | '=' | '!' | '^'
  static boolean stylus_entry(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "stylus_entry")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = statement(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, STYL_CURLY_LEFT);
    if (!result_) result_ = consumeToken(builder_, STYL_CURLY_RIGHT);
    if (!result_) result_ = consumeToken(builder_, STYL_PAR_LEFT);
    if (!result_) result_ = consumeToken(builder_, STYL_PAR_RIGHT);
    if (!result_) result_ = consumeToken(builder_, STYL_BRACKET_LEFT);
    if (!result_) result_ = consumeToken(builder_, STYL_BRACKET_RIGHT);
    if (!result_) result_ = consumeToken(builder_, STYL_COLON);
    if (!result_) result_ = consumeToken(builder_, STYL_DOT);
    if (!result_) result_ = consumeToken(builder_, STYL_SEMI);
    if (!result_) result_ = consumeToken(builder_, STYL_COMMA);
    if (!result_) result_ = consumeToken(builder_, STYL_DOLLAR);
    if (!result_) result_ = consumeToken(builder_, STYL_RADIX);
    if (!result_) result_ = consumeToken(builder_, STYL_OP_GT);
    if (!result_) result_ = consumeToken(builder_, STYL_AMP);
    if (!result_) result_ = consumeToken(builder_, STYL_OP_PLUS);
    if (!result_) result_ = consumeToken(builder_, STYL_OP_MINUS);
    if (!result_) result_ = consumeToken(builder_, STYL_OP_AR_MUL);
    if (!result_) result_ = consumeToken(builder_, STYL_OP_AR_DIV);
    if (!result_) result_ = consumeToken(builder_, STYL_OP_EQ);
    if (!result_) result_ = consumeToken(builder_, STYL_OP_EXL);
    if (!result_) result_ = consumeToken(builder_, STYL_HAT);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // stylus_entries*
  static boolean stylus_file(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "stylus_file")) return false;
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!stylus_entries(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "stylus_file");
        break;
      }
      offset_ = next_offset_;
    }
    return true;
  }

}
