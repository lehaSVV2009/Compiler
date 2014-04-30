package com.kadet.compiler.initializers;

import com.kadet.compiler.util.KadetException;

/**
 * Date: 30.04.14
 * Time: 16:53
 *
 * @author SarokaA
 */
public interface Initializer<T> {

    public void initialize(T t) throws KadetException;

}
