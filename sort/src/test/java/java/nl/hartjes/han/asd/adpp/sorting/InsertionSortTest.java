package java.nl.hartjes.han.asd.adpp.sorting;

import nl.nickhartjes.han.asd.adpp.sort.InsertionSort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InsertionSortTest extends SortTest {

    private InsertionSort instance;

    @BeforeEach
    void initTest() {
        this.instance = new InsertionSort();
    }

    @Test
    void emptyIntArraySortExeption_Test() {
        int[] sortArray = {};
        super.emptyIntArraySort_ThrowExecption_Test(this.instance, sortArray);
    }

    @Test
    void checkArraySortSize_Test() {
        int[] sortArray = {11, 5, 6, 87, 12, 22, 123};
        super.checkArraySortSize_AssertEquals_Test(this.instance, sortArray);
    }

    @Test
    void sortAllEquals_Test() {
        int[] sortArray = {11, 11, 11, 11, 11, 11, 11};
        super.sortAllEquals_AssertEquals_Test(this.instance, sortArray);
    }

    @Test
    void sortAllReverseOrder_Test() {
        int[] sortArray = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        super.checkOrderofArrayAfterSort(this.instance, sortArray);
    }

    @Test
    void sortSortedArray_Test() {
        int[] sortArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        super.checkOrderofArrayAfterSort(this.instance, sortArray);
    }
}
