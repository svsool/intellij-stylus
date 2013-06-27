package com.intellij.lang.stylus.psi;

/**
 * @author VISTALL
 * @since 20:29/26.06.13
 */
public interface StylusNodeTypes
{
	StylusNodeType RULE = new StylusNodeType("RULE", StylusRule.class);

	StylusNodeType PROPERTY = new StylusNodeType("PROPERTY", StylusProperty.class);
}
