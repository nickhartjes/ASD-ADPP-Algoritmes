package nl.nickhartjes.han.asd.adpp.sort;

import nl.nickhartjes.han.asd.adpp.sort.pivot.MiddlePivot;
import nl.nickhartjes.han.asd.adpp.sort.pivot.SortPivot;

/**
 * This sort implements a generic quicksort algorith created by Tony Hoare More information about
 * the quicksort: https://nl.wikipedia.org/wiki/Quicksort
 *
 * @param <T> The expected class type of the value
 * @author Nick Hartjes
 * @version 1.0
 * @since 2019-10-09
 */
public class GenericQuickSort<T extends Comparable<? super T>> {

  private T[] array;

  /**
   * Sorts the array in ascending order of it's elements All elements in the list must implement the
   * {@link Comparable} interface.
   *
   * @param arrayToSort array to sort
   * @return sorted array of elements
   */
  public T[] sort(T[] arrayToSort) {
    return this.sort(arrayToSort, new MiddlePivot<>());
  }

  /**
   * Sorts the array in ascending order of it's elements All elements in the list must implement the
   * {@link Comparable} interface.
   *
   * @param arrayToSort array to sort
   * @return sorted array of elements
   */
  public T[] sort(T[] arrayToSort, SortPivot<T> sortPivot) {

    if (arrayToSort == null || arrayToSort.length < 2) {
      return arrayToSort;
    }

    this.array = arrayToSort;
    quickSort(0, arrayToSort.length - 1, sortPivot);

    return array;
  }

  private void quickSort(int leftIndex, int rightIndex, SortPivot<T> sortPivot) {

    T pivot = sortPivot.getPivot(array, leftIndex, rightIndex);

    int leftValue = leftIndex;
    int rightValue = rightIndex;

    while (leftValue <= rightValue) {
      while (array[leftValue].compareTo(pivot) < 0) {
        leftValue++;
      }
      while (pivot.compareTo(array[rightValue]) < 0) {
        rightValue--;
      }
      if (leftValue <= rightValue) {
        exchangeNumbers(leftValue, rightValue);
        leftValue++;
        rightValue--;
      }
    }

    if (leftIndex < rightValue) quickSort(leftIndex, rightValue, sortPivot);
    if (leftValue < rightIndex) quickSort(leftValue, rightIndex, sortPivot);
  }

  private void exchangeNumbers(int i, int j) {
    T temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
