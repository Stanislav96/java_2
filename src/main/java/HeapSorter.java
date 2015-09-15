import java.util.Comparator;

/**
 * Created by User on 15.09.2015.
 */
public class HeapSorter implements Sorter {
  public <T> void sort(final T[] array, final Comparator<T> c) {
    if (array.length == 0) {
      return;
    }
    // making a heap
    // from array.length / 2 - 1 to 0
    for (int i = 1; i <= array.length / 2; ++i) {
      shiftDown(array, array.length / 2 - i, array.length - 1, c);
    }
    for (int i = 0; i < array.length - 1; ++i) {
      // moving max element to the end of rest elements
      swap(array, 0, array.length - i - 1);
      // shift down, don't touching elements that were moved to the end as max
      shiftDown(array, 0, array.length - i - 2, c);
    }
  }

  //pulling an element down while it is smaller than lower elements
  private static <T> void shiftDown(final T[] array, int i, final int last, final Comparator<T> c) {
    // moving down a heap
    while (i <= (last + 1) / 2 - 1) {
      int maxChild = 2 * i + 1;
      if (2 * i + 2 <= last && c.compare(array[2 * i + 2], array[2 * i + 1]) > 0) {
        maxChild = 2 * i + 2;
      }
      if (c.compare(array[maxChild], array[i]) > 0) {
        // pulling down the element
        swap(array, i, maxChild);
        i = maxChild;
      }
      else {
        break;
      }
    }
  }

  private static <T> void swap(final T[] array, final int first, final int last) {
    T tmp = array[first];
    array[first] = array[last];
    array[last] = tmp;
  }
}
