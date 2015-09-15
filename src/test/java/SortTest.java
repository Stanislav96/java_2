import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

import static org.junit.Assert.assertTrue;

/**
 * Created by User on 14.09.2015.
 */

class IntComparator implements Comparator<Integer> {
  public int compare(Integer a, Integer b) {
    return Integer.compare(a, b);
  }
}
class DblComparator implements Comparator<Double> {
  public int compare(Double a, Double b) {
    return Double.compare(a, b);
  }
}

public class SortTest {

  public static void testNull(final Sorter sorter) {
    final IntComparator c = new IntComparator();
    final Integer[] array = new Integer[0];
    sorter.sort(array, c);
  }

  public static void testReverse(final Sorter sorter) {
    final IntComparator c = new IntComparator();
    final Integer[] array = {7, 5, 4, 4, 2, 1};
    sorter.sort(array, c);
    assertTrue(checkSorted(array, c));
  }

  public static void testSorted(final Sorter sorter) {
    final IntComparator c = new IntComparator();
    final Integer[] array = {1, 2, 2, 4, 5, 8};
    sorter.sort(array, c);
    assertTrue(checkSorted(array, c));
    assertTrue(checkEqual(array, array));
  }

  public static void testShouldBeSorted(final Sorter sorter) {
    final IntComparator iC = new IntComparator();
    final DblComparator dC = new DblComparator();
    final Integer[] iArray = new Integer[10];
    final Random rand = new Random(System.currentTimeMillis());
    for (int i = 0; i < iArray.length; ++i) {
      iArray[i] = rand.nextInt();
    }
    sorter.sort(iArray, iC);
    assertTrue(checkSorted(iArray, iC));
    assertTrue(checkEqual(iArray, iArray));
    final Double[] dArray = new Double[10];
    for (int i = 0; i < dArray.length; ++i) {
      dArray[i] = rand.nextDouble();
    }
    sorter.sort(dArray, dC);
    assertTrue(checkSorted(dArray, dC));
    assertTrue(checkEqual(dArray, dArray));
  }

  @Test
  public static void mainTest() {
    final HeapSorter heapSorter = new HeapSorter();
    final StoogeSorter stoogeSorter = new StoogeSorter();
    testNull(heapSorter);
    testReverse(heapSorter);
    testSorted(heapSorter);
    testShouldBeSorted(heapSorter);
    testNull(stoogeSorter);
    testReverse(stoogeSorter);
    testSorted(stoogeSorter);
    testShouldBeSorted(stoogeSorter);
  }

  private static <T> boolean checkSorted(final T[] array, final Comparator<T> c) {
    for (int i = 0; i < array.length - 1; ++i) {
      if (c.compare(array[i], array[i + 1]) > 0) {
        return false;
      }
    }
    return true;
  }

  private static <T> boolean checkEqual(final T[] array, final T[] arrayCopy) {
    if (array.length != arrayCopy.length) {
      return false;
    }
    for (int i = 0; i < array.length; ++i) {
      if (count(array, array[i]) != count(arrayCopy, array[i])) {
        return false;
      }
    }
    return true;
  }

  private static <T> int count(final T[] array, final T elem) {
    int count = 0;
    for (int i = 0; i < array.length; ++i) {
      if (array[i].equals(elem)) {
        ++count;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    mainTest();
  }
}
