package nl.nickhartjes.han.asd.adpp.graph;

import java.util.Comparator;

public class Edge<T> implements Comparable<Edge> {

    private T sourceVertex;
    private T destinationVertex;
    private Double weight;

    public Edge(T sourceVertex, T destinationVertex) {
        this.sourceVertex = sourceVertex;
        this.destinationVertex = destinationVertex;
    }

    public Edge(T sourceVertex, T destinationVertex, Double weight) {
        this.sourceVertex = sourceVertex;
        this.destinationVertex = destinationVertex;
        this.weight = weight;
    }

    public T getSourceVertex() {
        return sourceVertex;
    }

    public void setSourceVertex(T sourceVertex) {
        this.sourceVertex = sourceVertex;
    }

    public T getDestinationVertex() {
        return destinationVertex;
    }

    public void setDestinationVertex(T destinationVertex) {
        this.destinationVertex = destinationVertex;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(destinationVertex.toString());
        if (getWeight() != null) {
            stringBuilder.append("(");
            stringBuilder.append(getWeight().toString());
            stringBuilder.append(")");
        }
        return stringBuilder.toString();
    }


//    @Override
//    public int compare(Edge edge1, Edge edge2) {
//        if (edge1.getWeight() < edge2.getWeight())
//            return -1;
//        if (edge1.getWeight() > edge2.getWeight())
//            return 1;
//        return 0;
//    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || obj.getClass() != this.getClass())
            return false;

        // type casting of the argument.
        Edge edge = (Edge) obj;
        return (this.getSourceVertex() == edge.getSourceVertex()
                && this.getDestinationVertex() == edge.getDestinationVertex()
                && this.getWeight() == edge.getWeight()
        );
    }

    @Override
    public int compareTo(Edge o) {
        if (this.getWeight() < o.getWeight())
            return -1;
        if (this.getWeight() > o.getWeight())
            return 1;
        return 0;
    }
}
