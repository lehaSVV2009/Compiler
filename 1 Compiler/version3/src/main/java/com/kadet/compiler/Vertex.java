package com.kadet.compiler;

/**
 * Date: 27.02.14
 * Time: 3:55
 *
 * @author SarokaA
 */
public class Vertex implements Comparable<Vertex> {
    private String label;

    public Vertex(String label) {
        this.label = label.toUpperCase();
    }

    @Override
    public int compareTo(Vertex o) {
        return (this.getLabel().compareTo(o.getLabel()));
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}

