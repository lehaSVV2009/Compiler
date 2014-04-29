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

    private String programName = "";

    private List<Procedure> procedures = new LinkedList<Procedure>();
    private List<Function> functions = new LinkedList<Function>();
    private List<Variable> variables = new LinkedList<Variable>();
    private List<Constant> constants = new LinkedList<Constant>();
    private Errors errors = new Errors();
    private Procedure currentProcedure = null;

    private Program () {}

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public void setCurrentProcedure(Procedure currentProcedure) {
        this.currentProcedure = currentProcedure;
    }

    public Procedure getCurrentProcedure () {
        return currentProcedure;
    }

    public String getProgramName() {
        return programName;
    }
}
