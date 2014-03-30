package com.kadet.compiler;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Date: 27.02.14
 * Time: 3:54
 *
 * @author SarokaA
 */
public class Graph {
    private List<Edge> edges;
    private Set<Vertex> vertices;

    public Graph() {
        edges = new ArrayList<Edge>();
        vertices = new TreeSet<Vertex>();
    }
    public void addEdge(Edge edge){
        getEdges().add(edge);
        getVertices().add(edge.getFromVertex());
        getVertices().add(edge.getToVertex());
    }

    public void addVertice(Vertex v){
        getVertices().add(v);
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public Set<Vertex> getVertices() {
        return vertices;
    }

    public static void printGraph(Graph g){
        System.out.println("Vertices...");
        for (Vertex v : g.getVertices()) {
            System.out.print(v.getLabel() + " ");
        }
        System.out.println("");
        System.out.println("Edges...");
        for (Edge e : g.getEdges()) {
            System.out.println(e);
        }
    }

}


