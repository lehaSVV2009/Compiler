grammar S004HelloWord;

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


@lexer::members {

    private List<RecognitionException> errors = new ArrayList<RecognitionException>();

    public List<RecognitionException> getAllErrors () {
        return new ArrayList<RecognitionException>(errors);
    }

    public boolean hasErrors () {
        return !errors.isEmpty();
    }

    public void reportError (RecognitionException e) {
        errors.add(e);
        displayRecognitionError(this.getTokenNames(), e);
    }

}

@parser::members {

    private List<RecognitionException> errors = new ArrayList<RecognitionException>();

    public List<RecognitionException> getAllErrors () {
        return new ArrayList<RecognitionException>(errors);
    }

    public boolean hasErrors () {
        return !errors.isEmpty();
    }

    public void reportError (RecognitionException e) {
        errors.add(e);
        displayRecognitionError(this.getTokenNames(), e);
    }

}




SALUTATION: 'Hello World';
ENDSYMBOL: '!';

expression: SALUTATION ENDSYMBOL;
