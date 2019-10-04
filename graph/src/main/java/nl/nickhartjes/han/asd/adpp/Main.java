package nl.nickhartjes.han.asd.adpp;

import nl.nickhartjes.han.asd.adpp.graph.Graph;
import nl.nickhartjes.han.asd.adpp.graph.GraphDirection;
import nl.nickhartjes.han.asd.adpp.graph.GraphWeight;

class Main {

    public static void main(String[] args) {

        Graph<String> route01 = new Graph<>("Route 01");
        route01.addVertex("a");
        route01.addVertex("b");
        route01.addVertex("c");
        route01.addVertex("d");
        route01.addVertex("e");
        route01.addVertex("f");

        route01.addEdge("a", "b");
        route01.addEdge("c", "b");
        route01.addEdge("a", "c");
        System.out.println(route01.toString());


        Graph<String> route02 = new Graph<>("Route 02", GraphDirection.DIRECTED, GraphWeight.UNWEIGHTED);
        route02.addVertex("a");
        route02.addVertex("b");
        route02.addVertex("c");
        route02.addVertex("d");
        route02.addVertex("e");
        route02.addVertex("f");

        route02.addEdge("a", "b");
        route02.addEdge("c", "b");
        route02.addEdge("a", "c");
        System.out.println(route02.toString());

        Graph<String> route03 = new Graph<>("Route 03", GraphDirection.DIRECTED, GraphWeight.WEIGHTED);
        route03.addVertex("a");
        route03.addVertex("b");
        route03.addVertex("c");
        route03.addVertex("d");
        route03.addVertex("e");
        route03.addVertex("f");

        route03.addEdge("a", "b", 8.1);
        route03.addEdge("c", "b", 3.4);
        route03.addEdge("a", "c", 6.1);

        route03.searchShortestPath("a", "c");
        System.out.println(route03.toString());
    }
}
