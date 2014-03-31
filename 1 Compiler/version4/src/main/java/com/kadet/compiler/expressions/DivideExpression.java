package com.kadet.compiler.expressions;

import com.kadet.compiler.entities.Int;
import com.kadet.compiler.entities.Value;
import com.kadet.compiler.util.KadetException;
import com.kadet.compiler.util.ValueUtils;

/**
 * Date: 30.03.14
 * Time: 19:08
 *
 * @author Кадет
 */
public class DivideExpression extends BinaryExpression {

    public DivideExpression (Expression expression1, Expression expression2) {
        super(expression1, expression2);
    }

    @Override
    public Value calculate () throws KadetException {
        Value value1 = expression1.calculate();
        Value value2 = expression2.calculate();
        if (ValueUtils.isInteger(value1) && ValueUtils.isInteger(value2)) {
            return integerDivideInteger(value1, value2);
        }
        throw new KadetException("PLUS Operation Error!");
    }

    private Value integerDivideInteger (Value value1, Value value2) {
        Integer integer1 = ValueUtils.getIntegerFromValue(value1);
        Integer integer2 = ValueUtils.getIntegerFromValue(value2);
        return new Int(integer1 / integer2);
    }
}
