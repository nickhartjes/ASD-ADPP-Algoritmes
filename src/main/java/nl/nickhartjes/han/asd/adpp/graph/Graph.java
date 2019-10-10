package nl.nickhartjes.han.asd.adpp.graph;

import nl.nickhartjes.han.asd.adpp.graph.search.DijkstraStrategy;
import nl.nickhartjes.han.asd.adpp.graph.search.SearchStrategy;

import java.util.HashMap;

public class Graph<T> {

    private String name;
    private GraphWeight weighted;
    private GraphDirection graphDirection;
    private SearchStrategy searchStrategy;

    private HashMap<T, GraphVertex<T>> adjacencyList = new HashMap<>();

    public Graph(String name) {
        this(name, GraphDirection.UNDIRECTED, GraphWeight.UNWEIGHTED);
    }

    public Graph(String name, GraphDirection graphDirection, GraphWeight graphWeight) {
        this.name = name;
        this.graphDirection = graphDirection;
        this.weighted = graphWeight;
        this.searchStrategy = new DijkstraStrategy<T>();
    }

    @SafeVarargs
    public final void addVertex(T... vertexes) {
        for (T vertex : vertexes) {
            this.adjacencyList.put(vertex, new GraphVertex<T>(vertex));
        }
    }

    public void addEdge(T sourceVertex, T destinationVertex) {
        if (weighted == GraphWeight.WEIGHTED)
            throw new IllegalArgumentException("You need to add weight to the Edge");
        this.addEdgeToAdjecencylist(sourceVertex, destinationVertex, 1d);
    }

    public void addEdge(T sourceVertex, T destinationVertex, Double weight) {
        if (this.weighted == GraphWeight.UNWEIGHTED)
            throw new IllegalArgumentException("You can't add weight to an unweigthed graph");
        this.addEdgeToAdjecencylist(sourceVertex, destinationVertex, weight);
    }

    public HashMap<T, GraphVertex<T>> getAdjacencyList() {
        return adjacencyList;
    }

    public GraphWeight getWeighted() {
        return weighted;
    }

    public GraphDirection getGraphDirection() {
        return graphDirection;
    }

    private void addEdgeToAdjecencylist(T sourceVertex, T destinationVertex, Double weight) {
        if (!this.adjacencyList.containsKey(sourceVertex))
            throw new IllegalArgumentException("The source vertex doesnt exist in this graph");

        if (!this.adjacencyList.containsKey(destinationVertex))
            throw new IllegalArgumentException("The destination vertex doesnt exist in this graph");

        if (sourceVertex.equals(destinationVertex))
            throw new IllegalArgumentException("A Vertex can't connect to itself");

        GraphVertex<T> sourceGraphVertex = this.adjacencyList.get(sourceVertex);
        GraphVertex<T>  destinationGraphVertex = this.adjacencyList.get(destinationVertex);
        GraphEdge<T> edge = new GraphEdge<>(sourceGraphVertex, destinationGraphVertex, weight);
        sourceGraphVertex.setEdge(edge);

        if (graphDirection == GraphDirection.UNDIRECTED) {
            GraphEdge<T> redirectEdge = new GraphEdge<>(destinationGraphVertex, sourceGraphVertex, weight);
            destinationGraphVertex.setEdge(redirectEdge);
        }
    }

    public GraphPath<T> searchShortestPath(T sourceVertex, T destinationVertex) {
        return this.searchStrategy.searchShortestPath(this, sourceVertex, destinationVertex);
    }

}
