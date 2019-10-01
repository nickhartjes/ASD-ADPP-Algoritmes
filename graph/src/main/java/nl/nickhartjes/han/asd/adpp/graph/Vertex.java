package nl.nickhartjes.han.asd.adpp.graph;

public class Vertex<T> {

    private T vertexValue;
    private Graph graph;

    public Vertex(T vertexValue, Graph graph) {
        this.vertexValue = vertexValue;
        this.graph = graph;
    }

    public T getVertexValue() {
        return vertexValue;
    }

    public void setVertexValue(T vertexValue) {
        this.vertexValue = vertexValue;
    }
}
