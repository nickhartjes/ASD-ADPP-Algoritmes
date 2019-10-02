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
            if(this == obj)
                return true;

            if(obj == null || obj.getClass()!= this.getClass())
                return false;

            // type casting of the argument.
            PriorityQueueElement priorityQueueElement = (PriorityQueueElement) obj;
            return (this.getVertex() == priorityQueueElement.getVertex()
                    && this.getWeight() == priorityQueueElement.getWeight()
            );
        }
    }

    private PriorityQueue queue = new PriorityQueue<Edge>();
    private Map distanceMap = new HashMap<T, Edge>();

    @Override
    public void searchShortestPath(Map<T, LinkedList<Edge>> graph, T sourceVertex, T destinationVertex) {

//        // Add all vertexes to the distance map
//        for (T vertex: graph.keySet()){
//            distanceMap.put(vertex, new Edge<>());
//        }
//
//        LinkedList<Edge> edges = graph.get(sourceVertex);
//        if(edges.size() == 0){
//            throw new IllegalStateException("Source vertex doesnt have edges");
//        }
//        for(Edge edge: edges){
//
//        }

//        this.queue.add(sourceVertex);

    }
}
