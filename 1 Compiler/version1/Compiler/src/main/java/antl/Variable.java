package antl;

public class Variable {

	public Variable(String name,String funName) {
		super();
		this.name = name;
		this.funcName = funName;
	}

	private String name;
	private Type type = Type.NON;
	private String funcName;

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getFuncName() {
		return funcName;
	}

	public void setFuncName(String funcName) {
		this.funcName = funcName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean equals(Object other) {
		if (this.getClass() != other.getClass())
			return false;
		Variable otherObj = (Variable) other;
		return this.name.equals(otherObj.getName());
	}

}
