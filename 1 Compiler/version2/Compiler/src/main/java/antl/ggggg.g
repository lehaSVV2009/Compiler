grammar ggggg;

options {
  language = Java;
  output=template;
}

tokens{DEDENT;}

@header{
	import java.util.*;
}

class MyLexer extends Lexer;
options{
	charVocabulary = ''..'177';
}


NAME: (('a'..'z')|('A'..'Z'))
 (('a'..'z')|('A'..'Z')|('0'..'9'))*
  ;

NUM: ('0'..'9')+;

SPACES:  (
		' '|'t'|
      (('n'|"rn"){newline();})
         )+
	{$setType(Token.SKIP);}
;

class MyParser extends Parser;
{
	public Hashtable results = new Hashtable();
}
mainRule:
	(element)+
	"END"
	;
element:
	name:NAME number:NUM
{
	results.put(name.getText(), number.getText());
}
	;
