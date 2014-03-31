package com.kadet.compiler.entities;

/**
 * Date: 30.03.14
 * Time: 17:25
 *
 * @author Кадет
 */
public class Value {

    protected Type type = Type.VALUE;

    public Type getType () {
        return type;
    }

    public Value copy () {
        return new Value();
    }
}
