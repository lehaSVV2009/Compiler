package com.kadet.compiler.entities;

import com.kadet.compiler.evaluators.StatementEvaluator;

import java.util.*;
import java.util.List;

/**
 * Date: 30.03.14
 * Time: 12:41
 *
 * @author Кадет
 */
public class Procedure {

    private String name;
    private java.util.List<ProcedureParameter> parameters = new ArrayList<ProcedureParameter>();
    private java.util.List<StatementEvaluator> statementEvaluators = new ArrayList<StatementEvaluator>();
    private java.util.List<Variable> variables = new ArrayList<Variable>();
    private java.util.List<Constant> constants = new ArrayList<Constant>();

    public Procedure (String name) {
        this.name = name;
    }

    public void setParameters (List<ProcedureParameter> parameters) {
        this.parameters = parameters;
    }

    public void addStatementEvaluator (StatementEvaluator statementEvaluator) {
        statementEvaluators.add(statementEvaluator);
    }

    public void addVariables (List<Variable> variables) {
        for (Variable variable : variables) {
            addVariable(variable);
        }
    }

    public void addConstants (List<Constant> constants) {
        for (Constant constant : constants) {
            addConstant(constant);
        }
    }

    public void addVariable (Variable variable) {
        variables.add(variable);
        System.out.println("To procedure " + name + " added Variable : " + variable);
    }

    public void addConstant (Constant constant) {
        constants.add(constant);
        System.out.println("To procedure " + name + " added Constant : " + constant);
    }

    public String getName () {
        return name;
    }

    @Override
    public String toString () {
        return "Procedure{" +
                "name='" + name + '\'' +
                ", parameters=" + parameters +
                ", statementEvaluators=" + statementEvaluators +
                '}';
    }
}
