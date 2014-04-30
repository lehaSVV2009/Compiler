package com.kadet.compiler.evaluators;

import com.kadet.compiler.entities.*;
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
public class ProcedureCallEvaluator extends CallEvaluator {

    public ProcedureCallEvaluator(String procedureName, List<Expression> actualParameters) {
        super(procedureName, actualParameters);
    }

    @Override
    protected Procedure getProcedure(String procedureName, Procedure parentProcedure) throws KadetException {
        if (!ProcedureUtils.hasSuchProcedureName(procedureName, parentProcedure)) {
            throw new KadetException("No such procedure!");
        }
        return ProcedureUtils.getProcedureFromProcedure(procedureName, parentProcedure);
    }

    @Override
    protected Evaluator createCallEvaluator(Procedure procedure) {
        return new ProcedureEvaluator(procedure);
    }
}
