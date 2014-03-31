package com.kadet.compiler.expressions;

/**
 * Date: 30.03.14
 * Time: 17:43
 *
 * @author Кадет
 */
public abstract class BinaryExpression implements Expression {

    protected Expression expression1;
    protected Expression expression2;

    public BinaryExpression (Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }
}
