/*!
 * Stylus plugin for Intellij IDEA
 *
 * Copyright 2013, svsool <svsool@bk.ru>
 */

package com.intellij.lang.stylus;

import com.intellij.lang.Language;

public class StylusLanguage extends Language
{
	public static final StylusLanguage INSTANCE = new StylusLanguage();

	protected StylusLanguage()
	{
		super("STYLUS");
	}

	@Override
	public String getDisplayName()
	{
		return "Stylus language";
	}
}
