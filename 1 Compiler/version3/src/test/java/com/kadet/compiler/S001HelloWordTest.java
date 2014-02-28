package com.kadet.compiler;

import static org.junit.Assert.*;

import org.antlr.runtime.tree.CommonTree;
import org.junit.Test;

public class S001HelloWordTest {

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
		S001HelloWordCompiler compiler = new S001HelloWordCompiler();
		CommonTree ast = compiler.compile("Hello World!");

		//check AST structure
		assertEquals(S001HelloWordParser.SALUTATION, ast.getChild(0).getType());
		assertEquals(S001HelloWordParser.ENDSYMBOL, ast.getChild(1).getType());
    }


    @Test
    public void testBiggerError() {
        //compile the expression
        S001HelloWordCompiler compiler = new S001HelloWordCompiler();
        CommonTree ast = compiler.compile("Bye!");
        //check AST structure
        assertEquals(S001HelloWordParser.SALUTATION, ast.getChild(0).getType());
        assertEquals(S001HelloWordParser.ENDSYMBOL, ast.getChild(1).getType());
    }


    @Test
    public void testCompletelyWrong() {
        //compile the expression
        S001HelloWordCompiler compiler = new S001HelloWordCompiler();
        CommonTree ast = compiler.compile("Incorrect Expression");

        //check AST structure
        assertEquals(0, ast.getChildCount());
    }


}
