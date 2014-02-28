grammar Graph;

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



ID
    :   ('a'..'z'|'A'..'Z') ('a'..'z'|'A'..'Z')*
    ;



NUM
    :   ('0'..'9')+
    ;


vertex
    :   ID
    ;

edge
    :   vertex '->' vertex '(' NUM ')'
    ;

graph
    :   'Graph {' edge+ '}';