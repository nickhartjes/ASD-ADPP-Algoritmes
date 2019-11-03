package nl.nickhartjes.han.asd.adpp.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GraphTest {

    private static final Logger logger = LoggerFactory.getLogger(GraphTest.class);

    @Test
    void addVertex_AddVerticesToAdjecencyList_Successful() {
        Graph<Integer> graph = new Graph<>();
        graph.addVertex(1, 2, 3);
        assertEquals(3, graph.getAdjacencyList().size());
    }

    @Test
    void addVertex_AddDuplicatedVerticesToAdjecencyList_Successful() {
        Graph<Integer> graph = new Graph<>();
        graph.addVertex(1, 2, 3, 3, 2, 1);
        assertEquals(3, graph.getAdjacencyList().size());
    }

    @Test
    void addEdge_AddEdgeToUnknownSourceVertex_ThrowException() {
        Graph<Integer> graph = new Graph<>();
        graph.addVertex(1, 2, 3);
        Assertions.assertThrows(IllegalArgumentException.class, () -> graph.addEdge(11, 1));
    }

    @Test
    void addEdge_AddEdgeToUnknownDestinationVertex_ThrowException() {
        Graph<Integer> graph = new Graph<>();
        graph.addVertex(1, 2, 3);
        Assertions.assertThrows(IllegalArgumentException.class, () -> graph.addEdge(1, 11));
    }

    @Test
    void addEdge_AddEdgesToVerticesInUndirectedUnweightedGraph_Successful() {
        Graph<Integer> graph = new Graph<>(GraphDirection.UNDIRECTED, GraphWeight.UNWEIGHTED);
        graph.addVertex(1, 2, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        assertEquals(2, graph.getAdjacencyList().get(1).getEdges().size());
        assertEquals(1, graph.getAdjacencyList().get(2).getEdges().size());
        assertEquals(1, graph.getAdjacencyList().get(3).getEdges().size());
    }

    @Test
    void addEdge_AddEdgesToVerticesInDirectedUnweightedGraph_Successful() {
        Graph<Integer> graph = new Graph<>(GraphDirection.DIRECTED, GraphWeight.UNWEIGHTED);
        graph.addVertex(1, 2, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        assertEquals(2, graph.getAdjacencyList().get(1).getEdges().size());
        assertEquals(0, graph.getAdjacencyList().get(2).getEdges().size());
        assertEquals(0, graph.getAdjacencyList().get(3).getEdges().size());
    }

    @Test
    void addEdge_AddEdgesToVerticesInUndirectedWeightedGraph_Successful() {
        Graph<Integer> graph = new Graph<>(GraphDirection.UNDIRECTED, GraphWeight.WEIGHTED);
        graph.addVertex(1, 2, 3);
        graph.addEdge(1, 2, 2.0);
        graph.addEdge(1, 3, 2.0);
        assertEquals(2, graph.getAdjacencyList().get(1).getEdges().size());
        assertEquals(1, graph.getAdjacencyList().get(2).getEdges().size());
        assertEquals(1, graph.getAdjacencyList().get(3).getEdges().size());
    }

    @Test
    void addEdge_AddEdgesToVerticesInDirectedWeightedGraph_Successful() {
        Graph<Integer> graph = new Graph<>(GraphDirection.DIRECTED, GraphWeight.WEIGHTED);
        graph.addVertex(1, 2, 3);
        graph.addEdge(1, 2, 2.0);
        graph.addEdge(1, 3, 2.0);
        assertEquals(2, graph.getAdjacencyList().get(1).getEdges().size());
        assertEquals(0, graph.getAdjacencyList().get(2).getEdges().size());
        assertEquals(0, graph.getAdjacencyList().get(3).getEdges().size());
    }

    @Test
    void addEdge_AddNegativeEdgeToVerticesInDirectedWeightedGraph_Successful() {
        Graph<Integer> graph = new Graph<>(GraphDirection.DIRECTED, GraphWeight.WEIGHTED);
        graph.addVertex(1, 2, 3);
        graph.addEdge(1, 2, -2.0);
        assertEquals(1, graph.getAdjacencyList().get(1).getEdges().size());
        assertEquals(0, graph.getAdjacencyList().get(2).getEdges().size());
    }

    @Test
    void addEdge_AddWeightToAndUnweightedEdge_ThrowException() {
        Graph<Integer> graph = new Graph<>(GraphDirection.DIRECTED, GraphWeight.UNWEIGHTED);
        graph.addVertex(1, 2, 3);
        Assertions.assertThrows(IllegalArgumentException.class, () -> graph.addEdge(1, 2, 2.0));
    }

    @Test
    void addEdge_ForgetWeightToAndWeightedEdge_ThrowException() {
        Graph<Integer> graph = new Graph<>(GraphDirection.DIRECTED, GraphWeight.WEIGHTED);
        graph.addVertex(1, 2, 3);
        Assertions.assertThrows(IllegalArgumentException.class, () -> graph.addEdge(1, 2));
    }

    @Test
    void addEdge_SourceAndDestinationVertexAreEqual_ThrowException() {
        Graph<Integer> graph = new Graph<>();
        graph.addVertex(1, 2, 3);
        Assertions.assertThrows(IllegalArgumentException.class, () -> graph.addEdge(1, 1));
    }

    @Test
    void searchShortestPath_DirectedUnweightedPath_Successful() {
        Graph<Integer> graph = new Graph<>(GraphDirection.DIRECTED, GraphWeight.UNWEIGHTED);
        graph.addVertex(1, 2, 3, 4, 5, 6, 7);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 7);
        graph.addEdge(1, 7);
        GraphPath<Integer> graphPath = graph.searchShortestPath(1, 7);
        // 1 --> 7
        logger.info("{}", graph);
        logger.info("{}", graphPath);
        assertEquals(2, graphPath.getPath().size());
        assertEquals(2, graphPath.getWeight());
    }

    @Test
    void searchShortestPath_UnDirectedUnweightedPath_Successful() {
        Graph<Integer> graph = new Graph<>(GraphDirection.UNDIRECTED, GraphWeight.UNWEIGHTED);
        graph.addVertex(1, 2, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);


        GraphPath<Integer> graphPath = graph.searchShortestPath(1, 3);
        // 1 --> 3
        logger.info("{}", graph);
        logger.info("{}", graphPath);
        assertEquals(2, graphPath.getPath().size());
        assertEquals(2, graphPath.getWeight());
    }

    @Test
    void searchShortestPath_DirectedWeightedPath_Successful() {
        Graph<Integer> graph = new Graph<>(GraphDirection.DIRECTED, GraphWeight.WEIGHTED);
        graph.addVertex(1, 2, 3, 4, 5, 6, 7);
        graph.addEdge(1, 2, 20d);
        graph.addEdge(1, 3, 2d);
        graph.addEdge(3, 7, 10d);
        graph.addEdge(1, 7, 30d);
        GraphPath<Integer> graphPath = graph.searchShortestPath(1, 7);
        // 1 --> 7
        logger.info("{}", graph);
        logger.info("{}", graphPath);
        assertEquals(3, graphPath.getPath().size());
        assertEquals(12, graphPath.getWeight());
    }

    @Test
    void searchShortestPath_UnDirectedWeightedPath_Successful() {
        Graph<Integer> graph = new Graph<>(GraphDirection.UNDIRECTED, GraphWeight.WEIGHTED);
        graph.addVertex(1, 2, 3);
        graph.addEdge(1, 2, 1d);
        graph.addEdge(1, 3, 8d);
        graph.addEdge(2, 3, 2d);


        GraphPath<Integer> graphPath = graph.searchShortestPath(1, 3);
        // 1 --> 3
        logger.info("{}", graph);
        logger.info("{}", graphPath);
        assertEquals(3, graphPath.getPath().size());
        assertEquals(3, graphPath.getWeight());
    }

    @Test
    void searchShortestPath_NoRoute_ThrowException() {
        Graph<Integer> graph = new Graph<>();
        graph.addVertex(1, 2, 3);
        Assertions.assertThrows(IllegalStateException.class, () -> graph.searchShortestPath(1, 7));
    }


}
