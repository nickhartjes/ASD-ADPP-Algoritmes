package nl.nickhartjes.han.asd.adpp.sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MergeSortTest extends SortTest {

    private MergeSort instance;

    @BeforeEach
    void initTest() {
        this.instance = new MergeSort();
    }

    @Test
    void emptyIntArraySortException_Test() {
        super.emptyIntArraySort_ThrowException_Test(this.instance);
    }

    @Test
    void checkArraySortSize_Test() {
        super.checkArraySortSize_AssertEquals_Test(this.instance);
    }

    @Test
    void sortAllEquals_Test() {
        super.sortAllEquals_AssertEquals_Test(this.instance);
    }

    @Test
    void sortAllReverseOrder_Test() {
        super.sortAllReverseOrder_Test(this.instance);
    }

    @Test
    void sortAlreadySortedArray_Test() {
        super.sortAlreadySortedArray_Test(this.instance);
    }

    @Test
    void sortNegativeArray_Test() {
        super.sortNegativeArray_Test(this.instance);
    }

    @Test
    void sortArrayWithMaxAndMinIntValue_Test() {
        super.sortArrayWithMaxAndMinIntValue_Test(this.instance);
    }

    @Test
    void sortArrayWithOneValue_Test() {
        super.sortArrayWithOneValue_Test(this.instance);
    }
}
