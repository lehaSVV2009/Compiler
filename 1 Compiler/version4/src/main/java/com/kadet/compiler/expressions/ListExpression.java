package com.kadet.compiler.expressions;

import com.kadet.compiler.entities.List;
import com.kadet.compiler.entities.Value;
import com.kadet.compiler.util.KadetException;

import java.util.ArrayList;

/**
 * Date: 31.03.14
 * Time: 11:23
 *
 * @author Кадет
 */
public class ListExpression implements Expression {

    private java.util.List<Expression> expressions = new ArrayList<Expression>();

    public ListExpression (java.util.List<Expression> expressions) {
        this.expressions = expressions;
    }

    @Override
    public Value calculate () throws KadetException {
        java.util.List<Value> values = new ArrayList<Value>();
        for (Expression expression : expressions) {
            values.add(expression.calculate());
        }
        System.out.println("\nList Calculation :" + values);
        return new List(values);
    }
}
