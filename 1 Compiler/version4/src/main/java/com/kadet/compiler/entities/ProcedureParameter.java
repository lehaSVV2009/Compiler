package com.kadet.compiler.entities;

/**
 * Date: 31.03.14
 * Time: 14:26
 *
 * @author Кадет
 */
public class ProcedureParameter {

    private String name;
    private Type type;

    public ProcedureParameter (String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public String getName () {
        return name;
    }

    public Type getType () {
        return type;
    }

    @Override
    public String toString () {
        return "ProcedureParameter{" +
                "name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
