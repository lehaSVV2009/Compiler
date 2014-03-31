package com.kadet.compiler.expressions;

import com.kadet.compiler.entities.Value;
import com.kadet.compiler.util.KadetException;

/**
 * Date: 30.03.14
 * Time: 18:38
 *
 * @author Кадет
 */
public class LessExpression extends BinaryExpression {

    public LessExpression (Expression expression1, Expression expression2) {
        super(expression1, expression2);
    }

    @Override
    public Value calculate () throws KadetException {
        return expression1.calculate();
    }
}
