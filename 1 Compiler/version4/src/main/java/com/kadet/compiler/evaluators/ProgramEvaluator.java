package com.kadet.compiler.evaluators;

import com.kadet.compiler.Errors;
import com.kadet.compiler.KadetError;

/**
 * Date: 30.03.14
 * Time: 12:53
 *
 * @author Кадет
 */
public class ProgramEvaluator implements Evaluator {

    private String name;

    private ProcedureEvaluator mainEvaluator;

    public ProgramEvaluator (String name) {
        this.name = name;
    }

    public void setMainEvaluator (ProcedureEvaluator mainEvaluator) {
        this.mainEvaluator = mainEvaluator;
    }

    @Override
    public void evaluate () {
        System.out.println("Program " + name + " Starts!");
        if (mainEvaluator == null) {
            Errors.addError(
                    new KadetError("No Main Method!"));
            return;
        }
        mainEvaluator.evaluate();
    }
}
