package com.kadet.compiler;

import com.kadet.compiler.evaluators.Evaluator;
import org.junit.Test;

public class KadetTest {

    @Test
    public void Void () {

    }

/*
    @Test
	public void correctProgram () {
        KadetCompiler compiler = new KadetCompiler();
        compiler.compile("\nprogram Test1 = " +
                                 "\nbegin " +
                                 "\nend Test1.");
    }



/*
    @Test
	public void constant () {
        KadetCompiler compiler = new KadetCompiler();
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
        KadetCompiler compiler = new KadetCompiler();
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
        KadetCompiler compiler = new KadetCompiler();
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
        KadetCompiler compiler = new KadetCompiler();
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
        KadetCompiler compiler = new KadetCompiler();
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
        KadetCompiler compiler = new KadetCompiler();
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
        KadetCompiler compiler = new KadetCompiler();
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
        KadetCompiler compiler = new KadetCompiler();
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
        KadetCompiler compiler = new KadetCompiler();
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
        KadetCompiler compiler = new KadetCompiler();
        compiler.compile("program XLSample = " +
                                 "constant one: Element := 1;" +
                                 "constant two: Element := 2;" +
                                 "var x,   y , z : Element := 42;" +
                                 "begin end XLSample.");
    }

    @Test
	public void assignment () {
        KadetCompiler compiler = new KadetCompiler();
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
        KadetCompiler compiler = new KadetCompiler();
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
        KadetCompiler compiler = new KadetCompiler();
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
        KadetCompiler compiler = new KadetCompiler();
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
        KadetCompiler compiler = new KadetCompiler();
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
        KadetCompiler compiler = new KadetCompiler();
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
        KadetCompiler compiler = new KadetCompiler();
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
        KadetCompiler compiler = new KadetCompiler();
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
        KadetCompiler compiler = new KadetCompiler();
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
    public void simpleEvaluator () {
        KadetCompiler compiler = new KadetCompiler();
        Evaluator evaluator = compiler.compile(
                "program HelloWorld = \n" +
                        "begin\n" +
                        "end HelloWorld."
        );
        evaluator.evaluate();
    }



    @Test
    public void specificTypes () {
        KadetCompiler compiler = new KadetCompiler();
        Evaluator evaluator = compiler.compile("program XLSample = " +
                                 "" +
                                 "constant one: Integer := 1;" +
                                 "constant two: Integer := 2;" +
                                 "var x,   y , z : Integer := 42;" +
                                 "var t : Boolean := @true;" +
                                 "begin " +
                                 "x:= 42 plus 6 multiply 7 plus 10 divide 2;" +
                                 "y := 10 ;" +
                                 "end XLSample.");
        evaluator.evaluate();
    }

    @Test
    public void listEvaluation () {
        KadetCompiler compiler = new KadetCompiler();
        Evaluator evaluator = compiler.compile("program XLSample = " +
                                 "\nconstant one: Integer := 1;" +
                                 "\nvar list : List;" +
                                 "\nvar t : Boolean := @true;" +
                                 "\nbegin " +
                                 "\nlist := <1, 2, 3, 4 plus 5>;" +
                                 "\nend XLSample.");
        evaluator.evaluate();
    }


    @Test
    public void listPlusOperation () {
        KadetCompiler compiler = new KadetCompiler();
        Evaluator evaluator = compiler.compile("program XLSample = " +
                                 "\nconstant one: Integer := 1;" +
                                 "\nvar list1 : List;" +
                                 "\nvar list2 : List;" +
                                 "\nvar x : Boolean := @true;" +
                                 "\nvar y : Integer := 12;" +
                                 "\nbegin " +
                                 "\nlist1 := <1, 2, 3, 4 plus 5>;" +
                                 "\nlist2 := <5, 6, 7, 9 minus 4>;" +
                                 "\nlist1 := 2 + 1;" +
                                 "\nlist1 := <1, 2> + 1;" +
                                 "\nlist1 := 2 + <1, 2>;" +
                                 "\nlist1 := <1, 2> + <1, 2, 4>;" +
                                 "\nend XLSample.");
        evaluator.evaluate();
    }

    @Test
    public void removeElementFromListOperation () {
        KadetCompiler compiler = new KadetCompiler();
        Evaluator evaluator = compiler.compile("program XLSample = " +
                                 "\nconstant one: Integer := 1;" +
                                 "\nvar list1 : List;" +
                                 "\nvar list2 : List;" +
                                 "\nvar x : Boolean := @true;" +
                                 "\nvar y : Integer := 12;" +
                                 "\nbegin " +
                                 "\nlist1 := <1, 2, 3, 4 plus 5>;" +
                                 "\nlist2 := <5, 6, 7, 9 minus 4>;" +
                                 "\nlist1 := <1, 1, 1, 2> - 1;" +
                                 "\nlist1 := <1, <1, 2>> - <1, 2>;" +
                                 "\nend XLSample.");
        evaluator.evaluate();
    }


    @Test
    public void overListOperation () {
        KadetCompiler compiler = new KadetCompiler();
        Evaluator evaluator = compiler.compile("program XLSample = " +
                                                       "\nconstant one: Integer := 1;" +
                                                       "\nvar list1 : List;" +
                                                       "\nvar list2 : List;" +
                                                       "\nvar x : Boolean := @true;" +
                                                       "\nvar y : Integer := 12;" +
                                                       "\nbegin " +
                                                       "\nlist1 := <1, 2, 3, 4 plus 5>;" +
                                                       "\nlist2 := <5, 6, 7, 9 minus 4>;" +
                                                       "\nlist1 := 2 * 1;" +
                                                       "\nlist1 := <1, 2> * 1;" +
                                                       "\nlist1 := 2 * <1, 2>;" +
                                                       "\nlist1 := <1, 2> * <1, 2, 4> - <1, 2>;" +
                                                       "\nend XLSample.");
        evaluator.evaluate();
    }


    @Test
    public void removeAllElementEntriesFromListOperation () {
        KadetCompiler compiler = new KadetCompiler();
        Evaluator evaluator = compiler.compile("program XLSample = " +
                                                       "\nconstant one: Integer := 1;" +
                                                       "\nvar list1 : List;" +
                                                       "\nvar list2 : List;" +
                                                       "\nvar x : Boolean := @true;" +
                                                       "\nvar y : Integer := 12;" +
                                                       "\nbegin " +
                                                       "\nlist1 := <1, 2, 3, 4 plus 5, 1, 1> / 1;" +
                                                       "\nlist2 := <5, 6, 7, 9, <1, 2>, <1, 2>, @true> / <1, 2>;" +
                                                       "\nend XLSample.");
        evaluator.evaluate();
    }


    @Test
    public void procedureInit () {
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
    }

    @Test
    public void procedureWithoutParametersInit () {
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
    }

    @Test
    public void functionInit () {
        KadetCompiler compiler = new KadetCompiler();
        Evaluator evaluator = compiler.compile("program XLSample = " +
                                                       "\n constant one: Integer := 1;" +
                                                       "\n function fee () : Integer =" +
                                                       "\n   constant y : Element := 12;" +
                                                       "\n   var result : List;" +
                                                       "\n begin" +
                                                       "\n   return 12;" +
                                                       "\n end foo." +
                                                       "\n begin " +
                                                       "\n end XLSample.");
        evaluator.evaluate();
    }

    @Test
    public void ifTrueTest () {
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

    }

    @Test
    public void ifFalseTest () {
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

    }



    @Test
    public void ifElseIfTest () {
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

    }



    @Test
    public void ifElseTest () {
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

    }







}
