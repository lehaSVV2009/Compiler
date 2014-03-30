package com.kadet.compiler;

import org.junit.Test;

public class SampleTest {

/*    @Test
	public void correctProgram () {
        SampleCompiler compiler = new SampleCompiler();
        compiler.compile("program XLSample = begin end XLSample.");
    }


    @Test
	public void constant () {
        SampleCompiler compiler = new SampleCompiler();
        compiler.compile("program XLSample = " +
                                 "constant one: Integer := 1;" +
                                 "constant two: Integer := 2;" +
                                 "begin end XLSample.");
    }

    @Test
	public void variable () {
        SampleCompiler compiler = new SampleCompiler();
        compiler.compile("program XLSample = " +
                                 "constant one: Integer := 1;" +
                                 "constant two: Integer := 2;" +
                                 "var x,   y , z : Integer := 42;" +
                                 "begin end XLSample.");
    }

    @Test
	public void assignment () {
        SampleCompiler compiler = new SampleCompiler();
        compiler.compile("program XLSample = " +
                                 "constant one: Integer := 1;" +
                                 "constant two: Integer := 2;" +
                                 "var x,   y , z : Integer := 42;" +
                                 "begin " +
                                 "x:=42;" +
                                 "y := 10 ;" +
                                 "end XLSample.");
    }

    @Test
	public void expression () {
        SampleCompiler compiler = new SampleCompiler();
        compiler.compile("program XLSample = " +
                                 "constant one: Integer := 1;" +
                                 "constant two: Integer := 2;" +
                                 "var x,   y , z : Integer := 42;" +
                                 "begin " +
                                 "x:=42 + 6 * 7 + 10;" +
                                 "y := 10 ;" +
                                 "end XLSample.");
    }

    @Test
	public void expressionWithBrackets () {
        SampleCompiler compiler = new SampleCompiler();
        compiler.compile("program XLSample = " +
                                 "constant one: Integer := 1;" +
                                 "constant two: Integer := 2;" +
                                 "var x,   y , z : Integer := 42;" +
                                 "begin " +
                                 "x:=(42 + 6) * (7 + 10) - x/y;" +
                                 "y := 10 ;" +
                                 "end XLSample.");
    }

    @Test
	public void ifStatement () {
        SampleCompiler compiler = new SampleCompiler();
        compiler.compile("program XLSample = " +
                                 "constant one: Integer := 1;" +
                                 "constant two: Integer := 2;" +
                                 "var x,   y , z : Integer := 42;" +
                                 "begin " +
                                 "x:=(42 + 6) * (7 + 10) - x/y;" +
                                 "y := 10 ;" +
                                 "if x < 10 then" +
                                 "  y:=12;" +
                                 "elsif x < 20 then" +
                                 "  y:=22;" +
                                 "else" +
                                 "  y:=32;" +
                                 "end if;" +
                                 "end XLSample.");
    }

    @Test
	public void multipleIfStatement () {
        SampleCompiler compiler = new SampleCompiler();
        compiler.compile("program XLSample = " +
                                 "constant one: Integer := 1;" +
                                 "constant two: Integer := 2;" +
                                 "var x,   y , z : Integer := 42;" +
                                 "begin " +
                                 "x:=(42 + 6) * (7 + 10) - x/y;" +
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
                                 "end XLSample.");
    }

    @Test
	public void comments () {
        SampleCompiler compiler = new SampleCompiler();
        compiler.compile("program XLSample = " +
                                 "//constant one: Integer := 1;" +
                                 "//constant two: Integer := 2;" +
                                 "//var x,   y , z : Integer := 42;" +
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
*/
  /*  @Test
    public void multipleComments () {
        SampleCompiler compiler = new SampleCompiler();
        compiler.compile("program XLSample = " +
                                 "*//*constant one: Integer := 1;" +
                                 "constant two: Integer := 2;" +
                                 "var x,   y , z : Integer := 42;" +
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

*//*
    @Test
	public void whileStatement () {
        SampleCompiler compiler = new SampleCompiler();
        compiler.compile("program XLSample = " +
                                 "constant one: Integer := 1;" +
                                 "constant two: Integer := 2;" +
                                 "var x,   y , z : Integer := 42;" +
                                 "begin " +
                                 "x:=(42 + 6) * (7 + 10) - x/y;" +
                                 "y := 10 ;" +
                                 "" +
                                 "while x!=42 " +
                                 "loop " +
                                 "x := x + 1;" +
                                 "end loop;" +
                                 "end XLSample.");
    }


    @Test
	public void procedure () {
        SampleCompiler compiler = new SampleCompiler();
        compiler.compile("program XLSample = " +
                                 "constant one: Integer := 1;" +
                                 "constant two: Integer := 2;" +
                                 "var x,   y , z : Integer := 42;" +
                                 "" +
                                 "procedure foo () = " +
                                 "  var x : Integer := 2;" +
                                 "begin " +
                                 "end foo." +
                                 "" +
                                 "" +
                                 "procedure fee (y: Integer) = " +
                                 "  var x : Integer := 2;" +
                                 "begin " +
                                 "end fee." +
                                 "" +
                                 "" +
                                 "function fie (y: Integer) : Integer = " +
                                 "  var x : Integer := 2;" +
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


    @Test
    public void specificTypes () {
        SampleCompiler compiler = new SampleCompiler();
        compiler.compile("program XLSample = " +
                                 "" +
                                 "type CardSuit = <CLUB, DIAMOND, HEART, SPADE>;" +
                                 "type Table = array [1..10] of Integer;" +
                                 "type TableTwo = array [1..10] of array[1..100] of String;" +
                                 "type TableThree = array [1..10] of " +
                                 "                                      record" +
                                 "                                          x: Integer;" +
                                 "                                          y: Integer;" +
                                 "                                      end record;" +
                                 "type Date = " +
                                 "  record " +
                                 "      day : Integer;" +
                                 "      month : Integer;" +
                                 "      weekend : Boolean;" +
                                 "  end record;" +
                                 "var x: Date;" +
                                 "constant one: Integer := 1;" +
                                 "constant two: Integer := 2;" +
                                 "var x,   y , z : Integer := 42;" +
                                 "begin " +
                                 "x:=42 + 6 * 7 + 10;" +
                                 "y := 10 ;" +
                                 "end XLSample.");
    }

@Test
    public void stringAndChar () {
        SampleCompiler compiler = new SampleCompiler();
        compiler.compile("program XLSample = " +
                                 "" +
                                 "var c : Char := 'a';" +
                                 "" +
                                 "var x : String := \"hello\";" +
                                 "var y : String := \"say \\\"hello \\\"to your folks\";" +
                                 "" +
                                 "constant one: Integer := 1;" +
                                 "constant two: Integer := 2;" +
                                 "var x,   y , z : Integer := 42;" +
                                 "begin " +
                                 "x:=42 + 6 * 7 + 10;" +
                                 "y := 10 ;" +
                                 "end XLSample.");
    }
*/


}
