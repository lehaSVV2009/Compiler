package com.kadet.compiler.entities;

import com.kadet.compiler.Type;

import java.util.ArrayList;

/**
 * Date: 30.03.14
 * Time: 17:25
 *
 * @author Кадет
 */
public class List extends Value {

    private java.util.List<Value> values = new ArrayList<Value>();

    public List () {
        this.type = Type.LIST;
    }

    public List (java.util.List<Value> values) {
        this();
        this.values = values;
    }
}
