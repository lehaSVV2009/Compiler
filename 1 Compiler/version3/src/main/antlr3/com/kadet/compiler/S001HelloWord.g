grammar S001HelloWord;

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


SALUTATION: 'Hello World';
ENDSYMBOL: '!';

expression: SALUTATION ENDSYMBOL;

