package com.kadet.compiler.expressions;

import com.kadet.compiler.entities.Value;
import com.kadet.compiler.util.KadetException;
import com.kadet.compiler.util.ValueUtils;

/**
 * Date: 31.03.14
 * Time: 11:53
 *
 * @author Кадет
 */
public class ElementFromListExpression extends ConstantOrVariableValueExpression {

    private Expression expression;

    public ElementFromListExpression(String varName, Expression expression) {
        super(varName);
        this.expression = expression;
    }

    @Override
    public Value calculate () throws KadetException {
        Value value = expression.calculate();
        if (value == null || !ValueUtils.isInteger(value)) {
            throw new KadetException("Non Integer Index");
        }
        int elementIndex = ValueUtils.getIntegerFromValue(value);
        Value list = super.calculate();
        java.util.List<Value> values = ValueUtils.getListFromValue(list);
        if (elementIndex < 0 || elementIndex >= values.size()) {
            throw new KadetException("Argument out of list range!");
        }
        return values.get(elementIndex);
    }
}
