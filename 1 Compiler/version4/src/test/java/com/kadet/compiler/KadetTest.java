package com.kadet.compiler;

import com.kadet.compiler.evaluators.Evaluator;
import com.kadet.compiler.util.KadetException;
import org.junit.Test;

public class KadetTest {

    private Evaluator evaluator;

    @Test
    public void Void() {

    }

/*
    @Test
	public void correctProgram () {
        try { KadetCompiler compiler = new KadetCompiler();
        compiler.compile("\nprogram Test1 = " +
                                 "\nbegin " +
                                 "\nend Test1.");
    }



/*
    @Test
	public void constant () {
        try { KadetCompiler compiler = new KadetCompiler();
        compiler.compile("\nprogram Test2 = " +
                                 "\nconstant one: Element := 1;" +
                                 "\nconstant two: Element := 2;" +
                                 "\nconstant characterA : Element := 'A';" +
                                 "\nconstant stringHello : Element := \"Hello\";" +
                                 "\nbegin " +
                                 "\nend Test2.");
    }


    @Test
	public void list () {
        try { KadetCompiler compiler = new KadetCompiler();
        compiler.compile("\nprogram Test3 = " +
                                 "\nconstant one: Element := 1;" +
                                 "\nconstant two: Element := 2;" +
                                 "\nconstant characterA : Element := 'A';" +
                                 "\nconstant stringHello : Element := \"Hello\";" +
                                 "\nvar x : Element := 42;" +
                                 "\nvar list : List := [ 123, 456 ];" +
                                 "\nbegin " +
                                 "\nend Test3.");
    }


    @Test
	public void listWithExpressions () {
        try { KadetCompiler compiler = new KadetCompiler();
        compiler.compile("\nprogram Test4 = " +
                                 "\nconstant one: Element := 1;" +
                                 "\nconstant two: Element := 2;" +
                                 "\nconstant characterA : Element := 'A';" +
                                 "\nconstant stringHello : Element := \"Hello\";" +
                                 "\nvar x : Element := 42;" +
                                 "\nvar list : List := [ 123, 456 ];" +
                                 "\nvar list2 : List := [ x + 5, 234, x ];" +
                                 "\nbegin " +
                                 "\nend Test4.");
    }


    @Test
	public void listElement () {
        try { KadetCompiler compiler = new KadetCompiler();
        compiler.compile("program Test1 = \n" +
                                 "\n" +
                                 "constant one : Element := 42;\n" +
                                 "var element1, element2 : Element := 1;\n" +
                                 "var element3 : Element;\n" +
                                 "var list : List;\n" +
                                 "var list2 : List := [ 123, 'A', element1 ];\n" +
                                 "\n" +
                                 "begin\n" +
                                 "\n" +
                                 "list := element1 + element2 + list2;\n" +
                                 "element3 := list [0];\n" +
                                 "\n" +
                                 "end Test1.");
    }
*/
/*
    @Test
    public void ifTest () {
        try { KadetCompiler compiler = new KadetCompiler();
        compiler.compile("program Test1 = \n" +
                                 "\n" +
                                 "constant one : Element := 42;\n" +
                                 "var element1, element2 : Element := 1;\n" +
                                 "var element3 : Element;\n" +
                                 "var list : List;\n" +
                                 "var list2 : List := < 123, element1 >;\n" +
                                 "\n" +
                                 "begin\n" +
                                 "\n" +
                                 "if element1 less 32 then\n" +
                                 "    element3 := element1;\n" +
                                 "end if;\n" +
                                 "\n" +
                                 "list := element1 + element2 + list2;\n" +
                                 "element3 := list [0];\n" +
                                 "\n" +
                                 "end Test1.");
    }


    @Test
    public void loopsTest () {
        try { KadetCompiler compiler = new KadetCompiler();
        compiler.compile("program Test1 = \n" +
                "\n" +
                "constant one : Element := 42;\n" +
                "var element1, element2 : Element := 1;\n" +
                "var element3 : Element;\n" +
                "var list : List;\n" +
                "var list2 : List := < 123, element1 >;\n" +
                "var i : Element;\n" +
                "\n" +
                "begin\n" +
                "\n" +
                "list := [ 10, 12 >;\n" +
                "\n" +
                "if element1 less 32 then\n" +
                "    element3 := element1 plus 1;\n" +
                "end if;\n" +
                "\n" +
                "for (i := 0; i less 10; i := i plus 1)\n" +
                "begin\n" +
                "    list := list + i;\n" +
                "end for;\n" +
                "\n" +
                "i := 100;\n" +
                "while i less 150 \n" +
                "begin\n" +
                "    list := list + i;\n" +
                "    i := i plus 20;\n" +
                "end while;\n" +
                "\n" +
                "list := element1 + element2 + list2;\n" +
                "element3 := list [0];\n" +
                "\n" +
                "end Test1.");
    }


    @Test
    public void mathExpressionTest () {
        try { KadetCompiler compiler = new KadetCompiler();
        compiler.compile("program Test2 = \n" +
                                 "  constant a : Element := 12;\n" +
                                 "  procedure bla () =\n" +
                                 "    begin\n" +
                                 "    end bla.\n" +
                                 "  var x, y : Element := 12;\n" +
                                 "begin\n" +
                                 "\n" +
                                 "  result := x plus y plus y minus 2 multiply 13 divide (12 plus 14);\n" +
                                 "\n" +
                                 "end Test2.");
    }


    @Test
    public void listOperations () {
        try { KadetCompiler compiler = new KadetCompiler();
        compiler.compile("program Test2 = \n" +
                                 "\n" +
                                 "  var list : List := < 1, 2, 3, 5 >;\n" +
                                 "\n" +
                                 "  var result : List;\n" +
                                 "\n" +
                                 "  var element : Element := 2;\n" +
                                 "\n" +
                                 "  var list2 : List;\n" +
                                 "\n" +
                                 "begin\n" +
                                 "\n" +
                                 "  result := list + 1 - element;\n" +
                                 "  \n" +
                                 "  list2 := < < 1, 2, 3, 5> >;\n" +
                                 "\n" +
                                 "  result := result * list2;\n" +
                                 "\n" +
                                 "  result := result / < <1, 2, 3, 5> >;\n" +
                                 "\n" +
                                 "end Test2.");
    }

    @Test
    public void functionsAndProcedures () {
        try { KadetCompiler compiler = new KadetCompiler();
        compiler.compile("program Test3 = \n" +
                                 "\n" +
                                 "  var variable : Element := 123;\n" +
                                 "\n" +
                                 "  var list : List := < 1, 2, 4 >;\n" +
                                 "\n" +
                                 "  procedure foo (x : Element) =\n" +
                                 "    constant y : Element := 12;\n" +
                                 "    var result : List;\n" +
                                 "  begin\n" +
                                 "\n" +
                                 "    x := x plus y;\n" +
                                 "    result := x + y;\n" +
                                 "\n" +
                                 "  end foo.\n" +
                                 "\n" +
                                 "  function defaultList () : List = \n" +
                                 "  begin\n" +
                                 "    variable := 12;\n" +
                                 "    return (< 1, 2, 4 >);\n" +
                                 "  end defaultList.\n" +
                                 " \n" +
                                 "begin\n" +
                                 "\n" +
                                 "  foo (987);\n" +
                                 "  list := defaultList();\n" +
                                 "\n" +
                                 "end Test3.");
    }


    
    @Test
	public void variable () {
        try { KadetCompiler compiler = new KadetCompiler();
        compiler.compile("program XLSample = " +
                                 "constant one: Element := 1;" +
                                 "constant two: Element := 2;" +
                                 "var x,   y , z : Element := 42;" +
                                 "begin end XLSample.");
    }

    @Test
	public void assignment () {
        try { KadetCompiler compiler = new KadetCompiler();
        compiler.compile("program XLSample = " +
                                 "constant one: Element := 1;" +
                                 "constant two: Element := 2;" +
                                 "var x,   y , z : Element := 42;" +
                                 "begin " +
                                 "x:=42;" +
                                 "y := 10 ;" +
                                 "end XLSample.");
    }

    @Test
	public void expression () {
        try { KadetCompiler compiler = new KadetCompiler();
        compiler.compile("program XLSample = " +
                                 "constant one: Element := 1;" +
                                 "constant two: Element := 2;" +
                                 "var x,   y , z : Element := 42;" +
                                 "begin " +
                                 "x:=42 + 6 * 7 + 10;" +
                                 "y := 10 ;" +
                                 "end XLSample.");
    }

    @Test
	public void expressionWithBrackets () {
        try { KadetCompiler compiler = new KadetCompiler();
        compiler.compile("program XLSample = " +
                                 "constant one: Element := 1;" +
                                 "constant two: Element := 2;" +
                                 "var x,   y , z : Element := 42;" +
                                 "begin " +
                                 "x:=(42 + 6) * (7 + 10) - x/y;" +
                                 "y := 10 ;" +
                                 "end XLSample.");
    }

    @Test
	public void ifStatement () {
        try { KadetCompiler compiler = new KadetCompiler();
        compiler.compile("program XLSample = " +
                                 "constant one: Element := 1;" +
                                 "constant two: Element := 2;" +
                                 "var x,   y , z : Element := 42;" +
                                 "begin " +
                                 "x:=(42 + 6) * (7 + 10) - x/y;" +
                                 "y := 10 ;" +
                                 "if x less 10 then" +
                                 "  y:=12;" +
                                 "elsif x less 20 then" +
                                 "  y:=22;" +
                                 "else" +
                                 "  y:=32;" +
                                 "end if;" +
                                 "end XLSample.");
    }

    @Test
	public void multipleIfStatement () {
        try { KadetCompiler compiler = new KadetCompiler();
        compiler.compile("program XLSample = " +
                                 "constant one: Element := 1;" +
                                 "constant two: Element := 2;" +
                                 "var x,   y , z : Element := 42;" +
                                 "begin " +
                                 "x:=(42 + 6) * (7 + 10) - x/y;" +
                                 "y := 10 ;" +
                                 "if x less 10 then" +
                                 "  y:=12;" +
                                 "  x:=22;" +
                                 "  if x equal 23 then" +
                                 "      y:=2;" +
                                 "  else" +
                                 "      y:=3;" +
                                 "  end if;" +
                                 "elsif x less 20 then" +
                                 "  y:=22;" +
                                 "else" +
                                 "  y:=32;" +
                                 "end if;" +
                                 "end XLSample.");
    }

    @Test
	public void comments () {
        try { KadetCompiler compiler = new KadetCompiler();
        compiler.compile("program XLSample = " +
                                 "//constant one: Element := 1;" +
                                 "//constant two: Element := 2;" +
                                 "//var x,   y , z : Element := 42;" +
                                 "\nbegin " +
                                 "//x:=(42 + 6) * (7 + 10) - x/y;" +
                                 "//y := 10 ;" +
                                 "//if x < 10 then" +
                                 "//  y:=12;" +
                                 "//  x:=22;" +
                                 "//  if x = 23 then" +
                                 "//      y:=2;" +
                                 "//  else" +
                                 "//      y:=3;" +
                                 "//  end if;" +
                                 "//elsif x < 20 then" +
                                 "//  y:=22;" +
                                 "//else" +
                                 "//  y:=32;" +
                                 "//end if;" +
                                 "\nend XLSample.");
    }

  /*  @Test
    public void multipleComments () {
        try { KadetCompiler compiler = new KadetCompiler();
        compiler.compile("program XLSample = " +
                                 "*//*constant one: Element := 1;" +
                                 "constant two: Element := 2;" +
                                 "var x,   y , z : Element := 42;" +
                                 "*//* begin " +
                                 "*//*x:=(42 + 6) * (7 + 10) - x/y;" +
                                 "y := 10 ;" +
                                 "if x < 10 then" +
                                 "  y:=12;" +
                                 "  x:=22;" +
                                 "  if x = 23 then" +
                                 "      y:=2;" +
                                 "  else" +
                                 "      y:=3;" +
                                 "  end if;" +
                                 "elsif x < 20 then" +
                                 "  y:=22;" +
                                 "else" +
                                 "  y:=32;" +
                                 "end if;" +
                                 "*//*end XLSample.");
    }

*/
    /*
    @Test
	public void whileStatement () {
        try { KadetCompiler compiler = new KadetCompiler();
        compiler.compile("program XLSample = " +
                                 "constant one: Element := 1;" +
                                 "constant two: Element := 2;" +
                                 "var x,   y , z : Element := 42;" +
                                 "begin " +
                                 "x:=(42 + 6) * (7 + 10) - x/y;" +
                                 "y := 10 ;" +
                                 "" +
                                 "while x not equal 42 " +
                                 "begin " +
                                 "x := x + 1;" +
                                 "end while;" +
                                 "end XLSample.");
    }


    @Test
	public void procedure () {
        try { KadetCompiler compiler = new KadetCompiler();
        compiler.compile("program XLSample = " +
                                 "constant one: Element := 1;" +
                                 "constant two: Element := 2;" +
                                 "var x,   y , z : Element := 42;" +
                                 "" +
                                 "procedure foo () = " +
                                 "  var x : Element := 2;" +
                                 "begin " +
                                 "end foo." +
                                 "" +
                                 "" +
                                 "procedure fee (y: Element) = " +
                                 "  var x : Element := 2;" +
                                 "begin " +
                                 "end fee." +
                                 "" +
                                 "" +
                                 "function fie (y: Element) : Element = " +
                                 "  var x : Element := 2;" +
                                 "begin " +
                                 "  return x;" +
                                 "end fie." +
                                 "" +
                                 "" +
                                 "begin " +
                                 "" +
                                 "foo();" +
                                 "fee(123);" +
                                 "x := fie(123);" +
                                 "" +
                                 " end XLSample.");
    }
*/

//
// Worked:
//

