package nl.nickhartjes.han.asd.adpp.graph;

public class GraphEdge<T> implements Comparable<GraphEdge> {

    private GraphVertex<T> source;
    private GraphVertex<T> destination;
    private int weight;

    public GraphEdge(GraphVertex<T> source, GraphVertex<T> destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public GraphVertex<T> getSource() {
        return source;
    }

    public GraphVertex<T> getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(GraphEdge o) {
        if (this.getWeight() > o.getWeight())
            return 1;
        else return -1;
    }
}
