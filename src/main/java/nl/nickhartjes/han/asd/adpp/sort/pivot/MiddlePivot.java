package nl.nickhartjes.han.asd.adpp.sort.pivot;

public class MiddlePivot<T extends Comparable> implements SortPivot<T> {

  @Override
  public T getPivot(T[] array, int leftIndex, int rightIndex) {
    return array[leftIndex + (rightIndex - leftIndex) / 2];
  }
}
