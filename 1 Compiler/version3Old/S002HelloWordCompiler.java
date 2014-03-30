package com.kadet.compiler;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.omg.CORBA._PolicyStub;

public class S002HelloWordCompiler extends AbstractCompiler{

	public CommonTree compile(String expression) {
		try {
			//lexer splits input into tokens
			ANTLRStringStream input = new ANTLRStringStream(expression);
			TokenStream tokens = new CommonTokenStream(new S001HelloWordLexer(input));
			
			//parser generates abstract syntax tree
			S002HelloWordParser parser = new S002HelloWordParser(tokens);
			S002HelloWordParser.expression_return ret = parser.expression();
			
			//acquire parse result
			CommonTree ast = (CommonTree) ret.tree;
			printTree(ast);
			return ast;
		} catch (RecognitionException e) {
			throw new IllegalStateException("Recognition exception is never thrown, only declared.");
		}
	}

    @SuppressWarnings("serial")
    public static class S002HelloWordError extends RuntimeException {

        public S002HelloWordError(String message, Throwable cause) {
            super(message, cause);
        }
    }

}
