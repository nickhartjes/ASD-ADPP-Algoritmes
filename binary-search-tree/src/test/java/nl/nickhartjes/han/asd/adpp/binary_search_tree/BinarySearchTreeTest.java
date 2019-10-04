package nl.nickhartjes.han.asd.adpp.binary_search_tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BinarySearchTreeTest {

    private BinarySearchTree<Integer> instance;

    @BeforeEach
    void initTest() {
        this.instance = new BinarySearchTree<>();
    }

    @Test
    void insertNode_Test() {
        this.instance.insert(10);
        assertEquals(10, this.instance.search(10));
        this.instance.insert(11);
        assertEquals(11, this.instance.search(11));
    }

    @Test
    void insertMultipleNodes_Test() {
        this.instance.insert(10, 11, 5);
        assertEquals(10, this.instance.search(10));
        assertEquals(11, this.instance.search(11));
        assertEquals(5, this.instance.search(5));
    }

    @Test
    void searchNode_Test() {
        this.instance.insert(60, 23, 44, 22, 344, 442, 500);
        assertEquals(344, this.instance.search(344));
    }

    @Test
    void findMax_Test() {
        this.instance.insert(60, 23, 44, 22, 344, 442, 500);
        assertEquals(500, this.instance.findMax());
    }

    @Test
    void findMin_Test() {
        this.instance.insert(60, 23, 44, 22, 344, 442, 500);
        assertEquals(22, this.instance.findMin());
    }

    @Test
    void emptyFind_ThrowExecption_Test() {
        Assertions.assertThrows(IllegalStateException.class, () -> this.instance.search(344));
    }

    @Test
    void emptyFindMax_ThrowExecption_Test() {
        Assertions.assertThrows(IllegalStateException.class, () -> this.instance.findMax());
    }

    @Test
    void emptyFindMin_ThrowExecption_Test() {
        Assertions.assertThrows(IllegalStateException.class, () -> this.instance.findMin());
    }
}
