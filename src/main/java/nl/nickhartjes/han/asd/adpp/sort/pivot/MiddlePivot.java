package nl.nickhartjes.han.asd.adpp.sort.pivot;

public class MiddlePivot<T extends Comparable> implements SortPivot<T> {

    /**
     * @param array      the array to get the pivot from
     * @param leftIndex  left boundry of the array
     * @param rightIndex right boundry of the array
     * @return
     */
    @Override
    public T getPivot(T[] array, int leftIndex, int rightIndex) {
        return array[leftIndex + (rightIndex - leftIndex) / 2];
    }
}
