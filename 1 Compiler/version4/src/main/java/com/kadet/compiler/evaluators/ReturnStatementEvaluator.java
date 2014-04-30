package com.kadet.compiler.evaluators;

import com.kadet.compiler.entities.Type;
import com.kadet.compiler.entities.Value;
import com.kadet.compiler.expressions.Expression;
import com.kadet.compiler.util.KadetException;
import com.kadet.compiler.util.ValueFactory;

/**
 * Date: 31.03.14
 * Time: 23:48
 *
 * @author Кадет
 */
public class ReturnStatementEvaluator implements StatementEvaluator {

    private Expression expression;
    private Value returnValue = ValueFactory.createValue(Type.VALUE);

    public ReturnStatementEvaluator(Expression expression) {
        this.expression = expression;
    }

    @Override
    public void evaluate() throws KadetException {
        this.returnValue = expression.calculate();
    }

    public Value getReturnValue() {
        return returnValue;
    }
}
