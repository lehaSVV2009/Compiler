package com.kadet.compiler.expressions;

import com.kadet.compiler.entities.Value;
import com.kadet.compiler.util.KadetException;

/**
 * Date: 30.03.14
 * Time: 17:48
 *
 * @author Кадет
 */
public interface Expression {

    Value calculate () throws KadetException;

}
