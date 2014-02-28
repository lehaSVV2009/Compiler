import com.kadet.compiler.antlrManager.CompilerHelper;
import org.antlr.runtime.ANTLRInputStream;

import java.io.File;
import java.io.IOException;

/**
 * Date: 13.02.14
 * Time: 21:02
 *
 * @author SarokaA
 */
public class GenerateLexerAndParser {

    public static final String G_FILE = "src/main/java/antl/ggggg.g";

    public static final String SRC_FOLDER = "src/main/java/antl";

    public static void main(String[] args) throws IOException {

        CompilerHelper.compile(
                new File(SRC_FOLDER).getAbsolutePath(),
                new File(G_FILE).getAbsolutePath()
        );

    }

}