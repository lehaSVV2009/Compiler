package com.kadet.compiler;

import org.junit.Test;

public class Sample4Test {

    @Test
    public void expressionEvaluation () {
        Sample4Compiler sample4Compiler = new Sample4Compiler();
        sample4Compiler.compile("4 * 3\n\r");
    }

    @Test
    public void bigExpressionEvaluation () {
        Sample4Compiler sample4Compiler = new Sample4Compiler();
        sample4Compiler.compile("x := 4; y := 3; 3 * (-x+y)*3\n\r");
    }

}
