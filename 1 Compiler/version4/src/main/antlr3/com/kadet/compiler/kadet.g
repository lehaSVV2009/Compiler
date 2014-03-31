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
    import com.kadet.compiler.util.*;
}

@parser::header {
    package com.kadet.compiler;
    import com.kadet.compiler.evaluators.*;
    import com.kadet.compiler.expressions.*;
    import com.kadet.compiler.entities.*;
    import com.kadet.compiler.util.*;
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
                                                   currentConstant.setValue(ValueFactory.createValue($type.TYPE));
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
                                                    var.setValue(ValueFactory.createValue($type.TYPE));
                                                  }
                                                }
        (
        ':=' expression
        )?
        ';'

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
    |   'Integer'               { $TYPE = Type.INTEGER; }
    |   'Boolean'               { $TYPE = Type.BOOLEAN; }
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
    :   assignment ';'              { $evaluator = $assignment.evaluator; }
    ;

assignment returns [AssignmentEvaluator evaluator]
    :	id = ID ':=' expression     { $evaluator = new AssignmentEvaluator($id.text, $expression.expression); }
    ;

//  expressions

term returns [Expression expression]
    :   element                                 { $expression = $element.expression; }
    |   list                                    { $expression = $list.expression; }
    |   ID '(' actualParameters ')'
    |   '(' innerExpression = expression ')'    { $expression = $innerExpression.expression; }
    |	elementFromList                         { $expression = $elementFromList.expression; }
    ;

elementFromList returns [Expression expression]
    :	ID '[' INTEGER ']'                      { $expression = new ElementFromListExpression($ID.text, Integer.parseInt($INTEGER.text)); }
    ;

element returns [Expression expression]
    :   INTEGER                                 { $expression = new ValueExpression(new Int(Integer.parseInt($INTEGER.text))); }
    |   '@true'                                 { $expression = new ValueExpression(new Bool(Boolean.parseBoolean("true"))); }
    |   '@false'                                { $expression = new ValueExpression(new Bool(Boolean.parseBoolean("false"))); }
 //   |   ID
    ;

list returns [Expression expression]
@init {
    java.util.List<Expression> expressions = new java.util.ArrayList<Expression>();
}
    :   '<'
        ( expression1 = expression              { expressions.add($expression1.expression); }

          (
          ',' expression2 = expression          { expressions.add($expression2.expression); }
          )*
        )? '>'                                  {
                                                  $expression = new ListExpression(expressions);
                                                }
    ;


// <1, 2> * 1 = < <1, 2>, 1 >
overList returns [Expression expression]
    :	expression1 = term                  { $expression = $expression1.expression; }
        (
        '*' expression2 = term              { $expression = new OverListExpression($expression, $expression2.expression); }
        )*
    ;

//  <1, 1, 2, 1> / 1 = <2>
removeAllElementEntries returns [Expression expression]
    :	expression1 = overList                  { $expression = $expression1.expression; }
        (
        '/' expression2 = overList              { $expression = new RemoveAllElementEntriesExpression($expression, $expression2.expression); }
        )*
    ;


//  <1, 1, 2, 1> - 1 = <1, 2, 1>
removeFromList returns [Expression expression]
    :	expression1 = removeAllElementEntries                    { $expression = $expression1.expression; }
        (
        '-' expression2 = removeAllElementEntries                { $expression = new RemoveFromListExpression($expression, $expression2.expression); }
        )*
    ;

// 1 + 2 = <1, 2>
// 1 + <1, 2> = <1, 1, 2>
// <1, 2> + 1 = <1, 2, 1>
// <1, 2> + <1, 3> = <1, 2, 1, 3>
addToList returns [Expression expression]
    :	expression1 = removeFromList                { $expression = $expression1.expression; }
        (
        '+' expression2 = removeFromList            { $expression = new AddToListExpression($expression, $expression2.expression); }
        )*
    ;

// 2 multiple 3 = 6
// 6 multiple 3 = 2
multiple returns [Expression expression]
    :   expression1 = addToList                     { $expression = $expression1.expression; }
        (
        'multiply' expression2 = addToList          { $expression = new MultipleExpression($expression, $expression2.expression); }
        | 'divide' expression2 = addToList          { $expression = new DivideExpression($expression, $expression2.expression); }
        )*
    ;

// 2 plus 3 = 5
// 3 minus 2 = 1
add returns [Expression expression]
    :   expression1 = multiple                      { $expression = $expression1.expression; }
        (
        'plus' expression2 = multiple               { $expression = new PlusExpression($expression, $expression2.expression); }
        | 'minus' expression2 = multiple            { $expression = new MinusExpression($expression, $expression2.expression); }
        )*
    ;


relation returns [Expression expression]
    :   expression1 = add                           { $expression = $expression1.expression; }
        (
        'equal'    expression2 = add                { $expression = new EqualExpression($expression, $expression2.expression); }
        | 'not equal'  expression2 = add            { $expression = new NotEqualExpression($expression, $expression2.expression); }
        | 'lessOrEqual'   expression2 = add         { $expression = new LessOrEqualExpression($expression, $expression2.expression); }
        | 'less'   expression2 = add                { $expression = new LessExpression($expression, $expression2.expression); }
        | 'greater'   expression2 = add             { $expression = new GreaterExpression($expression, $expression2.expression); }
        | 'greaterOrEqual' add  expression2 = add   { $expression = new GreaterOrEqualExpression($expression, $expression2.expression); }
        )*
    ;


expression returns [Expression expression]
    :   expression1 = relation               { $expression = $expression1.expression; }
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