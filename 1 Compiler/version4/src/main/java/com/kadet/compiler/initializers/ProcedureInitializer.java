package com.kadet.compiler.initializers;

import com.kadet.compiler.entities.Constant;
import com.kadet.compiler.entities.Procedure;
import com.kadet.compiler.util.KadetException;

/**
 * Date: 30.03.14
 * Time: 14:20
 *
 * @author Кадет
 */
public class ProcedureInitializer implements Initializer<Procedure> {

    public ProcedureInitializer() {
    }

    public void initialize (Procedure procedure) throws KadetException {
        for (Constant constant: procedure.getConstants()) {
            constant.initialize();
        }
    }

}
