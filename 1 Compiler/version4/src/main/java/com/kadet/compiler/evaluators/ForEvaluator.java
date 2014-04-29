package com.kadet.compiler.evaluators;

import com.kadet.compiler.entities.Choice;
import com.kadet.compiler.util.KadetException;

/**
 * Date: 30.03.14
 * Time: 14:01
 *
 * @author Кадет
 */
public class ForEvaluator extends ChoiceEvaluator {

    private AssignmentEvaluator initializeCounterEvaluator;
    private Choice forChoice;
    private AssignmentEvaluator increaseCounterEvaluator;

    public void setInitializeCounterEvaluator(AssignmentEvaluator initializeCounterEvaluator) {
        this.initializeCounterEvaluator = initializeCounterEvaluator;
    }

    public void setForChoice(Choice forChoice) {
        this.forChoice = forChoice;
    }

    public void setIncreaseCounterEvaluator(AssignmentEvaluator increaseCounterEvaluator) {
        this.increaseCounterEvaluator = increaseCounterEvaluator;
    }

    @Override
    public void evaluate () {
        System.out.println("For Evaluator Starts! (" + this + ")");
        try {
            if (forChoice == null) {
                throw new KadetException("No For expression!");
            }
            if (initializeCounterEvaluator != null) {
                initializeCounterEvaluator.evaluate();
            }
            while (checkChoiceExpression(forChoice)) {
                System.out.println("For is true!");
                evaluateChoice(forChoice);
                increaseCounterEvaluator.evaluate();
            }

        } catch (KadetException e) {
            e.printStackTrace();
        }

    }
}
