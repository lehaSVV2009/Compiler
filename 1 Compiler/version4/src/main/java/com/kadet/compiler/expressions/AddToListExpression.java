package com.kadet.compiler.expressions;

import com.kadet.compiler.entities.Element;
import com.kadet.compiler.entities.List;
import com.kadet.compiler.entities.Value;
import com.kadet.compiler.util.KadetException;
import com.kadet.compiler.util.ValueUtils;

import java.util.ArrayList;

/**
 * Date: 30.03.14
 * Time: 19:09
 *
 * @author Кадет
 */
public class AddToListExpression extends BinaryExpression {

    public AddToListExpression (Expression expression1, Expression expression2) {
        super(expression1, expression2);
    }

    @Override
    public Value calculate () throws KadetException {
        Value value1 = expression1.calculate();
        Value value2 = expression2.calculate();
        if (ValueUtils.isElementAndElement(value1, value2)) {
            return createListFromElements((Element) value1, (Element) value2);
        }
        if (ValueUtils.isElementAndList(value1, value2)) {
            return createNewListWithListElementAndElement((List) value2, (Element) value1);
        }
        if (ValueUtils.isListAndElement(value1, value2)) {
            return createNewListWithListElementAndElement((List) value1, (Element) value2);
        }
        if (ValueUtils.isListAndList(value1, value2)) {
            return uniteLists((List) value1, (List) value2);
        }
        throw new KadetException("+ Operation Error!");
    }

    private List createListFromElements (Element element1, Element element2) {
        java.util.List<Value> values = new ArrayList<Value>();
        values.add(element1);
        values.add(element2);
        return new List(values);
    }

    private List createNewListWithListElementAndElement (List list, Element element) {
        List newList = (List)list.copy();
        newList.addElement(element);
        return newList;
    }

    private List uniteLists (List list1, List list2) {
        List newList = (List)list1.copy();
        newList.addElementsFromOtherList(list2);
        return newList;
    }

}
