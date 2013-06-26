// This is a generated file. Not intended for manual editing.
package com.intellij.lang.stylus.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface StylusSelector extends PsiElement {

  @Nullable
  StylusSelectorClass getSelectorClass();

  @Nullable
  StylusSelectorId getSelectorId();

  @Nullable
  StylusSelectorPseudo getSelectorPseudo();

  @Nullable
  StylusSelectorTag getSelectorTag();

}
