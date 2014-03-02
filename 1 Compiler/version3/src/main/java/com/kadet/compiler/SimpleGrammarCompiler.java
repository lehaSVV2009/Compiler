package com.kadet.compiler;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.omg.CORBA._PolicyStub;

import java.util.ArrayList;
import java.util.List;

public class SimpleGrammarCompiler extends AbstractCompiler{


	public CommonTree compile(String expression) {
		try {
            System.out.println("expression: " + expression);

            //lexer splits input into tokens
            ANTLRStringStream input = new ANTLRStringStream(expression);
            SimpleGrammarLexer lexer = new SimpleGrammarLexer(input);
            TokenStream tokens = new CommonTokenStream(lexer);

            //parser generates abstract syntax tree
            SimpleGrammarParser parser = new SimpleGrammarParser(tokens);
            SimpleGrammarParser.decl_return ret = parser.decl();

            //acquire parse result
            CommonTree ast = (CommonTree) ret.tree;
            printTree(ast);
            return ast;

        } catch (RecognitionException e) {
			throw new IllegalStateException("Recognition exception is never thrown, only declared.");
		}

	}

}
