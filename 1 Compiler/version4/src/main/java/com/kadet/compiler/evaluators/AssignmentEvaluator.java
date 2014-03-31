package com.kadet.compiler.evaluators;

import com.kadet.compiler.Errors;
import com.kadet.compiler.KadetError;
import com.kadet.compiler.entities.Value;
import com.kadet.compiler.expressions.Expression;
import com.kadet.compiler.util.KadetException;

/**
 * Date: 30.03.14
 * Time: 14:01
 *
 * @author Кадет
 */
public class AssignmentEvaluator implements StatementEvaluator {

    private String name;
    private Expression expression;

    public AssignmentEvaluator (String name, Expression expression) {
        this.name = name;
        this.expression = expression;
    }

    @Override
    public void evaluate () {
        System.out.println("Assignment Evaluator Starts!");
        try {
            Value value = expression.calculate();
            System.out.println("Value: " + value.toString());
        } catch (KadetException e) {
            Errors.addError(
                    new KadetError(e.getMessage()));
            e.printStackTrace();
        }
    }
}
