package com.kadet.compiler.evaluators;

import com.kadet.compiler.Program;
import com.kadet.compiler.Variable;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 30.03.14
 * Time: 13:20
 *
 * @author Кадет
 */
public class ProcedureEvaluator implements Evaluator {

    private String name;
    private Program program = Program.getInstance();
    private List<Variable> parameters = new ArrayList<Variable>();
    private List<StatementEvaluator> statementEvaluators = new ArrayList<StatementEvaluator>();


    public ProcedureEvaluator (String name, List<Variable> parameters) {
        this.name = name;
        this.parameters = parameters;
    }

    public ProcedureEvaluator (String name) {
        this.name = name;
    }

    @Override
    public void evaluate () {
        System.out.println("Main Procedure Starts!");
        for (StatementEvaluator statementEvaluator : statementEvaluators) {
            statementEvaluator.evaluate();
        }
    }

    public void addStatementEvaluator (StatementEvaluator statementEvaluator) {
        statementEvaluators.add(statementEvaluator);
    }

}
