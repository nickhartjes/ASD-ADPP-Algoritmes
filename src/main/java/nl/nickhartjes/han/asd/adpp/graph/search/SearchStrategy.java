package nl.nickhartjes.han.asd.adpp.graph.search;

import nl.nickhartjes.han.asd.adpp.graph.Graph;
import nl.nickhartjes.han.asd.adpp.graph.GraphPath;

public interface SearchStrategy<T> {
    GraphPath<T> searchShortestPath(Graph<T> graph, T sourceVertex, T destinationVertex);
}
