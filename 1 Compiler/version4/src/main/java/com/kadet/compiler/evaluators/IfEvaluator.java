package com.kadet.compiler.evaluators;

import com.kadet.compiler.entities.Choice;
import com.kadet.compiler.util.KadetException;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 30.03.14
 * Time: 14:01
 *
 * @author Кадет
 */
public class IfEvaluator extends ChoiceEvaluator {

    private Choice ifChoice = null;

    private List<Choice> elsIfChoices = new ArrayList<Choice>();

    private Choice elseChoice = null;

    public IfEvaluator() {
    }

    public void setIfChoice(Choice ifChoice) {
        this.ifChoice = ifChoice;
    }

    public void setElseChoice(Choice elseChoice) {
        this.elseChoice = elseChoice;
    }

    public void setElsIfChoices(List<Choice> elsIfChoices) {
        this.elsIfChoices = elsIfChoices;
    }

    @Override
    public void evaluate() throws KadetException {
        System.out.println("If Evaluator Starts! (" + this + ")");
        if (ifChoice == null) {
            throw new KadetException("No If expression!");
        }
        if (checkChoiceExpression(ifChoice)) {
            evaluateChoice(ifChoice);
            System.out.println("If is true!");
        } else {
            System.out.println("If is false!");
            boolean hasTrueExpression = false;
            for (Choice elsIfChoice : elsIfChoices) {
                if (checkChoiceExpression(elsIfChoice)) {
                    evaluateChoice(elsIfChoice);
                    hasTrueExpression = true;
                    System.out.println("ElsIf is true!");
                }
            }
            if (!hasTrueExpression) {
                if (elseChoice != null) {
                    System.out.println("Else is evaluating");
                    evaluateChoice(elseChoice);
                }
            }
        }

    }


    @Override
    public String toString() {
        return "IfEvaluator{" +
                "ifChoice=" + ifChoice +
                ", elsIfChoices=" + elsIfChoices +
                ", elseChoice=" + elseChoice +
                '}';
    }
}
