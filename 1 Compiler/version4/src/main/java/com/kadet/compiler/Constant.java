package com.kadet.compiler;

/**
 * Date: 30.03.14
 * Time: 14:08
 *
 * @author Кадет
 */
public class Constant {

    private String name;
    private Type type;

    public Constant (String name) {
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
