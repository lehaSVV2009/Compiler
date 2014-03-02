// $ANTLR 3.5.1 D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g 2014-02-16 18:44:47

package antl;

import java.util.Deque;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

import org.antlr.stringtemplate.*;


import org.antlr.runtime.*;

import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings ("all")
public class gggggLexer extends Lexer {
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
    public static final int CLEAR_LINE = 4;
    public static final int COMMENT = 5;
    public static final int DEDENT = 6;
    public static final int ELSE = 7;
    public static final int ENDL = 8;
    public static final int FLOAT = 9;
    public static final int FOR = 10;
    public static final int FUNCTION = 11;
    public static final int ID = 12;
    public static final int IF = 13;
    public static final int INDENT = 14;
    public static final int INT = 15;
    public static final int MAIN = 16;
    public static final int STRING = 17;
    public static final int TAB = 18;
    public static final int WHILE = 19;
    public static final int WS = 20;


    int curLevel = 0;
    int prevLevel = 0;
    int startPos = 0;
    boolean isNewBlock = false;

    ClassicToken token = null;

    Stack<Integer> levels = new Stack<Integer>();
    Deque<Token> tokens = new java.util.ArrayDeque<Token>();

    @Override
    public void emit (Token token) {
        state.token = token;
        tokens.addLast(token);
    }

    @Override
    public Token nextToken () {
        super.nextToken();

        if (tokens.isEmpty())
            return Token.INVALID_TOKEN;  //EOF_TOKEN;
        return tokens.removeFirst();

    }


    // delegates
    // delegators
    public Lexer[] getDelegates () {
        return new Lexer[]{};
    }

    public gggggLexer () {
    }

    public gggggLexer (CharStream input) {
        this(input, new RecognizerSharedState());
    }

    public gggggLexer (CharStream input, RecognizerSharedState state) {
        super(input, state);
    }

    @Override
    public String getGrammarFileName () {
        return "D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g";
    }

