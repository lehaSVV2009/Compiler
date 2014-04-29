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
    private Procedure parentProcedure;
    private java.util.List<ProcedureParameter> parameters = new ArrayList<ProcedureParameter>();
    private java.util.List<StatementEvaluator> statementEvaluators = new ArrayList<StatementEvaluator>();
    private java.util.List<Variable> variables = new ArrayList<Variable>();
    private java.util.List<Constant> constants = new ArrayList<Constant>();
    private java.util.List<Procedure> procedures = new ArrayList<Procedure>();
    private java.util.List<Function> functions = new ArrayList<Function>();


    public Procedure () {
    }

    public Procedure(String name) {
        this.name = name;
    }

    public void setParentProcedure(Procedure parentProcedure) {
        this.parentProcedure = parentProcedure;
    }

    public void setParameters (List<ProcedureParameter> parameters) {
        this.parameters = parameters;
        for (ProcedureParameter parameter : parameters) {
            Variable variable = new Variable(parameter);
            variables.add(variable);
        }
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

    public void addFunction (Function function) {
        functions.add(function);
        System.out.println("Added Function : " + function);
    }

    public void addProcedure (Procedure procedure) {
        procedures.add(procedure);
        System.out.println("Added Procedure :" + procedure);
    }

    public String getName () {
        return name;
    }


    public boolean hasSuchName (String name) {
        return this.name.equals(name);
    }

    @Override
    public String toString () {
        return "Procedure{" +
                "name='" + name + '\'' +
                ", parameters=" + parameters +
                ", statementEvaluators=" + statementEvaluators +
                '}';
    }

    public List<ProcedureParameter> getParameters() {
        return parameters;
    }

    public List<StatementEvaluator> getStatementEvaluators() {
        return statementEvaluators;
    }

    public List<Variable> getVariables() {
        return variables;
    }

    public List<Constant> getConstants() {
        return constants;
    }

    public List<Procedure> getProcedures() {
        return procedures;
    }

    public List<Function> getFunctions() {
        return functions;
    }

    public Procedure getParentProcedure() {
        return parentProcedure;
    }
}
