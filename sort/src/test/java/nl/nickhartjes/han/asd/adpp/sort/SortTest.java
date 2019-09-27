package nl.nickhartjes.han.asd.adpp.sort;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.OptionalInt;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class SortTest {

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

    void emptyIntArraySort_ThrowExecption_Test(Sort instance, int[] sortArray) {
        Assertions.assertThrows(IllegalStateException.class, () -> instance.sort(sortArray));
    }

    void checkArraySortSize_AssertEquals_Test(Sort instance, int[] sortArray) {
        assertEquals(sortArray.length, instance.sort(sortArray).length);
    }

    void sortAllEquals_AssertEquals_Test(Sort instance, int[] sortArray) {
        assertEquals(sortArray.length, instance.sort(sortArray).length);
    }

    void checkOrderofArrayAfterSort(Sort instance, int[] sortArray) {
        int min = this.getMinFromArray(sortArray);
        int max = this.getMaxFromArray(sortArray);
        int[] sortedArray = instance.sort(sortArray);
        assertEquals(min, sortedArray[0]);
        assertEquals(max, sortedArray[sortArray.length - 1]);
        assertEquals(sortArray.length, sortedArray.length);
    }
}
