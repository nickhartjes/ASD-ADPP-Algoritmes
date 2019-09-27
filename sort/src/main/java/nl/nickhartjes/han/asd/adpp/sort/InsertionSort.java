package nl.nickhartjes.han.asd.adpp.sort;

public class InsertionSort implements Sort {

    @Override
    public int[] sort(int[] sortArray) {

        if (sortArray.length == 0) {
            throw new IllegalStateException("The array is empty");
        }

        if (sortArray.length == 1) {
            return sortArray;
        }

        int i, key, j;
        for (i = 1; i < sortArray.length; i++) {
            key = sortArray[i];
            j = i - 1;

            while (j >= 0 && sortArray[j] > key) {
                sortArray[j + 1] = sortArray[j];
                j = j - 1;
            }
            sortArray[j + 1] = key;
        }
        return sortArray;
    }
}
