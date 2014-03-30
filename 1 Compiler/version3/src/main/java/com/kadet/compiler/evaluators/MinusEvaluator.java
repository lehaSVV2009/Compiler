package com.kadet.compiler.evaluators;

/**
 * Date: 11.03.14
 * Time: 2:26
 *
 * @author Кадет
 */
public class MinusEvaluator implements Evaluator {

    private Evaluator op1;
    private Evaluator op2;

    public MinusEvaluator (Evaluator op1, Evaluator op2) {
        this.op1 = op1;
        this.op2 = op2;
    }

    @Override
    public int evaluate () {
        return op1.evaluate() - op2.evaluate();  //To change body of implemented methods use File | Settings | File Templates.
    }
}
