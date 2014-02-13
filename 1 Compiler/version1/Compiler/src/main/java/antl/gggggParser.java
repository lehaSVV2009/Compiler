// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g 2013-06-24 01:24:52

package antl;


import org.antlr.runtime.*;
import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.antlr.stringtemplate.language.AngleBracketTemplateLexer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class gggggParser extends Parser {
    public static final String[] tokenNames = new String[]{
            "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DEDENT", "ENDL", "CLEAR_LINE", "FUNCTION", "ID", "MAIN", "INDENT", "STRING", "IF", "ELSE", "WHILE", "FOR", "INT", "FLOAT", "TAB", "WS", "COMMENT", "'['", "']'", "','", "'return'", "'Alin'", "'Alout'", "'='", "'<'", "'<='", "'>'", "'>='", "'=='", "'!='", "'+'", "'-'", "'*'", "'/'", "'%'", "'^'", "'int'", "'float'"
    };
    public static final int EOF = -1;
    public static final int T__21 = 21;
    public static final int T__22 = 22;
    public static final int T__23 = 23;
    public static final int T__24 = 24;
    public static final int T__25 = 25;
    public static final int T__26 = 26;
    public static final int T__27 = 27;
    public static final int T__28 = 28;
    public static final int T__29 = 29;
    public static final int T__30 = 30;
    public static final int T__31 = 31;
    public static final int T__32 = 32;
    public static final int T__33 = 33;
    public static final int T__34 = 34;
    public static final int T__35 = 35;
    public static final int T__36 = 36;
    public static final int T__37 = 37;
    public static final int T__38 = 38;
    public static final int T__39 = 39;
    public static final int T__40 = 40;
    public static final int T__41 = 41;
    public static final int DEDENT = 4;
    public static final int ENDL = 5;
    public static final int CLEAR_LINE = 6;
    public static final int FUNCTION = 7;
    public static final int ID = 8;
    public static final int MAIN = 9;
    public static final int INDENT = 10;
    public static final int STRING = 11;
    public static final int IF = 12;
    public static final int ELSE = 13;
    public static final int WHILE = 14;
    public static final int FOR = 15;
    public static final int INT = 16;
    public static final int FLOAT = 17;
    public static final int TAB = 18;
    public static final int WS = 19;
    public static final int COMMENT = 20;

    // delegates
    // delegators


    public gggggParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }

    public gggggParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);

    }

    protected StringTemplateGroup templateLib =
            new StringTemplateGroup("gggggParserTemplates", AngleBracketTemplateLexer.class);

    public void setTemplateLib(StringTemplateGroup templateLib) {
        this.templateLib = templateLib;
    }

    public StringTemplateGroup getTemplateLib() {
        return templateLib;
    }

    /**
     * allows convenient multi-value initialization:
     * "new STAttrMap().put(...).put(...)"
     */
    public static class STAttrMap extends HashMap {
        public STAttrMap put(String attrName, Object value) {
            super.put(attrName, value);
            return this;
        }

        public STAttrMap put(String attrName, int value) {
            super.put(attrName, new Integer(value));
            return this;
        }
    }

    public String[] getTokenNames() {
        return gggggParser.tokenNames;
    }

    public String getGrammarFileName() {
        return "C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g";
    }


    AllDescTable table = new AllDescTable();


    public static class program_return extends ParserRuleReturnScope {
        public StringTemplate st;

        public Object getTemplate() {
            return st;
        }

        public String toString() {
            return st == null ? null : st.toString();
        }
    }

    ;

    // $ANTLR start "program"
    // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:62:1: program : ( globalsVar | function | main )+ ;
    public final program_return program() throws RecognitionException {
        program_return retval = new program_return();
        retval.start = input.LT(1);

        globalsVar_return globalsVar1 = null;

        function_return function2 = null;

        main_return main3 = null;


        int stageProg = 0;

        try {
            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:66:3: ( ( globalsVar | function | main )+ )
            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:67:6: ( globalsVar | function | main )+
            {
                // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:67:6: ( globalsVar | function | main )+
                int cnt1 = 0;
                loop1:
                do {
                    int alt1 = 4;
                    switch (input.LA(1)) {
                        case ID: {
                            alt1 = 1;
                        }
                        break;
                        case FUNCTION: {
                            alt1 = 2;
                        }
                        break;
                        case MAIN: {
                            alt1 = 3;
                        }
                        break;

                    }

                    switch (alt1) {
                        case 1:
                            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:67:7: globalsVar
                        {
                            pushFollow(FOLLOW_globalsVar_in_program94);
                            globalsVar1 = globalsVar();

                            state._fsp--;

                            if (stageProg <= 1) {
                                stageProg = 1;
                            } else {
                                Errors.WrongStageVar((globalsVar1 != null ? globalsVar1.varline : 0));
                            }

                        }
                        break;
                        case 2:
                            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:68:8: function
                        {
                            pushFollow(FOLLOW_function_in_program106);
                            function2 = function();

                            state._fsp--;

                            if (stageProg <= 2) {
                                stageProg = 2;
                            } else {
                                Errors.WrongStageFun((function2 != null ? function2.funline : 0));
                            }

                        }
                        break;
                        case 3:
                            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:69:8: main
                        {
                            pushFollow(FOLLOW_main_in_program117);
                            main3 = main();

                            state._fsp--;

                            if (stageProg <= 3) {
                                stageProg = 3;
                            } else {
                                Errors.WrongStageMain((main3 != null ? main3.mainline : 0));
                            }

                        }
                        break;

                        default:
                            if (cnt1 >= 1) break loop1;
                            EarlyExitException eee =
                                    new EarlyExitException(1, input);
                            throw eee;
                    }
                    cnt1++;
                } while (true);


            }

            retval.stop = input.LT(-1);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
        }
        return retval;
    }
    // $ANTLR end "program"

    public static class globalsVar_return extends ParserRuleReturnScope {
        public int varline;
        public StringTemplate st;

        public Object getTemplate() {
            return st;
        }

        public String toString() {
            return st == null ? null : st.toString();
        }
    }

    ;

    // $ANTLR start "globalsVar"
    // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:73:1: globalsVar returns [int varline] : assignOp l= ';' ENDL ;
    public final globalsVar_return globalsVar() throws RecognitionException {
        globalsVar_return retval = new globalsVar_return();
        retval.start = input.LT(1);

        Token l = null;

        try {
            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:75:3: ( assignOp l= ';' ENDL )
            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:75:5: assignOp l= ';' ENDL
            {
                pushFollow(FOLLOW_assignOp_in_globalsVar143);
                assignOp();

                state._fsp--;

                l = (Token) match(input, DEDENT, FOLLOW_DEDENT_in_globalsVar147);
                retval.varline = (l != null ? l.getLine() : 0);
                match(input, ENDL, FOLLOW_ENDL_in_globalsVar151);

            }

            retval.stop = input.LT(-1);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
        }
        return retval;
    }
    // $ANTLR end "globalsVar"

    public static class function_return extends ParserRuleReturnScope {
        public int funline;
        public StringTemplate st;

        public Object getTemplate() {
            return st;
        }

        public String toString() {
            return st == null ? null : st.toString();
        }
    }

    ;

    // $ANTLR start "function"
    // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:78:1: function returns [int funline] : functionHeader block CLEAR_LINE ;
    public final function_return function() throws RecognitionException {
        function_return retval = new function_return();
        retval.start = input.LT(1);

        functionHeader_return functionHeader4 = null;

        block_return block5 = null;


        try {
            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:83:2: ( functionHeader block CLEAR_LINE )
            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:83:4: functionHeader block CLEAR_LINE
            {
                pushFollow(FOLLOW_functionHeader_in_function171);
                functionHeader4 = functionHeader();

                state._fsp--;

                retval.funline = (functionHeader4 != null ? functionHeader4.funline : 0);
                pushFollow(FOLLOW_block_in_function178);
                block5 = block();

                state._fsp--;

                table.checkReturnable((block5 != null ? block5.hasLastRet : false), (functionHeader4 != null ? functionHeader4.funline : 0));
                match(input, CLEAR_LINE, FOLLOW_CLEAR_LINE_in_function182);

            }

            retval.stop = input.LT(-1);


            table.clearCurFun();

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
        }
        return retval;
    }
    // $ANTLR end "function"

    public static class functionHeader_return extends ParserRuleReturnScope {
        public int funline;
        public StringTemplate st;

        public Object getTemplate() {
            return st;
        }

        public String toString() {
            return st == null ? null : st.toString();
        }
    }

    ;

    // $ANTLR start "functionHeader"
    // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:87:1: functionHeader returns [int funline] : FUNCTION id= ID '[' formalArgsList ']' ;
    public final functionHeader_return functionHeader() throws RecognitionException {
        functionHeader_return retval = new functionHeader_return();
        retval.start = input.LT(1);

        Token id = null;

        try {
            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:89:3: ( FUNCTION id= ID '[' formalArgsList ']' )
            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:89:5: FUNCTION id= ID '[' formalArgsList ']'
            {
                match(input, FUNCTION, FOLLOW_FUNCTION_in_functionHeader198);
                id = (Token) match(input, ID, FOLLOW_ID_in_functionHeader202);
                table.defineFun((id != null ? id.getText() : null), (id != null ? id.getLine() : 0));
                retval.funline = (id != null ? id.getLine() : 0);
                match(input, 21, FOLLOW_21_in_functionHeader206);
                pushFollow(FOLLOW_formalArgsList_in_functionHeader208);
                formalArgsList();

                state._fsp--;

                match(input, 22, FOLLOW_22_in_functionHeader210);

            }

            retval.stop = input.LT(-1);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
        }
        return retval;
    }
    // $ANTLR end "functionHeader"

    public static class formalArgsList_return extends ParserRuleReturnScope {
        public StringTemplate st;

        public Object getTemplate() {
            return st;
        }

        public String toString() {
            return st == null ? null : st.toString();
        }
    }

    ;

    // $ANTLR start "formalArgsList"
    // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:92:1: formalArgsList : (id= ID ( ',' idi= ID )* )? ;
    public final formalArgsList_return formalArgsList() throws RecognitionException {
        formalArgsList_return retval = new formalArgsList_return();
        retval.start = input.LT(1);

        Token id = null;
        Token idi = null;

        try {
            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:93:3: ( (id= ID ( ',' idi= ID )* )? )
            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:93:5: (id= ID ( ',' idi= ID )* )?
            {
                // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:93:5: (id= ID ( ',' idi= ID )* )?
                int alt3 = 2;
                int LA3_0 = input.LA(1);

                if ((LA3_0 == ID)) {
                    alt3 = 1;
                }
                switch (alt3) {
                    case 1:
                        // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:93:6: id= ID ( ',' idi= ID )*
                    {
                        id = (Token) match(input, ID, FOLLOW_ID_in_formalArgsList232);
                        table.addParametr((id != null ? id.getText() : null), (id != null ? id.getLine() : 0));
                        // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:93:51: ( ',' idi= ID )*
                        loop2:
                        do {
                            int alt2 = 2;
                            int LA2_0 = input.LA(1);

                            if ((LA2_0 == 23)) {
                                alt2 = 1;
                            }


                            switch (alt2) {
                                case 1:
                                    // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:93:52: ',' idi= ID
                                {
                                    match(input, 23, FOLLOW_23_in_formalArgsList236);
                                    idi = (Token) match(input, ID, FOLLOW_ID_in_formalArgsList240);
                                    table.addParametr((idi != null ? idi.getText() : null), (idi != null ? idi.getLine() : 0));

                                }
                                break;

                                default:
                                    break loop2;
                            }
                        } while (true);


                    }
                    break;

                }


            }

            retval.stop = input.LT(-1);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
        }
        return retval;
    }
    // $ANTLR end "formalArgsList"

    public static class main_return extends ParserRuleReturnScope {
        public int mainline;
        public StringTemplate st;

        public Object getTemplate() {
            return st;
        }

        public String toString() {
            return st == null ? null : st.toString();
        }
    }

    ;

    // $ANTLR start "main"
    // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:96:1: main returns [int mainline] : MAIN block CLEAR_LINE ;
    public final main_return main() throws RecognitionException {
        main_return retval = new main_return();
        retval.start = input.LT(1);

        Token MAIN6 = null;


        table.defineCurFun(table.MAIN_NAME);

        try {
            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:104:2: ( MAIN block CLEAR_LINE )
            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:104:4: MAIN block CLEAR_LINE
            {
                MAIN6 = (Token) match(input, MAIN, FOLLOW_MAIN_in_main277);
                retval.mainline = (MAIN6 != null ? MAIN6.getLine() : 0);
                pushFollow(FOLLOW_block_in_main281);
                block();

                state._fsp--;

                match(input, CLEAR_LINE, FOLLOW_CLEAR_LINE_in_main283);

            }

            retval.stop = input.LT(-1);


            table.clearCurFun();

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
        }
        return retval;
    }
    // $ANTLR end "main"

    protected static class block_scope {
        List stmts;
    }

    protected Stack block_stack = new Stack();

    public static class block_return extends ParserRuleReturnScope {
        public List blocks;
        public boolean hasLastRet;
        public StringTemplate st;

        public Object getTemplate() {
            return st;
        }

        public String toString() {
            return st == null ? null : st.toString();
        }
    }

    ;

    // $ANTLR start "block"
    // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:107:10: fragment block returns [List blocks, boolean hasLastRet] : ENDL INDENT ( codeBlock )+ DEDENT ;
    public final block_return block() throws RecognitionException {
        block_stack.push(new block_scope());
        block_return retval = new block_return();
        retval.start = input.LT(1);

        codeBlock_return codeBlock7 = null;


        ((block_scope) block_stack.peek()).stmts = new ArrayList();
        retval.blocks = new ArrayList();
        boolean isRet = false;
        boolean isPrevIf = false;
        boolean isIfRet = false;

        try {
            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:118:3: ( ENDL INDENT ( codeBlock )+ DEDENT )
            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:118:7: ENDL INDENT ( codeBlock )+ DEDENT
            {
                match(input, ENDL, FOLLOW_ENDL_in_block322);
                match(input, INDENT, FOLLOW_INDENT_in_block324);
                // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:119:7: ( codeBlock )+
                int cnt4 = 0;
                loop4:
                do {
                    int alt4 = 2;
                    int LA4_0 = input.LA(1);

                    if ((LA4_0 == ID || (LA4_0 >= IF && LA4_0 <= FOR) || (LA4_0 >= 24 && LA4_0 <= 26))) {
                        alt4 = 1;
                    }


                    switch (alt4) {
                        case 1:
                            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:119:8: codeBlock
                        {
                            pushFollow(FOLLOW_codeBlock_in_block334);
                            codeBlock7 = codeBlock();

                            state._fsp--;


                            if (!isPrevIf && (codeBlock7 != null ? codeBlock7.isElse : false))
                                Errors.WrongIfElse((codeBlock7 != null ? codeBlock7.line : 0));
                            if (isRet && !isPrevIf) Errors.BadAfterRet((codeBlock7 != null ? codeBlock7.line : 0));
                            if ((codeBlock7 != null ? codeBlock7.isRet : false) && ((!(codeBlock7 != null ? codeBlock7.isIf : false) && !(codeBlock7 != null ? codeBlock7.isElse : false)) || ((codeBlock7 != null ? codeBlock7.isElse : false) && isIfRet))) {
                                isRet = true;
                                table.setFunReturnable();
                            }
                            isPrevIf = (codeBlock7 != null ? codeBlock7.isIf : false);
                            if ((codeBlock7 != null ? codeBlock7.isIf : false))
                                isIfRet = (codeBlock7 != null ? codeBlock7.isRet : false);


                        }
                        break;

                        default:
                            if (cnt4 >= 1) break loop4;
                            EarlyExitException eee =
                                    new EarlyExitException(4, input);
                            throw eee;
                    }
                    cnt4++;
                } while (true);

                retval.hasLastRet = (codeBlock7 != null ? codeBlock7.isRet : false);
                match(input, DEDENT, FOLLOW_DEDENT_in_block370);

            }

            retval.stop = input.LT(-1);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
            block_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "block"

    public static class codeBlock_return extends ParserRuleReturnScope {
        public boolean isRet;
        public int line;
        public boolean isIf;
        public boolean isElse;
        public StringTemplate st;

        public Object getTemplate() {
            return st;
        }

        public String toString() {
            return st == null ? null : st.toString();
        }
    }

    ;

    // $ANTLR start "codeBlock"
    // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:132:1: codeBlock returns [boolean isRet, int line, boolean isIf, boolean isElse] : ( assignOp l= ';' | functionCall l= ';' | ifOp | whileOp | forOp | elseOp | returnOp l= ';' | inOp l= ';' | outOp l= ';' ) ( ENDL | ) ;
    public final codeBlock_return codeBlock() throws RecognitionException {
        codeBlock_return retval = new codeBlock_return();
        retval.start = input.LT(1);

        Token l = null;
        ifOp_return ifOp8 = null;

        whileOp_return whileOp9 = null;

        forOp_return forOp10 = null;

        elseOp_return elseOp11 = null;


        retval.isRet = false;
        retval.isIf = false;
        retval.isElse = false;

        try {
            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:139:2: ( ( assignOp l= ';' | functionCall l= ';' | ifOp | whileOp | forOp | elseOp | returnOp l= ';' | inOp l= ';' | outOp l= ';' ) ( ENDL | ) )
            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:139:4: ( assignOp l= ';' | functionCall l= ';' | ifOp | whileOp | forOp | elseOp | returnOp l= ';' | inOp l= ';' | outOp l= ';' ) ( ENDL | )
            {
                // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:139:4: ( assignOp l= ';' | functionCall l= ';' | ifOp | whileOp | forOp | elseOp | returnOp l= ';' | inOp l= ';' | outOp l= ';' )
                int alt5 = 9;
                alt5 = dfa5.predict(input);
                switch (alt5) {
                    case 1:
                        // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:139:6: assignOp l= ';'
                    {
                        pushFollow(FOLLOW_assignOp_in_codeBlock395);
                        assignOp();

                        state._fsp--;

                        l = (Token) match(input, DEDENT, FOLLOW_DEDENT_in_codeBlock399);
                        retval.line = (l != null ? l.getLine() : 0);

                    }
                    break;
                    case 2:
                        // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:140:4: functionCall l= ';'
                    {
                        pushFollow(FOLLOW_functionCall_in_codeBlock415);
                        functionCall();

                        state._fsp--;

                        l = (Token) match(input, DEDENT, FOLLOW_DEDENT_in_codeBlock419);
                        retval.line = (l != null ? l.getLine() : 0);

                    }
                    break;
                    case 3:
                        // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:141:4: ifOp
                    {
                        pushFollow(FOLLOW_ifOp_in_codeBlock429);
                        ifOp8 = ifOp();

                        state._fsp--;

                        retval.isIf = true;
                        retval.isRet = (ifOp8 != null ? ifOp8.hasLastRet : false);
                        retval.line = (ifOp8 != null ? ifOp8.line : 0);

                    }
                    break;
                    case 4:
                        // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:142:4: whileOp
                    {
                        pushFollow(FOLLOW_whileOp_in_codeBlock450);
                        whileOp9 = whileOp();

                        state._fsp--;

                        retval.isRet = (whileOp9 != null ? whileOp9.hasLastRet : false);
                        retval.line = (whileOp9 != null ? whileOp9.line : 0);

                    }
                    break;
                    case 5:
                        // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:143:4: forOp
                    {
                        pushFollow(FOLLOW_forOp_in_codeBlock469);
                        forOp10 = forOp();

                        state._fsp--;

                        retval.isRet = (forOp10 != null ? forOp10.hasLastRet : false);
                        retval.line = (forOp10 != null ? forOp10.line : 0);

                    }
                    break;
                    case 6:
                        // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:144:4: elseOp
                    {
                        pushFollow(FOLLOW_elseOp_in_codeBlock490);
                        elseOp11 = elseOp();

                        state._fsp--;

                        retval.isElse = true;
                        retval.isRet = (elseOp11 != null ? elseOp11.hasLastRet : false);
                        retval.line = (elseOp11 != null ? elseOp11.line : 0);

                    }
                    break;
                    case 7:
                        // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:145:4: returnOp l= ';'
                    {
                        pushFollow(FOLLOW_returnOp_in_codeBlock510);
                        returnOp();

                        state._fsp--;

                        l = (Token) match(input, DEDENT, FOLLOW_DEDENT_in_codeBlock514);
                        retval.isRet = true;
                        retval.line = (l != null ? l.getLine() : 0);

                    }
                    break;
                    case 8:
                        // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:146:4: inOp l= ';'
                    {
                        pushFollow(FOLLOW_inOp_in_codeBlock525);
                        inOp();

                        state._fsp--;

                        l = (Token) match(input, DEDENT, FOLLOW_DEDENT_in_codeBlock530);
                        retval.line = (l != null ? l.getLine() : 0);

                    }
                    break;
                    case 9:
                        // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:147:4: outOp l= ';'
                    {
                        pushFollow(FOLLOW_outOp_in_codeBlock550);
                        outOp();

                        state._fsp--;

                        l = (Token) match(input, DEDENT, FOLLOW_DEDENT_in_codeBlock555);
                        retval.line = (l != null ? l.getLine() : 0);

                    }
                    break;

                }

                // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:148:3: ( ENDL | )
                int alt6 = 2;
                int LA6_0 = input.LA(1);

                if ((LA6_0 == ENDL)) {
                    alt6 = 1;
                } else if ((LA6_0 == DEDENT || LA6_0 == ID || (LA6_0 >= IF && LA6_0 <= FOR) || (LA6_0 >= 24 && LA6_0 <= 26))) {
                    alt6 = 2;
                } else {
                    NoViableAltException nvae =
                            new NoViableAltException("", 6, 0, input);

                    throw nvae;
                }
                switch (alt6) {
                    case 1:
                        // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:148:4: ENDL
                    {
                        match(input, ENDL, FOLLOW_ENDL_in_codeBlock567);

                    }
                    break;
                    case 2:
                        // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:148:10:
                    {
                    }
                    break;

                }


            }

            retval.stop = input.LT(-1);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
        }
        return retval;
    }
    // $ANTLR end "codeBlock"

    public static class returnOp_return extends ParserRuleReturnScope {
        public StringTemplate st;

        public Object getTemplate() {
            return st;
        }

        public String toString() {
            return st == null ? null : st.toString();
        }
    }

    ;

    // $ANTLR start "returnOp"
    // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:151:1: returnOp : ret= 'return' expr ;
    public final returnOp_return returnOp() throws RecognitionException {
        returnOp_return retval = new returnOp_return();
        retval.start = input.LT(1);

        Token ret = null;
        expr_return expr12 = null;


        try {
            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:152:2: (ret= 'return' expr )
            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:152:4: ret= 'return' expr
            {
                ret = (Token) match(input, 24, FOLLOW_24_in_returnOp584);
                pushFollow(FOLLOW_expr_in_returnOp587);
                expr12 = expr();

                state._fsp--;

                table.setFunRetType((expr12 != null ? expr12.type : null), (ret != null ? ret.getLine() : 0));

            }

            retval.stop = input.LT(-1);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
        }
        return retval;
    }
    // $ANTLR end "returnOp"

    public static class inOp_return extends ParserRuleReturnScope {
        public StringTemplate st;

        public Object getTemplate() {
            return st;
        }

        public String toString() {
            return st == null ? null : st.toString();
        }
    }

    ;

    // $ANTLR start "inOp"
    // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:155:1: inOp : 'Alin' '[' id= ID ']' ;
    public final inOp_return inOp() throws RecognitionException {
        inOp_return retval = new inOp_return();
        retval.start = input.LT(1);

        Token id = null;

        try {
            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:156:3: ( 'Alin' '[' id= ID ']' )
            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:156:5: 'Alin' '[' id= ID ']'
            {
                match(input, 25, FOLLOW_25_in_inOp601);
                match(input, 21, FOLLOW_21_in_inOp603);
                id = (Token) match(input, ID, FOLLOW_ID_in_inOp606);
                table.addVariable((id != null ? id.getText() : null), (id != null ? id.getLine() : 0));
                match(input, 22, FOLLOW_22_in_inOp609);

            }

            retval.stop = input.LT(-1);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
        }
        return retval;
    }
    // $ANTLR end "inOp"

    public static class outOp_return extends ParserRuleReturnScope {
        public StringTemplate st;

        public Object getTemplate() {
            return st;
        }

        public String toString() {
            return st == null ? null : st.toString();
        }
    }

    ;

    // $ANTLR start "outOp"
    // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:159:1: outOp : 'Alout' '[' ( STRING | expr ) ']' ;
    public final outOp_return outOp() throws RecognitionException {
        outOp_return retval = new outOp_return();
        retval.start = input.LT(1);

        try {
            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:160:3: ( 'Alout' '[' ( STRING | expr ) ']' )
            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:160:5: 'Alout' '[' ( STRING | expr ) ']'
            {
                match(input, 26, FOLLOW_26_in_outOp624);
                match(input, 21, FOLLOW_21_in_outOp626);
                // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:160:16: ( STRING | expr )
                int alt7 = 2;
                int LA7_0 = input.LA(1);

                if ((LA7_0 == STRING)) {
                    alt7 = 1;
                } else if ((LA7_0 == ID || (LA7_0 >= INT && LA7_0 <= FLOAT) || LA7_0 == 21)) {
                    alt7 = 2;
                } else {
                    NoViableAltException nvae =
                            new NoViableAltException("", 7, 0, input);

                    throw nvae;
                }
                switch (alt7) {
                    case 1:
                        // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:160:17: STRING
                    {
                        match(input, STRING, FOLLOW_STRING_in_outOp628);

                    }
                    break;
                    case 2:
                        // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:160:26: expr
                    {
                        pushFollow(FOLLOW_expr_in_outOp632);
                        expr();

                        state._fsp--;


                    }
                    break;

                }

                match(input, 22, FOLLOW_22_in_outOp634);

            }

            retval.stop = input.LT(-1);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
        }
        return retval;
    }
    // $ANTLR end "outOp"

    public static class assignOp_return extends ParserRuleReturnScope {
        public StringTemplate st;

        public Object getTemplate() {
            return st;
        }

        public String toString() {
            return st == null ? null : st.toString();
        }
    }

    ;

    // $ANTLR start "assignOp"
    // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:164:1: assignOp : id= ID '=' e= expr ;
    public final assignOp_return assignOp() throws RecognitionException {
        assignOp_return retval = new assignOp_return();
        retval.start = input.LT(1);

        Token id = null;
        expr_return e = null;


        try {
            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:165:2: (id= ID '=' e= expr )
            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:165:4: id= ID '=' e= expr
            {
                id = (Token) match(input, ID, FOLLOW_ID_in_assignOp649);
                table.addVariable((id != null ? id.getText() : null), (id != null ? id.getLine() : 0));
                match(input, 27, FOLLOW_27_in_assignOp656);
                pushFollow(FOLLOW_expr_in_assignOp660);
                e = expr();

                state._fsp--;

                table.initVariable((id != null ? id.getText() : null), (e != null ? e.type : null));

            }

            retval.stop = input.LT(-1);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
        }
        return retval;
    }
    // $ANTLR end "assignOp"

    public static class ifOp_return extends ParserRuleReturnScope {
        public int line;
        public boolean hasLastRet;
        public StringTemplate st;

        public Object getTemplate() {
            return st;
        }

        public String toString() {
            return st == null ? null : st.toString();
        }
    }

    ;

    // $ANTLR start "ifOp"
    // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:169:1: ifOp returns [int line, boolean hasLastRet] : IF '[' eqNotEqExpr ']' block ;
    public final ifOp_return ifOp() throws RecognitionException {
        ifOp_return retval = new ifOp_return();
        retval.start = input.LT(1);

        Token IF13 = null;
        block_return block14 = null;


        try {
            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:171:2: ( IF '[' eqNotEqExpr ']' block )
            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:171:4: IF '[' eqNotEqExpr ']' block
            {
                IF13 = (Token) match(input, IF, FOLLOW_IF_in_ifOp677);
                retval.line = (IF13 != null ? IF13.getLine() : 0);
                match(input, 21, FOLLOW_21_in_ifOp681);
                pushFollow(FOLLOW_eqNotEqExpr_in_ifOp682);
                eqNotEqExpr();

                state._fsp--;

                match(input, 22, FOLLOW_22_in_ifOp683);
                pushFollow(FOLLOW_block_in_ifOp685);
                block14 = block();

                state._fsp--;

                retval.hasLastRet = (block14 != null ? block14.hasLastRet : false);

            }

            retval.stop = input.LT(-1);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
        }
        return retval;
    }
    // $ANTLR end "ifOp"

    public static class elseOp_return extends ParserRuleReturnScope {
        public int line;
        public boolean hasLastRet;
        public StringTemplate st;

        public Object getTemplate() {
            return st;
        }

        public String toString() {
            return st == null ? null : st.toString();
        }
    }

    ;

    // $ANTLR start "elseOp"
    // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:174:1: elseOp returns [int line, boolean hasLastRet] : ELSE block ;
    public final elseOp_return elseOp() throws RecognitionException {
        elseOp_return retval = new elseOp_return();
        retval.start = input.LT(1);

        Token ELSE15 = null;
        block_return block16 = null;


        try {
            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:176:2: ( ELSE block )
            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:176:4: ELSE block
            {
                ELSE15 = (Token) match(input, ELSE, FOLLOW_ELSE_in_elseOp704);
                retval.line = (ELSE15 != null ? ELSE15.getLine() : 0);
                pushFollow(FOLLOW_block_in_elseOp708);
                block16 = block();

                state._fsp--;

                retval.hasLastRet = (block16 != null ? block16.hasLastRet : false);

            }

            retval.stop = input.LT(-1);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
        }
        return retval;
    }
    // $ANTLR end "elseOp"

    public static class whileOp_return extends ParserRuleReturnScope {
        public int line;
        public boolean hasLastRet;
        public StringTemplate st;

        public Object getTemplate() {
            return st;
        }

        public String toString() {
            return st == null ? null : st.toString();
        }
    }

    ;

    // $ANTLR start "whileOp"
    // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:179:1: whileOp returns [int line, boolean hasLastRet] : WHILE '[' eqNotEqExpr ']' block ;
    public final whileOp_return whileOp() throws RecognitionException {
        whileOp_return retval = new whileOp_return();
        retval.start = input.LT(1);

        Token WHILE17 = null;
        block_return block18 = null;


        try {
            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:181:3: ( WHILE '[' eqNotEqExpr ']' block )
            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:181:5: WHILE '[' eqNotEqExpr ']' block
            {
                WHILE17 = (Token) match(input, WHILE, FOLLOW_WHILE_in_whileOp727);
                retval.line = (WHILE17 != null ? WHILE17.getLine() : 0);
                match(input, 21, FOLLOW_21_in_whileOp731);
                pushFollow(FOLLOW_eqNotEqExpr_in_whileOp732);
                eqNotEqExpr();

                state._fsp--;

                match(input, 22, FOLLOW_22_in_whileOp733);
                pushFollow(FOLLOW_block_in_whileOp735);
                block18 = block();

                state._fsp--;

                retval.hasLastRet = (block18 != null ? block18.hasLastRet : false);

            }

            retval.stop = input.LT(-1);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
        }
        return retval;
    }
    // $ANTLR end "whileOp"

    public static class forOp_return extends ParserRuleReturnScope {
        public int line;
        public boolean hasLastRet;
        public StringTemplate st;

        public Object getTemplate() {
            return st;
        }

        public String toString() {
            return st == null ? null : st.toString();
        }
    }

    ;

    // $ANTLR start "forOp"
    // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:184:1: forOp returns [int line, boolean hasLastRet] : FOR '[' assignOp ';' eqNotEqExpr ';' assignOp ']' block ;
    public final forOp_return forOp() throws RecognitionException {
        forOp_return retval = new forOp_return();
        retval.start = input.LT(1);

        Token FOR19 = null;
        block_return block20 = null;


        try {
            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:186:3: ( FOR '[' assignOp ';' eqNotEqExpr ';' assignOp ']' block )
            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:186:5: FOR '[' assignOp ';' eqNotEqExpr ';' assignOp ']' block
            {
                FOR19 = (Token) match(input, FOR, FOLLOW_FOR_in_forOp753);
                retval.line = (FOR19 != null ? FOR19.getLine() : 0);
                match(input, 21, FOLLOW_21_in_forOp757);
                pushFollow(FOLLOW_assignOp_in_forOp759);
                assignOp();

                state._fsp--;

                match(input, DEDENT, FOLLOW_DEDENT_in_forOp761);
                pushFollow(FOLLOW_eqNotEqExpr_in_forOp763);
                eqNotEqExpr();

                state._fsp--;

                match(input, DEDENT, FOLLOW_DEDENT_in_forOp765);
                pushFollow(FOLLOW_assignOp_in_forOp767);
                assignOp();

                state._fsp--;

                match(input, 22, FOLLOW_22_in_forOp769);
                pushFollow(FOLLOW_block_in_forOp771);
                block20 = block();

                state._fsp--;

                retval.hasLastRet = (block20 != null ? block20.hasLastRet : false);

            }

            retval.stop = input.LT(-1);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
        }
        return retval;
    }
    // $ANTLR end "forOp"

    public static class eqNotEqExpr_return extends ParserRuleReturnScope {
        public Type type;
        public StringTemplate st;

        public Object getTemplate() {
            return st;
        }

        public String toString() {
            return st == null ? null : st.toString();
        }
    }

    ;

    // $ANTLR start "eqNotEqExpr"
    // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:190:1: eqNotEqExpr returns [Type type] : a1= expr (l= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) a2= expr )? ;
    public final eqNotEqExpr_return eqNotEqExpr() throws RecognitionException {
        eqNotEqExpr_return retval = new eqNotEqExpr_return();
        retval.start = input.LT(1);

        Token l = null;
        expr_return a1 = null;

        expr_return a2 = null;


        retval.type = Type.BOOL;

        try {
            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:195:3: (a1= expr (l= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) a2= expr )? )
            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:195:5: a1= expr (l= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) a2= expr )?
            {
                pushFollow(FOLLOW_expr_in_eqNotEqExpr797);
                a1 = expr();

                state._fsp--;

                // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:195:13: (l= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) a2= expr )?
                int alt8 = 2;
                int LA8_0 = input.LA(1);

                if (((LA8_0 >= 28 && LA8_0 <= 33))) {
                    alt8 = 1;
                }
                switch (alt8) {
                    case 1:
                        // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:195:14: l= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) a2= expr
                    {
                        l = (Token) input.LT(1);
                        if ((input.LA(1) >= 28 && input.LA(1) <= 33)) {
                            input.consume();
                            state.errorRecovery = false;
                        } else {
                            MismatchedSetException mse = new MismatchedSetException(null, input);
                            throw mse;
                        }

                        pushFollow(FOLLOW_expr_in_eqNotEqExpr818);
                        a2 = expr();

                        state._fsp--;

                        table.equalType((a1 != null ? a1.type : null), (a2 != null ? a2.type : null), (l != null ? l.getLine() : 0));

                    }
                    break;

                }


            }

            retval.stop = input.LT(-1);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
        }
        return retval;
    }
    // $ANTLR end "eqNotEqExpr"

    public static class expr_return extends ParserRuleReturnScope {
        public Type type;
        public StringTemplate st;

        public Object getTemplate() {
            return st;
        }

        public String toString() {
            return st == null ? null : st.toString();
        }
    }

    ;

    // $ANTLR start "expr"
    // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:198:1: expr returns [Type type] : m1= multDivExpr (l= ( '+' | '-' ) m2= multDivExpr )* ;
    public final expr_return expr() throws RecognitionException {
        expr_return retval = new expr_return();
        retval.start = input.LT(1);

        Token l = null;
        multDivExpr_return m1 = null;

        multDivExpr_return m2 = null;


        try {
            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:200:3: (m1= multDivExpr (l= ( '+' | '-' ) m2= multDivExpr )* )
            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:200:5: m1= multDivExpr (l= ( '+' | '-' ) m2= multDivExpr )*
            {
                pushFollow(FOLLOW_multDivExpr_in_expr841);
                m1 = multDivExpr();

                state._fsp--;

                retval.type = (m1 != null ? m1.type : null);
                // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:200:38: (l= ( '+' | '-' ) m2= multDivExpr )*
                loop9:
                do {
                    int alt9 = 2;
                    int LA9_0 = input.LA(1);

                    if (((LA9_0 >= 34 && LA9_0 <= 35))) {
                        alt9 = 1;
                    }


                    switch (alt9) {
                        case 1:
                            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:200:39: l= ( '+' | '-' ) m2= multDivExpr
                        {
                            l = (Token) input.LT(1);
                            if ((input.LA(1) >= 34 && input.LA(1) <= 35)) {
                                input.consume();
                                state.errorRecovery = false;
                            } else {
                                MismatchedSetException mse = new MismatchedSetException(null, input);
                                throw mse;
                            }

                            pushFollow(FOLLOW_multDivExpr_in_expr856);
                            m2 = multDivExpr();

                            state._fsp--;

                            table.equalType((m1 != null ? m1.type : null), (m2 != null ? m2.type : null), (l != null ? l.getLine() : 0));

                        }
                        break;

                        default:
                            break loop9;
                    }
                } while (true);


            }

            retval.stop = input.LT(-1);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
        }
        return retval;
    }
    // $ANTLR end "expr"

    public static class multDivExpr_return extends ParserRuleReturnScope {
        public Type type;
        public StringTemplate st;

        public Object getTemplate() {
            return st;
        }

        public String toString() {
            return st == null ? null : st.toString();
        }
    }

    ;

    // $ANTLR start "multDivExpr"
    // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:203:1: multDivExpr returns [Type type] : p1= powExpr (l= ( '*' | '/' | '%' ) p2= powExpr )* ;
    public final multDivExpr_return multDivExpr() throws RecognitionException {
        multDivExpr_return retval = new multDivExpr_return();
        retval.start = input.LT(1);

        Token l = null;
        powExpr_return p1 = null;

        powExpr_return p2 = null;


        try {
            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:205:5: (p1= powExpr (l= ( '*' | '/' | '%' ) p2= powExpr )* )
            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:205:7: p1= powExpr (l= ( '*' | '/' | '%' ) p2= powExpr )*
            {
                pushFollow(FOLLOW_powExpr_in_multDivExpr882);
                p1 = powExpr();

                state._fsp--;

                retval.type = (p1 != null ? p1.type : null);
                // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:205:36: (l= ( '*' | '/' | '%' ) p2= powExpr )*
                loop10:
                do {
                    int alt10 = 2;
                    int LA10_0 = input.LA(1);

                    if (((LA10_0 >= 36 && LA10_0 <= 38))) {
                        alt10 = 1;
                    }


                    switch (alt10) {
                        case 1:
                            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:205:37: l= ( '*' | '/' | '%' ) p2= powExpr
                        {
                            l = (Token) input.LT(1);
                            if ((input.LA(1) >= 36 && input.LA(1) <= 38)) {
                                input.consume();
                                state.errorRecovery = false;
                            } else {
                                MismatchedSetException mse = new MismatchedSetException(null, input);
                                throw mse;
                            }

                            pushFollow(FOLLOW_powExpr_in_multDivExpr899);
                            p2 = powExpr();

                            state._fsp--;

                            table.equalType((p1 != null ? p1.type : null), (p2 != null ? p2.type : null), (l != null ? l.getLine() : 0));

                        }
                        break;

                        default:
                            break loop10;
                    }
                } while (true);


            }

            retval.stop = input.LT(-1);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
        }
        return retval;
    }
    // $ANTLR end "multDivExpr"

    public static class powExpr_return extends ParserRuleReturnScope {
        public Type type;
        public StringTemplate st;

        public Object getTemplate() {
            return st;
        }

        public String toString() {
            return st == null ? null : st.toString();
        }
    }

    ;

    // $ANTLR start "powExpr"
    // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:208:1: powExpr returns [Type type] : a1= atom (l= '^' a2= atom )? ;
    public final powExpr_return powExpr() throws RecognitionException {
        powExpr_return retval = new powExpr_return();
        retval.start = input.LT(1);

        Token l = null;
        atom_return a1 = null;

        atom_return a2 = null;


        try {
            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:210:3: (a1= atom (l= '^' a2= atom )? )
            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:210:5: a1= atom (l= '^' a2= atom )?
            {
                pushFollow(FOLLOW_atom_in_powExpr924);
                a1 = atom();

                state._fsp--;

                retval.type = (a1 != null ? a1.type : null);
                // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:210:33: (l= '^' a2= atom )?
                int alt11 = 2;
                int LA11_0 = input.LA(1);

                if ((LA11_0 == 39)) {
                    alt11 = 1;
                }
                switch (alt11) {
                    case 1:
                        // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:210:34: l= '^' a2= atom
                    {
                        l = (Token) match(input, 39, FOLLOW_39_in_powExpr931);
                        pushFollow(FOLLOW_atom_in_powExpr936);
                        a2 = atom();

                        state._fsp--;

                        table.equalType(Type.INT, (a2 != null ? a2.type : null), (l != null ? l.getLine() : 0));

                    }
                    break;

                }


            }

            retval.stop = input.LT(-1);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
        }
        return retval;
    }
    // $ANTLR end "powExpr"

    public static class atom_return extends ParserRuleReturnScope {
        public Type type;
        public StringTemplate st;

        public Object getTemplate() {
            return st;
        }

        public String toString() {
            return st == null ? null : st.toString();
        }
    }

    ;

    // $ANTLR start "atom"
    // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:214:1: atom returns [Type type] : ( INT | FLOAT | funcOrVarCall | '[' expr ']' | '[' typeper ']' funcOrVarCall );
    public final atom_return atom() throws RecognitionException {
        atom_return retval = new atom_return();
        retval.start = input.LT(1);

        funcOrVarCall_return funcOrVarCall21 = null;

        expr_return expr22 = null;

        typeper_return typeper23 = null;


        try {
            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:216:3: ( INT | FLOAT | funcOrVarCall | '[' expr ']' | '[' typeper ']' funcOrVarCall )
            int alt12 = 5;
            switch (input.LA(1)) {
                case INT: {
                    alt12 = 1;
                }
                break;
                case FLOAT: {
                    alt12 = 2;
                }
                break;
                case ID: {
                    alt12 = 3;
                }
                break;
                case 21: {
                    int LA12_4 = input.LA(2);

                    if ((LA12_4 == ID || (LA12_4 >= INT && LA12_4 <= FLOAT) || LA12_4 == 21)) {
                        alt12 = 4;
                    } else if (((LA12_4 >= 40 && LA12_4 <= 41))) {
                        alt12 = 5;
                    } else {
                        NoViableAltException nvae =
                                new NoViableAltException("", 12, 4, input);

                        throw nvae;
                    }
                }
                break;
                default:
                    NoViableAltException nvae =
                            new NoViableAltException("", 12, 0, input);

                    throw nvae;
            }

            switch (alt12) {
                case 1:
                    // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:216:5: INT
                {
                    match(input, INT, FOLLOW_INT_in_atom960);
                    retval.type = Type.INT;

                }
                break;
                case 2:
                    // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:217:5: FLOAT
                {
                    match(input, FLOAT, FOLLOW_FLOAT_in_atom980);
                    retval.type = Type.FLOAT;

                }
                break;
                case 3:
                    // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:218:5: funcOrVarCall
                {
                    pushFollow(FOLLOW_funcOrVarCall_in_atom998);
                    funcOrVarCall21 = funcOrVarCall();

                    state._fsp--;

                    retval.type = (funcOrVarCall21 != null ? funcOrVarCall21.type : null);

                }
                break;
                case 4:
                    // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:219:5: '[' expr ']'
                {
                    match(input, 21, FOLLOW_21_in_atom1008);
                    pushFollow(FOLLOW_expr_in_atom1009);
                    expr22 = expr();

                    state._fsp--;

                    match(input, 22, FOLLOW_22_in_atom1010);
                    retval.type = (expr22 != null ? expr22.type : null);

                }
                break;
                case 5:
                    // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:220:5: '[' typeper ']' funcOrVarCall
                {
                    match(input, 21, FOLLOW_21_in_atom1023);
                    pushFollow(FOLLOW_typeper_in_atom1024);
                    typeper23 = typeper();

                    state._fsp--;

                    match(input, 22, FOLLOW_22_in_atom1025);
                    retval.type = (typeper23 != null ? typeper23.type : null);
                    pushFollow(FOLLOW_funcOrVarCall_in_atom1031);
                    funcOrVarCall();

                    state._fsp--;


                }
                break;

            }
            retval.stop = input.LT(-1);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
        }
        return retval;
    }
    // $ANTLR end "atom"

    public static class funcOrVarCall_return extends ParserRuleReturnScope {
        public Type type;
        public StringTemplate st;

        public Object getTemplate() {
            return st;
        }

        public String toString() {
            return st == null ? null : st.toString();
        }
    }

    ;

    // $ANTLR start "funcOrVarCall"
    // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:223:1: funcOrVarCall returns [Type type] : id= ID ( '[' argsList ']' )? ;
    public final funcOrVarCall_return funcOrVarCall() throws RecognitionException {
        funcOrVarCall_return retval = new funcOrVarCall_return();
        retval.start = input.LT(1);

        Token id = null;
        argsList_return argsList24 = null;


        retval.type = Type.NON;
        boolean isFun = false;

        try {
            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:229:3: (id= ID ( '[' argsList ']' )? )
            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:229:5: id= ID ( '[' argsList ']' )?
            {
                id = (Token) match(input, ID, FOLLOW_ID_in_funcOrVarCall1057);
                // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:229:11: ( '[' argsList ']' )?
                int alt13 = 2;
                int LA13_0 = input.LA(1);

                if ((LA13_0 == 21)) {
                    alt13 = 1;
                }
                switch (alt13) {
                    case 1:
                        // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:229:13: '[' argsList ']'
                    {
                        isFun = true;
                        match(input, 21, FOLLOW_21_in_funcOrVarCall1063);
                        pushFollow(FOLLOW_argsList_in_funcOrVarCall1064);
                        argsList24 = argsList();

                        state._fsp--;

                        table.checkFunParam((id != null ? id.getText() : null), (argsList24 != null ? argsList24.types : null), (id != null ? id.getLine() : 0));
                        match(input, 22, FOLLOW_22_in_funcOrVarCall1067);

                    }
                    break;

                }


                if (isFun) {
                    if (!table.checkUndefinedFun((id != null ? id.getText() : null), (id != null ? id.getLine() : 0))) {
                        retval.type = table.getFunType((id != null ? id.getText() : null));
                    }
                } else {
                    retval.type = table.getVarType((id != null ? id.getText() : null));
                    table.checkInitializeVar((id != null ? id.getText() : null), (id != null ? id.getLine() : 0));
                }


            }

            retval.stop = input.LT(-1);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
        }
        return retval;
    }
    // $ANTLR end "funcOrVarCall"

    public static class functionCall_return extends ParserRuleReturnScope {
        public StringTemplate st;

        public Object getTemplate() {
            return st;
        }

        public String toString() {
            return st == null ? null : st.toString();
        }
    }

    ;

    // $ANTLR start "functionCall"
    // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:242:1: functionCall : id= ID '[' argsList ']' ;
    public final functionCall_return functionCall() throws RecognitionException {
        functionCall_return retval = new functionCall_return();
        retval.start = input.LT(1);

        Token id = null;
        argsList_return argsList25 = null;


        try {
            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:243:5: (id= ID '[' argsList ']' )
            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:243:7: id= ID '[' argsList ']'
            {
                id = (Token) match(input, ID, FOLLOW_ID_in_functionCall1090);
                table.checkUndefinedFun((id != null ? id.getText() : null), (id != null ? id.getLine() : 0));
                match(input, 21, FOLLOW_21_in_functionCall1094);
                pushFollow(FOLLOW_argsList_in_functionCall1095);
                argsList25 = argsList();

                state._fsp--;

                table.checkFunParam((id != null ? id.getText() : null), (argsList25 != null ? argsList25.types : null), (id != null ? id.getLine() : 0));
                match(input, 22, FOLLOW_22_in_functionCall1099);

            }

            retval.stop = input.LT(-1);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
        }
        return retval;
    }
    // $ANTLR end "functionCall"

    public static class argsList_return extends ParserRuleReturnScope {
        public List<Type> types;
        public StringTemplate st;

        public Object getTemplate() {
            return st;
        }

        public String toString() {
            return st == null ? null : st.toString();
        }
    }

    ;

    // $ANTLR start "argsList"
    // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:246:1: argsList returns [List<Type> types] : (e1= expr ( ',' e2= expr )* )? ;
    public final argsList_return argsList() throws RecognitionException {
        argsList_return retval = new argsList_return();
        retval.start = input.LT(1);

        expr_return e1 = null;

        expr_return e2 = null;


        retval.types = new ArrayList<Type>();

        try {
            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:251:3: ( (e1= expr ( ',' e2= expr )* )? )
            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:251:5: (e1= expr ( ',' e2= expr )* )?
            {
                // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:251:5: (e1= expr ( ',' e2= expr )* )?
                int alt15 = 2;
                int LA15_0 = input.LA(1);

                if ((LA15_0 == ID || (LA15_0 >= INT && LA15_0 <= FLOAT) || LA15_0 == 21)) {
                    alt15 = 1;
                }
                switch (alt15) {
                    case 1:
                        // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:251:6: e1= expr ( ',' e2= expr )*
                    {
                        pushFollow(FOLLOW_expr_in_argsList1127);
                        e1 = expr();

                        state._fsp--;

                        retval.types.add((e1 != null ? e1.type : null));
                        // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:252:6: ( ',' e2= expr )*
                        loop14:
                        do {
                            int alt14 = 2;
                            int LA14_0 = input.LA(1);

                            if ((LA14_0 == 23)) {
                                alt14 = 1;
                            }


                            switch (alt14) {
                                case 1:
                                    // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:252:7: ',' e2= expr
                                {
                                    match(input, 23, FOLLOW_23_in_argsList1138);
                                    pushFollow(FOLLOW_expr_in_argsList1142);
                                    e2 = expr();

                                    state._fsp--;

                                    retval.types.add((e2 != null ? e2.type : null));

                                }
                                break;

                                default:
                                    break loop14;
                            }
                        } while (true);


                    }
                    break;

                }


            }

            retval.stop = input.LT(-1);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
        }
        return retval;
    }
    // $ANTLR end "argsList"

    public static class typeper_return extends ParserRuleReturnScope {
        public Type type;
        public StringTemplate st;

        public Object getTemplate() {
            return st;
        }

        public String toString() {
            return st == null ? null : st.toString();
        }
    }

    ;

    // $ANTLR start "typeper"
    // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:256:1: typeper returns [Type type] : ( 'int' | 'float' );
    public final typeper_return typeper() throws RecognitionException {
        typeper_return retval = new typeper_return();
        retval.start = input.LT(1);

        try {
            // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:258:2: ( 'int' | 'float' )
            int alt16 = 2;
            int LA16_0 = input.LA(1);

            if ((LA16_0 == 40)) {
                alt16 = 1;
            } else if ((LA16_0 == 41)) {
                alt16 = 2;
            } else {
                NoViableAltException nvae =
                        new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1:
                    // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:258:4: 'int'
                {
                    match(input, 40, FOLLOW_40_in_typeper1175);
                    retval.type = Type.INT;

                }
                break;
                case 2:
                    // C:\\Users\\Fox\\workspace1\\ggg\\src\\antl\\ggggg.g:259:4: 'float'
                {
                    match(input, 41, FOLLOW_41_in_typeper1185);
                    retval.type = Type.FLOAT;

                }
                break;

            }
            retval.stop = input.LT(-1);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
        }
        return retval;
    }
    // $ANTLR end "typeper"

    // Delegated rules


    protected DFA5 dfa5 = new DFA5(this);
    static final String DFA5_eotS =
            "\13\uffff";
    static final String DFA5_eofS =
            "\13\uffff";
    static final String DFA5_minS =
            "\1\10\1\25\11\uffff";
    static final String DFA5_maxS =
            "\1\32\1\33\11\uffff";
    static final String DFA5_acceptS =
            "\2\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\1\1\2";
    static final String DFA5_specialS =
            "\13\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\1\3\uffff\1\2\1\5\1\3\1\4\10\uffff\1\6\1\7\1\10",
            "\1\12\5\uffff\1\11",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i = 0; i < numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }

        public String getDescription() {
            return "139:4: ( assignOp l= ';' | functionCall l= ';' | ifOp | whileOp | forOp | elseOp | returnOp l= ';' | inOp l= ';' | outOp l= ';' )";
        }
    }


    public static final BitSet FOLLOW_globalsVar_in_program94 = new BitSet(new long[]{0x0000000000000382L});
    public static final BitSet FOLLOW_function_in_program106 = new BitSet(new long[]{0x0000000000000382L});
    public static final BitSet FOLLOW_main_in_program117 = new BitSet(new long[]{0x0000000000000382L});
    public static final BitSet FOLLOW_assignOp_in_globalsVar143 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DEDENT_in_globalsVar147 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ENDL_in_globalsVar151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionHeader_in_function171 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_block_in_function178 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_CLEAR_LINE_in_function182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTION_in_functionHeader198 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ID_in_functionHeader202 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_functionHeader206 = new BitSet(new long[]{0x0000000000400100L});
    public static final BitSet FOLLOW_formalArgsList_in_functionHeader208 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_functionHeader210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_formalArgsList232 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_formalArgsList236 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ID_in_formalArgsList240 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_MAIN_in_main277 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_block_in_main281 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_CLEAR_LINE_in_main283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENDL_in_block322 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_INDENT_in_block324 = new BitSet(new long[]{0x000000000700F100L});
    public static final BitSet FOLLOW_codeBlock_in_block334 = new BitSet(new long[]{0x000000000700F110L});
    public static final BitSet FOLLOW_DEDENT_in_block370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignOp_in_codeBlock395 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DEDENT_in_codeBlock399 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_functionCall_in_codeBlock415 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DEDENT_in_codeBlock419 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ifOp_in_codeBlock429 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_whileOp_in_codeBlock450 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_forOp_in_codeBlock469 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_elseOp_in_codeBlock490 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_returnOp_in_codeBlock510 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DEDENT_in_codeBlock514 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_inOp_in_codeBlock525 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DEDENT_in_codeBlock530 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_outOp_in_codeBlock550 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DEDENT_in_codeBlock555 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ENDL_in_codeBlock567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_returnOp584 = new BitSet(new long[]{0x0000000000230100L});
    public static final BitSet FOLLOW_expr_in_returnOp587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_inOp601 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_inOp603 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ID_in_inOp606 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_inOp609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_outOp624 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_outOp626 = new BitSet(new long[]{0x0000000000230900L});
    public static final BitSet FOLLOW_STRING_in_outOp628 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_expr_in_outOp632 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_outOp634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_assignOp649 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_assignOp656 = new BitSet(new long[]{0x0000000000230100L});
    public static final BitSet FOLLOW_expr_in_assignOp660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_ifOp677 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ifOp681 = new BitSet(new long[]{0x0000000000230100L});
    public static final BitSet FOLLOW_eqNotEqExpr_in_ifOp682 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ifOp683 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_block_in_ifOp685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELSE_in_elseOp704 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_block_in_elseOp708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHILE_in_whileOp727 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_whileOp731 = new BitSet(new long[]{0x0000000000230100L});
    public static final BitSet FOLLOW_eqNotEqExpr_in_whileOp732 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_whileOp733 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_block_in_whileOp735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOR_in_forOp753 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_forOp757 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_assignOp_in_forOp759 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DEDENT_in_forOp761 = new BitSet(new long[]{0x0000000000230100L});
    public static final BitSet FOLLOW_eqNotEqExpr_in_forOp763 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DEDENT_in_forOp765 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_assignOp_in_forOp767 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_forOp769 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_block_in_forOp771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_eqNotEqExpr797 = new BitSet(new long[]{0x00000003F0000002L});
    public static final BitSet FOLLOW_set_in_eqNotEqExpr802 = new BitSet(new long[]{0x0000000000230100L});
    public static final BitSet FOLLOW_expr_in_eqNotEqExpr818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_multDivExpr_in_expr841 = new BitSet(new long[]{0x0000000C00000002L});
    public static final BitSet FOLLOW_set_in_expr848 = new BitSet(new long[]{0x0000000000230100L});
    public static final BitSet FOLLOW_multDivExpr_in_expr856 = new BitSet(new long[]{0x0000000C00000002L});
    public static final BitSet FOLLOW_powExpr_in_multDivExpr882 = new BitSet(new long[]{0x0000007000000002L});
    public static final BitSet FOLLOW_set_in_multDivExpr889 = new BitSet(new long[]{0x0000000000230100L});
    public static final BitSet FOLLOW_powExpr_in_multDivExpr899 = new BitSet(new long[]{0x0000007000000002L});
    public static final BitSet FOLLOW_atom_in_powExpr924 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_39_in_powExpr931 = new BitSet(new long[]{0x0000000000230100L});
    public static final BitSet FOLLOW_atom_in_powExpr936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_atom960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_atom980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_funcOrVarCall_in_atom998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_atom1008 = new BitSet(new long[]{0x0000000000230100L});
    public static final BitSet FOLLOW_expr_in_atom1009 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_atom1010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_atom1023 = new BitSet(new long[]{0x0000030000000000L});
    public static final BitSet FOLLOW_typeper_in_atom1024 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_atom1025 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_funcOrVarCall_in_atom1031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_funcOrVarCall1057 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_funcOrVarCall1063 = new BitSet(new long[]{0x0000000000630100L});
    public static final BitSet FOLLOW_argsList_in_funcOrVarCall1064 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_funcOrVarCall1067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_functionCall1090 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_functionCall1094 = new BitSet(new long[]{0x0000000000630100L});
    public static final BitSet FOLLOW_argsList_in_functionCall1095 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_functionCall1099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_argsList1127 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_argsList1138 = new BitSet(new long[]{0x0000000000230100L});
    public static final BitSet FOLLOW_expr_in_argsList1142 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_40_in_typeper1175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_typeper1185 = new BitSet(new long[]{0x0000000000000002L});

}