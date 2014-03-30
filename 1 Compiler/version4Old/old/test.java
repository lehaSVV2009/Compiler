package com.kadet.compiler;


import java.io.IOException;
import org.antlr.runtime.*;

public class test {

	public static void main(String[] arg) throws IOException, RecognitionException {

	CharStream input = new ANTLRFileStream("test");
	
	gggggLexer lexer = new gggggLexer(input);
	
	CommonTokenStream tokens = new CommonTokenStream(lexer);
	
		
	
	gggggParser pars = new gggggParser(tokens);
	pars.program();
	System.out.println("done!!!");

}

}
