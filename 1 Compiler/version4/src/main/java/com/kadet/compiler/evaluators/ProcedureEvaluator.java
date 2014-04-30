package com.kadet.compiler.evaluators;

import com.kadet.compiler.entities.Procedure;
import com.kadet.compiler.entities.Program;
import com.kadet.compiler.entities.Variable;
import com.kadet.compiler.util.KadetException;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 30.03.14
 * Time: 13:20
 *
 * @author Кадет
 */
public class ProcedureEvaluator implements Evaluator {

    protected Procedure procedure = null;

    /*private String name;
    private Program program = Program.getInstance();
    private List<Variable> parameters = new ArrayList<Variable>();
    private List<StatementEvaluator> statementEvaluators = new ArrayList<StatementEvaluator>();
*/

    public ProcedureEvaluator() {
    }

    public ProcedureEvaluator(Procedure procedure) {
        this.procedure = procedure;
    }


    public void setProcedure(Procedure procedure) {
        this.procedure = procedure;
    }


    @Override
    public void evaluate() throws KadetException {
        if (procedure == null) {
            throw new KadetException("No procedure to evaluate!");
        }
        Program.getInstance().setCurrentProcedure(procedure);
        evaluateProcedureStatements(procedure);
        if (procedure.getParentProcedure() != null) {
            Program.getInstance().setCurrentProcedure(procedure.getParentProcedure());
        }
    }

    protected void evaluateProcedureStatements(Procedure procedure) throws KadetException {
        for (StatementEvaluator statementEvaluator : procedure.getStatementEvaluators()) {
            statementEvaluator.evaluate();
        }
    }

}
