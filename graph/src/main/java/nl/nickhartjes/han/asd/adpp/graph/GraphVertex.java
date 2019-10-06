package nl.nickhartjes.han.asd.adpp.graph;

import java.util.LinkedList;

public class GraphVertex<T> {

    private T value;
    private LinkedList<GraphEdge<T>> edges;

    public GraphVertex(T value) {
        this.value = value;
        this.edges = new LinkedList<>();
    }

    public T getValue() {
        return this.value;
    }

    public LinkedList<GraphEdge<T>> getEdges() {
        return this.edges;
    }

    public void setEdge(GraphEdge<T> edge) {
        this.edges.add(edge);
    }
}
