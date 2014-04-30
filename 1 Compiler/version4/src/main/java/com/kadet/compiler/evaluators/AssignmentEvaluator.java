package com.kadet.compiler.evaluators;

import com.kadet.compiler.entities.Procedure;
import com.kadet.compiler.entities.Program;
import com.kadet.compiler.entities.Value;
import com.kadet.compiler.entities.Variable;
import com.kadet.compiler.expressions.Expression;
import com.kadet.compiler.util.Errors;
import com.kadet.compiler.util.KadetError;
import com.kadet.compiler.util.KadetException;
import com.kadet.compiler.util.VariableUtils;

import java.util.List;

/**
 * Date: 30.03.14
 * Time: 14:01
 *
 * @author Кадет
 */
public class AssignmentEvaluator implements StatementEvaluator {

    private String name;
    private Expression expression;

    public AssignmentEvaluator(String name, Expression expression) {
        this.name = name;
        this.expression = expression;
    }

    @Override
    public void evaluate() throws KadetException {
        System.out.println("Assignment Evaluator Starts!");
        Procedure currentProcedure = Program.getInstance().getCurrentProcedure();
        System.out.println("Assignment in procedure: " + currentProcedure);
        if (currentProcedure == null) {
            throw new KadetException("There is no current procedure!");
        }
        if (!VariableUtils.hasSuchVariableName(name, currentProcedure)) {
            throw new KadetException("No such variable!");
        }
            /*Variable currentVariable = null;
            for (Variable variable : VariableUtils.getVariablesFromProcedure(currentProcedure)) {
                if (variable.hasSuchName(name)) {
                    currentVariable = variable;
                    break;
                }
            } */
        Variable currentVariable = VariableUtils.getVariableFromProcedure(name, currentProcedure);
        Value value = expression.calculate();
        if (value == null) {
            throw new KadetException("Bad Value!");
        }
        currentVariable.setValue(value.copy());
        System.out.println("Value assign to variable. Variable : " + currentVariable);
    }


}
