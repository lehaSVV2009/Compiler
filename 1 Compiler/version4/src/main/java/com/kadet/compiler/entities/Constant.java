package com.kadet.compiler.entities;

import com.kadet.compiler.expressions.Expression;
import com.kadet.compiler.util.KadetException;
import com.kadet.compiler.util.ValueFactory;

/**
 * Date: 30.03.14
 * Time: 14:08
 *
 * @author Кадет
 */
public class Constant extends Variable{

    private Expression expression;

    public Constant (String name) {
        super(name);
        setValue(ValueFactory.createValue(Type.VALUE));
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public void initialize() throws KadetException {
        setValue(expression.calculate());
        System.out.println("Constant is initialized!: " + toString());
    }

}
