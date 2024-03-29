package nl.nickhartjes.han.asd.adpp;

import nl.nickhartjes.han.asd.adpp.binary_search_tree.BinarySearchTree;
import nl.nickhartjes.han.asd.adpp.graph.Graph;
import nl.nickhartjes.han.asd.adpp.graph.GraphDirection;
import nl.nickhartjes.han.asd.adpp.graph.GraphWeight;
import nl.nickhartjes.han.asd.adpp.models.Student;
import nl.nickhartjes.han.asd.adpp.sort.GenericQuickSort;
import nl.nickhartjes.han.asd.adpp.sort.InsertionSort;
import nl.nickhartjes.han.asd.adpp.sort.MergeSort;
import nl.nickhartjes.han.asd.adpp.sort.QuickSort;
import nl.nickhartjes.han.asd.adpp.sort.pivot.MedianOfThreePivot;
import nl.nickhartjes.han.asd.adpp.sort.pivot.MiddlePivot;
import nl.nickhartjes.han.asd.adpp.sort.pivot.RandomPivot;
import nl.nickhartjes.han.asd.adpp.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    private int[] intArray;
    private Integer[] integerArray;
    private Character[] characterArray;
    private Character[] graphCharacterArray;
    private Student[] studentArray;

    public static void main(String... args) {
        Main main = new Main();
        main.testSort();
        main.testGraph();
        main.testBinaryTree();
    }

    private void initializeData() {
        logger.info("---");

        this.integerArray = new Integer[]{
                21, 9, 75, 77, 48, 12, 91, 73, 84, 57, 97, 23, 9, 94, 91, 80, 4, 46, 73, 92, 22, 91, 84, 40,
                6, 61, 64, 90, 42, 6, 72, 54, 54, 30, 79, 3, 78, 88, 54, 22, 16, 70, 18, 15, 45, 33, 23, 81,
                71, 2, 55, 86, 37, 97, 76, 41, 54, 29, 28, 34, 36, 100, 77, 94, 91, 41, 91, 16, 65, 34, 97,
                32, 75, 76, 73, 79, 39, 78, 92, 60, 64, 50, 65, 93, 64, 65, 66, 13, 33, 22, 55, 10, 51, 31,
                29, 96, 11, 21, 23, 43
        };
        this.intArray = Arrays.stream(this.integerArray)
                .mapToInt(Integer::intValue)
                .toArray();

        this.characterArray = new Character[]{
                'L', 'f', 'e', 'C', 'f', 'J', 'L', 'z', 'X', 's', 'Z', 'V', 'Z', 'E', 'd', 'X', 'f', 'H', 'P',
                'y', 'V', 'f', 'd', 'M', 'o', 'V', 'p', 'o', 'S', 'k', 'g', 'u', 'J', 'P', 'k', 'f', 'c', 'G',
                'i', 'f'
        };

        this.graphCharacterArray = new Character[]{
                'a', 'b', 'c', 'd', 'e', 'f'
        };

        var marc = new Student(527698, "Marc", "Groenhout");
        var joey = new Student(609590, "Joey", "Stoppels");
        var nick = new Student(423064, "Nick", "Hartjes");
        this.studentArray = new Student[]{marc, joey, nick};
    }

    private void testSort() {

        logger.info("--- Start Sort ---");
        this.initializeData();
        var runInsertion = new InsertionSort();
        logger.info("--- Start Insertions sort ---");
        logger.info("Before: {}", this.intArray);
        logger.info("After: {}", runInsertion.sort(this.intArray));
        logger.info("--- End Insertions sort ---");

        this.initializeData();
        var runMerge = new MergeSort();
        logger.info("--- Start merge sort ---");
        logger.info("Before: {}", this.intArray);
        logger.info("After: {}", runMerge.sort(this.intArray));
        logger.info("--- End merge sort ---");

        this.initializeData();
        var quickSort = new QuickSort();
        logger.info("--- Start quick sort ---");
        logger.info("Before: {}", this.intArray);
        logger.info("After: {}", quickSort.sort(this.intArray));
        this.initializeData();
        logger.info("Before: {}", this.intArray);
        logger.info("After: {}", quickSort.sort(this.intArray, true));
        logger.info("--- End quick sort ---");

//        this.initializeData();
//        var quickMergeCharacter = new GenericQuickSort<Character>();
//        Util.printArray(quickMergeCharacter.sort(this.characterArray, new RandomPivot<>()));
//        Util.printArray(quickMergeCharacter.sort(this.characterArray, new MedianOfThreePivot<>()));

        this.initializeData();
        var quickSortCharacter = new GenericQuickSort<Character>();
        logger.info("--- Start generic quick sort ---");
        logger.info("Before: {}", Util.printArray(this.characterArray));
        logger.info("After MiddlePivot : {}", Util.printArray(quickSortCharacter.sort(this.characterArray, new MiddlePivot<>())));
        this.initializeData();
        logger.info("After RandomPivot: {}", Util.printArray(quickSortCharacter.sort(this.characterArray, new RandomPivot<>())));
        this.initializeData();
        logger.info("After MOTPivot: {}", Util.printArray(quickSortCharacter.sort(this.characterArray, new MedianOfThreePivot<>())));
        logger.info("--- End merge sort ---");

        var quickSortStudents = new GenericQuickSort<Student>();
        logger.info("--- Start generic quick sort ---");
        logger.info("Before: {}", Util.printArray(this.studentArray));
        logger.info("After MiddlePivot : {}", Util.printArray(quickSortStudents.sort(this.studentArray, new MiddlePivot<>())));
        this.initializeData();
        logger.info("After RandomPivot: {}", Util.printArray(quickSortStudents.sort(this.studentArray, new RandomPivot<>())));
        this.initializeData();
        logger.info("After MOTPivot: {}", Util.printArray(quickSortStudents.sort(this.studentArray, new MedianOfThreePivot<>())));
        logger.info("--- End merge sort ---");

        logger.info("--- End Sort ---");
    }

    private void testGraph() {
        this.initializeData();

        logger.info("--- Start Graph ---");
        Graph<Character> route01 = new Graph<>();
        route01.addVertex(this.graphCharacterArray);
        route01.addEdge('a', 'b');
        route01.addEdge('c', 'b');
        route01.addEdge('a', 'c');
        logger.info("Graph 01: {}", route01);

        Graph<Character> route02 =
                new Graph<>(GraphDirection.DIRECTED, GraphWeight.UNWEIGHTED);
        route02.addVertex(this.graphCharacterArray);
        route02.addEdge('a', 'b');
        route02.addEdge('c', 'b');
        route02.addEdge('a', 'c');
        logger.info("Graph 02: {}", route02);

        Graph<Character> route03 = new Graph<>(GraphDirection.DIRECTED, GraphWeight.WEIGHTED);
        route03.addVertex(this.graphCharacterArray);
        route03.addEdge('a', 'b', 8);
        route03.addEdge('c', 'b', 3);
        route03.addEdge('a', 'c', 6);
        route03.addEdge('c', 'd', 4);
        route03.addEdge('d', 'e', 7);
        route03.addEdge('e', 'a', 2);
        logger.info("Graph 03: {}", route03);
        logger.info("Graph 03: shortestpath {}", route03.searchShortestPath('a', 'e'));

        Graph<Character> route04 =
                new Graph<>(GraphDirection.UNDIRECTED, GraphWeight.WEIGHTED);
        route04.addVertex(this.graphCharacterArray);
        route04.addEdge('a', 'b', 8);
        route04.addEdge('c', 'b', 3);
        route04.addEdge('a', 'c', 6);
        route04.addEdge('c', 'd', 4);
        route04.addEdge('d', 'e', 7);
        route04.addEdge('e', 'a', 2);
        logger.info("Graph 04: shortestpath {}", route04.searchShortestPath('a', 'e'));

        Graph<Character> route05 =
                new Graph<>(GraphDirection.DIRECTED, GraphWeight.UNWEIGHTED);
        route05.addVertex(this.graphCharacterArray);
        route05.addEdge('a', 'b');
        route05.addEdge('c', 'b');
        route05.addEdge('a', 'c');
        route05.addEdge('c', 'd');
        route05.addEdge('d', 'e');
        route05.addEdge('e', 'a');
        logger.info("Graph 05: shortestpath {}", route05.searchShortestPath('a', 'e'));

        logger.info("--- End Graph ---");
    }

    private void testBinaryTree() {
        this.initializeData();

        logger.info("--- Start BinaryTree ---");
        BinarySearchTree<Integer> binarySearchTree01 = new BinarySearchTree<>();
        binarySearchTree01.insert(10);
        binarySearchTree01.insert(15);
        binarySearchTree01.insert(11);
        binarySearchTree01.insert(8);
        binarySearchTree01.insert(2);
        binarySearchTree01.insert(1);
        // or
        binarySearchTree01.insert(3, 2, 4, 2, 77, 3, 213423, 34, 223, 443, -33);

        logger.info("Tree {}", binarySearchTree01.displayTree());
        Integer node = binarySearchTree01.search(2);
        logger.info("Find {}", node);
        Integer node1 = binarySearchTree01.findMax();
        logger.info("FindMax {}", node1);
        Integer node2 = binarySearchTree01.findMin();
        logger.info("FindMin {}", node2);

        logger.info("Tree before remove 213423: {}", binarySearchTree01.displayTree());
        binarySearchTree01.remove(213423);
        logger.info("Tree after remove 213423: {}", binarySearchTree01.displayTree());

        logger.info("Tree before remove 10: {}", binarySearchTree01.displayTree());
        binarySearchTree01.remove(10);
        logger.info("Tree after remove 10: {}", binarySearchTree01.displayTree());
        logger.info("--- End BinaryTree ---");
    }
}
