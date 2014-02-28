import antl.gggggLexer;
import antl.gggggParser;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

import java.io.IOException;

public class Test {

    public static void main(String[] arg) throws IOException, RecognitionException {

        CharStream input = new ANTLRFileStream("test");

        gggggLexer lexer = new gggggLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);


        gggggParser pars = new gggggParser(tokens);
        pars.program();
        System.out.println("done!!!");

    }

}
