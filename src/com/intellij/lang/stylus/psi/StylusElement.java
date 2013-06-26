package com.intellij.lang.stylus.psi;

import org.jetbrains.annotations.NotNull;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;

/**
 * @author VISTALL
 * @since 20:28/26.06.13
 */
public class StylusElement extends ASTWrapperPsiElement
{
	public StylusElement(@NotNull ASTNode node)
	{
		super(node);
	}
}
