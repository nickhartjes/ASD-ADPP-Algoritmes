package nl.nickhartjes.han.asd.adpp.binary_search_tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTreeTest {

    private static final Logger logger = LoggerFactory.getLogger(BinarySearchTreeTest.class);

    private BinarySearchTree<Integer> instance;

    @BeforeEach
    void initTest() {
        this.instance = new BinarySearchTree<>();
    }

    @Test
    void insert_insertNode_Successful() {
        this.instance.insert(10);
        assertEquals(10, this.instance.search(10));
        this.instance.insert(11);
        assertEquals(11, this.instance.search(11));
    }

    @Test
    void insert_insertMultipleNodes_Successful() {
        this.instance.insert(10, 11, 5);
        assertEquals(10, this.instance.search(10));
        assertEquals(11, this.instance.search(11));
        assertEquals(5, this.instance.search(5));
    }

    @Test
    void search_findNode_Successful() {
        this.instance.insert(60, 23, 44, 22, 344, 442, 500);
        assertEquals(344, this.instance.search(344));
    }

    @Test
    void findMax_SearchMaximumValue_Successful() {
        this.instance.insert(60, 23, 44, 22, 344, 442, 500);
        assertEquals(500, this.instance.findMax());
    }

    @Test
    void findMin_FindMinimumValue_Successful() {
        this.instance.insert(60, 23, 44, 22, 344, 442, 500);
        assertEquals(22, this.instance.findMin());
    }

    @Test
    void search_emptyFind_ThrowException() {
        Assertions.assertThrows(IllegalStateException.class, () -> this.instance.search(344));
    }

    @Test
    void findMax_EmptyFindMax_ThrowException() {
        Assertions.assertThrows(IllegalStateException.class, () -> this.instance.findMax());
    }

    @Test
    void findMin_EmptyFindMin_ThrowException() {
        Assertions.assertThrows(IllegalStateException.class, () -> this.instance.findMin());
    }

    @Test
    void remove_RemoveNode_Successful() {
        this.instance.insert(60, 23, 44, 22, 344, 442, 500);
        this.instance.remove(22);
        logger.info("{}", this.instance);
        Assertions.assertThrows(IllegalStateException.class, () -> this.instance.search(22));
    }

    @Test
    void remove_RemoveRootNode_Successful() {
        this.instance.insert(60, 23, 44, 22, 344, 442, 500);
        this.instance.remove(60);
        logger.info("{}", this.instance);
        Assertions.assertThrows(IllegalStateException.class, () -> this.instance.search(60));
    }
}
