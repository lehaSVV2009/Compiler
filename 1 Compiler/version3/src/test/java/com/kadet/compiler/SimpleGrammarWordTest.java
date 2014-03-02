package com.kadet.compiler;

import static org.junit.Assert.*;

import org.antlr.runtime.tree.CommonTree;
import org.junit.Test;

public class SimpleGrammarWordTest {

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
