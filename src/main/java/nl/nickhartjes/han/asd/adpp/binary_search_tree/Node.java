package nl.nickhartjes.han.asd.adpp.binary_search_tree;

public class Node<T extends Comparable<T>> {

    private T value;
    private Node<T> left;
    private Node<T> right;

    Node(T value) {
        this.value = value;
    }

    T getValue() {
        return value;
    }

    Node<T> getLeft() {
        return left;
    }

    void setLeft(Node<T> left) {
        this.left = left;
    }

    Node<T> getRight() {
        return right;
    }

    void setRight(Node<T> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return  value.toString();
    }
}
