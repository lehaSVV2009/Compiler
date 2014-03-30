package com.kadet.compiler.expressions;

/**
 * Date: 30.03.14
 * Time: 17:43
 *
 * @author Кадет
 */
public abstract class BinaryExpression implements Expression {

    protected Expression evaluator1;
    protected Expression evaluator2;

    public BinaryExpression (Expression evaluator1, Expression evaluator2) {
        this.evaluator1 = evaluator1;
        this.evaluator2 = evaluator2;
    }
}
