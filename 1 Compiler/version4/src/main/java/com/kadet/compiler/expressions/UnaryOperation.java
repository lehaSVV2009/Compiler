package com.kadet.compiler.expressions;

import com.kadet.compiler.evaluators.Evaluator;

/**
 * Date: 30.03.14
 * Time: 17:44
 *
 * @author Кадет
 */
public abstract class UnaryOperation implements Evaluator {

    protected Expression expression;

    public UnaryOperation (Expression expression) {
        this.expression = expression;
    }
}
