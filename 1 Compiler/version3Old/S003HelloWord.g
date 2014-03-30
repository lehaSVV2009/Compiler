grammar S003HelloWord;

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
    import com.kadet.compiler.S003HelloWordCompiler.S003HelloWordError;
}

@rulecatch {
    catch(RecognitionException e) {
        throw new S003HelloWordError(":(", e);
    }
}

SALUTATION: 'Hello World';
ENDSYMBOL: '!';

expression: SALUTATION ENDSYMBOL;