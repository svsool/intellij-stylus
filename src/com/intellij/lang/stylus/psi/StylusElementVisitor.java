package com.intellij.lang.stylus.psi;

import com.intellij.psi.PsiElementVisitor;

/**
 * @author VISTALL
 * @since 17:19/27.06.13
 */
public class StylusElementVisitor extends PsiElementVisitor
{
	public void visitProperty(StylusProperty property)
	{
		visitElement(property);
	}

	public void visitRule(StylusRule rule)
	{
		visitElement(rule);
	}
}
