grammar Sample3;

options {

    // java lexer and parser
    language = Java;

    // abstract syntax tree
    output = AST;

}

@lexer::header {
    package com.kadet.compiler;

    import com.kadet.compiler.evaluators.*;
}

@parser::header {
    package com.kadet.compiler;

    import com.kadet.compiler.evaluators.*;
}


evaluator returns [Evaluator e]
    :   expression EOF  { $e = $expression.e; }
    ;


//  expressions fun time

term returns [Evaluator e]
    :   IDENT               {   $e = new IntEvaluator(0); }
    |   '(' expression ')'  {   $e = $expression.e; }
    |   INTEGER             {   $e = new IntEvaluator(Integer.parseInt($INTEGER.text)); }
    ;


unary returns [Evaluator e]
    :                       {   boolean positive = true;}
    (   '+'
    |   '-'                 {    positive = !positive; }
    )* term                 {
                                $e = $term.e;
                                if (!positive)
                                    $e = new NegationEvaluator($e);
                            }
    ;

mult returns [Evaluator e]
    :   op1 = unary { $e = $op1.e; }
        (   '*' op2 = unary     { $e = new TimesEvaluator($e, $op2.e); }
        |   '/' op2 = unary     { $e = new DivideEvaluator($e, $op2.e); }
        |   'mod' op2 = unary   { $e = new ModEvaluator($e, $op2.e); }
        )*
    ;

expression returns [Evaluator e]
    :   op1 = mult { $e = $op1.e;}
        (   '+' op2 = mult      { $e = new PlusEvaluator($e, $op2.e); }
        |   '-' op2 = mult      { $e = new MinusEvaluator($e, $op2.e); }
        )*
    ;

fragment LETTER
    :   ('a'..'z' | 'A'..'Z')
    ;

fragment DIGIT
    :   '0'..'9'
    ;

IDENT
    :   ( LETTER )( LETTER | DIGIT )*
    ;

INTEGER
    :   DIGIT+
    ;

STRING_LITERAL
    :   '"'
                                        {
                                            StringBuilder b = new StringBuilder();
                                        }
        (
        ('\\' '"')                      {   b.appendCodePoint('"');}
        |
        c = ~( '"' | '\r' | '\n' )      {   b.appendCodePoint(c);}
        )*
        '"'
                                        {   setText (b.toString());}
    ;

CHAR_LITERAL
    :   '\'' . '\'' {setText(getText().substring(1, 2));}
    ;

WS
    :   (' ' | '\t' | '\n' | '\r' | '\f')+  {$channel = HIDDEN;}
    ;

COMMENT
    :   '//' .* ('\n' | '\r')   {$channel = HIDDEN;}
    ;

MULTIPLE_COMMENT
    :   '/*' .* '*/'    {$channel = HIDDEN;}
    ;