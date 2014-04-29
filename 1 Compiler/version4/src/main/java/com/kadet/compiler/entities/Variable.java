package com.kadet.compiler.entities;

/**
 * Date: 30.03.14
 * Time: 12:38
 *
 * @author Кадет
 */
public class Variable {

    private String name;
    private Value value;

    public Variable (String name) {
        this.name = name;
    }

    public void setValue (Value value) {
        this.value = value;
    }

    @Override
    public String toString () {
        return "Variable{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    public Variable copy () {
        Variable variable = new Variable(name);
        variable.setValue(value);
        return variable;
    }

    public boolean hasSuchName (String name) {
        return this.name.equals(name);
    }

}
