package com.kadet.compiler;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;

public class GggCompiler extends AbstractCompiler{


    @Override
    public CommonTree compile (String expression) {
        return null;
    }

    public void compileCode(String code) {

        try {
            System.out.println("Code: " + code);

            //lexer splits input into tokens
            ANTLRStringStream input = new ANTLRStringStream(code);
            gggggLexer lexer = new gggggLexer(input);
            TokenStream tokens = new CommonTokenStream(lexer);

            //parser generates abstract syntax tree
            gggggParser parser = new gggggParser(tokens);
            gggggParser.program_return programReturn = parser.program();

            System.out.println("start = " + programReturn.start);

            //acquire parse result
            CommonTree ast = (CommonTree) programReturn.tree;
            printTree(ast);

        } catch (RecognitionException e) {
            throw new IllegalStateException("Recognition exception is never thrown, only declared.");
        }


	}

}
