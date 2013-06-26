package com.intellij.lang.stylus.psi;

/**
 * @author VISTALL
 * @since 20:29/26.06.13
 */
public interface StylusNodeTypes
{
	StylusNodeType RULE = new StylusNodeType("RULE", StylusRule.class);

	StylusNodeType SELECTOR_TAG = new StylusNodeType("SELECTOR_TAG", StylusSelectorTag.class);

	StylusNodeType SELECTOR_CLASS = new StylusNodeType("SELECTOR_CLASS", StylusSelectorClass.class);

	StylusNodeType PROPERTY = new StylusNodeType("PROPERTY", StylusProperty.class);
}
