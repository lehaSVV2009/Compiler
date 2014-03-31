package com.kadet.compiler.util;

import com.kadet.compiler.Type;
import com.kadet.compiler.entities.*;

import java.util.ArrayList;

/**
 * Date: 31.03.14
 * Time: 2:00
 *
 * @author Кадет
 */
public final class ValueFactory {

    public static Value createValue (Type type) {
        switch (type) {
            case BOOLEAN: {
                return new Bool(false);
            }
            case ELEMENT: {
                return new Element(new Object());
            }
            case INTEGER: {
                return new Int(0);
            }
            case LIST: {
                return new List(new ArrayList<Value>());
            }
            case VALUE: {
                return new Value();
            }
            default: {
                return new Value();
            }
        }
    }

}
