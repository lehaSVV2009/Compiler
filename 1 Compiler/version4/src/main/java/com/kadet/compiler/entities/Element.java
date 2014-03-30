package com.kadet.compiler.entities;

import com.kadet.compiler.Type;

/**
 * Date: 30.03.14
 * Time: 17:25
 *
 * @author Кадет
 */
public class Element extends Value {

    private Object content;

    public Element (Object content) {
        this.type = Type.ELEMENT;
        this.content = content;
    }

    public Object getContent () {
        return content;
    }
}
