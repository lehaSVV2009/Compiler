package com.kadet.compiler.evaluators;

import com.kadet.compiler.expressions.Expression;
import com.kadet.compiler.util.KadetException;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 30.04.14
 * Time: 17:39
 *
 * @author SarokaA
 */
public class KadOutEvaluator implements StatementEvaluator {

    private List<Expression> expressions = new ArrayList<Expression>();

    public void addExpression (Expression expression) {
        expressions.add(expression);
    }

    @Override
    public void evaluate() throws KadetException {
        for (Expression expression : expressions) {
            System.out.println("<=<" + expression.calculate());
        }
    }

}
