grammar ggggg;

options {
  language = Java;
  output=AST;
  // output=template;
}

tokens{DEDENT;}

@header {
  package com.kadet.compiler;
}


@lexer::header {  
  package com.kadet.compiler;
  import java.util.Deque;
  import java.util.ArrayList;
  import java.util.List;
  import java.util.LinkedList;
  import org.antlr.stringtemplate.*;
  
  
}	

@lexer::members {

    int curLevel= 0;
    int prevLevel=0;
    int startPos=0;
    boolean isNewBlock = false;
    
    ClassicToken token = null;
    
    Stack<Integer> levels = new Stack<Integer>();
     Deque<Token> tokens = new java.util.ArrayDeque<Token>();

    @Override
    public void emit(Token token) {
        state.token = token;
        tokens.addLast(token);
    }
 
    @Override
    public Token nextToken() {
        super.nextToken();
  
        if (tokens.isEmpty())
            return Token.EOF_TOKEN;  //EOF_TOKEN;
        return tokens.removeFirst();
        
    }
}

@members
{
  AllDescTable table = new AllDescTable();
}
  
    
  
program
@init {
  int stageProg = 0;
  }
  :  
     (globalsVar {if(stageProg<=1){stageProg = 1;} else {Errors.WrongStageVar($globalsVar.varline);}} 
     | function {if(stageProg<=2){stageProg = 2;} else {Errors.WrongStageFun($function.funline);}}
     | main {if(stageProg<=3){stageProg = 3;} else {Errors.WrongStageMain($main.mainline);}}
     )+ ;

	
globalsVar
returns[int varline]
  : assignOp l=';' {$varline = $l.line;} ENDL
  ;

function
returns[int funline]
@after {
 table.clearCurFun();
}
	:	functionHeader {$funline = $functionHeader.funline;} 
		block {table.checkReturnable($block.hasLastRet, $functionHeader.funline);} CLEAR_LINE
	;
	
functionHeader
returns[int funline]
  : FUNCTION id=ID {table.defineFun($id.text,$id.line);$funline = $id.line;} '[' formalArgsList ']'     
  ;
	
formalArgsList
  : (id=ID {table.addParametr($id.text,$id.line);}(',' idi=ID {table.addParametr($idi.text,$idi.line);} )*)?    
  ;
	
main
returns[int mainline]
@init {
 table.defineCurFun(table.MAIN_NAME);
}
@after {
  table.clearCurFun();
}
	:	MAIN { $mainline = $MAIN.line;} block CLEAR_LINE
	;
	
fragment block returns [List blocks, boolean hasLastRet]									
scope{List stmts;
		}
@init{
  $block::stmts = new ArrayList();
  $blocks = new ArrayList();
  boolean isRet = false;
  boolean isPrevIf = false;
  boolean isIfRet = false;  
} 

  :   ENDL INDENT 
      (codeBlock 
      {
        if(!isPrevIf && $codeBlock.isElse) Errors.WrongIfElse($codeBlock.line);
        if(isRet && !isPrevIf)Errors.BadAfterRet($codeBlock.line);
        if($codeBlock.isRet && ((!$codeBlock.isIf && !$codeBlock.isElse) || ($codeBlock.isElse && isIfRet))){isRet=true;table.setFunReturnable();}
        isPrevIf = $codeBlock.isIf;
        if($codeBlock.isIf) isIfRet=$codeBlock.isRet;   
      }
      )+  
      {$hasLastRet=$codeBlock.isRet;}
      DEDENT    
  ;

codeBlock
returns[boolean isRet, int line, boolean isIf, boolean isElse]
@init{
  $isRet=false;
  $isIf=false;
  $isElse=false;
}
	:	(	assignOp l=';'   { $line=$l.line;}       
	|	functionCall l=';' { $line=$l.line;}   
	|	ifOp	             { $isIf=true; $isRet=$ifOp.hasLastRet; $line=$ifOp.line;} 
	|	whileOp            { $isRet=$whileOp.hasLastRet; $line=$whileOp.line;} 
	|	forOp              { $isRet=$forOp.hasLastRet; $line=$forOp.line;} 
	|	elseOp             { $isElse=true; $isRet=$elseOp.hasLastRet; $line=$elseOp.line;} 
	|	returnOp l=';'     { $isRet=true; $line=$l.line;}
	|	inOp		l=';'      { $line=$l.line;}        
	|	outOp		l=';'      { $line=$l.line;}
	)(ENDL| )
	;
	
returnOp
	:	ret='return'  expr {table.setFunRetType($expr.type,$ret.line);}
	;

inOp
  : 'Alin' '['id=ID {table.addVariable($id.text,$id.line);}']' 
  ;
	
outOp
  : 'Alout' '['(STRING | expr)']'
  ;


assignOp
	:	id=ID {table.addVariable($id.text,$id.line);} 
	 '=' e=expr {table.initVariable($id.text,$e.type);}
	 ;

ifOp
returns[int line, boolean hasLastRet]
	:	IF {$line=$IF.line;} '['eqNotEqExpr']' block  {$hasLastRet=$block.hasLastRet;} 
	;
	
