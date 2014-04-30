package com.kadet.compiler.evaluators;

import com.kadet.compiler.entities.*;
import com.kadet.compiler.util.KadetException;
import com.kadet.compiler.util.ValueFactory;

import java.util.List;

/**
 * Date: 30.03.14
 * Time: 13:18
 *
 * @author Кадет
 */
public class FunctionEvaluator extends ProcedureEvaluator{

    private Value returnValue = ValueFactory.createValue(Type.VALUE);

    public FunctionEvaluator (Function function) {
        super(function);
    }

    @Override
    protected void evaluateProcedureStatements(Procedure procedure) throws KadetException {
        for (StatementEvaluator evaluator : procedure.getStatementEvaluators()) {
            if (evaluator instanceof ReturnStatementEvaluator) {
                ReturnStatementEvaluator returnEvaluator
                        = (ReturnStatementEvaluator) evaluator;
                returnEvaluator.evaluate();
                this.returnValue = returnEvaluator.getReturnValue();
                return;
            }
            evaluator.evaluate();
        }
        throw new KadetException("There is no return statement!");
    }

    public Value getReturnValue() {
        return returnValue;
    }
}
