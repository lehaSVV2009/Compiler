package com.kadet.compiler.evaluators;

import com.kadet.compiler.entities.Choice;

/**
 * Date: 30.03.14
 * Time: 14:01
 *
 * @author Кадет
 */
public class WhileEvaluator implements StatementEvaluator {

    private Choice whileChoice;

    public void setWhileChoice(Choice whileChoice) {
        this.whileChoice = whileChoice;
    }

    @Override
    public void evaluate () {
        System.out.println("While Evaluator Starts!");
    }
}
