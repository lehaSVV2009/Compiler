package com.kadet.compiler.expressions;

import com.kadet.compiler.entities.List;
import com.kadet.compiler.entities.Value;
import com.kadet.compiler.util.KadetException;

import java.util.ArrayList;

/**
 * Date: 30.03.14
 * Time: 19:10
 *
 * @author Кадет
 */
public class OverListExpression extends BinaryExpression {

    public OverListExpression (Expression expression1, Expression expression2) {
        super(expression1, expression2);
    }

    @Override
    public Value calculate () throws KadetException {
        Value value1 = expression1.calculate();
        Value value2 = expression2.calculate();
        return createOverList(value1, value2);
    }

    private List createOverList (Value value1, Value value2) {
        java.util.List<Value> values = new ArrayList<Value>();
        values.add(value1);
        values.add(value2);
        return new List(values);
    }

}
