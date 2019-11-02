package nl.nickhartjes.han.asd.adpp.sort;

import nl.nickhartjes.han.asd.adpp.sort.pivot.MedianOfThreePivot;
import nl.nickhartjes.han.asd.adpp.sort.pivot.MiddlePivot;
import nl.nickhartjes.han.asd.adpp.sort.pivot.RandomPivot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GenericQuickSortTest extends SortTest {

    private GenericQuickSort<Integer> instance;

    @BeforeEach
    void setUp() {
        this.instance = new GenericQuickSort<>();
    }

    @Test
    void sort_EmptyArraySort_ThrowException() {
        Integer[] sortArray = {};
        Assertions.assertThrows(IllegalStateException.class, () -> this.instance.sort(sortArray));
    }

    @Test
    void sort_CheckArraySortSize_Successful() {
        Integer[] toSortArray = {11, 5, 6, 123, 87, 12, 22};
        Integer[] sortedArray = this.instance.sort(toSortArray);
        assertEquals(toSortArray.length, sortedArray.length);
        assertEquals(5, toSortArray[0]);
        assertEquals(123, toSortArray[6]);
    }

    @Test
    void sort_SortWithMiddlePivot_Successful() {
        Integer[] toSortArray = {11, 5, 6, 123, 87, 12, 22};
        Integer[] sortedArray = this.instance.sort(toSortArray, new MiddlePivot<>());
        assertEquals(toSortArray.length, sortedArray.length);
        assertEquals(5, toSortArray[0]);
        assertEquals(123, toSortArray[6]);
    }

    @Test
    void sort_SortWithRandomPivot_Successful() {
        Integer[] toSortArray = {11, 5, 6, 123, 87, 12, 22};
        Integer[] sortedArray = this.instance.sort(toSortArray, new RandomPivot<>());
        assertEquals(toSortArray.length, sortedArray.length);
        assertEquals(5, toSortArray[0]);
        assertEquals(123, toSortArray[6]);
    }

    @Test
    void sort_SortWithMedianOfThreePivot_Successful() {
        Integer[] toSortArray = {11, 5, 6, 123, 87, 12, 22};
        Integer[] sortedArray = this.instance.sort(toSortArray, new MedianOfThreePivot<>());
        assertEquals(toSortArray.length, sortedArray.length);
        assertEquals(5, toSortArray[0]);
        assertEquals(123, toSortArray[6]);
    }

    @Test
    void sort_SortAllEquals_Successful() {
        Integer[] toSortArray = {11, 11, 11, 11, 11, 11, 11};
        Integer[] sortedArray = this.instance.sort(toSortArray);
        assertEquals(toSortArray.length, sortedArray.length);
        assertEquals(11, toSortArray[0]);
        assertEquals(11, toSortArray[6]);
    }

    @Test
    void sort_SortAllReverseOrder_Successful() {
        Integer[] toSortArray = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        Integer[] sortedArray = this.instance.sort(toSortArray);
        assertEquals(toSortArray.length, sortedArray.length);
        assertEquals(1, toSortArray[0]);
        assertEquals(10, toSortArray[9]);
    }

    @Test
    void sort_SortArrayWithMaxAndMinIntValue_Successful() {
        Integer[] toSortArray = {2147483647, 2, 3, 4, 5, 6, -2147483647};
        Integer[] sortedArray = this.instance.sort(toSortArray);
        assertEquals(toSortArray.length, sortedArray.length);
        assertEquals(-2147483647, toSortArray[0]);
        assertEquals(2147483647, toSortArray[6]);
    }

    @Test
    void sort_SortArrayWithOnlyOneValue_Successful() {
        Integer[] toSortArray = {2147483647};
        Integer[] sortedArray = this.instance.sort(toSortArray);
        assertEquals(toSortArray.length, sortedArray.length);
        assertEquals(2147483647, toSortArray[0]);
    }

}
