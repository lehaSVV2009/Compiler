package com.kadet.compiler.expressions;

import com.kadet.compiler.entities.Bool;
import com.kadet.compiler.entities.Value;
import com.kadet.compiler.util.KadetException;
import com.kadet.compiler.util.ValueUtils;

/**
 * Date: 30.03.14
 * Time: 17:33
 *
 * @author Кадет
 */
public class OrExpression extends BinaryExpression {

    public OrExpression (Expression expression1, Expression expression2) {
        super(expression1, expression2);
    }
    @Override
    public Value calculate () throws KadetException {
        Value value1 = expression1.calculate();
        Value value2 = expression2.calculate();
        if (ValueUtils.isBoolean(value1) && ValueUtils.isBoolean(value2)) {
            if (orBetweenBooleanValues(value1, value2)) {
                return new Bool(true);
            }
        }
        throw new KadetException("Or Operation  Error!");
    }


    private boolean orBetweenBooleanValues(Value value1, Value value2) {
        return ValueUtils.getBooleanFromValue(value1) || ValueUtils.getBooleanFromValue(value2);
    }

}
