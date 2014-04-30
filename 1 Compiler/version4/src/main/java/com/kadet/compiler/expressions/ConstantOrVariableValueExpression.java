package com.kadet.compiler.expressions;

import com.kadet.compiler.entities.*;
import com.kadet.compiler.util.KadetException;
import com.kadet.compiler.util.ValueUtils;
import com.kadet.compiler.util.VariableUtils;
import sun.dc.pr.PRError;

/**
 * Date: 29.04.14
 * Time: 21:11
 *
 * @author SarokaA
 */
public class ConstantOrVariableValueExpression implements Expression{

    private String name;

    public ConstantOrVariableValueExpression(String name) {
        this.name = name;
    }

    @Override
    public Value calculate() throws KadetException {
        Procedure procedure = Program.getInstance().getCurrentProcedure();
        if (procedure == null) {
            throw new KadetException("There are no executing procedure!");
        }
        Variable variable = VariableUtils.getConstantOrVariableFromProcedure(name, procedure);
        Value value = variable.getValue();
        if (ValueUtils.isList(value)) {
            value = ((List)value).copy();
        }
        return variable.getValue();
    }
}
