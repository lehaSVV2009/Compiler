package com.kadet.compiler.expressions;

import com.kadet.compiler.entities.List;
import com.kadet.compiler.entities.Value;
import com.kadet.compiler.util.KadetException;

/**
 * Date: 30.03.14
 * Time: 19:10
 *
 * @author Кадет
 */
public class RemoveAllElementEntriesExpression extends RemoveFromListExpression {

    public RemoveAllElementEntriesExpression (Expression expression1, Expression expression2) {
        super(expression1, expression2);
    }

    @Override
    protected List createNewListFromListWithoutElement (List list, Value value) {
        List newList = (List)list.copy();
        newList.removeAllElementEntries(value);
        return newList;
    }
}
