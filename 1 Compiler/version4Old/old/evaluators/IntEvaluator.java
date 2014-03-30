package com.kadet.compiler.evaluators;

/**
 * Date: 11.03.14
 * Time: 2:25
 *
 * @author Кадет
 */
public class IntEvaluator implements Evaluator {

    private int value;

    public IntEvaluator (int value) {
        this.value = value;
    }

    @Override
    public int evaluate () {
        return value;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
