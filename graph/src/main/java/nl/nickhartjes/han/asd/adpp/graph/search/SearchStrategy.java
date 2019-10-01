package nl.nickhartjes.han.asd.adpp.graph.search;

import nl.nickhartjes.han.asd.adpp.graph.Edge;

import java.util.LinkedList;
import java.util.Map;

public interface SearchStrategy<T> {
    void searchShortestPath(Map<T, LinkedList<Edge>> graph, T sourceVertex, T destinationVertex);
}
