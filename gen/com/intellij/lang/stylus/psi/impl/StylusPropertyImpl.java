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

public class StylusPropertyImpl extends ASTWrapperPsiElement implements StylusProperty {

  public StylusPropertyImpl(ASTNode node) {
    super(node);
  }

  @Override
  @NotNull
  public StylusPropertyName getPropertyName() {
    return findNotNullChildByClass(StylusPropertyName.class);
  }

  @Override
  @NotNull
  public StylusPropertyValue getPropertyValue() {
    return findNotNullChildByClass(StylusPropertyValue.class);
  }

  @Override
  @NotNull
  public PsiElement getIndent() {
    return findNotNullChildByType(STYL_INDENT);
  }

  @Override
  @NotNull
  public PsiElement getOutdent() {
    return findNotNullChildByType(STYL_OUTDENT);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof StylusVisitor) ((StylusVisitor)visitor).visitProperty(this);
    else super.accept(visitor);
  }

}
