package nl.nickhartjes.han.asd.adpp.graph.search;

import nl.nickhartjes.han.asd.adpp.graph.Graph;
import nl.nickhartjes.han.asd.adpp.graph.GraphPath;
import nl.nickhartjes.han.asd.adpp.graph.GraphVertex;

import java.util.Map;

public interface SearchStrategy<T> {
    GraphPath<T> searchShortestPath(Graph<T> graph, T sourceVertex, T destinationVertex);
}
