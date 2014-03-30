grammar Sample;

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


program
    :   'program' IDENT '='
        ( constant | variable | procedure | function | typeDecl )*
        'begin'
        statement*
        'end' IDENT '.'
    ;

constant
    :   'constant' IDENT ':' type (':=' expression)? ';'
    ;

variable
    :   'var' IDENT (',' IDENT)* ':' type (':=' expression)? ';'
    ;

type
    :   'Integer'
    |   'Boolean'
    |   'String'
    |   'Char'
    |   IDENT
    |   typeSpec
    ;

typeDecl
    :   'type' IDENT '=' typeSpec ';'
    ;

typeSpec
    :   arrayType
    |   recordType
    |   enumType
    ;

arrayType
    :   'array'  '[' INTEGER '..' INTEGER ']' 'of' type
    ;

recordType
    :   'record' field* 'end' 'record'
    ;

field
    :   IDENT ':' type ';'
    ;

enumType
    :   '<' IDENT (',' IDENT)* '>'
    ;


statement
    :   assignmentStatement
    |   ifStatement
    |   whileStatement
    |   procedureCallStatement
    ;

ifStatement
    :   'if' expression 'then' statement+
        ('elsif' expression 'then' statement+)*
        ('else' + statement+)?
        'end' 'if' ';'
    ;

whileStatement
    :   'while' expression loopStatement
    ;

loopStatement
    :   'loop' (statement)* 'end' 'loop' ';'
    ;

assignmentStatement
    :   IDENT ':=' expression ';'
    ;

//  expressions

term
    :   IDENT
    |   '(' expression ')'
    |   INTEGER
    |   IDENT '(' actualParameters ')'
    |   STRING_LITERAL
    |   CHAR_LITERAL
    ;

negation
    :   'not'* term
    ;

unary
    :   ('+' | '-')* negation
    ;

mult
    :   unary ( ('*' | '/' | 'mod') unary)*
    ;

add
    :   mult ( ('+' | '-') mult)*
    ;

relation
    :   add ( ('=' | '!=' | '<=' | '<' | '>' | '>=') add)*
    ;

expression
    :   relation ( ('and' | 'or') relation)*
    ;

procedure
    :   'procedure' IDENT '(' parameters? ')' '='
        (constant | variable)*
        'begin'
        statement*
        'end' IDENT '.'
    ;

procedureCallStatement
    :   IDENT '(' actualParameters ')' ';'
    ;

actualParameters
    :   ( expression (',' expression)* )?
    ;

function
    :   'function' IDENT '(' parameters? ')' ':' type '='
        (constant | variable)*
        'begin'
        (statement|returnStatement)*
        'end' IDENT '.'
    ;

returnStatement
    :   'return' expression ';'
    ;

parameters
    :   parameter (',' parameter)*
    ;

parameter
    :   IDENT ':' type
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