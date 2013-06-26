// This is a generated file. Not intended for manual editing.
package com.intellij.lang.stylus.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.intellij.lang.stylus.StylusTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.stylus.psi.*;

public class StylusSelectorImpl extends ASTWrapperPsiElement implements StylusSelector {

  public StylusSelectorImpl(ASTNode node) {
    super(node);
  }

  @Override
  @Nullable
  public StylusSelectorClass getSelectorClass() {
    return findChildByClass(StylusSelectorClass.class);
  }

  @Override
  @Nullable
  public StylusSelectorId getSelectorId() {
    return findChildByClass(StylusSelectorId.class);
  }

  @Override
  @Nullable
  public StylusSelectorPseudo getSelectorPseudo() {
    return findChildByClass(StylusSelectorPseudo.class);
  }

  @Override
  @Nullable
  public StylusSelectorTag getSelectorTag() {
    return findChildByClass(StylusSelectorTag.class);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof StylusVisitor) ((StylusVisitor)visitor).visitSelector(this);
    else super.accept(visitor);
  }

}
