package com.kadet.compiler;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.omg.CORBA._PolicyStub;

import java.util.ArrayList;
import java.util.List;

public class S004HelloWordCompiler extends AbstractCompiler{

    private List<RecognitionException> errors = new ArrayList<RecognitionException>();

	public CommonTree compile(String expression) {
		try {
            System.out.println("expression: " + expression);

            // clean error logs
            errors = new ArrayList<RecognitionException>();

            //lexer splits input into tokens
            ANTLRStringStream input = new ANTLRStringStream(expression);
            S004HelloWordLexer lexer = new S004HelloWordLexer(input);
            TokenStream tokens = new CommonTokenStream(lexer);

            //parser generates abstract syntax tree
            S004HelloWordParser parser = new S004HelloWordParser(tokens);
            S004HelloWordParser.expression_return ret = parser.expression();

            if (lexer.hasErrors()) {
                errors.addAll(lexer.getAllErrors());
            }

            if (parser.hasErrors()) {
                errors.addAll(parser.getAllErrors());
            }


            //acquire parse result
            CommonTree ast = (CommonTree) ret.tree;
            printTree(ast);
            return ast;

        } catch (RecognitionException e) {
			throw new IllegalStateException("Recognition exception is never thrown, only declared.");
		}

	}

    public List<RecognitionException> getErrors() {
        return errors;
    }
}
