package nl.nickhartjes.han.asd.adpp.sort.generic;

public class QuickSort<T extends Comparable> {

    private T[] array;

    public T[] sort(T[] arrayToSort) {
        return this.sort(arrayToSort, false);
    }

    public T[] sort(T[] arrayToSort, boolean medianOfThree) {
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

    private void quickSort(int leftIndex, int rightIndex, boolean medianOfThree) {

        int i = leftIndex;
        int j = rightIndex;

        // calculate pivot number, I am taking pivot as middle index number
        T pivot = array[leftIndex + (rightIndex - leftIndex) / 2];
        if (medianOfThree) {
            pivot = middleOfThree(array[leftIndex], pivot, array[rightIndex]);
        }


        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (array[i].compareTo(pivot) < 0) {
                i++;
            }
            while (pivot.compareTo(array[j]) < 0) {
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
        if (leftIndex < j) {
            quickSort(leftIndex, j, medianOfThree);
        }
        if (i < rightIndex) {
            quickSort(i, rightIndex, medianOfThree);
        }
    }

    private void exchangeNumbers(int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private T middleOfThree(T a, T b, T c) {


        if (a.compareTo(b) < 0) {
            return b;
        }
//        // Checking for b
//        if ((a < b && b < c) || (c < b && b < a)) {
//            return b;
//        }
//
//        // Checking for a
//        else if ((b < a && a < c) || (c < a && a < b)) {
//            return a;
//        } else {
//            return c;
//        }
    }

}
