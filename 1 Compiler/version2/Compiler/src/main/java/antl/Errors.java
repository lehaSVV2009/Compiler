package antl;

import java.util.List;

public class Errors {

    public void DuplicateError(String name_var, int line) {
        System.out.println("ERROR : Duplicate local variable '" + name_var
                + "' in line " + line);
    }

    public void UndefinedVar(String name_var, int line) {
        System.out.println("ERROR : The var '" + name_var
                + "' is undefined in line " + line);
    }

    public void UndefinedMethod(String name_func, int line) {
        System.out.println("ERROR : The method '" + name_func
                + "' is undefined in line " + line);
    }

    public void DuplicateMethod(String name_funcElse, int line) {
        System.out.println("ERROR : Duplicate local method '" + name_funcElse
                + "' in line " + line);
    }

    public void MethodWithoutParams(String name_func, int line) {
        System.out.println("ERROR : Method '" + name_func
                + "' must't have any parametrs in line " + line);
    }

    public void MethodWithParams(String name_func, int line, int kol_params) {
        System.out.println("ERROR : Method '" + name_func + "' must have "
                + kol_params + " parametrs in line " + line);
    }

    public void MethodWithErrorsParams(String name_func, int line,
                                       List<String> params) {
        System.out.println("ERROR : Method '" + name_func + "' must have "
                + params + " parametrs in line " + line);
    }

    public void WrongType(String type1, String type2, int line) {
        System.out.println("ERROR : Types '" + type1
                + "' and '" + type2 + "' must be casts in line " + line);
    }

    public void BadRetType(String type, String prevType, int line) {
        System.out.println("ERROR : Return type must be '" + type
                + "' first return has '" + prevType + "' in line " + line);
    }

    public void NotReturnFunc(String name, int line) {
        System.out.println("ERROR : Function '" + name
                + "' can't return smth in line " + line);
    }

    public void ReturnFunc(String name, int line) {
        System.out.println("ERROR : Function '" + name
                + "' must have a return value in line " + line);
    }

    public void CheckOnRet(int line) {
        System.out.println("ERROR : Function must be returnble " + line);
    }

    public void LastRet(int line) {
        System.out.println("ERROR : Function must have last return " + line);
    }

    ////

    public static void BadAfterRet(int line) {
        System.out.println("ERROR : instraction can't be after return in line " + line);
    }

    public void RetDontNeed(int line) {
        System.out.println("ERROR : Return don't need in this func in line " + line);
    }

    public void VarDontInit(String name, int line) {
        System.out.println("ERROR : Variable '" + name
                + "' must be initialize in line " + line);
    }

    public static void BadBlockLine(int line) {
        System.out.println("ERROR : Block line have uncorrect tab number in line " + line);
    }

    public static void WrongStageVar(int line) {
        System.out.println("ERROR : wrong stage for define global var in line " + line);
    }

    public static void WrongStageFun(int line) {
        System.out.println("ERROR : wrong stage for define global fun in line " + line);
    }

    public static void WrongStageMain(int line) {
        System.out.println("ERROR : wrong stage for define global main in line " + line);
    }

    public static void WrongIfElse(int line) {
        System.out.println("ERROR : wrong If Else operator in line " + line);
    }
}