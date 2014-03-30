package com.kadet.compiler;

import org.junit.Test;

/**
 * Date: 29.03.14
 * Time: 23:30
 *
 * @author Кадет
 */
public class gggTest {

    @Test
    public void gggSampleTest () {
        GggCompiler gggCompiler = new GggCompiler();
        gggCompiler.compileCode("var1 = 12;\n" +
                                "var2 = 13;\n" +
                                "\n" +
                                "\n" +
                                "\n" +
                                "Alenamain" +
                                "\n\t" +
                                "" +
                                "\n"
        );
    }




}
