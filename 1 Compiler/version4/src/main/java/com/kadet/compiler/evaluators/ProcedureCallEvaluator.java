package com.kadet.compiler.evaluators;

import com.kadet.compiler.entities.Procedure;
import com.kadet.compiler.entities.Program;
import com.kadet.compiler.entities.Value;
import com.kadet.compiler.entities.Variable;
import com.kadet.compiler.expressions.Expression;
import com.kadet.compiler.util.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 30.03.14
 * Time: 14:01
 *
 * @author Кадет
 */
public class ProcedureCallEvaluator implements StatementEvaluator {

    private String procedureName;
    private List<Expression> actualParameters = new ArrayList<Expression>();

    public ProcedureCallEvaluator(String procedureName, List<Expression> actualParameters) {
        this.procedureName = procedureName;
        this.actualParameters = actualParameters;
    }

    @Override
    public void evaluate () {
        System.out.println("Procedure Call Evaluator Starts!");
        Procedure currentProcedure = Program.getInstance().getCurrentProcedure();
        try {
            if (currentProcedure == null) {
                throw new KadetException("There is no current procedure!");
            }
            if (!ProcedureUtils.hasSuchProcedureName(procedureName, currentProcedure)) {
                throw new KadetException("No such procedure!");
            }
            Procedure procedure = ProcedureUtils.getProcedureFromProcedure(procedureName, currentProcedure);
            System.out.println("Called procedure: " + procedure.getName());
            Evaluator procedureEvaluator = new ProcedureEvaluator(procedure);
            procedureEvaluator.evaluate();
        } catch (KadetException e) {
            Errors.addError(
                    new KadetError(e.getMessage()));
            e.printStackTrace();
        }
    }
}
