package com.kadet.compiler;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;

public class SampleCompiler extends AbstractCompiler{


	public CommonTree compile(String expression) {
		try {
            System.out.println("expression: " + expression);

            //lexer splits input into tokens
            ANTLRStringStream input = new ANTLRStringStream(expression);
            SampleLexer lexer = new SampleLexer(input);
            TokenStream tokens = new CommonTokenStream(lexer);

            //parser generates abstract syntax tree
            SampleParser parser = new SampleParser(tokens);
            SampleParser.program_return programReturn = parser.program();

            //acquire parse result
            CommonTree ast = (CommonTree) programReturn.tree;
            printTree(ast);
            return ast;

        } catch (RecognitionException e) {
			throw new IllegalStateException("Recognition exception is never thrown, only declared.");
		}

	}

}
