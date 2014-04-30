package com.kadet.compiler.evaluators;

import com.kadet.compiler.entities.Choice;
import com.kadet.compiler.entities.Value;
import com.kadet.compiler.util.KadetException;
import com.kadet.compiler.util.ValueUtils;

import java.util.List;

/**
 * Date: 29.04.14
 * Time: 21:58
 *
 * @author SarokaA
 */
public abstract class ChoiceEvaluator implements StatementEvaluator {


    protected boolean checkChoiceExpression(Choice choice) throws KadetException {
        Value expressionResult = choice.getExpression().calculate();
        if (!ValueUtils.isBoolean(expressionResult)) {
            throw new KadetException("Not Boolean expression!");
        }
        return ValueUtils.getBooleanFromValue(expressionResult);
    }

    protected void evaluateChoice(Choice choice) throws KadetException {
        List<StatementEvaluator> statementEvaluators = choice.getStatementEvaluators();
        for (StatementEvaluator evaluator : statementEvaluators) {
            evaluator.evaluate();
        }
    }

}
