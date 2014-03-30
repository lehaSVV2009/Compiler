package com.kadet.compiler;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;

public class Sample4Compiler extends AbstractCompiler{


	public CommonTree compile(String expression) {
		try {
            System.out.println("expression: " + expression);

            //lexer splits input into tokens
            ANTLRStringStream input = new ANTLRStringStream(expression);
            Sample4Lexer lexer = new Sample4Lexer(input);
            TokenStream tokens = new CommonTokenStream(lexer);

            //parser generates abstract syntax tree
            Sample4Parser parser = new Sample4Parser(tokens);

            Sample4Parser.evaluator_return evaluator = parser.evaluator();
            CommonTreeNodeStream nodeStream = new CommonTreeNodeStream(evaluator.tree);
            EvaluatorWalker walker = new EvaluatorWalker(nodeStream);
            int result = walker.evaluator();
            System.out.println("ok - result = " + result);


            /*System.out.println("result = " + programReturn.result);

            //acquire parse result
            CommonTree ast = (CommonTree) programReturn.tree;
            System.out.println(ast.toStringTree());
//            printTree(ast);
            return ast;*/
            return null;

        } catch (RecognitionException e) {
			throw new IllegalStateException("Recognition exception is never thrown, only declared.");
		}

	}

}
