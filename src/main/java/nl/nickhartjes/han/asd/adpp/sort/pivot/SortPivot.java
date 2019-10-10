package nl.nickhartjes.han.asd.adpp.sort.pivot;

/**
 * This is the interface for the Sort Pivot
 *
 * @param <T> The expected class type of the value
 * @author Nick Hartjes
 * @version 1.0
 * @since 2019-10-09
 */
public interface SortPivot<T extends Comparable> {

  /**
   * Returns the pivot value from an array
   *
   * @param array the array to get the pivot from
   * @param leftIndex left boundry of the array
   * @param rightIndex right boundry of the array
   * @return the value of the pivot
   */
  T getPivot(T[] array, int leftIndex, int rightIndex);
}
