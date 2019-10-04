package nl.nickhartjes.han.asd.adpp.graph.search;

import nl.nickhartjes.han.asd.adpp.graph.Edge;

import java.util.*;

public class DijkstraStrategy<T> implements SearchStrategy<T> {

    private class PriorityQueueElement<T> implements Comparator<PriorityQueueElement> {

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
        public int compare(PriorityQueueElement vertex01, PriorityQueueElement vertex02) {
            if (vertex01.getWeight() < vertex02.getWeight())
                return -1;
            if (vertex01.getWeight() > vertex02.getWeight())
                return 1;
            return 0;
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
    }

    private PriorityQueue<Edge<T>> queue = new PriorityQueue<>();
    private Map<T, PriorityQueueElement<? extends T>> distanceMap = new HashMap<>();
    private Map<T, LinkedList<Edge>> graph = new HashMap<>();

    @Override
    public void searchShortestPath(Map<T, LinkedList<Edge>> graph, T sourceVertex, T destinationVertex) {
        this.graph = graph;

        // Set the first value in the distance table
        distanceMap.put(sourceVertex, new PriorityQueueElement<>(sourceVertex, 0));


        this.addEdgesToQueue(sourceVertex);


        while (!queue.isEmpty()) {

            // Get the lowest weight from the priority queue
            Edge<T> firstEdge = queue.poll();
            T sourceVertex1 = firstEdge.getSourceVertex();
            T destinationVertex1 = firstEdge.getDestinationVertex();


            PriorityQueueElement<? extends T> test = distanceMap.get(sourceVertex1);

            double newWeight = test.getWeight() + firstEdge.getWeight();

            PriorityQueueElement<T> elke = new PriorityQueueElement<>(sourceVertex1, newWeight);
            distanceMap.put(destinationVertex1, elke);

            this.addEdgesToQueue(firstEdge.getDestinationVertex());

            System.out.println("test");
        }

        System.out.println("test");
    }

    private void addEdgesToQueue(T vertex){
        LinkedList<Edge> edgesFromVertex = this.graph.get(vertex);
//        if (edgesFromSourceVortex.isEmpty()) throw new IllegalStateException("Source vertex doesnt have edges");
//        this.queue.addAll(edgesFromVertex);
        for (Edge edge: edgesFromVertex){
            this.queue.add(edge);
        }
    }
}
