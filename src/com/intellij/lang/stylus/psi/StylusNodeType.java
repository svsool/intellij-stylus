package com.intellij.lang.stylus.psi;

import java.lang.reflect.Constructor;

import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import com.intellij.lang.ASTNode;
import com.intellij.util.ReflectionUtil;

/**
 * @author VISTALL
 * @since 20:29/26.06.13
 */
public class StylusNodeType extends StylusElementType
{
	private final Constructor<? extends StylusElement> myConstructor;

	public StylusNodeType(@NotNull @NonNls String debugName, Class<? extends StylusElement> clazz)
	{
		super(debugName);
		try
		{
			myConstructor = clazz.getConstructor(ASTNode.class);
		}
		catch(NoSuchMethodException e)
		{
			throw new Error(e);
		}
	}

	public StylusElement newInstance(ASTNode astNode)
	{
		return ReflectionUtil.createInstance(myConstructor, astNode);
	}
}
