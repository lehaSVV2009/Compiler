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
    private Function curFun = null;

    public static final String MAIN_NAME = "main";

    private Program () {}

    public void addVariable (Variable variable) {
        variables.add(variable);
    }

    public void addConstant (Constant constant) {
        constants.add(constant);
    }

    public void addFunction (Function function) {
        functions.add(function);
    }

    public void addProcedure (Procedure procedure) {
        procedures.add(procedure);
        System.out.println("Added procedure:" + procedure);
    }

}
