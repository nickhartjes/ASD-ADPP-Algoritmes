package nl.nickhartjes.han.asd.adpp.graph;

import nl.nickhartjes.han.asd.adpp.graph.search.DijkstraStrategy;
import nl.nickhartjes.han.asd.adpp.graph.search.SearchStrategy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Graph<T> {

    private String name;
    private GraphWeight weighted;
    private GraphDirection graphDirection;
    private SearchStrategy searchStrategy;

    private Map<T, LinkedList<Edge>> adjacencyList = new HashMap<>();

    public Graph(String name) {
        this(name, GraphDirection.UNDIRECTED, GraphWeight.UNWEIGHTED);
    }

    public Graph(String name, GraphDirection graphDirection, GraphWeight graphWeight) {
        this.name = name;
        this.graphDirection = graphDirection;
        this.weighted = graphWeight;
        this.searchStrategy = new DijkstraStrategy<T>();
    }

    public void addVertex(T vertex) {
        LinkedList<Edge> vertexList = new LinkedList<>();
        adjacencyList.put(vertex, vertexList);
    }

    public void addEdge(T sourceVertex, T destinationVertex) {
        if (weighted == GraphWeight.WEIGHTED) {
            throw new IllegalArgumentException("You need to add weight to the Edge");
        }

        this.addEdge(sourceVertex, destinationVertex, null);
    }

    public void addEdge(T sourceVertex, T destinationVertex, Double weight) {
        if (weighted == GraphWeight.UNWEIGHTED && weight != null) {
            throw new IllegalArgumentException("You can't add weight to an unweigthed graph");
        }
        if (!adjacencyList.containsKey(sourceVertex))
            throw new IllegalArgumentException("The source vertex doesnt exist in this graph");

        if (!adjacencyList.containsKey(destinationVertex))
            throw new IllegalArgumentException("The destination vertex doesnt exist in this graph");

        if (sourceVertex.equals(destinationVertex))
            throw new IllegalArgumentException("A Vertex can't connect to itself");

        // If unweigted set all to 1
        if (weighted == GraphWeight.UNWEIGHTED)
            weight = 1d;

        LinkedList<Edge> sourceEdges = adjacencyList.get(sourceVertex);
        sourceEdges.add(new Edge<T>(sourceVertex, destinationVertex, weight));
        adjacencyList.replace(sourceVertex, sourceEdges);

        if (graphDirection == GraphDirection.UNDIRECTED) {
            LinkedList<Edge> destinationEdges = adjacencyList.get(destinationVertex);
            destinationEdges.add(new Edge<T>(destinationVertex, sourceVertex, weight));
            adjacencyList.replace(destinationVertex, destinationEdges);
        }
    }

    public void searchShortestPath(T sourceVertex, T destinationVertex) {
        this.searchStrategy.searchShortestPath(adjacencyList, sourceVertex, destinationVertex);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Graph ").append(name).append(" {").append("\n");

        adjacencyList.forEach((k, v) -> {
            str.append("    ");
            str.append(k.toString()).append(" : ");
            for (Edge edge : v) {
                str.append(" -> ");
                str.append(edge.toString());
            }
            str.append("\n");
        });
        str.append("}");
        return str.toString();
    }
}
