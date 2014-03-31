package com.kadet.compiler.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 30.03.14
 * Time: 12:38
 *
 * @author Кадет
 */
public class Errors {

    private static List<KadetError> errors = new ArrayList<KadetError>();

    public static void addError (KadetError error) {
        errors.add(error);
    }

    public static boolean hasErrors () {
        return errors.size() == 0;
    }

}
