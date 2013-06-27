package com.intellij.stylus.parser;

import com.intellij.lang.stylus.StylusParserDefinition;
import com.intellij.testFramework.ParsingTestCase;

/**
 * @author VISTALL
 * @since 16:43/27.06.13
 */
public class StylusParserTest extends ParsingTestCase
{
	public StylusParserTest()
	{
		super("parsing", "styl", new StylusParserDefinition());
	}

	public void testHieraryTree()
	{
		doTest(true);
	}

	@Override
	protected String getTestDataPath()
	{
		return "testData";
	}

	@Override
	protected boolean shouldContainTempFiles()
	{
		return false;
	}
}
