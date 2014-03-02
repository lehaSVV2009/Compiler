package com.kadet.compiler.antlrManager;

/**
 * Date: 13.02.14
 * Time: 21:06
 *
 * @author SarokaA
 */
public class CompilerHelper {

    public static void compile (String src, String grammar) {
        org.antlr.Tool.main(
                        new String[]{
                                "-o",
                                src,
                                grammar});
    }

}