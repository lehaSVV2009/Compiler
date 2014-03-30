grammar Stewie;

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
        ( variable | constant | procedure | function )*
        'begin'
        statement*
        'end' IDENT '.'
    ;

constant
    :   'constant' initialize ';'
    ;

variable
    :   'var' initialize ';'
    ;

initialize
    :	IDENT (',' IDENT)* ':' type (':=' expression)? 
    ;

type
    :   'List'
    |   'Element'
    ;

statement
    :   assignmentStatement
    |   ifStatement
    |   whileStatement
    |   forStatement
    |   procedureCallStatement
    ;

ifStatement
    :   'if' expression 'then'
            statement+
        ('elsif' expression 'then'
            statement+ )*
        ('else'
            statement+ )?
        'end' 'if' ';'
    ;

whileStatement
    :   'while' expression
        'begin'
            (statement)*
        'end' 'while' ';'
    ;

forStatement
    :   'for' '(' assignment ';' expression ';' assignment ')'
        'begin'
            (statement)*
        'end' 'for' ';'
    ;

assignmentStatement
    :   assignment ';'
    ;

assignment
    :	IDENT ':=' expression	
    ;

//  expressions

term
    :   element
    |   list
    |   IDENT '(' actualParameters ')'
    |   '(' expression ')'
    |	elementFromList
    ;

elementFromList
    :	IDENT '[' INTEGER ']'	
    ;

element
    :   INTEGER
    |	STRING_LITERAL    
    |   CHAR_LITERAL
    |   IDENT
    ;

list
    :   '[' ( expression (',' expression)* )? ']'
    ;


intersection
    :	term ( '*' term)*
    ;


difference
    :	intersection ( '/' intersection )*
    ;


removeFromList
    :	difference ( '-' difference )*
    ;

addToList
    :	removeFromList ( '+' removeFromList)*		
    ;


multiple
    :   addToList ( ('multiply' | 'divide' ) addToList)*
    ;

add
    :   multiple ( ('plus' | 'minus') multiple)*
    ;

relation
    :   add ( ('equal' | 'not equal' | 'lessOrEqual' | 'less' | 'greater' | 'greaterOrEqual') add)*
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