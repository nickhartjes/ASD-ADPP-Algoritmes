package nl.nickhartjes.han.asd.adpp;

import nl.nickhartjes.han.asd.adpp.binary_search_tree.BinarySearchTree;
import nl.nickhartjes.han.asd.adpp.graph.Graph;
import nl.nickhartjes.han.asd.adpp.graph.GraphDirection;
import nl.nickhartjes.han.asd.adpp.graph.GraphWeight;
import nl.nickhartjes.han.asd.adpp.models.Student;
import nl.nickhartjes.han.asd.adpp.sort.*;
import nl.nickhartjes.han.asd.adpp.sort.pivot.MedianOfThreePivot;
import nl.nickhartjes.han.asd.adpp.sort.pivot.MiddlePivot;
import nl.nickhartjes.han.asd.adpp.sort.pivot.RandomPivot;

import static nl.nickhartjes.han.asd.adpp.util.Util.*;

class Main {

  public static void main(String... args) {
    Main main = new Main();
            main.testSort();
//    main.testGraph();
    //        main.testBinaryTree();
  }

  public void testGraph() {
    Graph<String> route01 = new Graph<>("Route 01");
    route01.addVertex("a", "b", "c", "d", "e", "f");

    route01.addEdge("a", "b");
    route01.addEdge("c", "b");
    route01.addEdge("a", "c");
    System.out.println(route01.toString());

    Graph<String> route02 =
        new Graph<>("Route 02", GraphDirection.DIRECTED, GraphWeight.UNWEIGHTED);
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

    Graph<String> route04 =
        new Graph<>("Route 04", GraphDirection.UNDIRECTED, GraphWeight.WEIGHTED);
    route04.addVertex("a", "b", "c", "d", "e", "f");
    route04.addEdge("a", "b", 8.1);
    route04.addEdge("c", "b", 3.4);
    route04.addEdge("a", "c", 6.1);
    route04.addEdge("c", "d", 4.5);
    route04.addEdge("d", "e", 7.4);
    route04.addEdge("e", "a", 2.2);
    System.out.println(route04.searchShortestPath("a", "e").toString());

    Graph<String> route05 =
        new Graph<>("Route 03", GraphDirection.DIRECTED, GraphWeight.UNWEIGHTED);
    route05.addVertex("a", "b", "c", "d", "e", "f");
    route05.addEdge("a", "b");
    route05.addEdge("c", "b");
    route05.addEdge("a", "c");
    route05.addEdge("c", "d");
    route05.addEdge("d", "e");
    route05.addEdge("e", "a");
    System.out.println(route05.searchShortestPath("a", "e").toString());
  }

  public void testSort() {
    int[] array01 = {12, 123, 123, 334, 52, 1, 13, 655, 66};
    int[] array02 = {
      21, 9, 75, 77, 48, 12, 91, 73, 84, 57, 97, 23, 9, 94, 91, 80, 4, 46, 73, 92, 22, 91, 84, 40,
      6, 61, 64, 90, 42, 6, 72, 54, 54, 30, 79, 3, 78, 88, 54, 22, 16, 70, 18, 15, 45, 33, 23, 81,
      71, 2, 55, 86, 37, 97, 76, 41, 54, 29, 28, 34, 36, 100, 77, 94, 91, 41, 91, 16, 65, 34, 97,
      32, 75, 76, 73, 79, 39, 78, 92, 60, 64, 50, 65, 93, 64, 65, 66, 13, 33, 22, 55, 10, 51, 31,
      29, 96, 11, 21, 23, 43
    };
    Character[] array03 = {
      'L', 'f', 'e', 'C', 'f', 'J', 'L', 'z', 'X', 's', 'Z', 'V', 'Z', 'E', 'd', 'X', 'f', 'H', 'P',
      'y', 'V', 'f', 'd', 'M', 'o', 'V', 'p', 'o', 'S', 'k', 'g', 'u', 'J', 'P', 'k', 'f', 'c', 'G',
      'i', 'f'
    };

    var marc = new Student(527698, "Marc", "Groenhout");
    var joey = new Student(609590, "Joey", "Stoppels");
    var nick = new Student(423064, "Nick", "Hartjes");
    Student[] array04 = {marc, joey, nick};

    var runInsertion = new InsertionSort();
    printArray(runInsertion.sort(array01));
    printArray(runInsertion.sort(array02));

    var runMerge = new MergeSort();
    printArray(runMerge.sort(array01));
    printArray(runMerge.sort(array02));

    var quickMerge = new QuickSort();
    printArray(quickMerge.sort(array01));
    printArray(quickMerge.sort(array02));

    printArray(quickMerge.sort(array01, true));
    printArray(quickMerge.sort(array02, true));

    var quickMergeCharacter = new GenericQuickSort<Character>();
    printArray(quickMergeCharacter.sort(array03, new MiddlePivot<>()));
    printArray(quickMergeCharacter.sort(array03, new RandomPivot<>()));
    printArray(quickMergeCharacter.sort(array03, new MedianOfThreePivot<>()));

    var quickMergeStudent = new GenericQuickSort<Student>();
    printArray(quickMergeStudent.sort(array04, new MiddlePivot<>()));
    printArray(quickMergeStudent.sort(array04, new RandomPivot<>()));
    printArray(quickMergeStudent.sort(array04, new MedianOfThreePivot<>()));
  }

  private void testBinaryTree() {
    BinarySearchTree<Integer> binarySearchTree01 = new BinarySearchTree<>();
    binarySearchTree01.insert(10);
    binarySearchTree01.insert(15);
    binarySearchTree01.insert(11);
    binarySearchTree01.insert(8);
    binarySearchTree01.insert(2);
    binarySearchTree01.insert(1);
    binarySearchTree01.insert(3, 2, 4, 2, 77, 3, 213423, 34, 223, 443, -33);

    binarySearchTree01.displayTree();
    Integer node = binarySearchTree01.search(2);
    Integer node1 = binarySearchTree01.findMax();
    Integer node2 = binarySearchTree01.findMin();
    System.out.println(node);
  }
}
