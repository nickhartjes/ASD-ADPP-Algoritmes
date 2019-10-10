package nl.nickhartjes.han.asd.adpp.sort;

public class MergeSort implements Sort {

    @Override
    public int[] sort(int[] arrayToSort) {
        if (arrayToSort == null || arrayToSort.length == 0) {
            throw new IllegalStateException("The array is empty");
        }

        // If the array is shorter then 2, it doesn't need sorting
        if (arrayToSort.length < 2) {
            return arrayToSort;
        }
        return this.sort(arrayToSort, 0, arrayToSort.length - 1);
    }

    private int[] sort(int[] arrayToSort, int left, int right) {
        if (left < right) {
            // Find the middle point
            int middle = (left + right) / 2;

            // Sort first and second halves
            sort(arrayToSort, left, middle);
            sort(arrayToSort, middle + 1, right);

            // Merge the sorted halves
            merge(arrayToSort, left, middle, right);
        }
        return arrayToSort;
    }

    private void merge(int[] arrayToSort, int left, int middle, int right) {
        // Find sizes of two subarrays to be merged
        int lengtSubArray01 = middle - left + 1;
        int lengtSubArray02 = right - middle;

        // Create temp arrays
        int[] leftSubArray = new int[lengtSubArray01];
        int[] rightSubArray = new int[lengtSubArray02];

        // Copy data to temp arrays
        System.arraycopy(arrayToSort, left, leftSubArray, 0, lengtSubArray01);
        System.arraycopy(arrayToSort, middle + 1, rightSubArray, 0, lengtSubArray02);

        // Merge the temp arrays
        int i = 0;
        int j = 0;
        int k = left;
        while (i < lengtSubArray01 && j < lengtSubArray02) {
            if (leftSubArray[i] <= rightSubArray[j]) {
                arrayToSort[k] = leftSubArray[i];
                i++;
            } else {
                arrayToSort[k] = rightSubArray[j];
                j++;
            }
            k++;
        }

        while (i < lengtSubArray01) {
            arrayToSort[k] = leftSubArray[i];
            i++;
            k++;
        }

        while (j < lengtSubArray02) {
            arrayToSort[k] = rightSubArray[j];
            j++;
            k++;
        }
    }
}
