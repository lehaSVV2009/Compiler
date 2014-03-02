grammar SimpleGrammar;

options {

    // java lexer and parser
    language = Java;

    // abstract syntax tree
    output = AST;

}

@lexer::header {
    package com.kadet.compiler;
}

@parser::header {
    package com.kadet.compiler;
}



DATATYPE
    :   'int'|'float'
    ;


ID
    :   ('a'..'z'|'A'..'Z'|'_')('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'.'|'a'..'z'|'A'..'Z')*
    ;

COMMA
    :   ','
    ;

SEMICOLON
    :   ';'
    ;




decl
    :   DATATYPE ID(',' ID)* SEMICOLON
    ;