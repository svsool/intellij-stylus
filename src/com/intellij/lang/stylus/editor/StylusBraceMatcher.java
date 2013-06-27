package com.intellij.lang.stylus.editor;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.lang.stylus.psi.StylusTokenTypes;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

/**
 * @author VISTALL
 * @since 19:40/27.06.13
 */
public class StylusBraceMatcher implements PairedBraceMatcher
{
	private static BracePair[] ourPairs = new BracePair[]
	{
		new BracePair(StylusTokenTypes.LBRACE, StylusTokenTypes.RBRACE, true)
	};

	@Override
	public BracePair[] getPairs()
	{
		return ourPairs;
	}

	@Override
	public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType lbraceType, @Nullable IElementType contextType)
	{
		return true;
	}

	@Override
	public int getCodeConstructStart(PsiFile file, int openingBraceOffset)
	{
		return openingBraceOffset;
	}
}