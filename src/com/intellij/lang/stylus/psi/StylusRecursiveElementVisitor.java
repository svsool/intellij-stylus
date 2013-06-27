package com.intellij.lang.stylus.psi;

import com.intellij.psi.PsiElement;

/**
 * @author VISTALL
 * @since 17:22/27.06.13
 */
public class StylusRecursiveElementVisitor extends StylusElementVisitor
{
	@Override
	public void visitElement(PsiElement element)
	{
		element.acceptChildren(this);
	}
}
