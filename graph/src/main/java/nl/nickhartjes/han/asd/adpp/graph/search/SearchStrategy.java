package nl.nickhartjes.han.asd.adpp.graph.search;

import nl.nickhartjes.han.asd.adpp.graph.GraphVertex;

import java.util.Map;

public interface SearchStrategy<T> {
    void searchShortestPath(Map<T, GraphVertex<T>> adjacencyList, T sourceVertex, T destinationVertex);
}
