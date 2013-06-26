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

public class StylusPropertyNameImpl extends ASTWrapperPsiElement implements StylusPropertyName {

  public StylusPropertyNameImpl(ASTNode node) {
    super(node);
  }

  @Override
  @NotNull
  public PsiElement getIdent() {
    return findNotNullChildByType(STYL_IDENT);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof StylusVisitor) ((StylusVisitor)visitor).visitPropertyName(this);
    else super.accept(visitor);
  }

}
