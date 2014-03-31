package com.kadet.compiler.entities;

import java.util.ArrayList;

/**
 * Date: 30.03.14
 * Time: 17:25
 *
 * @author Кадет
 */
public class List extends Value {

    private java.util.List<Value> values = new ArrayList<Value>();

    private List () {
        this.type = Type.LIST;
    }

    public List (java.util.List<Value> values) {
        this();
        this.values = values;
    }

    public void addElement (Value value) {
        values.add(value);
    }

    public void removeElement (Value value) {
        values.remove(value);
    }

    public void removeAllElementEntries (Value value) {
        while (values.contains(value)) {
            values.remove(value);
        }
    }

    @Override
    public String toString () {
        return "List{" +
                "values=" + values +
                '}';
    }

    public java.util.List<Value> getValues () {
        return values;
    }

    @Override
    public Value copy () {
        java.util.List<Value> newValues = new ArrayList<Value>();
        for (Value value : values) {
            newValues.add(value.copy());
        }
        return new List(values);
    }

    public void addElementsFromOtherList (List list) {
        for (Value value : list.getValues()) {
            values.add(value);
        }
    }

    @Override
    public boolean equals (Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj || getClass() != obj.getClass()) {
            return false;
        }
        List list = (List) obj;
        java.util.List<Value> objValues = list.getValues();
        if (values.size() != objValues.size()) {
            return false;
        }
        boolean equalValues = true;
        for (int valueIndex = values.size() - 1; valueIndex >= 0; --valueIndex) {
            if (!values.get(valueIndex).equals(objValues.get(valueIndex))) {
                equalValues = false;
            }
        }
        return equalValues;
    }
}