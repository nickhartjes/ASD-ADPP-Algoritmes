package nl.nickhartjes.han.asd.adpp.graph;

import nl.nickhartjes.han.asd.adpp.graph.search.DijkstraStrategy;
import nl.nickhartjes.han.asd.adpp.graph.search.SearchStrategy;

import java.util.HashMap;
import java.util.Map;

public class Graph<T> {

    private GraphWeight weighted;
    private GraphDirection graphDirection;
    private SearchStrategy searchStrategy;

    private HashMap<T, GraphVertex<T>> adjacencyList = new HashMap<>();

    public Graph() {
        this(GraphDirection.UNDIRECTED, GraphWeight.UNWEIGHTED);
    }

    public Graph(GraphDirection graphDirection, GraphWeight graphWeight) {
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

    public Map<T, GraphVertex<T>> getAdjacencyList() {
        return adjacencyList;
    }

    public GraphWeight getWeighted() {
        return weighted;
    }

    private void addEdgeToAdjecencylist(T sourceVertex, T destinationVertex, Double weight) {
        if (!this.adjacencyList.containsKey(sourceVertex))
            throw new IllegalArgumentException("The source vertex doesnt exist in this graph");

        if (!this.adjacencyList.containsKey(destinationVertex))
            throw new IllegalArgumentException("The destination vertex doesnt exist in this graph");

        if (sourceVertex.equals(destinationVertex))
            throw new IllegalArgumentException("A Vertex can't connect to itself");

        GraphVertex<T> sourceGraphVertex = this.adjacencyList.get(sourceVertex);
        GraphVertex<T> destinationGraphVertex = this.adjacencyList.get(destinationVertex);
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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        stringBuilder.append("Graph {\n");
        for (Map.Entry<T, GraphVertex<T>> entry : this.getAdjacencyList().entrySet()) {
            stringBuilder.append("\t");
            stringBuilder.append(entry.getKey());
            stringBuilder.append(" -->  ");
            for (GraphEdge edge : entry.getValue().getEdges()) {
                stringBuilder.append("(");
                stringBuilder.append(edge.getDestination());
                if (this.getWeighted() == GraphWeight.WEIGHTED) {
                    stringBuilder.append(", ");
                    stringBuilder.append(edge.getWeight());
                }
                stringBuilder.append(") ");
            }
            stringBuilder.append("\n");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
