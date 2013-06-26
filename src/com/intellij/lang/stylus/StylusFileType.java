/*!
 * Stylus plugin for Intellij IDEA
 *
 * Copyright 2013, svsool <svsool@bk.ru>
 */
package com.intellij.lang.stylus;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NonNls;

import javax.swing.*;

public class StylusFileType extends LanguageFileType {
    public static final StylusFileType INSTANCE = new StylusFileType();
    @NonNls public static final String DEFAULT_EXTENSION = "styl";

    private StylusFileType() {
        super(StylusLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Stylus file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Stylus language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return DEFAULT_EXTENSION;
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return StylusIcons.FILE;
    }
}
