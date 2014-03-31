package com.kadet.compiler.expressions;

import com.kadet.compiler.entities.Element;
import com.kadet.compiler.entities.List;
import com.kadet.compiler.entities.Value;
import com.kadet.compiler.util.KadetException;
import com.kadet.compiler.util.ValueUtils;

/**
 * Date: 30.03.14
 * Time: 19:09
 *
 * @author Кадет
 */
public class RemoveFromListExpression extends BinaryExpression {

    public RemoveFromListExpression (Expression expression1, Expression expression2) {
        super(expression1, expression2);
    }

    @Override
    public Value calculate () throws KadetException {
        Value value1 = expression1.calculate();
        Value value2 = expression2.calculate();
        if (ValueUtils.isListAndElement(value1, value2)
                || ValueUtils.isListAndList(value1, value2)) {
            return createNewListFromListWithoutElement((List) value1, value2);
        }
        throw new KadetException("- Operation Error!");
    }

    protected List createNewListFromListWithoutElement (List list, Value value) {
        List newList = (List)list.copy();
        newList.removeElement(value);
        return newList;
    }

}
