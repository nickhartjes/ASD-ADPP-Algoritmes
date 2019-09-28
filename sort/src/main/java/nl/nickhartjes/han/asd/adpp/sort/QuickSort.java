package nl.nickhartjes.han.asd.adpp.sort;

public class QuickSort implements Sort {

    private int[] array;

    @Override
    public int[] sort(int[] arrayToSort) {
        return this.sort(arrayToSort, false);
    }

    public int[] sort(int[] arrayToSort, boolean medianOfThree) {
        if (arrayToSort == null || arrayToSort.length == 0) {
            throw new IllegalStateException("The array is empty");
        }

        // If the array is shorter then 2, it doesn't need sorting
        if (arrayToSort.length < 2) {
            return arrayToSort;
        }

        this.array = arrayToSort;
        int length = arrayToSort.length;
        quickSort(0, length - 1, medianOfThree);

        return array;
    }

    private void quickSort(int lowerIndex, int higherIndex, boolean medianOfThree) {

        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number

        int pivot = array[lowerIndex + (higherIndex - lowerIndex) / 2];
        if (medianOfThree) {
            pivot = middleOfThree(array[lowerIndex], pivot, array[higherIndex]);
        }


        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j) {
            quickSort(lowerIndex, j, medianOfThree);
        }
        if (i < higherIndex) {
            quickSort(i, higherIndex, medianOfThree);
        }
    }

    private void exchangeNumbers(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private int middleOfThree(int a, int b, int c) {
        // Checking for b
        if ((a < b && b < c) || (c < b && b < a)) {
            return b;
        }

        // Checking for a
        else if ((b < a && a < c) || (c < a && a < b)) {
            return a;
        } else {
            return c;
        }
    }
}
