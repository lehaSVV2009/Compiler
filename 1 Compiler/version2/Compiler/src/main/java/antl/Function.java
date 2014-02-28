package antl;

import java.util.LinkedList;
import java.util.List;

public class Function {
    private String name;
    private Type type = Type.NON;
    private List<Variable> params = new LinkedList<Variable>();
    private boolean hasLastRet = false;


    public Function(String name) {
        super();
        this.name = name;
    }

    public Function(String name, Type type) {
        super();
        this.name = name;
        this.type = type;
        if (type != null && !Type.NON.equals(type)) setHasLastRet(true);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
        if (type != null && !Type.NON.equals(type)) setHasLastRet(true);
    }

    public List<Variable> getParams() {
        return params;
    }

    public void setParams(List<Variable> params) {
        this.params = params;
    }

    public boolean isHasLastRet() {
        return hasLastRet;
    }

    public void setHasLastRet(boolean hasLastRet) {
        this.hasLastRet = hasLastRet;
    }

    public boolean equals(Object other) {
        if (this.getClass() != other.getClass())
            return false;
        Function otherObj = (Function) other;
        return this.name.equals(otherObj.getName());
    }
}
