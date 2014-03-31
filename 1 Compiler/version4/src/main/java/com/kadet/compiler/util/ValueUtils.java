package com.kadet.compiler.util;

import com.kadet.compiler.entities.Type;
import com.kadet.compiler.entities.Bool;
import com.kadet.compiler.entities.Int;
import com.kadet.compiler.entities.List;
import com.kadet.compiler.entities.Value;

/**
 * Date: 31.03.14
 * Time: 0:34
 *
 * @author Кадет
 */
public final class ValueUtils {

    public static boolean isBoolean (Value value) {
        try {
            Bool boolValue = (Bool)value;
            Object content = boolValue.getContent();
            if (!(content instanceof Boolean)) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Boolean getBooleanFromValue (Value value) {
        if (!isBoolean(value)) {
            throw new RuntimeException("Value is not Boolean!");
        }
        return ((java.lang.Boolean)((Bool)value).getContent());
    }

    public static boolean isElement (Value value) {
        return value.getType() == Type.ELEMENT
                || value.getType() == Type.INTEGER
                || value.getType() == Type.BOOLEAN;
    }

    public static boolean isInteger (Value value) {
        try {
            Int intValue = (Int)value;
            Object content = intValue.getContent();
            if (!(content instanceof Integer)) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Integer getIntegerFromValue (Value value) {
        if (!isInteger(value)) {
            throw new RuntimeException("Value is not Integer!");
        }
        return ((Integer)((Int)value).getContent());
    }

    public static boolean isList (Value value) {
        try {
            List listValue = (List)value;
            java.util.List<Value> values = listValue.getValues();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static java.util.List<Value> getListFromValue (Value value) {
        if (!isList(value)) {
            throw new RuntimeException("Value is not List!");
        }
        return (((List)value).getValues());
    }

    public static boolean isElementAndList (Value value1, Value value2) {
        return (isElement(value1) && isList(value2));
    }

    public static boolean isListAndElement (Value value1, Value value2) {
        return (isList(value1) && isElement(value2));
    }

    public static boolean isListAndList (Value value1, Value value2) {
        return (isList(value1) && isList(value2));
    }

    public static boolean isElementAndElement (Value value1, Value value2) {
        return (isElement(value1) && isElement(value2));
    }


}
