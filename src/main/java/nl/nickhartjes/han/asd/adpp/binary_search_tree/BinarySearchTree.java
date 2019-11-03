package nl.nickhartjes.han.asd.adpp.binary_search_tree;

public class BinarySearchTree<T extends Comparable<T>> {

    private Node<T> root;


    @SafeVarargs
    public final void insert(T... values) {
        for (T value : values) {
            this.insert(value);
        }
    }

    public void insert(T value) {
        Node<T> newNode = new Node<>(value);

        // Set the root node on first insert.
        if (this.root == null) {
            this.root = newNode;
            return;
        }

        Node<T> current = this.root;
        Node<T> parent = null;

        while (true) {
            parent = current;
            if (current.getValue().compareTo(value) < 0) {
                current = current.getLeft();
                if (current == null) {
                    parent.setLeft(newNode);
                    return;
                }
            } else {
                current = current.getRight();
                if (current == null) {
                    parent.setRight(newNode);
                    return;
                }
            }
        }
    }

    public String displayTree() {
        return this.display(this.root);
    }

    public String display(Node<T> node) {
        StringBuilder sb = new StringBuilder();
        if (node != null) {
            sb.append("(");
            sb.append(display(node.getLeft()));
            sb.append(" ").append(node.toString());
            sb.append(display(node.getRight()));
            sb.append(")");
        }
        return sb.toString();
    }

    public T search(T valueToSearch) {
        Node<T> value = this.searchInSubtree(this.root, valueToSearch);
        if (value == null || value.getValue() == null)
            throw new IllegalStateException("No nodes found to search");
        else
            return value.getValue();
    }

    /**
     * Search for a Node in subtree with a pre-order traversal algorithm
     *
     * @param subtreeRoot
     * @param valueToSearch
     * @return
     */
    public Node<T> searchInSubtree(Node<T> subtreeRoot, T valueToSearch) {
        if (subtreeRoot == null || subtreeRoot.getValue().compareTo(valueToSearch) == 0)
            return subtreeRoot;

        if (subtreeRoot.getValue().compareTo(valueToSearch) < 0)
            return searchInSubtree(subtreeRoot.getLeft(), valueToSearch);

        return searchInSubtree(subtreeRoot.getRight(), valueToSearch);
    }

    /**
     * Find the maximal value in the binary search tree
     *
     * @return The maximal value found in the binary search tree
     */
    public T findMax() {
        return this.find(Find.MAX);
    }

    /**
     * Find the minimal value in the binary search tree
     *
     * @return The minimal value found in the binary search tree
     */
    public T findMin() {
        return this.find(Find.MIN);
    }

    private T find(Find find) {
        Node<T> value = this.findInSubtree(this.root, find);
        if (value == null || value.getValue() == null)
            throw new IllegalStateException("No nodes found to search");
        else
            return value.getValue();
    }

    private Node<T> findInSubtree(Node<T> node, Find findOption) {
        if (node == null || node.getValue() == null)
            return null;

        Node<T> leftNode = findInSubtree(node.getLeft(), findOption);
        Node<T> rightNode = findInSubtree(node.getRight(), findOption);

        if (findOption == Find.MAX) {
            if (rightNode != null && rightNode.getValue().compareTo(node.getValue()) > 0)
                return rightNode;
            if (leftNode != null && leftNode.getValue().compareTo(node.getValue()) > 0)
                return leftNode;
        } else if (findOption == Find.MIN) {
            if (rightNode != null && rightNode.getValue().compareTo(node.getValue()) < 0)
                return rightNode;
            if (leftNode != null && leftNode.getValue().compareTo(node.getValue()) < 0)
                return leftNode;
        }
        return node;
    }

    public void remove(T valueToRemove) {
        this.removeRecursive(this.root, valueToRemove);
    }

    private Node<T> removeRecursive(Node<T> subtreeRoot, T valueToRemove) {

        // Return if empty
        if (subtreeRoot == null) return subtreeRoot;

        // Recurse down the tree
        if (valueToRemove.compareTo(subtreeRoot.getValue()) > 0)
            subtreeRoot.setLeft(this.removeRecursive(subtreeRoot.getLeft(), valueToRemove));
        else if (valueToRemove.compareTo(subtreeRoot.getValue()) < 0)
            subtreeRoot.setRight(this.removeRecursive(subtreeRoot.getRight(), valueToRemove));

        else {

            if (subtreeRoot.getLeft() == null)
                return subtreeRoot.getRight();
            else if (subtreeRoot.getRight() == null)
                return subtreeRoot.getLeft();

            subtreeRoot.setValue(getMinimalValue(subtreeRoot.getRight()));
            subtreeRoot.setRight(removeRecursive(subtreeRoot.getRight(), subtreeRoot.getValue()));

        }
        return subtreeRoot;
    }

    private T getMinimalValue(Node<T> root) {
        T minimalValue = root.getValue();
        while (root.getLeft() != null) {
            minimalValue = root.getLeft().getValue();
            root = root.getLeft();
        }
        return minimalValue;
    }
}
