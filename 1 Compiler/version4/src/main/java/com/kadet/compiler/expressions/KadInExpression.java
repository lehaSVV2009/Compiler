package com.kadet.compiler.expressions;

import com.kadet.compiler.entities.Bool;
import com.kadet.compiler.entities.Int;
import com.kadet.compiler.entities.List;
import com.kadet.compiler.entities.Value;
import com.kadet.compiler.util.KadetException;

import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Date: 30.04.14
 * Time: 18:36
 *
 * @author SarokaA
 */
public class KadInExpression implements Expression {

    private final static String TRUE = "true";
    private final static String FALSE = "false";

    private InputStream inputStream;

    public KadInExpression(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public Value calculate() throws KadetException {
        Scanner scanner = new Scanner(inputStream);
        String text = scanner.nextLine();
        System.out.println(text);
        return getValueFromText(text);
    }

    private Value getValueFromText (String text) throws KadetException{
        text = text.trim();
        if (text.length() == 0) {
            throw new KadetException("Bad Input Text!");
        }
        if (TRUE.equalsIgnoreCase(text) || ('@' + TRUE).equalsIgnoreCase(text) ) {
            return new Bool(true);
        }
        if (FALSE.equalsIgnoreCase(text) || ('@' + FALSE).equalsIgnoreCase(text)) {
            return new Bool(false);
        }
        try {
            int value = Integer.parseInt(text);
            return new Int(value);
        } catch (NumberFormatException nfe) {
            if(('<' != text.charAt(0) || '>' != text.charAt(text.length() - 1))) {
                throw new KadetException("Bad Input Text!");
            }
            text = text.substring(1, text.length() - 1);
            System.out.println(text);
            String []textElements = text.split(",");
            List list = new List();
            for (String textElement : textElements) {
                list.addElement(getValueFromText(textElement));
            }
            return list;
        }
    }


}
