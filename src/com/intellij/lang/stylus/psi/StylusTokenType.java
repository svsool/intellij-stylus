/*!
 * Stylus plugin for Intellij IDEA
 *
 * Copyright 2013, svsool <svsool@bk.ru>
 */

package com.intellij.lang.stylus.psi;

import com.intellij.lang.stylus.StylusLanguage;
import com.intellij.psi.tree.IElementType;

public class StylusTokenType extends IElementType
{
	public StylusTokenType(String debugName)
	{
		super(debugName, StylusLanguage.INSTANCE);
	}
}
