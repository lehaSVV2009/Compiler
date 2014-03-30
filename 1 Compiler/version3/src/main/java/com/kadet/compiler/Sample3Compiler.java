package com.kadet.compiler;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;

public class Sample3Compiler extends AbstractCompiler{


	public CommonTree compile(String expression) {
		try {
            System.out.println("expression: " + expression);

            //lexer splits input into tokens
            ANTLRStringStream input = new ANTLRStringStream(expression);
            Sample3Lexer lexer = new Sample3Lexer(input);
            TokenStream tokens = new CommonTokenStream(lexer);

            //parser generates abstract syntax tree
            Sample3Parser parser = new com.kadet.compiler.Sample3Parser(tokens);
            Sample3Parser.evaluator_return programReturn = parser.evaluator();

            System.out.println("result = " + programReturn.e.evaluate());

            //acquire parse result
            CommonTree ast = (CommonTree) programReturn.tree;
            printTree(ast);
            return ast;

        } catch (RecognitionException e) {
			throw new IllegalStateException("Recognition exception is never thrown, only declared.");
		}

	}

}
