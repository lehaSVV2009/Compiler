package com.kadet.compiler.entities;

import com.kadet.compiler.evaluators.StatementEvaluator;
import com.kadet.compiler.expressions.Expression;

import java.util.*;
import java.util.List;

/**
 * Date: 29.04.14
 * Time: 16:32
 *
 * @author SarokaA
 */
public class Choice {


    private Expression expression;
    private java.util.List<StatementEvaluator> statementEvaluators = new ArrayList<StatementEvaluator>();

    public Choice() {
    }

    public Choice(Expression expression) {
        this.expression = expression;
    }

    public void addStatementEvaluator(StatementEvaluator statementEvaluator) {
        statementEvaluators.add(statementEvaluator);
    }

    public List<StatementEvaluator> getStatementEvaluators() {
        return statementEvaluators;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return "Choice{" +
                "expression=" + expression +
                ", statementEvaluators=" + statementEvaluators +
                '}';
    }
}
