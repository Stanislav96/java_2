import java.util.Comparator;

/**
 * Created by User on 16.09.2015.
 */
public class StoogeSorter implements Sorter {

  public <T> void sort(final T[] array, final Comparator<T> c) {
    if (array.length == 0) {
      return;
    }
    sort(array, c, 0, array.length - 1);
  }

  private static <T> void sort(final T[] array, final Comparator<T> c, final int first, final int last) {
    // 1 element in array
    if (first == last) {
      return;
    }
    // changing first and last elements, if needed
    if (c.compare(array[first], array[last]) == 1) {
      swap(array, first, last);
    }
    // 2 elements in array
    if (last - first == 1) {
      return;
    }
    int index = (last - first + 1) / 3; // 1 third
    //sorting 1 and 2 thirds
    sort(array, c, first, last - index);
    //sorting 2 and 3 thirds
    sort(array, c, first + index, last);
    //sorting 1 and 2 thirds
    sort(array, c, first, last - index);
  }

  private static <T> void swap(final T[] array, final int first, final int last) {
    T tmp = array[first];
    array[first] = array[last];
    array[last] = tmp;
  }
}
