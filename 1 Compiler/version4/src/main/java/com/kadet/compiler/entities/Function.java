package com.kadet.compiler.entities;

import com.kadet.compiler.evaluators.ReturnStatementEvaluator;

import java.util.*;
import java.util.List;

/**
 * Date: 30.03.14
 * Time: 12:37
 *
 * @author Кадет
 */
public class Function extends Procedure {

    private Type returnType;

    public Function (String name) {
        super(name);
    }

    public void setReturnType (Type returnType) {
        this.returnType = returnType;
    }

    public Type getReturnType () {
        return returnType;
    }
}
