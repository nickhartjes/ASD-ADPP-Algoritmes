package nl.nickhartjes.han.asd.adpp.sort;

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
    void sortAlreadySortedArray_Test() {
        int[] sortArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        super.checkOrderofArrayAfterSort(this.instance, sortArray);
    }

    @Test
    void sortNegativeArray_Test() {
        int[] sortArray = {-1, -2, -3, -4, -5, -6, -7, -8, -9, -10};
        super.checkOrderofArrayAfterSort(this.instance, sortArray);
    }

    @Test
    void sortArrayWithMaxAndMinIntValue_Test() {
        int[] sortArray = {2147483647, 2, 3, 4, 5, 6, -2147483647};
        super.checkOrderofArrayAfterSort(this.instance, sortArray);
    }
}
