package com.kadet.compiler.expressions;

import com.kadet.compiler.entities.Procedure;
import com.kadet.compiler.entities.Program;
import com.kadet.compiler.entities.Value;
import com.kadet.compiler.entities.Variable;
import com.kadet.compiler.util.KadetException;
import com.kadet.compiler.util.VariableUtils;
import sun.dc.pr.PRError;

/**
 * Date: 29.04.14
 * Time: 21:11
 *
 * @author SarokaA
 */
public class VariableValueExpression implements Expression{

    private String name;

    public VariableValueExpression(String name) {
        this.name = name;
    }

    @Override
    public Value calculate() throws KadetException {
        Procedure procedure = Program.getInstance().getCurrentProcedure();
        if (procedure == null) {
            throw new KadetException("There are no executing procedure!");
        }
        if (!VariableUtils.hasSuchVariableName(name, procedure)) {
            throw new KadetException("There are no such variable name!");
        }
        Variable variable = VariableUtils.getVariableFromProcedure(name, procedure);
        return variable.getValue();
    }
}
