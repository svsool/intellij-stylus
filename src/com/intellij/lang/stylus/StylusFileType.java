/*!
 * Stylus plugin for Intellij IDEA
 *
 * Copyright 2013, svsool <svsool@bk.ru>
 */
package com.intellij.lang.stylus;

import javax.swing.Icon;

import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.intellij.openapi.fileTypes.LanguageFileType;

public class StylusFileType extends LanguageFileType
{
	public static final StylusFileType INSTANCE = new StylusFileType();
	@NonNls
	public static final String DEFAULT_EXTENSION = "styl";

	private StylusFileType()
	{
		super(StylusLanguage.INSTANCE);
	}

	@NotNull
	@Override
	public String getName()
	{
		return "STYLUS";
	}

	@NotNull
	@Override
	public String getDescription()
	{
		return "Stylus files";
	}

	@NotNull
	@Override
	public String getDefaultExtension()
	{
		return DEFAULT_EXTENSION;
	}

	@Nullable
	@Override
	public Icon getIcon()
	{
		return StylusIcons.FILE;
	}
}
