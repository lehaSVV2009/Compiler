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
                "\n  var x : Boolean;" +
                "\n" +
                "\nbegin " +
                "\n  x := >=>;" +
                "\n  x := >=>;" +
                "\n  x := >=>;" +
                "\n  x := >=>;" +
                "\nend XLSample.");
        evaluator.evaluate();
    }

}
