grammar kadet;

options {

    // java lexer and parser
    language = Java;

    // abstract syntax tree
    output = AST;

}

@lexer::header {
    package com.kadet.compiler;
    import com.kadet.compiler.evaluators.*;
    import com.kadet.compiler.expressions.*;
    import com.kadet.compiler.entities.*;
}

@parser::header {
    package com.kadet.compiler;
    import com.kadet.compiler.evaluators.*;
    import com.kadet.compiler.expressions.*;
    import com.kadet.compiler.entities.*;
}

@members
{
    Program program = Program.getInstance();
}

program returns [ProgramEvaluator evaluator]
    :   'program' id = ID '='           { $evaluator = new ProgramEvaluator($id.text);}
        (
            variable
            | constant
            | procedure
            | function
        )*
        'begin'                         {
                                          ProcedureEvaluator mainEvaluator = new ProcedureEvaluator("main");
                                          $evaluator.setMainEvaluator(mainEvaluator);
                                        }
        (
            statement                   { mainEvaluator.addStatementEvaluator($statement.evaluator); }
        )*
        'end' ID '.'
    ;

constant
    :   'constant' id = ID                     {
                                                 List<Constant> initConstants = new ArrayList<Constant>();
                                                 Constant constant = new Constant($id.text);
                                                 initConstants.add(constant);
                                               }
       (
           ',' otherId = ID                    {
                                                 constant = new Constant($otherId.text);
                                                 initConstants.add(constant);
                                               }
        )*
       ':' type                                {
                                                 for (Constant currentConstant : initConstants) {
                                                   currentConstant.setType($type.TYPE);
                                                 }
                                               }
       (':=' expression)? ';'

                                               {
                                                 for (Constant currentConstant : initConstants) {
                                                   program.addConstant(currentConstant);
                                                   System.out.println("Added constant:" + currentConstant);
                                                 }
                                               }
    ;

variable
    :   'var' id = ID                           {
                                                  List<Variable> initVariables = new ArrayList<Variable>();
                                                  Variable variable = new Variable($id.text);
                                                  initVariables.add(variable);
                                                }
        (
            ',' otherId = ID                    {
                                                  variable = new Variable($otherId.text);
                                                  initVariables.add(variable);
                                                }
         )*
        ':' type                                {
                                                  for (Variable var : initVariables) {
                                                    var.setType($type.TYPE);
                                                  }
                                                }
        (':=' expression)? ';'

                                                {
                                                  for (Variable var : initVariables) {
                                                    program.addVariable(var);
                                                    System.out.println("Added variable:" + var);
                                                  }
                                                }
    ;

type returns [Type TYPE]
    :   'List'                  { $TYPE = Type.LIST; }
    |   'Element'               { $TYPE = Type.ELEMENT; }
    ;

statement returns [StatementEvaluator evaluator]
    :   assignmentStatement         { $evaluator = $assignmentStatement.evaluator; }
    |   ifStatement                 { $evaluator = $ifStatement.evaluator; }
    |   whileStatement              { $evaluator = $whileStatement.evaluator; }
    |   forStatement                { $evaluator = $forStatement.evaluator; }
    |   procedureCallStatement      { $evaluator = $procedureCallStatement.evaluator; }
    ;

ifStatement returns [IfEvaluator evaluator]
@init {
    $evaluator = new IfEvaluator();
}
    :   'if' expression 'then'
            statement+
        ('elsif' expression 'then'
            statement+ )*
        ('else'
            statement+ )?
        'end' 'if' ';'
    ;

whileStatement returns [WhileEvaluator evaluator]
@init {
    $evaluator = new WhileEvaluator();
}
    :   'while' expression
        'begin'
            (statement)*
        'end' 'while' ';'
    ;

forStatement returns [ForEvaluator evaluator]
@init {
    $evaluator = new ForEvaluator();
}
    :   'for' '(' assignment ';' expression ';' assignment ')'
        'begin'
            (statement)*
        'end' 'for' ';'
    ;

assignmentStatement returns [AssignmentEvaluator evaluator]
    :   assignment ';'          { $evaluator = $assignment.evaluator; }
    ;

assignment returns [AssignmentEvaluator evaluator]
    :	id = ID ':=' expression      { $evaluator = new AssignmentEvaluator(); }
    ;

//  expressions

term
    :   element
    |   list
    |   ID '(' actualParameters ')'
    |   '(' expression ')'
    |	elementFromList
    ;

elementFromList
    :	ID '[' INTEGER ']'
    ;

element
    :   INTEGER
    |	STRING_LITERAL
    |   CHAR_LITERAL
    |   ID
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

relation returns [Expression expression]
    :   add ( ('equal' | 'not equal' | 'lessOrEqual' | 'less' | 'greater' | 'greaterOrEqual') add)*
         {
            $expression
                    = new ValueExpression(
                                new Element(123));
         }
    ;

expression returns [Expression expression]
    :   expression1 = relation               { $expression = expression1.expression; }
        (
        'and' expression2 = relation         { $expression = new AndExpression($expression, $expression2.expression); }
        | 'or' expression2 = relation        { $expression = new OrExpression($expression, $expression2.expression); }
        )*
    ;

procedure
    :   'procedure' ID '(' parameters? ')' '='
        (constant | variable)*
        'begin'
        statement*
        'end' ID '.'
    ;

procedureCallStatement returns [ProcedureCallEvaluator evaluator]
@init {
    $evaluator = new ProcedureCallEvaluator();
}
    :   ID '(' actualParameters ')' ';'
    ;

actualParameters
    :   ( expression (',' expression)* )?
    ;

function
    :   'function' ID '(' parameters? ')' ':' type '='
        (constant | variable)*
        'begin'
        (statement|returnStatement)*
        'end' ID '.'
    ;

returnStatement
    :   'return' expression ';'
    ;

parameters
    :   parameter (',' parameter)*
    ;

parameter
    :   ID ':' type
    ;


fragment LETTER
    :   ('a'..'z' | 'A'..'Z')
    ;

fragment DIGIT
    :   '0'..'9'
    ;

ID
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