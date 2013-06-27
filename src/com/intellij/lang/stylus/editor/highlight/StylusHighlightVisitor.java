package com.intellij.lang.stylus.editor.highlight;

import org.jetbrains.annotations.NotNull;
import com.intellij.codeInsight.daemon.impl.HighlightInfo;
import com.intellij.codeInsight.daemon.impl.HighlightInfoType;
import com.intellij.codeInsight.daemon.impl.HighlightVisitor;
import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder;
import com.intellij.lang.stylus.editor.StylusSyntaxHighlighter;
import com.intellij.lang.stylus.psi.StylusFile;
import com.intellij.lang.stylus.psi.StylusProperty;
import com.intellij.lang.stylus.psi.StylusRecursiveElementVisitor;
import com.intellij.lang.stylus.psi.StylusRule;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;

/**
 * @author VISTALL
 * @since 17:18/27.06.13
 */
public class StylusHighlightVisitor extends StylusRecursiveElementVisitor implements HighlightVisitor
{
	private HighlightInfoHolder myHolder;

	@Override
	public void visitRule(StylusRule rule)
	{
		super.visitRule(rule);
		final PsiElement nameIdentifier = rule.getNameIdentifier();
		if(nameIdentifier != null)
		{
			HighlightInfo.Builder builder = HighlightInfo.newHighlightInfo(HighlightInfoType.INFORMATION);
			builder.textAttributes(StylusSyntaxHighlighter.STYLUS_SELECTOR_NAME);
			builder.range(nameIdentifier);

			myHolder.add(builder.create());
		}
	}

	@Override
	public void visitProperty(StylusProperty property)
	{
		super.visitProperty(property);

		final PsiElement nameIdentifier = property.getNameIdentifier();
		if(nameIdentifier != null)
		{
			HighlightInfo.Builder builder = HighlightInfo.newHighlightInfo(HighlightInfoType.INFORMATION);
			builder.textAttributes(StylusSyntaxHighlighter.STYLUS_PROPERTY_NAME);
			builder.range(nameIdentifier);

			myHolder.add(builder.create());
		}
	}

	@Override
	public boolean suitableForFile(@NotNull PsiFile file)
	{
		return file instanceof StylusFile;
	}

	@Override
	public void visit(@NotNull PsiElement element)
	{
		element.accept(this);
	}

	@Override
	public boolean analyze(@NotNull PsiFile file, boolean updateWholeFile, @NotNull HighlightInfoHolder holder, @NotNull Runnable action)
	{
		myHolder = holder;
		action.run();
		return true;
	}

	@NotNull
	@Override
	public HighlightVisitor clone()
	{
		return new StylusHighlightVisitor();
	}

	@Override
	public int order()
	{
		return 0;
	}
}
