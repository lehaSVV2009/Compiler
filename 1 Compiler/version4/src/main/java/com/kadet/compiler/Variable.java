package com.kadet.compiler;

/**
 * Date: 30.03.14
 * Time: 12:38
 *
 * @author Кадет
 */
public class Variable {

    private String name;
    private Type type;

    public Variable (String name) {
        this.name = name;
    }

    public void setType (Type type) {
        this.type = type;
    }

    @Override
    public String toString () {
        return "Name: " + name +
                "\nType: " + type.toString();
    }
}
