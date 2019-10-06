package nl.nickhartjes.han.asd.adpp;

import nl.nickhartjes.han.asd.adpp.graph.Graph;
import nl.nickhartjes.han.asd.adpp.graph.GraphDirection;
import nl.nickhartjes.han.asd.adpp.graph.GraphWeight;

class Main {

    public static void main(String[] args) {

        Graph<String> route01 = new Graph<>("Route 01");
        route01.addVertex("a", "b", "c", "d", "e", "f");

        route01.addEdge("a", "b");
        route01.addEdge("c", "b");
        route01.addEdge("a", "c");
        System.out.println(route01.toString());


        Graph<String> route02 = new Graph<>("Route 02", GraphDirection.DIRECTED, GraphWeight.UNWEIGHTED);
        route02.addVertex("a", "b", "c", "d", "e", "f");

        route02.addEdge("a", "b");
        route02.addEdge("c", "b");
        route02.addEdge("a", "c");
        System.out.println(route02.toString());

        Graph<String> route03 = new Graph<>("Route 03", GraphDirection.DIRECTED, GraphWeight.WEIGHTED);
        route03.addVertex("a", "b", "c", "d", "e", "f");
        route03.addEdge("a", "b", 8.1);
        route03.addEdge("c", "b", 3.4);
        route03.addEdge("a", "c", 6.1);
        route03.addEdge("c", "d", 4.5);
        route03.addEdge("d", "e", 7.4);
        route03.addEdge("e", "a", 2.2);
        System.out.println(route03.searchShortestPath("a", "e").toString());

        Graph<String> route04 = new Graph<>("Route 04", GraphDirection.UNDIRECTED, GraphWeight.WEIGHTED);
        route04.addVertex("a", "b", "c", "d", "e", "f");
        route04.addEdge("a", "b", 8.1);
        route04.addEdge("c", "b", 3.4);
        route04.addEdge("a", "c", 6.1);
        route04.addEdge("c", "d", 4.5);
        route04.addEdge("d", "e", 7.4);
        route04.addEdge("e", "a", 2.2);
        System.out.println(route04.searchShortestPath("a", "e").toString());

        Graph<String> route05 = new Graph<>("Route 03", GraphDirection.DIRECTED, GraphWeight.UNWEIGHTED);
        route05.addVertex("a", "b", "c", "d", "e", "f");
        route05.addEdge("a", "b");
        route05.addEdge("c", "b");
        route05.addEdge("a", "c");
        route05.addEdge("c", "d");
        route05.addEdge("d", "e");
        route05.addEdge("e", "a");
        System.out.println(route05.searchShortestPath("a", "e").toString());

    }
}
