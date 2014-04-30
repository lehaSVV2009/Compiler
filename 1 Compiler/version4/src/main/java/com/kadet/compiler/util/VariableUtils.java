package com.kadet.compiler.util;

import com.kadet.compiler.entities.Constant;
import com.kadet.compiler.entities.Procedure;
import com.kadet.compiler.entities.Variable;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 01.04.14
 * Time: 12:30
 *
 * @author Кадет
 */
public final class VariableUtils {

    public static void copyVariableList(List<Variable> variables) {
        List<Variable> copyVariables = new ArrayList<Variable>();
        for (Variable variable : variables) {
            copyVariables.add(variable.copy());
        }
    }

    public static boolean hasSuchVariableOrConstantName(String name, Procedure procedure) {
        return hasSuchConstantName(name, procedure) || hasSuchVariableName(name, procedure) ;
    }

    public static boolean hasSuchVariableName(String name, Procedure procedure) {
        boolean hasName = false;
        for (Variable variable : procedure.getVariables()) {
            if (variable.hasSuchName(name)) {
                hasName = true;
            }
        }
        Procedure parentProcedure = procedure.getParentProcedure();
        while (parentProcedure != null) {
            for (Variable variable : parentProcedure.getVariables()) {
                if (variable.hasSuchName(name)) {
                    hasName = true;
                }
            }
            parentProcedure = parentProcedure.getParentProcedure();
        }
        return hasName;
    }

    public static boolean hasSuchConstantName(String name, Procedure procedure) {
        boolean hasName = false;
        for (Constant constant : procedure.getConstants()) {
            if (constant.hasSuchName(name)) {
                hasName = true;
            }
        }
        Procedure parentProcedure = procedure.getParentProcedure();
        while (parentProcedure != null) {
            for (Constant constant : parentProcedure.getConstants()) {
                if (constant.hasSuchName(name)) {
                    hasName = true;
                }
            }
            parentProcedure = parentProcedure.getParentProcedure();
        }
        return hasName;
    }


    public static List<Variable> getVariablesFromProcedure (Procedure procedure) {
        List<Variable> variables = new ArrayList<Variable>();
        for (Variable variable : procedure.getVariables()) {
            variables.add(variable);
        }
        Procedure parentProcedure = procedure.getParentProcedure();
        while (parentProcedure != null) {
            for (Variable variable : parentProcedure.getVariables()) {
                variables.add(variable);
            }
            parentProcedure = parentProcedure.getParentProcedure();
        }
        return variables;
    }

    public static Variable getVariableFromProcedure(String name, Procedure procedure) throws KadetException {
        for (Variable variable : VariableUtils.getVariablesFromProcedure(procedure)) {
            if (variable.hasSuchName(name)) {
                return variable;
            }
        }
        throw new KadetException("There are no such variable!");
    }

    public static List<Constant> getConstantsFromProcedure (Procedure procedure) {
        List<Constant> constants = new ArrayList<Constant>();
        for (Constant constant : procedure.getConstants()) {
            constants.add(constant);
        }
        Procedure parentProcedure = procedure.getParentProcedure();
        while (parentProcedure != null) {
            for (Constant constant : parentProcedure.getConstants()) {
                constants.add(constant);
            }
            parentProcedure = parentProcedure.getParentProcedure();
        }
        return constants;
    }

    public static Constant getConstantFromProcedure(String name, Procedure procedure) throws KadetException {
        for (Constant constant : VariableUtils.getConstantsFromProcedure(procedure)) {
            if (constant.hasSuchName(name)) {
                return constant;
            }
        }
        throw new KadetException("There are no such variable!");
    }


    public static Variable getConstantOrVariableFromProcedure (String name, Procedure procedure) throws KadetException {
        if (hasSuchConstantName(name, procedure)) {
            return getConstantFromProcedure(name, procedure);
        } else if(hasSuchVariableName(name, procedure)) {
            return getVariableFromProcedure(name, procedure);
        }
        throw new KadetException("There are no such Constant or Variable!");
    }


}
