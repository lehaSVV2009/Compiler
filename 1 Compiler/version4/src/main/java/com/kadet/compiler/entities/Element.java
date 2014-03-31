package com.kadet.compiler.entities;

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

    @Override
    public String toString () {
        return "Content: " + content;
    }

    @Override
    public Value copy () {
        return new Element(content);
    }

    @Override
    public boolean equals (Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj || getClass() != obj.getClass()) {
            return false;
        }
        Element element = (Element) obj;
        if (content != element.getContent() || type != element.getType()) {
            return false;
        }
        return true;
    }
}
