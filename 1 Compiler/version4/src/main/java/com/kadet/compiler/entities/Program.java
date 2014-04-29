package com.kadet.compiler.entities;

import com.kadet.compiler.util.Errors;

import java.util.LinkedList;
import java.util.List;

/**
 * Date: 30.03.14
 * Time: 12:37
 *
 * @author Кадет
 */
public class Program {

    private static Program instance = new Program();

    public static Program getInstance () {
        return instance;
    }

    private List<Procedure> procedures = new LinkedList<Procedure>();
    private List<Function> functions = new LinkedList<Function>();
    private List<Variable> variables = new LinkedList<Variable>();
    private List<Constant> constants = new LinkedList<Constant>();
    private Errors errors = new Errors();
    private Procedure currentProcedure = null;

    public static final String MAIN_NAME = "main";

    private Program () {}

    public void addVariable (Variable variable) {
        variables.add(variable);
        System.out.println("Added Variable : " + variable);
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

    public void addConstant (Constant constant) {
        constants.add(constant);
        System.out.println("Added Constant : " + constant);
    }

    public void addFunction (Function function) {
        functions.add(function);
        System.out.println("Added Function : " + function);
    }

    public void addProcedure (Procedure procedure) {
        procedures.add(procedure);
        System.out.println("Added Procedure :" + procedure);
    }

    public List<Procedure> getProcedures () {
        return procedures;
    }

    public List<Function> getFunctions () {
        return functions;
    }

    public List<Variable> getVariables () {
        return variables;
    }

    public List<Constant> getConstants () {
        return constants;
    }

    public Procedure getCurrentProcedure () {
        return currentProcedure;
    }
}
