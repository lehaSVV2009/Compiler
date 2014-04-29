package com.kadet.compiler.expressions;

import com.kadet.compiler.entities.Bool;
import com.kadet.compiler.entities.Value;
import com.kadet.compiler.util.KadetException;
import com.kadet.compiler.util.ValueUtils;

/**
 * Date: 30.03.14
 * Time: 18:38
 *
 * @author Кадет
 */
public class LessOrEqualExpression extends BinaryExpression {

    public LessOrEqualExpression (Expression expression1, Expression expression2) {
        super(expression1, expression2);
    }

    @Override
    public Value calculate () throws KadetException {
        Value value1 = expression1.calculate();
        Value value2 = expression2.calculate();
        if (!ValueUtils.isInteger(value1) || !ValueUtils.isInteger(value2)) {
            throw new KadetException("Not Integer Values in Less Expression!");
        }
        return (ValueUtils.getIntegerFromValue(value1) <= ValueUtils.getIntegerFromValue(value2)) ? new Bool(true) : new Bool(false);
    }
}