elseOp
returns[int line, boolean hasLastRet]
	:	ELSE {$line=$ELSE.line;} block  {$hasLastRet=$block.hasLastRet;} 
	;

whileOp
returns[int line, boolean hasLastRet]
  : WHILE {$line=$WHILE.line;} '['eqNotEqExpr']' block {$hasLastRet=$block.hasLastRet;} 
	;

forOp
returns[int line, boolean hasLastRet]
  : FOR {$line=$FOR.line;} '[' assignOp ';' eqNotEqExpr ';' assignOp ']' block {$hasLastRet=$block.hasLastRet;} 
	;


eqNotEqExpr
returns [Type type]
@init{
  $type = Type.BOOL;
}
  : a1=expr (l=('<'|'<='|'>'|'>='|'=='|'!=') a2=expr {table.equalType($a1.type,$a2.type,$l.line);})?
  ;

expr
returns [Type type]
  : m1=multDivExpr {$type=$m1.type;} (l=('+'|'-') m2=multDivExpr {table.equalType($m1.type,$m2.type,$l.line);})*
  ; 

multDivExpr
returns [Type type]
    : p1=powExpr {$type=$p1.type;} (l=('*'|'/'|'%') p2=powExpr {table.equalType($p1.type,$p2.type,$l.line);})*
  ;

powExpr
returns [Type type]
  : a1 = atom {$type=$a1.type;} (l='^'a2 = atom {table.equalType(Type.INT,$a2.type,$l.line);})?
  ;


atom
  returns [Type type]
  : INT             {$type = Type.INT;}
  | FLOAT           {$type = Type.FLOAT;}
  | funcOrVarCall   {$type = $funcOrVarCall.type;}
  | '['expr']'      {$type = $expr.type;}
  | '['typeper']'   {$type = $typeper.type;} funcOrVarCall 
  ;
  
funcOrVarCall
returns [Type type]
@init{
 $type = Type.NON;
 boolean isFun = false;
}
  : id=ID ( {isFun=true;} '['argsList {table.checkFunParam($id.text,$argsList.types,$id.line);}']')?
  {
    if(isFun) {
     if(!table.checkUndefinedFun($id.text,$id.line)) {
      $type=table.getFunType($id.text);
     }
    } else {
     $type=table.getVarType($id.text);
     table.checkInitializeVar($id.text,$id.line);
    }
   }
  ;

functionCall
    : id=ID {table.checkUndefinedFun($id.text,$id.line);} '['argsList {table.checkFunParam($id.text,$argsList.types,$id.line);} ']'
    ;

argsList
returns [List<Type> types]
	@init {
  $types = new ArrayList<Type>();
  }
  : (e1=expr {$types.add($e1.type);} 
     (',' e2=expr {$types.add($e2.type);})*)?
     
     ;

typeper
  returns [Type type]
	:	'int'    {$type = Type.INT;}
	|	'float'  {$type = Type.FLOAT;}
	;

DEDENT  :';'; 	
									
FUNCTION
  : 'Alenafun' {isNewBlock=true;}
  ;
  
MAIN
  : 'Alenamain' {isNewBlock=true;}
  ;
  
WHILE
  : 'while' {isNewBlock=true;}
  ;
  
FOR : 'for' {isNewBlock=true;}
  ;
  
IF  :'if' {isNewBlock=true;}
  ;
  
ELSE
  :'else' {isNewBlock=true;}
  ;
	
ID  :	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;

INT :	'0'..'9'+
    ;

FLOAT
    :   ('0'..'9')+ '.' ('0'..'9')+ 
    ;
    
TAB 	: '	'  | '\\t'
	;

ENDL	
	:	'\n'
	;
	
WS  :   ( ' '
        | '\r'
        ) {$channel=HIDDEN;}
    ;

STRING
    :  '"' ( ~('\\'|'"') )* '"'
    ;

COMMENT
    :   '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    |   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ;

INDENT													
@init{  curLevel=0; }
:
  {getCharPositionInLine()==0}?=> ({curLevel++; } t=TAB)+

{
  if(levels.empty()) {levels.push(0);}

  if (curLevel > levels.peek().intValue())
  {
   if(!isNewBlock) {
      Errors.BadBlockLine($t.line);         
    } else {    
      levels.push(curLevel);
      emit(new ClassicToken(INDENT,"INDENT"));
    }
    
    isNewBlock=false;
  } 
  
  if(curLevel < levels.peek().intValue())
  {
    while (curLevel < levels.peek().intValue()) 
    {
    levels.pop();
    emit(new ClassicToken(DEDENT,"DEDENT"));
    }
  }
  if(curLevel == levels.peek().intValue()) { skip(); }
 
};

CLEAR_LINE																	
  :  {getCharPositionInLine()==1 || getCharPositionInLine()==0 }?=> ENDL 
  {
  if(levels.peek().intValue()!=0)
  {
    while(levels.peek()!=0)
    {
    
    levels.pop();
    emit(new ClassicToken(DEDENT,"DEDENT"));
    }
  }  
  }
  ; 