package com.kadet.compiler.tokens;

/**
 * Date: 23.03.14
 * Time: 18:20
 *
 * @author Кадет
 */
public enum Type {

    ELEMENT("Element"), LIST("List"),  VOID("void");

    private String name;

    Type(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
