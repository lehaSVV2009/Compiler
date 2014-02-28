package com.kadet.compiler;

/**
 * Date: 27.02.14
 * Time: 3:55
 *
 * @author SarokaA
 */
public class Edge {

    private Vertex fromVertex;
    private Vertex toVertex;
    private Double weight;

    public Edge() {
    }

    public Edge(Vertex fromVertex,
                Vertex toVertex,
                Double weight) {
        this.fromVertex = fromVertex;
        this.toVertex = toVertex;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return fromVertex.getLabel() +
                " to " + toVertex.getLabel() +
                " with weight " + getWeight();
    }

    public Vertex getFromVertex() {
        return fromVertex;
    }

    public void setFromVertex(Vertex fromVertex) {
        this.fromVertex = fromVertex;
    }

    public Vertex getToVertex() {
        return toVertex;
    }

    public void setToVertex(Vertex toVertex) {
        this.toVertex = toVertex;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
