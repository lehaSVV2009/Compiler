package com.kadet.compiler;

import com.kadet.compiler.evaluators.ProgramEvaluator;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;

/**
 * Date: 16.03.14
 * Time: 16:37
 *
 * @author Кадет
 */
public class KadetCompiler extends AbstractCompiler {
    @Override
    public ProgramEvaluator compile (String expression) {
        System.out.println("expression: " + expression);

        //lexer splits input into tokens
        ANTLRStringStream input = new ANTLRStringStream(expression);
        kadetLexer lexer = new kadetLexer(input);
        TokenStream tokens = new CommonTokenStream(lexer);

        //parser generates abstract syntax tree
        kadetParser parser = new kadetParser(tokens);
        kadetParser.program_return programReturn = null;
        try {
            programReturn = parser.program();
        } catch (RecognitionException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        //acquire parse result
        CommonTree ast = (CommonTree) programReturn.tree;
        printTree(ast);

        return programReturn.evaluator;
    }
}
