package com.intellij.lang.stylus.psi;

import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import com.intellij.lang.stylus.StylusLanguage;
import com.intellij.psi.tree.IElementType;

public class StylusElementType extends IElementType
{
	public StylusElementType(@NotNull @NonNls String debugName)
	{
		super(debugName, StylusLanguage.INSTANCE);
	}
}