    @Test
    public void simpleEvaluator() {
        try {
            KadetCompiler compiler = new KadetCompiler();
            Evaluator evaluator = compiler.compile(
                    "program HelloWorld = \n" +
                            "begin\n" +
                            "end HelloWorld."
            );
            evaluator.evaluate();
        } catch (KadetException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void specificTypes() {
        try {
            KadetCompiler compiler = new KadetCompiler();
            Evaluator evaluator = compiler.compile("program XLSample = " +
                    "" +
                    "constant one: Integer := 1;" +
                    "constant two: Integer := 2;" +
                    "var x,   y , z : Integer;" +
                    "var t : Boolean;" +
                    "begin " +
                    "x:= 42 plus 6 multiply 7 plus 10 divide 2;" +
                    "y := 10 ;" +
                    "end XLSample.");
            evaluator.evaluate();
        } catch (KadetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void listEvaluation() {
        try {
            KadetCompiler compiler = new KadetCompiler();
            Evaluator evaluator = compiler.compile("program XLSample = " +
                    "\nconstant one: Integer := 1;" +
                    "\nvar list : List;" +
                    "\nvar t : Boolean;" +
                    "\nbegin " +
                    "\nlist := <1, 2, 3, 4 plus 5>;" +
                    "\nend XLSample.");
            evaluator.evaluate();
        } catch (KadetException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void listPlusOperation() {
        try {
            KadetCompiler compiler = new KadetCompiler();
            Evaluator evaluator = compiler.compile("program XLSample = " +
                    "\nconstant one: Integer := 1;" +
                    "\nvar list1 : List;" +
                    "\nvar list2 : List;" +
                    "\nvar x : Boolean;" +
                    "\nvar y : Integer;" +
                    "\nbegin " +
                    "\nlist1 := <1, 2, 3, 4 plus 5>;" +
                    "\nlist2 := <5, 6, 7, 9 minus 4>;" +
                    "\nlist1 := 2 + 1;" +
                    "\nlist1 := <1, 2> + 1;" +
                    "\nlist1 := 2 + <1, 2>;" +
                    "\nlist1 := <1, 2> + <1, 2, 4>;" +
                    "\nend XLSample.");
            evaluator.evaluate();
        } catch (KadetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void removeElementFromListOperation() {
        try {
            KadetCompiler compiler = new KadetCompiler();
            Evaluator evaluator = compiler.compile("program XLSample = " +
                    "\nconstant one: Integer := 1;" +
                    "\nvar list1 : List;" +
                    "\nvar list2 : List;" +
                    "\nvar x : Boolean;" +
                    "\nvar y : Integer;" +
                    "\nbegin " +
                    "\nlist1 := <1, 2, 3, 4 plus 5>;" +
                    "\nlist2 := <5, 6, 7, 9 minus 4>;" +
                    "\nlist1 := <1, 1, 1, 2> - 1;" +
                    "\nlist1 := <1, <1, 2>> - <1, 2>;" +
                    "\nend XLSample.");
            evaluator.evaluate();
        } catch (KadetException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void overListOperation() {
        try {
            KadetCompiler compiler = new KadetCompiler();
            Evaluator evaluator = compiler.compile("program XLSample = " +
                    "\nconstant one: Integer := 1;" +
                    "\nvar list1 : List;" +
                    "\nvar list2 : List;" +
                    "\nvar x : Boolean;" +
                    "\nvar y : Integer;" +
                    "\nbegin " +
                    "\nlist1 := <1, 2, 3, 4 plus 5>;" +
                    "\nlist2 := <5, 6, 7, 9 minus 4>;" +
                    "\nlist1 := 2 * 1;" +
                    "\nlist1 := <1, 2> * 1;" +
                    "\nlist1 := 2 * <1, 2>;" +
                    "\nlist1 := <1, 2> * <1, 2, 4> - <1, 2>;" +
                    "\nend XLSample.");
            evaluator.evaluate();
        } catch (KadetException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void removeAllElementEntriesFromListOperation() {
        try {
            KadetCompiler compiler = new KadetCompiler();
            Evaluator evaluator = compiler.compile("program XLSample = " +
                    "\nconstant one: Integer := 1;" +
                    "\nvar list1 : List;" +
                    "\nvar list2 : List;" +
                    "\nvar x : Boolean;" +
                    "\nvar y : Integer;" +
                    "\nbegin " +
                    "\nlist1 := <1, 2, 3, 4 plus 5, 1, 1> / 1;" +
                    "\nlist2 := <5, 6, 7, 9, <1, 2>, <1, 2>, @true> / <1, 2>;" +
                    "\nend XLSample.");
            evaluator.evaluate();
        } catch (KadetException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void procedureInit() {
        try {
            KadetCompiler compiler = new KadetCompiler();
            Evaluator evaluator = compiler.compile("program XLSample = " +
                    "\n constant one: Integer := 1;" +
                    "\n procedure foo (x : Element) =" +
                    "\n   constant y : Element := 12;" +
                    "\n   var result : List;" +
                    "\n begin" +
                    "\n   x := 1 plus 2;" +
                    "\n   result := 3 + 4;" +
                    "\n end foo." +
                    "\n begin " +
                    "\n end XLSample.");
            evaluator.evaluate();
        } catch (KadetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void procedureWithoutParametersInit() {
        try {
            KadetCompiler compiler = new KadetCompiler();
            Evaluator evaluator = compiler.compile("program XLSample = " +
                    "\n constant one: Integer := 1;" +
                    "\n procedure foo () =" +
                    "\n   constant y : Element := 12;" +
                    "\n   var result : List;" +
                    "\n begin" +
                    "\n end foo." +
                    "\n begin " +
                    "\n end XLSample.");
            evaluator.evaluate();
        } catch (KadetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void functionInit() {
        try {
            KadetCompiler compiler = new KadetCompiler();
            Evaluator evaluator = compiler.compile("program XLSample = " +
                    "\n constant one: Integer := 1;" +
                    "\n function fee () =" +
                    "\n   constant y : Element := 12;" +
                    "\n   var result : List;" +
                    "\n begin" +
                    "\n   return 12;" +
                    "\n end fee." +
                    "\n begin " +
                    "\n end XLSample.");
            evaluator.evaluate();
        } catch (KadetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ifTrueTest() {
        try {
            KadetCompiler compiler = new KadetCompiler();
            Evaluator evaluator = compiler.compile("program XLSample = " +
                    "\n constant one : Integer := 1;" +
                    "\n var x : Integer;" +
                    "\n begin " +
                    "\n   if 3 less 5 then" +
                    "\n      x := 1 plus 4;" +
                    "\n   end if;" +
                    "\n end XLSample.");
            evaluator.evaluate();
        } catch (KadetException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void ifFalseTest() {
        try {
            KadetCompiler compiler = new KadetCompiler();
            Evaluator evaluator = compiler.compile("program XLSample = " +
                    "\n constant one : Integer := 1;" +
                    "\n var x : Integer;" +
                    "\n begin " +
                    "\n   if (3 greater 5) then" +
                    "\n      x := 1 plus 4;" +
                    "\n   end if;" +
                    "\n end XLSample.");
            evaluator.evaluate();
        } catch (KadetException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void ifElseIfTest() {
        try {
            KadetCompiler compiler = new KadetCompiler();
            Evaluator evaluator = compiler.compile("program XLSample = " +
                    "\n constant one : Integer := 1;" +
                    "\n var x : Integer;" +
                    "\n begin " +
                    "\n   if (3 greater 5) then" +
                    "\n      x := 1 plus 4;" +
                    "\n   elsif @false then" +
                    "\n      x := 2 plus 4;" +
                    "\n   elsif @true then" +
                    "\n      x := 3 plus 4;" +
                    "\n   end if;" +
                    "\n end XLSample.");
            evaluator.evaluate();
        } catch (KadetException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void ifElseTest() {
        try {
            KadetCompiler compiler = new KadetCompiler();
            Evaluator evaluator = compiler.compile("program XLSample = " +
                    "\n constant one : Integer := 1;" +
                    "\n var x : Integer;" +
                    "\n begin " +
                    "\n   if 6 greaterOrEqual 7 then" +
                    "\n      x := 1 plus 4;" +
                    "\n   else then" +
                    "\n      x := 5 plus 4;" +
                    "\n   end if;" +
                    "\n end XLSample.");
            evaluator.evaluate();
        } catch (KadetException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void getVariableValue() {
        try {
            KadetCompiler compiler = new KadetCompiler();
            Evaluator evaluator = compiler.compile("program XLSample = " +
                    "\n constant one : Integer := 1;" +
                    "\n var x : Integer;" +
                    "\n begin " +
                    "\n   x := 2 plus 3;" +
                    "\n   x := 4 plus x;" +
                    "\n end XLSample.");
            evaluator.evaluate();
        } catch (KadetException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void getVariableWithMistake() {
        try {
            KadetCompiler compiler = new KadetCompiler();
            Evaluator evaluator = compiler.compile("program XLSample = " +
                    "\n constant one : Integer := 1;" +
                    "\n var x : Integer;" +
                    "\n var x : Integer;" +
                    "\n begin " +
                    "\n   x := 2 plus 3;" +
                    "\n   x := 4 + x;" +
                    "\n end XLSample.");
            evaluator.evaluate();
        } catch (KadetException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void whileTest() {
        try {
            KadetCompiler compiler = new KadetCompiler();
            Evaluator evaluator = compiler.compile("program XLSample = " +
                    "\n constant one : Integer := 1;" +
                    "\n var x : Integer;" +
                    "\n begin " +
                    "\n   x := 2;" +
                    "\n   while x less 4" +
                    "\n   begin" +
                    "\n     x := x plus 1;" +
                    "\n   end while;" +
                    "\n end XLSample.");
            evaluator.evaluate();
        } catch (KadetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void forTest() {
        try {
            KadetCompiler compiler = new KadetCompiler();
            Evaluator evaluator = compiler.compile("program XLSample = " +
                    "\n constant one : Integer := 1;" +
                    "\n var i : Integer;" +
                    "\n var x : Integer;" +
                    "\n begin " +
                    "\n   for ( i := 4; i less 10; i := i plus 1 ) " +
                    "\n   begin" +
                    "\n     x := x + 1;" +
                    "\n   end for;" +
                    "\n end XLSample.");
            evaluator.evaluate();
        } catch (KadetException e) {
            e.printStackTrace();
        }
    }

    /*@Test(timeout = 5000)
    public void whileStackOverFlowTest () {
        try { KadetCompiler compiler = new KadetCompiler();
        Evaluator evaluator = compiler.compile("program XLSample = " +
                "\n constant one : Integer := 1;" +
                "\n var x : Integer;" +
                "\n begin " +
                "\n   x := 2;" +
                "\n   while @true" +
                "\n   begin" +
                "\n     x := x plus 1;" +
                "\n   end while;" +
                "\n end XLSample.");
        evaluator.evaluate(); } catch(KadetException e) {e.printStackTrace();}
    }*/


    @Test
    public void procedureInProcedureCall() {
        try {
            KadetCompiler compiler = new KadetCompiler();
            Evaluator evaluator = compiler.compile("program XLSample = " +
                    "\n constant one: Integer := 1;" +
                    "\n procedure foo () =" +
                    "\n   var x : Integer;" +
                    "\n   var y : Integer;" +
                    "\n   var result : List;" +
                    "\n" +
                    "\n   procedure foofoo () = " +
                    "\n   begin" +
                    "\n     x := 12;" +
                    "\n   end foofoo." +
                    "\n" +
                    "\n begin" +
                    "\n   y := 1 plus y;" +
                    "\n   result := y + 4;" +
                    "\n   foofoo();" +
                    "\n   x := x + 1;" +
                    "\n end foo." +
                    "\n begin " +
                    "\n   foo();" +
                    "\n end XLSample.");
            evaluator.evaluate();
        } catch (KadetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void procedureWithParametersCall() {
        try {
            KadetCompiler compiler = new KadetCompiler();
            Evaluator evaluator = compiler.compile("program XLSample = " +
                    "\n constant one: Integer := 1;" +
                    "\n var b : Boolean;" +
                    "\n procedure foo (z : Integer, b : Boolean) =" +
                    "\n   var x : Integer;" +
                    "\n   var y : Integer;" +
                    "\n   var result : List;" +
                    "\n begin" +
                    "\n   z := z + b;" +
                    "\n end foo." +
                    "\n begin " +
                    "\n   b := @true; " +
                    "\n   foo(12, b);" +
                    "\n end XLSample.");
            evaluator.evaluate();
        } catch (KadetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void castTest() {
        try {
            KadetCompiler compiler = new KadetCompiler();
            Evaluator evaluator = compiler.compile("program XLSample = " +
                    "\n constant one: Integer := 1;" +
                    "\n var b : Element;" +
                    "\n var x : Integer;" +
                    "\n begin " +
                    "\n   b := @true; " +
                    "\n   x := 1;" +
                    "\n   x := b;" +
                    "\n   x := x or b;" +
                    "\n   x := x + b;" +
                    "\n end XLSample.");
            evaluator.evaluate();
        } catch (KadetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void simpleFunctionTest() {
        try {
            KadetCompiler compiler = new KadetCompiler();
            Evaluator evaluator = compiler.compile("program XLSample = " +
                    "\n constant one: Integer := 1;" +
                    "\n var b : Element;" +
                    "\n" +
                    "\n function fee () =" +
                    "\n   constant y : Element := 12;" +
                    "\n   var result : List;" +
                    "\n begin" +
                    "\n   return 12 + 1;" +
                    "\n end fee." +
                    "\n" +
                    "\n var x : Integer;" +
                    "\n begin " +
                    "\n   b := f: fee();" +
                    "\n end XLSample.");
            evaluator.evaluate();
        } catch (KadetException e) {
            e.printStackTrace();
        }

    }

    @Test(expected = KadetException.class)
    public void wrongParametersType() throws KadetException {
        KadetCompiler compiler = new KadetCompiler();
        Evaluator evaluator = compiler.compile("program XLSample = " +
                "\n constant one: Integer := 1;" +
                "\n var b : Element;" +
                "\n" +
                "\n function fee (x : Integer) =" +
                "\n   constant y : Element := 12;" +
                "\n   var result : List;" +
                "\n begin" +
                "\n   return 12 + 1;" +
                "\n end fee." +
                "\n" +
                "\n var x : Integer;" +
                "\n begin " +
                "\n   b := f: fee(@true);" +
                "\n end XLSample.");
        evaluator.evaluate();
    }


}
