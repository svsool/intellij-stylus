/*!
 * Stylus plugin for Intellij IDEA
 *
 * Copyright 2013, svsool <svsool@bk.ru>
 */

package com.intellij.lang.stylus.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.lang.stylus.StylusLanguage;

public class StylusTokenType extends IElementType {
    public StylusTokenType(String debugName) {
        super(debugName, StylusLanguage.INSTANCE);
    }
}
