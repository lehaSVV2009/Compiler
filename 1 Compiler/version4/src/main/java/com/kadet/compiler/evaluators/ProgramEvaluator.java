package com.kadet.compiler.evaluators;

import com.kadet.compiler.entities.Program;
import com.kadet.compiler.util.Errors;
import com.kadet.compiler.util.KadetError;

/**
 * Date: 30.03.14
 * Time: 12:53
 *
 * @author Кадет
 */
public class ProgramEvaluator implements Evaluator {

    private ProcedureEvaluator mainEvaluator;

    public ProgramEvaluator () {
    }

    public void setMainEvaluator (ProcedureEvaluator mainEvaluator) {
        this.mainEvaluator = mainEvaluator;
    }

    @Override
    public void evaluate () {
        System.out.println("Program " + Program.getInstance().getProgramName() + " Starts!");
        if (mainEvaluator == null) {
            Errors.addError(
                    new KadetError("No Main Method!"));
            return;
        }
        mainEvaluator.evaluate();
    }
}
