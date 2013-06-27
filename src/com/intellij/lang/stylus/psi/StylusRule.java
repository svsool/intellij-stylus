package com.intellij.lang.stylus.psi;

import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNameIdentifierOwner;
import com.intellij.util.IncorrectOperationException;

/**
 * @author VISTALL
 * @since 20:27/26.06.13
 */
public class StylusRule extends StylusElement implements PsiNameIdentifierOwner
{
	public StylusRule(@NotNull ASTNode node)
	{
		super(node);
	}

	@Override
	protected void accept(@NotNull StylusElementVisitor elementVisitor)
	{
		elementVisitor.visitRule(this);
	}

	@Override
	public String getName()
	{
		final PsiElement nameIdentifier = getNameIdentifier();
		return nameIdentifier != null ? nameIdentifier.getText() : null;
	}

	@Override
	public PsiElement setName(@NonNls @NotNull String name) throws IncorrectOperationException
	{
		return null;
	}

	@Nullable
	@Override
	public PsiElement getNameIdentifier()
	{
		return findChildByType(StylusTokenTypes.IDENTIFIER);
	}
}
