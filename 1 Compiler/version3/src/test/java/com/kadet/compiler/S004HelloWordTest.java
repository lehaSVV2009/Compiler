package com.kadet.compiler;

import static org.junit.Assert.*;

import org.antlr.runtime.tree.CommonTree;
import org.junit.Test;

public class S004HelloWordTest {

	/**
	 * Abstract syntax tree generated from "Hello word!" should have an unnamed 
	 * root node with two children. First child corresponds to salutation token 
	 * and second child corresponds to end symbol token.
	 * 
	 * Token type constants are defined in generated S001HelloWordParser class.
	 */
    @Test
    public void testCorrectExpression() {
        //compile the expression
        S004HelloWordCompiler compiler = new S004HelloWordCompiler();
        CommonTree ast = compiler.compile("Hello World!");

        assertEquals(0, compiler.getErrors().size());

        //check AST structure
        assertEquals(S004HelloWordParser.SALUTATION, ast.getChild(0).getType());
        assertEquals(S004HelloWordParser.ENDSYMBOL, ast.getChild(1).getType());
    }

    @Test
    public void testSmallerError () {

        S004HelloWordCompiler compiler = new S004HelloWordCompiler();
        CommonTree commonTree = compiler.compile("Hello World?");

        assertEquals(2, compiler.getErrors().size());

    }

    @Test
    public void testBiggerError() {

        S004HelloWordCompiler compiler = new S004HelloWordCompiler();
        CommonTree commonTree = compiler.compile("Bye!");

        assertEquals(4, compiler.getErrors().size());

    }

    @Test()
    public void testCompletelyWrong () {

        S004HelloWordCompiler compiler = new S004HelloWordCompiler();
        CommonTree commonTree = compiler.compile("Incorrect Expression");

        assertEquals(21, compiler.getErrors().size());

    }


}
