package nl.nickhartjes.han.asd.adpp.graph.search;

import nl.nickhartjes.han.asd.adpp.graph.*;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DijkstraStrategy<T> implements SearchStrategy<T> {

    private PriorityQueue<PriorityQueueElement> queue;
    private Map<GraphVertex<T>, DistanceMapEntry<T>> distanceMap;
    private Map<T, GraphVertex<T>> adjacencyList;

    public DijkstraStrategy() {
        this.queue = new PriorityQueue<>();
        this.distanceMap = new HashMap<>();
        this.adjacencyList = new HashMap<>();
    }

    @Override
    public GraphPath<T> searchShortestPath(Graph<T> graph , T sourceVertex, T destinationVertex) {
        // Set graph in the class scope
        this.adjacencyList = graph.getAdjacencyList();

        // Set the the distance as high as possible.
        int shortestDistance = Integer.MAX_VALUE;

        // Set the first value in the distance table
        GraphVertex<T> sourceGraphVertex = this.adjacencyList.get(sourceVertex);
        int startWeight = 0;
        if(graph.getWeighted() == GraphWeight.UNWEIGHTED)
            startWeight = startWeight + 1;

        this.distanceMap.put(sourceGraphVertex, new DistanceMapEntry<T>(sourceGraphVertex, sourceGraphVertex, startWeight));

        // Add the source to the queue
        this.addToQueue(sourceVertex, startWeight, shortestDistance);

        while (!queue.isEmpty()) {
            // Get the lowest weight from the priority queue
            PriorityQueueElement lowestElementFromQueue = queue.poll();

            GraphVertex<T> process = lowestElementFromQueue.getVertex();

            // Check if we reached our destination vertex
            if (process.getValue().equals(destinationVertex)) {
                shortestDistance = this.distanceMap.get(process).getWeight();
            }

            this.addToQueue(process.getValue(), lowestElementFromQueue.getWeight(), shortestDistance);
        }

        if (shortestDistance == Integer.MAX_VALUE)
            throw new IllegalStateException("No route exists");

        return this.traceBackShortestRoute(this.distanceMap, this.adjacencyList.get(sourceVertex), this.adjacencyList.get(destinationVertex));
    }

    private GraphPath<T> traceBackShortestRoute(Map<GraphVertex<T>, DistanceMapEntry<T>> distanceMap, GraphVertex<T> sourceVertex, GraphVertex<T> destinationVertex) {
        GraphPath<T> graphPath = new GraphPath<>();
        graphPath.setWeight(distanceMap.get(destinationVertex).getWeight());
        GraphVertex<T> graphVertex = destinationVertex;
        while (true) {
            DistanceMapEntry<T> distanceMapEntry = distanceMap.get(graphVertex);
            graphPath.addPathStep(distanceMapEntry.getVertex());
            if (distanceMapEntry.getVertex().equals(sourceVertex)) {
                break;
            }
            graphVertex = distanceMapEntry.getParentVertex();
        }
        return graphPath;
    }


    private void addToQueue(T sourceVertex, int weight, int shortestDistance) {
        GraphVertex<T> sourceGraphVertex = adjacencyList.get(sourceVertex);

        for (GraphEdge<T> edge : sourceGraphVertex.getEdges()) {
            int newWeight = weight + edge.getWeight();

            if (newWeight < shortestDistance) {

                GraphVertex<T> destinationGraphVertex = edge.getDestination();

                // Check if the distancemap does not contain the vertex already, then add it to the queue
                // Or if vertex in the distance map has a higher double value, then scan it again
                if (!distanceMap.containsKey(destinationGraphVertex) || distanceMap.get(destinationGraphVertex).getWeight() > newWeight) {
                    this.queue.add(new PriorityQueueElement(destinationGraphVertex, newWeight));
                    distanceMap.put(edge.getDestination(), new DistanceMapEntry<T>(edge.getDestination(), edge.getSource(), newWeight));
                }
            }
        }
    }

    private class PriorityQueueElement implements Comparable {

        private GraphVertex<T> vertex;
        private int weight;

        PriorityQueueElement(GraphVertex<T> vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        GraphVertex<T> getVertex() {
            return vertex;
        }

        int getWeight() {
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

    private class DistanceMapEntry<T> implements Comparable {

        private GraphVertex<T> vertex;
        private GraphVertex<T> parentVertex;
        private int weight;

        public DistanceMapEntry(GraphVertex<T> vertex, GraphVertex<T> parentVertex, int weight) {
            this.vertex = vertex;
            this.parentVertex = parentVertex;
            this.weight = weight;
        }

        public GraphVertex<T> getVertex() {
            return vertex;
        }

        public void setVertex(GraphVertex<T> vertex) {
            this.vertex = vertex;
        }

        public GraphVertex<T> getParentVertex() {
            return parentVertex;
        }

        public void setParentVertex(GraphVertex<T> parentVertex) {
            this.parentVertex = parentVertex;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        @Override
        public int compareTo(Object obj) {
            DistanceMapEntry distanceMapEntry = (DistanceMapEntry) obj;
            return Double.compare(this.getWeight(), distanceMapEntry.getWeight());
        }
    }
}
