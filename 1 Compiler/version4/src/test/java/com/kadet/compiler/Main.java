package com.kadet.compiler;

import com.kadet.compiler.evaluators.Evaluator;
import com.kadet.compiler.util.KadetException;

/**
 * Date: 29.04.14
 * Time: 20:42
 *
 * @author SarokaA
 */
public class Main {

    public static void main(String[] args) throws KadetException {
        KadetCompiler compiler = new KadetCompiler();
        Evaluator evaluator = compiler.compile("program XLSample = " +
                "\n constant one : Integer := 1;" +
                "\n var x : Integer;" +
                "\n var x : Integer;" +
                "\n begin " +
                "\n   x := 2 plus 3;" +
                "\n   x := 4 plus x;" +
                "\n end XLSample.");
        evaluator.evaluate();
    }

}
