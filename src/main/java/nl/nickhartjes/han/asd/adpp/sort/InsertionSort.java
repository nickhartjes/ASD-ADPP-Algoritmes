package nl.nickhartjes.han.asd.adpp.sort;

public class InsertionSort implements Sort {

    @Override
    public int[] sort(int[] arrayToSort) {
        if (arrayToSort == null || arrayToSort.length == 0) {
            throw new IllegalStateException("The array is empty");
        }

        // If the array is shorter then 2, it doesn't need sorting
        if (arrayToSort.length < 2) {
            return arrayToSort;
        }

        int key;
        int j;
        for (int i = 1; i < arrayToSort.length; i++) {
            key = arrayToSort[i];
            j = i - 1;

            // Move element of the arrayToSort that are greater then the key one position ahead
            while (j >= 0 && arrayToSort[j] > key) {
                arrayToSort[j + 1] = arrayToSort[j];
                j = j - 1;
            }
            arrayToSort[j + 1] = key;
        }
        return arrayToSort;
    }
}
