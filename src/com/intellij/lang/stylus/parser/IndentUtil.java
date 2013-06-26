package com.intellij.lang.stylus.parser;

public class IndentUtil
{
  public static int calcIndent(CharSequence text, int position, int tabSize)
  {
    int result = 0;

    while (position < text.length()) {
      char c = text.charAt(position);
      if (!Character.isWhitespace(c)) {
        break;
      }
      if (c == '\n')
      {
        result = 0;
      }
      else if (c == '\t') {
        result += tabSize;
      }
      else {
        result++;
      }
      position++;
    }
    return result;
  }

  public static int calcSecondLineIndent(String text, int tabSize)
  {
    int i = text.indexOf('\n');
    if (i == -1) {
      return -1;
    }

    return calcIndent(text, i + 1, tabSize);
  }
}