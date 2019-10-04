package nl.nickhartjes.han.asd.adpp;

import nl.nickhartjes.han.asd.adpp.binary_search_tree.BinarySearchTree;
import nl.nickhartjes.han.asd.adpp.binary_search_tree.Node;

class Main {

    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree01 = new BinarySearchTree<>();
        binarySearchTree01.insert(10);
        binarySearchTree01.insert(15);
        binarySearchTree01.insert(11);
        binarySearchTree01.insert(8);
        binarySearchTree01.insert(2);
        binarySearchTree01.insert(1);
        binarySearchTree01.insert(3,2,4,2,77,3,213423,34,223,443, -33);

        binarySearchTree01.displayTree();
        Integer node = binarySearchTree01.search(2);
        Integer node1 = binarySearchTree01.findMax();
        Integer node2 = binarySearchTree01.findMin();
        System.out.println(node);
    }
}
