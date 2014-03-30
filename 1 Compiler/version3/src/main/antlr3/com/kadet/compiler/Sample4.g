grammar Sample4;

options {
  language = Java;
  output=AST;
  ASTLabelType=CommonTree;
}

tokens {
    NEGATION;
}


@header {
    package com.kadet.compiler;
}


@lexer::header {
    package com.kadet.compiler;
}



evaluator
    :   assignment* expression EOF!
    ;


assignment
    :   IDENT ':='^ expression ';'^
    ;

term
    :   IDENT
    |   '('! expression ')'!
    |   INTEGER
    ;

unary
    :   ('+'! | negation^)* term
    ;

negation
    :   '-' -> NEGATION
    ;

add
    :   unary ( ('+'^ | '-'^) unary)*
    ;

mult
    :   add ( ('*'^ | '/'^ | 'mod'^) add)*
    ;

expression
    :   mult ( ('and' | 'or') mult)*
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


WS
    :   (' ' | '\t' | '\n' | '\r' | '\f')+  {$channel = HIDDEN;}
    ;
