package com.kadet.compiler.tokens;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 23.03.14
 * Time: 18:14
 *
 * @author Кадет
 */
public class Function {

    private String name;
    private Type type = Type.VOID;
    private List<Variable> params = new ArrayList<Variable>();
    private boolean hasReturn = false;


    public Function (String name) {
        super();
        this.name = name;
    }

    public Function (String name, Type type) {
        super();
        this.name = name;
        this.type = type;
        if (type != null && !Type.VOID.equals(type)) {
            setHasReturn(true);
        }
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public Type getType () {
        return type;
    }

    public void setType (Type type) {
        this.type = type;
        if (type != null && !Type.VOID.equals(type)) {
            setHasReturn(true);
        }
    }

    public List<Variable> getParams () {
        return params;
    }

    public void setParams (List<Variable> params) {
        this.params = params;
    }

    public boolean isHasReturn () {
        return hasReturn;
    }

    public void setHasReturn (boolean hasReturn) {
        this.hasReturn = hasReturn;
    }

    public boolean equals (Object other) {
        if (this.getClass() != other.getClass()) {
            return false;
        }
        Function otherObj = (Function) other;
        return this.name.equals(otherObj.getName());
    }


}
