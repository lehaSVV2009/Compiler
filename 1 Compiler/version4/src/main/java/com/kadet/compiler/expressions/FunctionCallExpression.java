package com.kadet.compiler.expressions;

import com.kadet.compiler.entities.Function;
import com.kadet.compiler.entities.Procedure;
import com.kadet.compiler.entities.Value;
import com.kadet.compiler.evaluators.CallEvaluator;
import com.kadet.compiler.evaluators.Evaluator;
import com.kadet.compiler.evaluators.FunctionEvaluator;
import com.kadet.compiler.util.KadetException;
import com.kadet.compiler.util.ProcedureUtils;

import java.util.List;

/**
 * Date: 30.04.14
 * Time: 14:29
 *
 * @author SarokaA
 */
public class FunctionCallExpression extends CallEvaluator implements Expression {

    private FunctionEvaluator functionEvaluator;

    public FunctionCallExpression(String procedureName, List<Expression> actualParameters) {
        super(procedureName, actualParameters);
    }

    @Override
    protected Procedure getProcedure(String procedureName, Procedure parentProcedure) throws KadetException {
        if (!ProcedureUtils.hasSuchFunctionName(procedureName, parentProcedure)) {
            System.out.println("procedureName" + procedureName + "parentProcedure Functions : " + parentProcedure.getFunctions());
            throw new KadetException("No such function!");
        }
        return ProcedureUtils.getFunctionFromProcedure(procedureName, parentProcedure);
    }

    @Override
    public Value calculate() throws KadetException {
        evaluate();
        return functionEvaluator.getReturnValue();
    }

    @Override
    protected Evaluator createCallEvaluator(Procedure procedure) {
        functionEvaluator = new FunctionEvaluator((Function) procedure);
        return functionEvaluator;
    }
}
