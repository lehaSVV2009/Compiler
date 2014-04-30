package com.kadet.compiler.evaluators;

import com.kadet.compiler.entities.*;
import com.kadet.compiler.expressions.Expression;
import com.kadet.compiler.util.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 30.04.14
 * Time: 14:54
 *
 * @author SarokaA
 */
public abstract class CallEvaluator implements StatementEvaluator {

    private String procedureName;
    private List<Expression> actualParameters = new ArrayList<Expression>();

    public CallEvaluator(String procedureName, List<Expression> actualParameters) {
        this.procedureName = procedureName;
        this.actualParameters = actualParameters;
    }

    @Override
    public void evaluate() throws KadetException {
        System.out.println("Procedure Call Evaluator Starts!");
        Procedure currentProcedure = Program.getInstance().getCurrentProcedure();
        if (currentProcedure == null) {
            throw new KadetException("There is no current procedure!");
        }
        Procedure procedure = getProcedure(procedureName, currentProcedure);
        System.out.println("Called procedure: " + procedure.getName());
        List<Value> parameterValues
                = evaluateExpressions(actualParameters);
        addParametersValuesToProcedure(parameterValues, procedure);
        Evaluator procedureEvaluator
                = createCallEvaluator(procedure);
        procedureEvaluator.evaluate();
    }

    abstract protected Procedure getProcedure(String procedureName, Procedure parentProcedure) throws KadetException;

    abstract protected Evaluator createCallEvaluator(Procedure procedure);

    private List<Value> evaluateExpressions(List<Expression> expressions) throws KadetException {
        List<Value> values = new ArrayList<Value>();
        for (Expression expression : expressions) {
            values.add(expression.calculate());
        }
        return values;
    }

    private void addParametersValuesToProcedure(List<Value> values, Procedure procedure) throws KadetException {
        List<String> variableNames
                = getParametersNamesFromParameters(procedure.getParameters());
        List<Variable> variables
                = getVariablesFromProcedureByNames(variableNames, procedure);
        for (int valueIndex = 0, valuesNumber = values.size(); valueIndex < valuesNumber; ++valueIndex) {
            if (valueIndex >= variables.size()) {
                break;
            }
            Variable currentVariable = variables.get(valueIndex);
            Value value = values.get(valueIndex);
            if (!currentVariable.getValue().getType().equals(value.getType())) {
                throw new KadetException("Wrong type of parameter!");
            }
            currentVariable.setValue(
                    values.get(valueIndex));
        }
    }

    private List<String> getParametersNamesFromParameters(List<ProcedureParameter> parameters) {
        List<String> names = new ArrayList<String>();
        for (ProcedureParameter parameter : parameters) {
            names.add(parameter.getName());
        }
        return names;
    }

    private List<Variable> getVariablesFromProcedureByNames(List<String> names, Procedure procedure) throws KadetException {
        List<Variable> variables = new ArrayList<Variable>();
        for (String name : names) {
            variables.add(VariableUtils.getVariableFromProcedure(name, procedure));
        }
        return variables;
    }
}
