package com.kadet.compiler.evaluators;

/**
 * Date: 11.03.14
 * Time: 2:26
 *
 * @author Кадет
 */
public class NegationEvaluator implements Evaluator {

    private Evaluator op1;

    public NegationEvaluator (Evaluator op1) {
        this.op1 = op1;
    }

    @Override
    public int evaluate () {
        return -op1.evaluate();
    }
}
