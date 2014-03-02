tree grammar ListLangWalker;

options {
	language = Python;
	tokenVocab=ListLang;	// import tokens
	ASTLabelType=CommonTree;
}

@header {
	import ll_scope
	import jtrans
	from ll_scope import Scope
	
	translator = jtrans.JTranslator()
}

program returns[code]
scope {
	global_scope;
}
@init {
	translator.walker = self
	$program::global_scope = Scope()
	translator.enter_scope($program::global_scope)
}
@after {
	$code = translator.program()
	translator.leave_scope()
}
	:	slist[$program::global_scope]
	;
	
slist[init_scope]
scope {
	local_scope;
}
@init {	
	$slist::local_scope = $slist.init_scope
}
	:	^( SLIST statement+ )
	;
	
statement
	:	function
	|	operation
	;
	
function
scope {
	params;
	function_scope;
}
@init {
	$function::params = []
	$function::function_scope = None
}
	:	^( DEFINE ID param* 
			{$function::function_scope = Scope(scope_name=$ID.text, global_scope=$program::global_scope)}
			{translator.enter_scope($function::function_scope)}			
			{for p_id, p_type in $function::params: $function::function_scope.add_var(p_id, p_type)}
			{$slist::local_scope.add_function($function::params, $function::function_scope)}
		function_slist )
			{translator.leave_scope()}
			{translator.function($function::params, $function::function_scope)}
	;
	
function_slist
	:	slist[$function::function_scope]
	;

param
	:	^( PARAM TYPE ID ) {$function::params.append(($ID.text, $TYPE.text))}
	;
	
block_slist
	:	slist[$slist::local_scope]
	;

operation
	:	^( WHILE 
			{translator.while_operation_begin()}
		val=rvalue 
			{translator.while_operation_value($val.type)}
		block_slist)
			{translator.while_operation()}
			
	|	^( FOR ID val=rvalue
			{translator.for_operation_begin($ID.text, $val.type)}
		block_slist 
			{translator.for_operation()}
		)
	|	^( IF val=rvalue 
			{translator.if_operation_value($val.type)}
		block_slist
			{translator.if_operation_else()}
		elif_operation* else_operation? 
			{translator.if_operation()} 
		) 
			
		
	|	^( PRINT (val=rvalue
			{translator.print_value($val.type)}
		)* ) 
			{translator.print_operation()}
	|	^( RETURN val=rvalue? ) 
			{translator.return_operation($val.type)}
			
	|	^( GLOBAL ID )
			{translator.global_operation($ID.text)}
	|	expr
	;

elif_operation
	:	^( ELIF val=rvalue
			{translator.if_operation_value($val.type, is_elif=True)}
		block_slist 
			{translator.if_operation_else()}
		)
	;

else_operation
	:	^( ELSE block_slist )
	;

expr
	:	assignment_expr
	| 	rvalue
	;

assignment_expr
	:	^( ASS_OP ID rvalue ) {translator.assignment_expr($ID.text, $rvalue.type)}
	;	

rvalue returns[type]
	:	^( OR_OP val1=rvalue val2=rvalue )
			{$type = translator.or_expr($val1.type, $val2.type)}
			
	|	^( AND_OP val1=rvalue val2=rvalue )
			{$type = translator.and_expr($val1.type, $val2.type)}
			
	|	^( EQ_OP val1=rvalue val2=rvalue )
			{$type = translator.equality_expr($EQ_OP.text, $val1.type, $val2.type)}
			
	|	^( REL_OP val1=rvalue val2=rvalue )
			{$type = translator.relational_expr($REL_OP.text, $val1.type, $val2.type)}
	
	|	^( ADD_OP val1=rvalue val2=rvalue )
			{$type = translator.additive_expr($ADD_OP.text, $val1.type, $val2.type)}
			
	|	^( MUL_OP val1=rvalue val2=rvalue )
			{$type = translator.multiplicative_expr($MUL_OP.text, $val1.type, $val2.type)}
			
	|	^( PRE_INCR val=rvalue )
			{$type = translator.pre_incr_expr($val.type)}
			
	|	^( PRE_DECR val=rvalue )
			{$type = translator.pre_decr_expr($val.type)}
	
	|	^( NOT_OP val=rvalue )		{$type = translator.not_expr($val.type)}
	
	|	^( INCR_OP val=rvalue )
			{$type = translator.post_incr_expr($val.type)}
	
	|	^( DECR_OP val=rvalue )
			{$type = translator.post_decr_expr($val.type)}
	
	|	^( CALL
			{types = []}
		 ID (val=rvalue
		 	{types.append($val.type)}
		 )* )
			{$type = translator.call_expr($ID.text, types)}
	
	|	^( CAST TYPE val=rvalue ) 
			{$type = translator.cast_expr($val.type, $TYPE.text)}
	
	|	^( L_SQUARE_BRACKET list_val=rvalue val1=rvalue COLON? val2=rvalue? )
			{$type = translator.slice_expr($list_val.type, $val1.type, $val2.type)}
	
	|	^( LIST_MAKER			{translator.list_maker_begin()}
		(val = rvalue 			{translator.list_maker_arg($val.type)} 
		)* )				{$type = translator.list_maker()}
		
	|	INT 				{$type = translator.element_literal(int($INT.text))}
	
	|	ID 				{$type = translator.var_identifier($ID.text)}
	;