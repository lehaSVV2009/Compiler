package com.kadet.compiler.evaluators;

import com.kadet.compiler.entities.Choice;
import com.kadet.compiler.util.KadetException;

/**
 * Date: 30.03.14
 * Time: 14:01
 *
 * @author Кадет
 */
public class WhileEvaluator extends ChoiceEvaluator {

    private Choice whileChoice;

    public void setWhileChoice(Choice whileChoice) {
        this.whileChoice = whileChoice;
    }

    @Override
    public void evaluate() throws KadetException {
        System.out.println("While Evaluator Starts! ");
        if (whileChoice == null) {
            throw new KadetException("No While expression!");
        }
        while (checkChoiceExpression(whileChoice)) {
            System.out.println("While is true!");
            evaluateChoice(whileChoice);
        }

    }
}
