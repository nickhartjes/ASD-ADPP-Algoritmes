package nl.nickhartjes.han.asd.adpp.sort.pivot;

import java.util.Random;

public class RandomPivot<T extends Comparable> implements SortPivot<T> {

  /**
   * Returns a random pivot value from an array.
   * the random value wil be choosen between the left
   * and the right boundry
   *
   * @param array the array to get the pivot from
   * @param leftIndex left boundry of the array
   * @param rightIndex right boundry of the array
   * @return the value of the pivot
   */
  @Override
  public T getPivot(T[] array, int leftIndex, int rightIndex) {
    int random = new Random().nextInt(rightIndex - leftIndex);
    return array[random + leftIndex];
  }
}
