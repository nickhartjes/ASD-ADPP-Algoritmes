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

    public void addVertex(T... vertexes) {
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

    private void addEdgeToAdjecencylist(T sourceVertex, T destinationVertex, Double weight) {
        if (!this.adjacencyList.containsKey(sourceVertex))
            throw new IllegalArgumentException("The source vertex doesnt exist in this graph");

        if (!this.adjacencyList.containsKey(destinationVertex))
            throw new IllegalArgumentException("The destination vertex doesnt exist in this graph");

        if (sourceVertex.equals(destinationVertex))
            throw new IllegalArgumentException("A Vertex can't connect to itself");

        GraphVertex sourceGraphVertex = this.adjacencyList.get(sourceVertex);
        GraphVertex destinationGraphVertex = this.adjacencyList.get(destinationVertex);
        GraphEdge edge = new GraphEdge(sourceGraphVertex, destinationGraphVertex, weight);
        sourceGraphVertex.setEdge(edge);

        if (graphDirection == GraphDirection.UNDIRECTED) {
            GraphEdge redirectEdge = new GraphEdge(destinationGraphVertex, sourceGraphVertex, weight);
            destinationGraphVertex.setEdge(redirectEdge);
        }
    }

    public void searchShortestPath(T sourceVertex, T destinationVertex) {
        this.searchStrategy.searchShortestPath(adjacencyList, sourceVertex, destinationVertex);
        this.resetVertexVisited();
    }

    public void resetVertexVisited() {
        for (T key : this.adjacencyList.keySet()) {
            this.adjacencyList.get(key).unsetVisit();
        }
    }

//    @Override
//    public String toString() {
//        StringBuilder str = new StringBuilder();
//        str.append("Graph ").append(name).append(" {").append("\n");
//
//        adjacencyList.forEach((k, v) -> {
//            str.append("    ");
//            str.append(k.toString()).append(" : ");
//            for (Edge edge : v) {
//                str.append(" -> ");
//                str.append(edge.toString());
//            }
//            str.append("\n");
//        });
//        str.append("}");
//        return str.toString();
//    }
}
