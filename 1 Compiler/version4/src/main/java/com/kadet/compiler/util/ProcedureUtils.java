package com.kadet.compiler.util;

import com.kadet.compiler.entities.Function;
import com.kadet.compiler.entities.Procedure;
import com.kadet.compiler.entities.Variable;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 29.04.14
 * Time: 23:05
 *
 * @author SarokaA
 */
public final class ProcedureUtils {


    public static boolean hasSuchProcedureName(String name, Procedure procedure) {
        boolean hasName = false;
        for (Procedure currentProcedure : procedure.getProcedures()) {
            if (currentProcedure.hasSuchName(name)) {
                hasName = true;
            }
        }
        Procedure parentProcedure = procedure.getParentProcedure();
        while (parentProcedure != null) {
            for (Procedure currentProcedure : parentProcedure.getProcedures()) {
                if (currentProcedure.hasSuchName(name)) {
                    hasName = true;
                }
            }
            parentProcedure = parentProcedure.getParentProcedure();
        }
        return hasName;
    }

    public static List<Procedure> getProceduresFromProcedure (Procedure procedure) {
        List<Procedure> procedures = new ArrayList<Procedure>();
        for (Procedure currentProcedure : procedure.getProcedures()) {
            procedures.add(currentProcedure);
        }
        Procedure parentProcedure = procedure.getParentProcedure();
        while (parentProcedure != null) {
            for (Procedure currentProcedure : parentProcedure.getProcedures()) {
                procedures.add(currentProcedure);
            }
            parentProcedure = parentProcedure.getParentProcedure();
        }
        return procedures;
    }

    public static Procedure getProcedureFromProcedure(String name, Procedure procedure) throws KadetException {
        for (Procedure currentProcedure : ProcedureUtils.getProceduresFromProcedure(procedure)) {
            if (currentProcedure.hasSuchName(name)) {
                return currentProcedure;
            }
        }
        throw new KadetException("There are no such procedure!");
    }


    public static boolean hasSuchFunctionName(String name, Procedure procedure) {
        boolean hasName = false;
        for (Function currentFunction : procedure.getFunctions()) {
            if (currentFunction.hasSuchName(name)) {
                hasName = true;
            }
        }
        Procedure parentProcedure = procedure.getParentProcedure();
        while (parentProcedure != null) {
            for (Function currentFunction : parentProcedure.getFunctions()) {
                if (currentFunction.hasSuchName(name)) {
                    hasName = true;
                }
            }
            parentProcedure = parentProcedure.getParentProcedure();
        }
        return hasName;
    }

    public static List<Function> getFunctionsFromProcedure (Procedure procedure) {
        List<Function> functions = new ArrayList<Function>();
        for (Function currentFunction : procedure.getFunctions()) {
            functions.add(currentFunction);
        }
        Procedure parentProcedure = procedure.getParentProcedure();
        while (parentProcedure != null) {
            for (Function currentFunction : parentProcedure.getFunctions()) {
                functions.add(currentFunction);
            }
            parentProcedure = parentProcedure.getParentProcedure();
        }
        return functions;
    }

    public static Function getFunctionFromProcedure(String name, Procedure procedure) throws KadetException {
        for (Function currentFunction : ProcedureUtils.getFunctionsFromProcedure(procedure)) {
            if (currentFunction.hasSuchName(name)) {
                return currentFunction;
            }
        }
        throw new KadetException("There are no such procedure!");
    }



}