    // $ANTLR start "T__21"
    public final void mT__21 () throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:46:7: ( '!=' )
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:46:9: '!='
            {
                match("!=");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22 () throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:47:7: ( '%' )
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:47:9: '%'
            {
                match('%');
            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23 () throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:48:7: ( '*' )
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:48:9: '*'
            {
                match('*');
            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24 () throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:49:7: ( '+' )
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:49:9: '+'
            {
                match('+');
            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25 () throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:50:7: ( ',' )
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:50:9: ','
            {
                match(',');
            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26 () throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:51:7: ( '-' )
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:51:9: '-'
            {
                match('-');
            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27 () throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:52:7: ( '/' )
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:52:9: '/'
            {
                match('/');
            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28 () throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:53:7: ( '<' )
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:53:9: '<'
            {
                match('<');
            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29 () throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:54:7: ( '<=' )
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:54:9: '<='
            {
                match("<=");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30 () throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:55:7: ( '=' )
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:55:9: '='
            {
                match('=');
            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31 () throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:56:7: ( '==' )
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:56:9: '=='
            {
                match("==");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32 () throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:57:7: ( '>' )
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:57:9: '>'
            {
                match('>');
            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33 () throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:58:7: ( '>=' )
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:58:9: '>='
            {
                match(">=");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34 () throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:59:7: ( 'Alin' )
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:59:9: 'Alin'
            {
                match("Alin");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35 () throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:60:7: ( 'Alout' )
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:60:9: 'Alout'
            {
                match("Alout");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36 () throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:61:7: ( '[' )
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:61:9: '['
            {
                match('[');
            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37 () throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:62:7: ( ']' )
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:62:9: ']'
            {
                match(']');
            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38 () throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:63:7: ( '^' )
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:63:9: '^'
            {
                match('^');
            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39 () throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:64:7: ( 'float' )
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:64:9: 'float'
            {
                match("float");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40 () throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:65:7: ( 'int' )
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:65:9: 'int'
            {
                match("int");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41 () throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:66:7: ( 'return' )
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:66:9: 'return'
            {
                match("return");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "DEDENT"
    public final void mDEDENT () throws RecognitionException {
        try {
            int _type = DEDENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:262:9: ( ';' )
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:262:10: ';'
            {
                match(';');
            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "DEDENT"

    // $ANTLR start "FUNCTION"
    public final void mFUNCTION () throws RecognitionException {
        try {
            int _type = FUNCTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:265:3: ( 'Alenafun' )
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:265:5: 'Alenafun'
            {
                match("Alenafun");

                isNewBlock = true;
            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "FUNCTION"

    // $ANTLR start "MAIN"
    public final void mMAIN () throws RecognitionException {
        try {
            int _type = MAIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:269:3: ( 'Alenamain' )
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:269:5: 'Alenamain'
            {
                match("Alenamain");

                isNewBlock = true;
            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "MAIN"

    // $ANTLR start "WHILE"
    public final void mWHILE () throws RecognitionException {
        try {
            int _type = WHILE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:273:3: ( 'while' )
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:273:5: 'while'
            {
                match("while");

                isNewBlock = true;
            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "WHILE"

    // $ANTLR start "FOR"
    public final void mFOR () throws RecognitionException {
        try {
            int _type = FOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:276:5: ( 'for' )
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:276:7: 'for'
            {
                match("for");

                isNewBlock = true;
            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "FOR"

    // $ANTLR start "IF"
    public final void mIF () throws RecognitionException {
        try {
            int _type = IF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:279:5: ( 'if' )
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:279:6: 'if'
            {
                match("if");

                isNewBlock = true;
            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "IF"

    // $ANTLR start "ELSE"
    public final void mELSE () throws RecognitionException {
        try {
            int _type = ELSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:283:3: ( 'else' )
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:283:4: 'else'
            {
                match("else");

                isNewBlock = true;
            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "ELSE"

    // $ANTLR start "ID"
    public final void mID () throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:286:5: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:286:7: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
                if ((input.LA(1) >= 'A' && input.LA(1) <= 'Z') || input.LA(1) == '_' || (input.LA(1) >= 'a' && input.LA(1) <= 'z')) {
                    input.consume();
                } else {
                    MismatchedSetException mse = new MismatchedSetException(null, input);
                    recover(mse);
                    throw mse;
                }
                // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:286:31: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
                loop1:
                while (true) {
                    int alt1 = 2;
                    int LA1_0 = input.LA(1);
                    if (((LA1_0 >= '0' && LA1_0 <= '9') || (LA1_0 >= 'A' && LA1_0 <= 'Z') || LA1_0 == '_' || (LA1_0 >= 'a' && LA1_0 <= 'z'))) {
                        alt1 = 1;
                    }

                    switch (alt1) {
                        case 1:
                            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:
                        {
                            if ((input.LA(1) >= '0' && input.LA(1) <= '9') || (input.LA(1) >= 'A' && input.LA(1) <= 'Z') || input.LA(1) == '_' || (input.LA(1) >= 'a' && input.LA(1) <= 'z')) {
                                input.consume();
                            } else {
                                MismatchedSetException mse = new MismatchedSetException(null, input);
                                recover(mse);
                                throw mse;
                            }
                        }
                        break;

                        default:
                            break loop1;
                    }
                }

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "INT"
    public final void mINT () throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:289:5: ( ( '0' .. '9' )+ )
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:289:7: ( '0' .. '9' )+
            {
                // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:289:7: ( '0' .. '9' )+
                int cnt2 = 0;
                loop2:
                while (true) {
                    int alt2 = 2;
                    int LA2_0 = input.LA(1);
                    if (((LA2_0 >= '0' && LA2_0 <= '9'))) {
                        alt2 = 1;
                    }

                    switch (alt2) {
                        case 1:
                            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:
                        {
                            if ((input.LA(1) >= '0' && input.LA(1) <= '9')) {
                                input.consume();
                            } else {
                                MismatchedSetException mse = new MismatchedSetException(null, input);
                                recover(mse);
                                throw mse;
                            }
                        }
                        break;

                        default:
                            if (cnt2 >= 1) break loop2;
                            EarlyExitException eee = new EarlyExitException(2, input);
                            throw eee;
                    }
                    cnt2++;
                }

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "FLOAT"
    public final void mFLOAT () throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:293:5: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )+ )
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:293:9: ( '0' .. '9' )+ '.' ( '0' .. '9' )+
            {
                // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:293:9: ( '0' .. '9' )+
                int cnt3 = 0;
                loop3:
                while (true) {
                    int alt3 = 2;
                    int LA3_0 = input.LA(1);
                    if (((LA3_0 >= '0' && LA3_0 <= '9'))) {
                        alt3 = 1;
                    }

                    switch (alt3) {
                        case 1:
                            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:
                        {
                            if ((input.LA(1) >= '0' && input.LA(1) <= '9')) {
                                input.consume();
                            } else {
                                MismatchedSetException mse = new MismatchedSetException(null, input);
                                recover(mse);
                                throw mse;
                            }
                        }
                        break;

                        default:
                            if (cnt3 >= 1) break loop3;
                            EarlyExitException eee = new EarlyExitException(3, input);
                            throw eee;
                    }
                    cnt3++;
                }

                match('.');
                // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:293:25: ( '0' .. '9' )+
                int cnt4 = 0;
                loop4:
                while (true) {
                    int alt4 = 2;
                    int LA4_0 = input.LA(1);
                    if (((LA4_0 >= '0' && LA4_0 <= '9'))) {
                        alt4 = 1;
                    }

                    switch (alt4) {
                        case 1:
                            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:
                        {
                            if ((input.LA(1) >= '0' && input.LA(1) <= '9')) {
                                input.consume();
                            } else {
                                MismatchedSetException mse = new MismatchedSetException(null, input);
                                recover(mse);
                                throw mse;
                            }
                        }
                        break;

                        default:
                            if (cnt4 >= 1) break loop4;
                            EarlyExitException eee = new EarlyExitException(4, input);
                            throw eee;
                    }
                    cnt4++;
                }

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "FLOAT"

    // $ANTLR start "TAB"
    public final void mTAB () throws RecognitionException {
        try {
            int _type = TAB;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:296:6: ( '\t' | '\\\\t' )
            int alt5 = 2;
            int LA5_0 = input.LA(1);
            if ((LA5_0 == '\t')) {
                alt5 = 1;
            } else if ((LA5_0 == '\\')) {
                alt5 = 2;
            } else {
                NoViableAltException nvae =
                        new NoViableAltException("", 5, 0, input);
                throw nvae;
            }

            switch (alt5) {
                case 1:
                    // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:296:8: '\t'
                {
                    match('\t');
                }
                break;
                case 2:
                    // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:296:15: '\\\\t'
                {
                    match("\\t");

                }
                break;

            }
            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "TAB"

    // $ANTLR start "ENDL"
    public final void mENDL () throws RecognitionException {
        try {
            int _type = ENDL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:300:2: ( '\\n' )
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:300:4: '\\n'
            {
                match('\n');
            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "ENDL"

    // $ANTLR start "WS"
    public final void mWS () throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:303:5: ( ( ' ' | '\\r' ) )
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:303:9: ( ' ' | '\\r' )
            {
                if (input.LA(1) == '\r' || input.LA(1) == ' ') {
                    input.consume();
                } else {
                    MismatchedSetException mse = new MismatchedSetException(null, input);
                    recover(mse);
                    throw mse;
                }
                _channel = HIDDEN;
            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "STRING"
    public final void mSTRING () throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:309:5: ( '\"' (~ ( '\\\\' | '\"' ) )* '\"' )
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:309:8: '\"' (~ ( '\\\\' | '\"' ) )* '\"'
            {
                match('\"');
                // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:309:12: (~ ( '\\\\' | '\"' ) )*
                loop6:
                while (true) {
                    int alt6 = 2;
                    int LA6_0 = input.LA(1);
                    if (((LA6_0 >= '\u0000' && LA6_0 <= '!') || (LA6_0 >= '#' && LA6_0 <= '[') || (LA6_0 >= ']' && LA6_0 <= '\uFFFF'))) {
                        alt6 = 1;
                    }

                    switch (alt6) {
                        case 1:
                            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:
                        {
                            if ((input.LA(1) >= '\u0000' && input.LA(1) <= '!') || (input.LA(1) >= '#' && input.LA(1) <= '[') || (input.LA(1) >= ']' && input.LA(1) <= '\uFFFF')) {
                                input.consume();
                            } else {
                                MismatchedSetException mse = new MismatchedSetException(null, input);
                                recover(mse);
                                throw mse;
                            }
                        }
                        break;

                        default:
                            break loop6;
                    }
                }

                match('\"');
            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT () throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:313:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' | '/*' ( options {greedy=false; } : . )* '*/' )
            int alt10 = 2;
            int LA10_0 = input.LA(1);
            if ((LA10_0 == '/')) {
                int LA10_1 = input.LA(2);
                if ((LA10_1 == '/')) {
                    alt10 = 1;
                } else if ((LA10_1 == '*')) {
                    alt10 = 2;
                } else {
                    int nvaeMark = input.mark();
                    try {
                        input.consume();
                        NoViableAltException nvae =
                                new NoViableAltException("", 10, 1, input);
                        throw nvae;
                    } finally {
                        input.rewind(nvaeMark);
                    }
                }

            } else {
                NoViableAltException nvae =
                        new NoViableAltException("", 10, 0, input);
                throw nvae;
            }

            switch (alt10) {
                case 1:
                    // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:313:9: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
                {
                    match("//");

                    // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:313:14: (~ ( '\\n' | '\\r' ) )*
                    loop7:
                    while (true) {
                        int alt7 = 2;
                        int LA7_0 = input.LA(1);
                        if (((LA7_0 >= '\u0000' && LA7_0 <= '\t') || (LA7_0 >= '\u000B' && LA7_0 <= '\f') || (LA7_0 >= '\u000E' && LA7_0 <= '\uFFFF'))) {
                            alt7 = 1;
                        }

                        switch (alt7) {
                            case 1:
                                // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:
                            {
                                if ((input.LA(1) >= '\u0000' && input.LA(1) <= '\t') || (input.LA(1) >= '\u000B' && input.LA(1) <= '\f') || (input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF')) {
                                    input.consume();
                                } else {
                                    MismatchedSetException mse = new MismatchedSetException(null, input);
                                    recover(mse);
                                    throw mse;
                                }
                            }
                            break;

                            default:
                                break loop7;
                        }
                    }

                    // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:313:28: ( '\\r' )?
                    int alt8 = 2;
                    int LA8_0 = input.LA(1);
                    if ((LA8_0 == '\r')) {
                        alt8 = 1;
                    }
                    switch (alt8) {
                        case 1:
                            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:313:28: '\\r'
                        {
                            match('\r');
                        }
                        break;

                    }

                    match('\n');
                    _channel = HIDDEN;
                }
                break;
                case 2:
                    // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:314:9: '/*' ( options {greedy=false; } : . )* '*/'
                {
                    match("/*");

                    // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:314:14: ( options {greedy=false; } : . )*
                    loop9:
                    while (true) {
                        int alt9 = 2;
                        int LA9_0 = input.LA(1);
                        if ((LA9_0 == '*')) {
                            int LA9_1 = input.LA(2);
                            if ((LA9_1 == '/')) {
                                alt9 = 2;
                            } else if (((LA9_1 >= '\u0000' && LA9_1 <= '.') || (LA9_1 >= '0' && LA9_1 <= '\uFFFF'))) {
                                alt9 = 1;
                            }

                        } else if (((LA9_0 >= '\u0000' && LA9_0 <= ')') || (LA9_0 >= '+' && LA9_0 <= '\uFFFF'))) {
                            alt9 = 1;
                        }

                        switch (alt9) {
                            case 1:
                                // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:314:42: .
                            {
                                matchAny();
                            }
                            break;

                            default:
                                break loop9;
                        }
                    }

                    match("*/");

                    _channel = HIDDEN;
                }
                break;

            }
            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "INDENT"
    public final void mINDENT () throws RecognitionException {
        try {
            int _type = INDENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken t = null;

            curLevel = 0;
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:319:3: ({...}? => (t= TAB )+ )
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:320:3: {...}? => (t= TAB )+
            {
                if (!((getCharPositionInLine() == 0))) {
                    throw new FailedPredicateException(input, "INDENT", "getCharPositionInLine()==0");
                }
                // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:320:35: (t= TAB )+
                int cnt11 = 0;
                loop11:
                while (true) {
                    int alt11 = 2;
                    int LA11_0 = input.LA(1);
                    if ((LA11_0 == '\t' || LA11_0 == '\\')) {
                        alt11 = 1;
                    }

                    switch (alt11) {
                        case 1:
                            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:320:36: t= TAB
                        {
                            curLevel++;
                            int tStart567 = getCharIndex();
                            int tStartLine567 = getLine();
                            int tStartCharPos567 = getCharPositionInLine();
                            mTAB();
                            t = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, tStart567, getCharIndex() - 1);
                            t.setLine(tStartLine567);
                            t.setCharPositionInLine(tStartCharPos567);

                        }
                        break;

                        default:
                            if (cnt11 >= 1) break loop11;
                            EarlyExitException eee = new EarlyExitException(11, input);
                            throw eee;
                    }
                    cnt11++;
                }


                if (levels.empty()) {
                    levels.push(0);
                }

                if (curLevel > levels.peek().intValue()) {
                    if (!isNewBlock) {
                        Errors.BadBlockLine((t != null ? t.getLine() : 0));
                    } else {
                        levels.push(curLevel);
                        emit(new ClassicToken(INDENT, "INDENT"));
                    }

                    isNewBlock = false;
                }

                if (curLevel < levels.peek().intValue()) {
                    while (curLevel < levels.peek().intValue()) {
                        levels.pop();
                        emit(new ClassicToken(DEDENT, "DEDENT"));
                    }
                }
                if (curLevel == levels.peek().intValue()) {
                    skip();
                }


            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "INDENT"

    // $ANTLR start "CLEAR_LINE"
    public final void mCLEAR_LINE () throws RecognitionException {
        try {
            int _type = CLEAR_LINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:350:3: ({...}? => ENDL )
            // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:350:6: {...}? => ENDL
            {
                if (!((getCharPositionInLine() == 1 || getCharPositionInLine() == 0))) {
                    throw new FailedPredicateException(input, "CLEAR_LINE", "getCharPositionInLine()==1 || getCharPositionInLine()==0 ");
                }
                mENDL();


                if (levels.peek().intValue() != 0) {
                    while (levels.peek() != 0) {

                        levels.pop();
                        emit(new ClassicToken(DEDENT, "DEDENT"));
                    }
                }

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "CLEAR_LINE"

    @Override
    public void mTokens () throws RecognitionException {
        // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:1:8: ( T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | DEDENT | FUNCTION | MAIN | WHILE | FOR | IF | ELSE | ID | INT | FLOAT | TAB | ENDL | WS | STRING | COMMENT | INDENT | CLEAR_LINE )
        int alt12 = 38;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1:
                // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:1:10: T__21
            {
                mT__21();

            }
            break;
            case 2:
                // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:1:16: T__22
            {
                mT__22();

            }
            break;
            case 3:
                // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:1:22: T__23
            {
                mT__23();

            }
            break;
            case 4:
                // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:1:28: T__24
            {
                mT__24();

            }
            break;
            case 5:
                // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:1:34: T__25
            {
                mT__25();

            }
            break;
            case 6:
                // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:1:40: T__26
            {
                mT__26();

            }
            break;
            case 7:
                // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:1:46: T__27
            {
                mT__27();

            }
            break;
            case 8:
                // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:1:52: T__28
            {
                mT__28();

            }
            break;
            case 9:
                // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:1:58: T__29
            {
                mT__29();

            }
            break;
            case 10:
                // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:1:64: T__30
            {
                mT__30();

            }
            break;
            case 11:
                // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:1:70: T__31
            {
                mT__31();

            }
            break;
            case 12:
                // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:1:76: T__32
            {
                mT__32();

            }
            break;
            case 13:
                // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:1:82: T__33
            {
                mT__33();

            }
            break;
            case 14:
                // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:1:88: T__34
            {
                mT__34();

            }
            break;
            case 15:
                // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:1:94: T__35
            {
                mT__35();

            }
            break;
            case 16:
                // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:1:100: T__36
            {
                mT__36();

            }
            break;
            case 17:
                // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:1:106: T__37
            {
                mT__37();

            }
            break;
            case 18:
                // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:1:112: T__38
            {
                mT__38();

            }
            break;
            case 19:
                // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:1:118: T__39
            {
                mT__39();

            }
            break;
            case 20:
                // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:1:124: T__40
            {
                mT__40();

            }
            break;
            case 21:
                // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:1:130: T__41
            {
                mT__41();

            }
            break;
            case 22:
                // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:1:136: DEDENT
            {
                mDEDENT();

            }
            break;
            case 23:
                // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:1:143: FUNCTION
            {
                mFUNCTION();

            }
            break;
            case 24:
                // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:1:152: MAIN
            {
                mMAIN();

            }
            break;
            case 25:
                // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:1:157: WHILE
            {
                mWHILE();

            }
            break;
            case 26:
                // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:1:163: FOR
            {
                mFOR();

            }
            break;
            case 27:
                // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:1:167: IF
            {
                mIF();

            }
            break;
            case 28:
                // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:1:170: ELSE
            {
                mELSE();

            }
            break;
            case 29:
                // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:1:175: ID
            {
                mID();

            }
            break;
            case 30:
                // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:1:178: INT
            {
                mINT();

            }
            break;
            case 31:
                // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:1:182: FLOAT
            {
                mFLOAT();

            }
            break;
            case 32:
                // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:1:188: TAB
            {
                mTAB();

            }
            break;
            case 33:
                // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:1:192: ENDL
            {
                mENDL();

            }
            break;
            case 34:
                // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:1:197: WS
            {
                mWS();

            }
            break;
            case 35:
                // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:1:200: STRING
            {
                mSTRING();

            }
            break;
            case 36:
                // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:1:207: COMMENT
            {
                mCOMMENT();

            }
            break;
            case 37:
                // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:1:215: INDENT
            {
                mINDENT();

            }
            break;
            case 38:
                // D:\\ACTIVITY\\study\\3season\\issue2\\ЯПИС\\1 Compiler\\version1\\Compiler\\src\\main\\java\\antl\\ggggg.g:1:222: CLEAR_LINE
            {
                mCLEAR_LINE();

            }
            break;

        }
    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
            "\7\uffff\1\35\1\37\1\41\1\43\1\25\3\uffff\3\25\1\uffff\2\25\1\uffff\1" +
                    "\54\1\56\1\uffff\1\61\12\uffff\4\25\1\70\3\25\4\uffff\1\75\1\uffff\4\25" +
                    "\1\104\1\105\1\uffff\3\25\4\uffff\1\111\3\25\2\uffff\2\25\1\117\1\uffff" +
                    "\1\120\1\25\1\123\1\25\1\125\2\uffff\2\25\1\uffff\1\130\1\uffff\2\25\1" +
                    "\uffff\1\133\1\25\1\uffff\1\135\1\uffff";
    static final String DFA12_eofS =
            "\136\uffff";
    static final String DFA12_minS =
            "\1\11\6\uffff\1\52\3\75\1\154\3\uffff\1\154\1\146\1\145\1\uffff\1\150" +
                    "\1\154\1\uffff\1\56\1\11\1\164\1\0\12\uffff\1\145\1\157\1\162\1\164\1" +
                    "\60\1\164\1\151\1\163\2\uffff\1\0\1\uffff\1\11\1\0\1\156\1\165\1\156\1" +
                    "\141\2\60\1\uffff\1\165\1\154\1\145\1\uffff\1\0\2\uffff\1\60\1\164\1\141" +
                    "\1\164\2\uffff\1\162\1\145\1\60\1\uffff\1\60\1\146\1\60\1\156\1\60\2\uffff" +
                    "\1\165\1\141\1\uffff\1\60\1\uffff\1\156\1\151\1\uffff\1\60\1\156\1\uffff" +
                    "\1\60\1\uffff";
    static final String DFA12_maxS =
            "\1\172\6\uffff\1\57\3\75\1\154\3\uffff\1\157\1\156\1\145\1\uffff\1\150" +
                    "\1\154\1\uffff\1\71\1\134\1\164\1\0\12\uffff\2\157\1\162\1\164\1\172\1" +
                    "\164\1\151\1\163\2\uffff\1\0\1\uffff\1\134\1\0\1\156\1\165\1\156\1\141" +
                    "\2\172\1\uffff\1\165\1\154\1\145\1\uffff\1\0\2\uffff\1\172\1\164\1\141" +
                    "\1\164\2\uffff\1\162\1\145\1\172\1\uffff\1\172\1\155\1\172\1\156\1\172" +
                    "\2\uffff\1\165\1\141\1\uffff\1\172\1\uffff\1\156\1\151\1\uffff\1\172\1" +
                    "\156\1\uffff\1\172\1\uffff";
    static final String DFA12_acceptS =
            "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\5\uffff\1\20\1\21\1\22\3\uffff\1\26\2" +
                    "\uffff\1\35\4\uffff\1\42\1\43\1\44\1\7\1\11\1\10\1\13\1\12\1\15\1\14\10" +
                    "\uffff\1\36\1\37\1\uffff\1\45\10\uffff\1\33\3\uffff\1\40\1\uffff\1\41" +
                    "\1\46\4\uffff\1\32\1\24\3\uffff\1\16\5\uffff\1\34\1\17\2\uffff\1\23\1" +
                    "\uffff\1\31\2\uffff\1\25\2\uffff\1\27\1\uffff\1\30";
    static final String DFA12_specialS =
            "\27\uffff\1\1\26\uffff\1\3\1\uffff\1\0\1\4\13\uffff\1\2\40\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\27\1\31\2\uffff\1\32\22\uffff\1\32\1\1\1\33\2\uffff\1\2\4\uffff\1" +
                    "\3\1\4\1\5\1\6\1\uffff\1\7\12\26\1\uffff\1\22\1\10\1\11\1\12\2\uffff" +
                    "\1\13\31\25\1\14\1\30\1\15\1\16\1\25\1\uffff\4\25\1\24\1\17\2\25\1\20" +
                    "\10\25\1\21\4\25\1\23\3\25",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\34\4\uffff\1\34",
            "\1\36",
            "\1\40",
            "\1\42",
            "\1\44",
            "",
            "",
            "",
            "\1\45\2\uffff\1\46",
            "\1\50\7\uffff\1\47",
            "\1\51",
            "",
            "\1\52",
            "\1\53",
            "",
            "\1\55\1\uffff\12\26",
            "\1\57\122\uffff\1\57",
            "\1\60",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\64\3\uffff\1\62\5\uffff\1\63",
            "\1\65",
            "\1\66",
            "\1\67",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\1\71",
            "\1\72",
            "\1\73",
            "",
            "",
            "\1\uffff",
            "",
            "\1\57\122\uffff\1\57",
            "\1\uffff",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\103",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "",
            "\1\106",
            "\1\107",
            "\1\110",
            "",
            "\1\uffff",
            "",
            "",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\1\112",
            "\1\113",
            "\1\114",
            "",
            "",
            "\1\115",
            "\1\116",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\1\121\6\uffff\1\122",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\1\124",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "",
            "",
            "\1\126",
            "\1\127",
            "",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "",
            "\1\131",
            "\1\132",
            "",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\1\134",
            "",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i = 0; i < numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    protected class DFA12 extends DFA {

        public DFA12 (BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }

        @Override
        public String getDescription () {
            return "1:1: Tokens : ( T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | DEDENT | FUNCTION | MAIN | WHILE | FOR | IF | ELSE | ID | INT | FLOAT | TAB | ENDL | WS | STRING | COMMENT | INDENT | CLEAR_LINE );";
        }

        @Override
        public int specialStateTransition (int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
            int _s = s;
            switch (s) {
                case 0:
                    int LA12_48 = input.LA(1);

                    int index12_48 = input.index();
                    input.rewind();
                    s = -1;
                    if ((LA12_48 == '\t' || LA12_48 == '\\') && ((getCharPositionInLine() == 0))) {
                        s = 47;
                    } else s = 61;

                    input.seek(index12_48);
                    if (s >= 0) return s;
                    break;

                case 1:
                    int LA12_23 = input.LA(1);

                    int index12_23 = input.index();
                    input.rewind();
                    s = -1;
                    if ((LA12_23 == '\t' || LA12_23 == '\\') && ((getCharPositionInLine() == 0))) {
                        s = 47;
                    } else s = 46;

                    input.seek(index12_23);
                    if (s >= 0) return s;
                    break;

                case 2:
                    int LA12_61 = input.LA(1);

                    int index12_61 = input.index();
                    input.rewind();
                    s = -1;
                    if ((!(((getCharPositionInLine() == 0))))) {
                        s = 60;
                    } else if (((getCharPositionInLine() == 0))) {
                        s = 47;
                    }

                    input.seek(index12_61);
                    if (s >= 0) return s;
                    break;

                case 3:
                    int LA12_46 = input.LA(1);

                    int index12_46 = input.index();
                    input.rewind();
                    s = -1;
                    if ((!(((getCharPositionInLine() == 0))))) {
                        s = 60;
                    } else if (((getCharPositionInLine() == 0))) {
                        s = 47;
                    }

                    input.seek(index12_46);
                    if (s >= 0) return s;
                    break;

                case 4:
                    int LA12_49 = input.LA(1);

                    int index12_49 = input.index();
                    input.rewind();
                    s = -1;
                    if ((!(((getCharPositionInLine() == 1 || getCharPositionInLine() == 0))))) {
                        s = 62;
                    } else if (((getCharPositionInLine() == 1 || getCharPositionInLine() == 0))) {
                        s = 63;
                    }

                    input.seek(index12_49);
                    if (s >= 0) return s;
                    break;
            }
            NoViableAltException nvae =
                    new NoViableAltException(getDescription(), 12, _s, input);
            error(nvae);
            throw nvae;
        }
    }

}
