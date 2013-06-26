package com.intellij.lang.stylus.parser;

import org.jetbrains.annotations.NotNull;
import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiParser;
import com.intellij.lang.stylus.psi.StylusNodeTypes;
import com.intellij.lang.stylus.psi.StylusTokenTypes;
import com.intellij.psi.tree.IElementType;

/**
 * @author VISTALL
 * @since 20:35/26.06.13
 */
public class StylusParser implements PsiParser, StylusTokenTypes, StylusNodeTypes
{
	@NotNull
	@Override
	public ASTNode parse(IElementType root, PsiBuilder builder)
	{
		final PsiBuilder.Marker mark = builder.mark();
		while(!builder.eof())
		{
			final IElementType tokenType = builder.getTokenType();
			if(tokenType == SELECTOR_TAG_NAME)
			{
				PsiBuilder.Marker ruleMarker = builder.mark();

				parseSelectorTag(builder);

				ruleMarker.done(RULE);
			}
			else
			{
				builder.advanceLexer();
			}
		}
		mark.done(root);
		return builder.getTreeBuilt();
	}

	private void parseSelectorTag(PsiBuilder builder)
	{
		PsiBuilder.Marker marker = builder.mark();

		assert builder.getTokenType() == SELECTOR_TAG_NAME;

		builder.advanceLexer();

		if(builder.getTokenType() == DOT)
		{
			PsiBuilder.Marker classMarker = builder.mark();
			builder.advanceLexer();

			if(builder.getTokenType() == IDENTIFIER)
			{
				builder.advanceLexer();

				classMarker.done(SELECTOR_CLASS);
			}
			else
			{
				classMarker.error("Identifier expected");
			}
		}

		advanceUntilNotEqual(builder, NEWLINE);

		while(!builder.eof())
		{
			if(builder.getTokenType() == INDENT)
			{
				parseProperty(builder);
			}
			else if(builder.getTokenType() == NEWLINE)
			{
				builder.advanceLexer();
			}
			else
			{
				break;
			}
		}

		marker.done(SELECTOR_TAG);
	}

	private static void parseProperty(PsiBuilder builder)
	{
		assert builder.getTokenType() == INDENT;

		PsiBuilder.Marker marker = builder.mark();
		builder.advanceLexer();
		if(builder.getTokenType() == PROPERTY_NAME)
		{
			advanceUntilEqual(builder, NEWLINE);

			marker.done(PROPERTY);
		}
		else
		{
			marker.error("Expected identifier");
		}
	}

	private static void advanceUntilNotEqual(PsiBuilder builder, IElementType elementType)
	{
		while(!builder.eof() && builder.getTokenType() == elementType)
		{
			builder.advanceLexer();
		}
	}

	private static void advanceUntilEqual(PsiBuilder builder, IElementType elementType)
	{
		while(!builder.eof() && builder.getTokenType() != elementType)
		{
			builder.advanceLexer();
		}
	}

	private static void parseOneToken(PsiBuilder builder, IElementType doneTo)
	{
		final PsiBuilder.Marker mark = builder.mark();
		builder.advanceLexer();
		mark.done(doneTo);
	}
}
