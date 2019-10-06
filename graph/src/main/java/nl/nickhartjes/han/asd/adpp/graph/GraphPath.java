package nl.nickhartjes.han.asd.adpp.graph;

import java.util.LinkedList;
import java.util.List;

public class GraphPath<T> {

    private List<GraphVertex<T>> path;
    private double weight;

    public GraphPath() {
        this.path = new LinkedList<>();
    }

    public List<GraphVertex<T>> getPath() {
        return path;
    }

    public void setPath(List<GraphVertex<T>> path) {
        this.path = path;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void addPathStep(GraphVertex<T> step) {
        this.path.add(step);
    }
}
