package com.kadet.compiler;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;

public class Sample2Compiler extends AbstractCompiler{


	public CommonTree compile(String expression) {
		try {
            System.out.println("expression: " + expression);

            //lexer splits input into tokens
            ANTLRStringStream input = new ANTLRStringStream(expression);
            Sample2Lexer lexer = new Sample2Lexer(input);
            TokenStream tokens = new CommonTokenStream(lexer);

            //parser generates abstract syntax tree
            Sample2Parser parser = new Sample2Parser(tokens);
            Sample2Parser.evaluator_return programReturn = parser.evaluator();

            System.out.println("result = " + programReturn.result);

            //acquire parse result
            CommonTree ast = (CommonTree) programReturn.tree;
            printTree(ast);
            return ast;

        } catch (RecognitionException e) {
			throw new IllegalStateException("Recognition exception is never thrown, only declared.");
		}

	}

}
