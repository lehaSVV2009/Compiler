package com.kadet.compiler;

import org.junit.Test;

public class Sample2Test {

    @Test
    public void expressionEvaluation () {
        Sample2Compiler sample2Compiler = new Sample2Compiler();
        sample2Compiler.compile("4 * 3\n\r");
    }

    @Test
    public void bigExpressionEvaluation () {
        Sample2Compiler sample2Compiler = new Sample2Compiler();
        sample2Compiler.compile("3 * (4 + 2) - 3\n\r");
    }

}
