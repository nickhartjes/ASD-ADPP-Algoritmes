package nl.nickhartjes.han.asd.adpp.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GraphPath<T> {

    private LinkedList<GraphVertex<T>> path;
    private double weight;

    public GraphPath() {
        this.path = new LinkedList<>();
    }

    public List<GraphVertex<T>> getPath() {
        return path;
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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator iterator = path.descendingIterator();

        // print list with descending order
        while (iterator.hasNext()) {
            stringBuilder.append(iterator.next().toString());
            stringBuilder.append(" --> ");
        }

        return "Path{" +
                "path=" + stringBuilder.toString() +
                ", weight=" + weight +
                '}';
    }
}
