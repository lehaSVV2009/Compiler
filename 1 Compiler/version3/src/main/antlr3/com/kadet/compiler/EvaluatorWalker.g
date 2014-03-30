tree grammar EvaluatorWalker;

options {
  language = Java;
  tokenVocab = Sample4;
  ASTLabelType = CommonTree;
}

@header {
  package com.kadet.compiler;
  import java.util.Map;
  import java.util.HashMap;
}

@members {
  private Map<String, Integer> variables = new HashMap<String, Integer>();
}

evaluator returns [int result]
	:	assignment* e=expression EOF { result = e; }
	;
	
assignment
	:	^(':=' IDENT e=expression)
			{ variables.put($IDENT.text, e); }
	;
	
expression returns [int result]
	:	^('+' op1=expression op2=expression) { result = op1 + op2; }
	|	^('-' op1=expression op2=expression) { result = op1 - op2; }
	|	^('*' op1=expression op2=expression) { result = op1 * op2; }
	|	^('/' op1=expression op2=expression) { result = op1 / op2; }
	|	^('%' op1=expression op2=expression) { result = op1 \% op2; }
	|	^(NEGATION e=expression)  { result = -e; }
	|	IDENT { result = variables.get($IDENT.text); }
	|	INTEGER { result = Integer.parseInt($INTEGER.text); }
	;
