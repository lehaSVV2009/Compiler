package com.kadet.compiler.entities;

import com.kadet.compiler.evaluators.StatementEvaluator;

import java.util.*;
import java.util.List;

/**
 * Date: 30.03.14
 * Time: 12:41
 *
 * @author Кадет
 */
public class Procedure {

    private String name;
    private java.util.List<ProcedureParameter> parameters = new ArrayList<ProcedureParameter>();
    private java.util.List<StatementEvaluator> statementEvaluators = new ArrayList<StatementEvaluator>();


    public Procedure (String name) {
        this.name = name;
    }

    public void setParameters (List<ProcedureParameter> parameters) {
        this.parameters = parameters;
    }

    public void addStatementEvaluator (StatementEvaluator statementEvaluator) {
        statementEvaluators.add(statementEvaluator);
    }

    public String getName () {
        return name;
    }

    @Override
    public String toString () {
        return "Procedure{" +
                "name='" + name + '\'' +
                ", parameters=" + parameters +
                ", statementEvaluators=" + statementEvaluators +
                '}';
    }
}
