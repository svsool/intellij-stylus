package com.intellij.lang.stylus.psi;

import org.jetbrains.annotations.NotNull;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;

/**
 * @author VISTALL
 * @since 20:28/26.06.13
 */
public abstract class StylusElement extends ASTWrapperPsiElement
{
	public StylusElement(@NotNull ASTNode node)
	{
		super(node);
	}

	@Override
	public void accept(@NotNull PsiElementVisitor visitor)
	{
		if(visitor instanceof StylusElementVisitor)
		{
			accept((StylusElementVisitor) visitor);
		}
		else
		{
			visitor.visitElement(this);
		}
	}

	protected abstract void accept(@NotNull StylusElementVisitor elementVisitor);
}
