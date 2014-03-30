package com.kadet.compiler;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllDescTable {
	private List<Function> funs = new LinkedList<Function>();
	private List<Variable> vars = new LinkedList<Variable>();
	private Errors error = new Errors();
	private Function curFun = null;

	public static final String MAIN_NAME = "Alenamain";

	public void addParametr(String varName, int line) {
		Variable var = new Variable(varName,
				(curFun != null) ? curFun.getName() : null);
		if (vars.contains(var)) {
			error.DuplicateError(var.getName(), line);
		} else {
			vars.add(var);
		}
		if (curFun != null)
			curFun.getParams().add(var);
	}

	public void initVariable(String name, Type type) {
		for (Variable var : vars) {
			if (var.getName().equals(name)) {
				var.setType(type);
				break;
			}
		}
	}

	public void addVariable(String varName, int line) {
		Variable var = new Variable(varName,
				(curFun != null) ? curFun.getName() : null);
		if (!vars.contains(var)) {
			vars.add(var);
		}
	}

	public void defineFun(String funName, int line) {
		Function fun = new Function(funName);
		if (funs.contains(fun)) {
			error.DuplicateMethod(fun.getName(), line);
		} else {
			funs.add(fun);
		}
		curFun = fun;
	}

	public void clearCurFun() {
		if (curFun != null && curFun.getName() != null) {
			List<Variable> tempVars = new LinkedList<Variable>();
			tempVars.addAll(vars);
			for (Variable var : tempVars) {
				if (curFun.getName().equals(var.getFuncName())) {
					vars.remove(var);
				}
			}
		}
		curFun = null;
	}

	public void defineCurFun(String name) {
		curFun = new Function(name);
	}

	public boolean checkUndefinedFun(String name, int line) {
		Function fun = new Function(name);
		if (!funs.contains(fun)) {
			error.UndefinedMethod(fun.getName(), line);
		}
		return !funs.contains(fun);
	}

	public Type getFunType(String name) {
		for (Function fun : funs) {
			if (fun.getName().equals(name)) {
				return fun.getType();
			}
		}
		return null;
	}

	public Type getVarType(String name) {
		for (Variable var : vars) {
			if (var.getName().equals(name)) {
				return var.getType();
			}
		}
		return Type.NON;
	}

	// /
	public boolean equalType(Type type1, Type type2, int line) {
		if (type1 != null && type2 != null)
			if (!type1.getName().equals(type2.getName()) || (Type.NON.equals(type1) && Type.NON.equals(type2))) {
				error.WrongType(type1.getName(), type2.getName(), line);
				return false;
			}
		return true;
	}

	public void checkFunParam(String name, List<Type> types, int line) {
		Function curFun = null;
		if (funs.contains(new Function(name))) {
			for (Function fun : funs) {
				if (fun.getName().equals(name)) {
					curFun = fun;
					break;
				}
			}
			if (curFun != null) {
				if (types.size() == 0)
					error.MethodWithoutParams(name, line);
				List<String> params = new ArrayList<String>();
				for (Variable var : curFun.getParams()) {
					params.add(var.getName());
				}
				if (types.size() != curFun.getParams().size()) {
					error.MethodWithErrorsParams(name, line, params);
				}
			}
		}
	}

	public void checkInitializeVar(String name, int line) {
		Variable aVar = null;
		for (Variable var : vars) {
			if (var.getName().equals(name)) {
				aVar = var;
			}
		}
		if (aVar == null)
			error.VarDontInit(name, line);
	}
	
	public void setFunRetType(Type type, int line) {
		if(curFun==null) {
			error.RetDontNeed(line);
		} else {
			if(!Type.NON.equals(curFun.getType()) && !curFun.getType().equals(type)) {
				error.BadRetType(type.getName(), curFun.getType().getName(), line);
			} else {
				curFun.setType(type);
			}
		}
	}
	
	public void setFunReturnable() {
		if(curFun!=null) {
			curFun.setHasLastRet(true);
		} 
	}
	
	public void checkReturnable(boolean hasLastRet, int line) {
		if(curFun!=null && curFun.isHasLastRet()) {
			if(!hasLastRet) error.LastRet(line);
		}
	}

}