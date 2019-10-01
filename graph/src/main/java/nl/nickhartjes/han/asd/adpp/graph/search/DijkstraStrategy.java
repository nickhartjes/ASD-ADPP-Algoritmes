package nl.nickhartjes.han.asd.adpp.graph.search;

import nl.nickhartjes.han.asd.adpp.graph.Edge;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

public class DijkstraStrategy<T> implements SearchStrategy<T> {

//    private class Distance<T> implements Comparator<Distance> {
//        T parent = null;
//        double weight = 0d;
//
//        public T getParent() {
//            return parent;
//        }
//
//        public void setParent(T parent) {
//            this.parent = parent;
//        }
//
//        public double getWeight() {
//            return weight;
//        }
//
//        public void setWeight(double weight) {
//            this.weight = weight;
//        }
//
//        @Override
//        public int compare(Distance edge1, Distance edge2) {
//            if (edge1.getWeight() < edge2.getWeight())
//                return -1;
//            if (edge1.getWeight() > edge2.getWeight())
//                return 1;
//            return 0;
//        }
//
//        @Override
//        public boolean equals(Object obj) {
//            if(this == obj)
//                return true;
//
//            if(obj == null || obj.getClass()!= this.getClass())
//                return false;
//
//            // type casting of the argument.
//            Distance distance = (Distance) obj;
//            return (this.getParent() == distance.getParent()
//                    && this.getWeight() == distance.getWeight()
//            );
//        }
//    }

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
