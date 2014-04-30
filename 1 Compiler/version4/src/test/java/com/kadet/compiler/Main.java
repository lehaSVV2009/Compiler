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
                "\n  var list1 : List;" +
                "\n  var list2 : List;" +
                "\n  var list3 : List;" +
                "\n" +
                "\nbegin " +
                "\n  << list1, list2, list3 ;" +
                "\n  list1 := <1, 2, 3>;" +
                "\n  << list1, list2, list3 ;" +
                "\n  list2 := list1;" +
                "\n  << list1, list2, list3 ;" +
                "\n  list2 := list2 + 1;" +
                "\n  << list1, list2, list3 ;" +
                "\nend XLSample.");
        evaluator.evaluate();
    }

}
