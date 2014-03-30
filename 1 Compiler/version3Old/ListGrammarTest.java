package com.kadet.compiler;

import org.junit.Test;

public class ListGrammarTest {

    @Test
	public void correctTest () {
        SimpleGrammarCompiler compiler = new SimpleGrammarCompiler();
        compiler.compile("int a, b;");
    }

    @Test
	public void incorrectTest () {
        SimpleGrammarCompiler compiler = new SimpleGrammarCompiler();
        compiler.compile("int a, b");
    }
}
