package com.kadet.compiler.entities;

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

    public Function (String name, Type returnType) {
        super(name);
        this.returnType = returnType;
    }


    public Type getReturnType () {
        return returnType;
    }
}
