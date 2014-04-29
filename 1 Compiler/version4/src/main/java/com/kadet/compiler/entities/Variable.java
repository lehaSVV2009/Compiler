package com.kadet.compiler.entities;

import com.kadet.compiler.util.ValueFactory;

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

    public Variable(ProcedureParameter parameter) {
        this.name = parameter.getName();
        this.value = ValueFactory.createValue(parameter.getType());
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

    public Value getValue() {
        return value;
    }
}
