package com.kadet.compiler.expressions;

import com.kadet.compiler.entities.Value;
import com.kadet.compiler.util.KadetException;

/**
 * Date: 31.03.14
 * Time: 11:53
 *
 * @author Кадет
 */
public class ElementFromListExpression implements Expression {

    private String varName;
    private Integer elementIndex;

    public ElementFromListExpression (String varName, Integer elementIndex) {
        this.varName = varName;
        this.elementIndex = elementIndex;
    }

    @Override
    public Value calculate () throws KadetException {
        return new Value();
    }
}
