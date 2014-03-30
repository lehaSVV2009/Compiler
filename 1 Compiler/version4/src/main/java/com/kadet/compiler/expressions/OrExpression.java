package com.kadet.compiler.expressions;

import com.kadet.compiler.entities.Value;

/**
 * Date: 30.03.14
 * Time: 17:33
 *
 * @author Кадет
 */
public class OrExpression extends BinaryExpression {

    public OrExpression (Expression evaluator1, Expression evaluator2) {
        super(evaluator1, evaluator2);
    }

    @Override
    public Value calculate () {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
