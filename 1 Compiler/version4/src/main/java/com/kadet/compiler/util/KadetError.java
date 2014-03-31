package com.kadet.compiler.util;

/**
 * Date: 30.03.14
 * Time: 13:28
 *
 * @author Кадет
 */
public class KadetError {

    private int lineNumber;
    private String errorText;

    public KadetError (int lineNumber, String errorText) {
        this.lineNumber = lineNumber;
        this.errorText = errorText;
    }

    public KadetError (String errorText) {
        this.errorText = errorText;
    }
}
