package com.kadet.compiler.expressions;

import com.kadet.compiler.entities.Bool;
import com.kadet.compiler.entities.Value;
import com.kadet.compiler.util.KadetException;

/**
 * Date: 30.03.14
 * Time: 18:35
 *
 * @author Кадет
 */
public class EqualExpression extends BinaryExpression {

    public EqualExpression (Expression expression1, Expression expression2) {
        super(expression1, expression2);
    }

    @Override
    public Value calculate () throws KadetException {
        Value value1 = expression1.calculate();
        Value value2 = expression2.calculate();
        return (value1.equals(value2)) ? new Bool(true) : new Bool(false);
    }
}
