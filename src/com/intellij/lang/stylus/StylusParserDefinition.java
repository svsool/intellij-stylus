/*!
 * Stylus plugin for Intellij IDEA
 *
 * Copyright 2013, svsool <svsool@bk.ru>
 */

package com.intellij.lang.stylus;

import org.jetbrains.annotations.NotNull;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lang.stylus.parser.StylusLexer;
import com.intellij.lang.stylus.parser.StylusParser;
import com.intellij.lang.stylus.psi.StylusFile;
import com.intellij.lang.stylus.psi.StylusNodeType;
import com.intellij.lang.stylus.psi.StylusTokenTypes;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;

public class StylusParserDefinition implements ParserDefinition
{
	public static final TokenSet WHITE_SPACES = TokenSet.create(StylusTokenTypes.TAB, StylusTokenTypes.WHITESPACE, StylusTokenTypes.TAB);
	public static final TokenSet COMMENTS = TokenSet.create(StylusTokenTypes.BLOCK_COMMENT, StylusTokenTypes.COMMENT);

	public static final IFileElementType FILE = new IFileElementType(StylusLanguage.INSTANCE);

	@NotNull
	@Override
	public Lexer createLexer(Project project)
	{
		return new StylusLexer();
	}

	@NotNull
	public TokenSet getWhitespaceTokens()
	{
		return WHITE_SPACES;
	}

	@NotNull
	public TokenSet getCommentTokens()
	{
		return COMMENTS;
	}

	@NotNull
	public TokenSet getStringLiteralElements()
	{
		return TokenSet.EMPTY;
	}

	@NotNull
	public PsiParser createParser(final Project project)
	{
		return new StylusParser();
	}

	@Override
	public IFileElementType getFileNodeType()
	{
		return FILE;
	}

	public PsiFile createFile(FileViewProvider viewProvider)
	{
		return new StylusFile(viewProvider);
	}

	public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right)
	{
		return SpaceRequirements.MAY;
	}

	@NotNull
	public PsiElement createElement(ASTNode node)
	{
		final IElementType elementType = node.getElementType();
		if(elementType instanceof StylusNodeType)
		{
			return ((StylusNodeType) elementType).newInstance(node);
		}
		else
		{
			return new ASTWrapperPsiElement(node);
		}
	}
}