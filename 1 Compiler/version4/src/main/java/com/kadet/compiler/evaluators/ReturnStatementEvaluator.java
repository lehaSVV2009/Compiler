package com.kadet.compiler.evaluators;

import com.kadet.compiler.expressions.Expression;

/**
 * Date: 31.03.14
 * Time: 23:48
 *
 * @author Кадет
 */
public class ReturnStatementEvaluator implements StatementEvaluator {

    private Expression expression;

    public ReturnStatementEvaluator (Expression expression) {
        this.expression = expression;
    }

    @Override
    public void evaluate () {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
