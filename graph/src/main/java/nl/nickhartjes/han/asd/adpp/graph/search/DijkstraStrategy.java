package nl.nickhartjes.han.asd.adpp.graph.search;

import nl.nickhartjes.han.asd.adpp.graph.Edge;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

public class DijkstraStrategy<T> implements SearchStrategy<T> {

    private PriorityQueue<PriorityQueueElement<T>> queue = new PriorityQueue<>();
    private Map<T, DistanceMapElement<T, T, Double>> distanceMap = new HashMap<>();
    private Map<T, LinkedList<Edge<T>>> graph = new HashMap<>();

    @Override
    public void searchShortestPath(Map<T, LinkedList<Edge<T>>> graph, T sourceVertex, T destinationVertex) {
        // Set graph in the class scope
        this.graph = graph;

        // Set the first value in the distance table
        distanceMap.put(sourceVertex, new DistanceMapElement<T, T, Double>(sourceVertex, sourceVertex, 0d));

        // Add the edges of the root node to the queue
        this.addEdgesToQueue(sourceVertex);

        while (!queue.isEmpty()) {

            // Get the lowest weight from the priority queue
            PriorityQueueElement<T> lowestElementFromQueue = queue.poll();
            T vertex = lowestElementFromQueue.getVertex();
            if (vertex.equals(destinationVertex)) {
                this.addEdgesToQueue(lowestElementFromQueue.getVertex());
            }

        }

        System.out.println("test");
    }

    private void addEdgesToQueue(T vertex) {
        LinkedList<Edge<T>> edgesFromVertex = this.graph.get(vertex);
        DistanceMapElement sourceDistanceMapElement = distanceMap.get(vertex);

        for (Edge<T> edge : edgesFromVertex) {
            T edgeSource = edge.getSourceVertex();
            T edgeDestination = edge.getDestinationVertex();
            double weight = edge.getWeight() + sourceDistanceMapElement.getWeight();

            distanceMap.put(edgeDestination, new DistanceMapElement<T, T, Double>(edgeDestination, edgeSource, weight));
            this.queue.add(new PriorityQueueElement<T>(edgeDestination, weight));
        }
    }

    private class DistanceMapElement<T, T1, D extends Number> {

        private T vertex;
        private T parentVertex;
        private double weight;

        public DistanceMapElement(T vertex, T parentVertex, double weight) {
            this.vertex = vertex;
            this.parentVertex = parentVertex;
            this.weight = weight;
        }

        public T getVertex() {
            return vertex;
        }

        public void setVertex(T vertex) {
            this.vertex = vertex;
        }

        public T getParentVertex() {
            return parentVertex;
        }

        public void setParentVertex(T parentVertex) {
            this.parentVertex = parentVertex;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }
    }

    private class PriorityQueueElement<T> implements Comparable {

        private T vertex;
        private double weight;

        public PriorityQueueElement(T vertex, double weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        public T getVertex() {
            return vertex;
        }

        public double getWeight() {
            return weight;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;

            if (obj == null || obj.getClass() != this.getClass())
                return false;

            // type casting of the argument.
            PriorityQueueElement priorityQueueElement = (PriorityQueueElement) obj;
            return (this.getVertex() == priorityQueueElement.getVertex()
                    && this.getWeight() == priorityQueueElement.getWeight()
            );
        }

        @Override
        public int compareTo(Object obj) {
            PriorityQueueElement priorityQueueElement = (PriorityQueueElement) obj;
            if (this.getWeight() < priorityQueueElement.getWeight())
                return -1;
            if (this.getWeight() > priorityQueueElement.getWeight())
                return 1;
            return 0;
        }
    }
}
