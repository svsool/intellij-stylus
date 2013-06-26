/*!
 * Stylus plugin for Intellij IDEA
 *
 * Copyright 2013, svsool <svsool@bk.ru>
 */

package com.intellij.lang.stylus.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.intellij.lang.stylus.StylusFileType;
import com.intellij.lang.stylus.StylusLanguage;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class StylusFile extends PsiFileBase {
    public StylusFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, StylusLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return StylusFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Stylus File";
    }

    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }
}