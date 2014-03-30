package com.kadet.compiler.expressions;

import com.kadet.compiler.entities.Value;

/**
 * Date: 30.03.14
 * Time: 18:01
 *
 * @author Кадет
 */
public class ValueExpression implements Expression {

    private Value value;

    public ValueExpression (Value value) {
        this.value = value;
    }

    @Override
    public Value calculate () {
        return value;
    }
}
