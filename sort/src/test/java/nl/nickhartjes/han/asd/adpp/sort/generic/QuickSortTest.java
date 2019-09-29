package nl.nickhartjes.han.asd.adpp.sort.generic;

import nl.nickhartjes.han.asd.adpp.sort.Sort;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.OptionalInt;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class QuickSortTest {

    void emptyArraySort_ThrowExecption_Test(Sort instance) {
        int[] sortArray = {};
        Assertions.assertThrows(IllegalStateException.class, () -> instance.sort(sortArray));
    }

    void checkArraySortSize_AssertEquals_Test(Sort instance) {
        int[] sortArray = {11, 5, 6, 87, 12, 22, 123};
        assertEquals(sortArray.length, instance.sort(sortArray).length);
    }

    void sortAllEquals_AssertEquals_Test(Sort instance) {
        int[] sortArray = {11, 11, 11, 11, 11, 11, 11};
        assertEquals(sortArray.length, instance.sort(sortArray).length);
    }

    void sortAllReverseOrder_Test(Sort instance) {
        int[] sortArray = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        this.checkOrderofArrayAfterSort(instance, sortArray);
    }

    void sortAlreadySortedArray_Test(Sort instance) {
        int[] sortArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        this.checkOrderofArrayAfterSort(instance, sortArray);
    }

    void sortNegativeArray_Test(Sort instance) {
        int[] sortArray = {-1, -2, -3, -4, -5, -6, -7, -8, -9, -10};
        this.checkOrderofArrayAfterSort(instance, sortArray);
    }

    void sortArrayWithMaxAndMinIntValue_Test(Sort instance) {
        int[] sortArray = {2147483647, 2, 3, 4, 5, 6, -2147483647};
        this.checkOrderofArrayAfterSort(instance, sortArray);
    }

    void sortArrayWithOneValue_Test(Sort instance) {
        int[] sortArray = {2147483647};
        this.checkOrderofArrayAfterSort(instance, sortArray);
    }

    private void checkOrderofArrayAfterSort(Sort instance, int[] sortArray) {
        int min = this.getMinFromArray(sortArray);
        int max = this.getMaxFromArray(sortArray);
        int[] sortedArray = instance.sort(sortArray);
        assertEquals(min, sortedArray[0]);
        assertEquals(max, sortedArray[sortArray.length - 1]);
        assertEquals(sortArray.length, sortedArray.length);
    }

    private int getMinFromArray(int[] intArray) {
        OptionalInt min = Arrays.stream(intArray).min();
        if (min.isPresent()) {
            return min.getAsInt();
        } else {
            throw new NoSuchElementException();
        }
    }

    private int getMaxFromArray(int[] intArray) {
        OptionalInt min = Arrays.stream(intArray).max();
        if (min.isPresent()) {
            return min.getAsInt();
        } else {
            throw new NoSuchElementException();
        }
    }

}
