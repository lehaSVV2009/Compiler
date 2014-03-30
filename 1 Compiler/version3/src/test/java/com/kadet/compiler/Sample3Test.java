package com.kadet.compiler;

import org.junit.Test;

public class Sample3Test {

    @Test
    public void expressionEvaluation () {
        Sample3Compiler sample3Compiler = new Sample3Compiler();
        sample3Compiler.compile("4 * 3\n\r");
    }

    @Test
    public void bigExpressionEvaluation () {
        Sample3Compiler sample3Compiler = new Sample3Compiler();
        sample3Compiler.compile("3 * (4 + 2) - 3\n\r");
    }

}
