package nl.nickhartjes.han.asd.adpp.graph.search;

import nl.nickhartjes.han.asd.adpp.graph.GraphEdge;
import nl.nickhartjes.han.asd.adpp.graph.GraphVertex;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DijkstraStrategy<T> implements SearchStrategy<T> {

    private PriorityQueue<PriorityQueueElement> queue;
    private Map<GraphVertex<T>, Double> distanceMap;
    private Map<T, GraphVertex<T>> adjacencyList;

    public DijkstraStrategy() {
        this.queue = new PriorityQueue<>();
        this.distanceMap = new HashMap<>();
        this.adjacencyList = new HashMap<>();
    }

    @Override
    public void searchShortestPath(Map<T, GraphVertex<T>> adjacencyList, T sourceVertex, T destinationVertex) {
        // Set graph in the class scope
        this.adjacencyList = adjacencyList;

        // Set the the distance as high as possible.
        Double shortestDistance = Double.POSITIVE_INFINITY;

        // Set the first value in the distance table
        this.addToQueue(sourceVertex, 0d, shortestDistance);

        while (!queue.isEmpty()) {
            // Get the lowest weight from the priority queue
            PriorityQueueElement lowestElementFromQueue = queue.poll();

            GraphVertex<T> process = lowestElementFromQueue.getVertex();

            // Check if we reached our destination vertex
            if (process.getValue().equals(destinationVertex)) {
                shortestDistance = this.distanceMap.get(process);
            }

            this.addToQueue(process.getValue(), lowestElementFromQueue.getWeight(), shortestDistance);
        }

        System.out.println("distance:" + shortestDistance);
    }

    private void addToQueue(T sourceVertex, Double weight, Double shortestDistance) {
        GraphVertex<T> sourceGraphVertex = adjacencyList.get(sourceVertex);

        for (GraphEdge<T> edge : sourceGraphVertex.getEdges()) {
            double newWeight = weight + edge.getWeight();

            if (newWeight < shortestDistance) {

                GraphVertex<T> destinationGraphVertex = edge.getDestination();

                // Check if the distancemap does not contain the vertex already, then add it to the queue
                // Or if vertex in the distance map has a higher double value, then scan it again
                if (!distanceMap.containsKey(destinationGraphVertex) || (distanceMap.containsKey(destinationGraphVertex) || distanceMap.get(destinationGraphVertex) < newWeight)) {
                    this.queue.add(new PriorityQueueElement(destinationGraphVertex, newWeight));
                    distanceMap.put(edge.getDestination(), newWeight);
                }
            }
        }
    }

    private class PriorityQueueElement implements Comparable {

        private GraphVertex<T> vertex;
        private double weight;

        PriorityQueueElement(GraphVertex<T> vertex, double weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        GraphVertex<T> getVertex() {
            return vertex;
        }

        double getWeight() {
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
            return Double.compare(this.getWeight(), priorityQueueElement.getWeight());
        }
    }
}
