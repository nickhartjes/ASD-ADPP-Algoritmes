package nl.nickhartjes.han.asd.adpp.sort.pivot;

public class MedianOfThreePivot<T extends Comparable> implements SortPivot<T> {
  @Override
  public T getPivot(T[] array, int leftIndex, int rightIndex) {
    MiddlePivot<T> middlePivot = new MiddlePivot<>();
    return middleOfThree(
        array[leftIndex], middlePivot.getPivot(array, leftIndex, rightIndex), array[rightIndex]);
  }

  private T middleOfThree(T first, T middle, T last) {
    if ((first.compareTo(middle) < 0 && middle.compareTo(last) < 0)
        || (last.compareTo(middle) < 0 && middle.compareTo(first) < 0)) {
      return middle;
    } else if ((middle.compareTo(first) < 0 && first.compareTo(last) < 0)
        || (last.compareTo(first) < 0 && first.compareTo(middle) < 0)) {
      return first;
    } else {
      return last;
    }
  }
}
