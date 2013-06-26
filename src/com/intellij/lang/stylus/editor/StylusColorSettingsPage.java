package com.intellij.lang.stylus.editor;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import com.intellij.lang.stylus.StylusIcons;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

import static com.intellij.lang.stylus.editor.StylusSyntaxHighlighter.*;

public class StylusColorSettingsPage implements ColorSettingsPage {
    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Comment", STYL_COMMENT),
            new AttributesDescriptor("Identifier", STYL_IDENT),
            new AttributesDescriptor("Number", STYL_NUMBER),
    };

    @Nullable
    @Override
    public Icon getIcon() {
        return StylusIcons.FILE;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new StylusSyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return "// test comment\n" +
                "body {\n" +
                "  font: 12px Helvetica, Arial, sans-serif;\n" +
                "}\n" +
                "a.button {\n" +
                "  -webkit-border-radius: 5px;\n" +
                "  -moz-border-radius: 5px;\n" +
                "  border-radius: 5px;\n" +
                "}";
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "Stylus";
    }
}