grammar S002HelloWord;

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
    import com.kadet.compiler.S002HelloWordCompiler.S002HelloWordError;
}


SALUTATION: 'Hello World';
ENDSYMBOL: '!';

expression: SALUTATION ENDSYMBOL;
catch[RecognitionException e] {
    throw new S002HelloWordError(":(", e);
}
