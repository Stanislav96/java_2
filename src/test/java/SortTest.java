import org.junit.Test;

import java.util.Comparator;
import java.util.Random;

import static org.junit.Assert.assertTrue;

/**
 * Created by User on 14.09.2015.
 */

class MyComparator implements Comparator<Integer>
{
  public int compare(Integer a, Integer b)
  {
    return Integer.compare(a, b);
  }
}
public class SortTest
{

  @Test
  public static void TestNull()
  {
    Sort.StoogeSort(null, null);
    Sort.HeapSort(null, null);
  }

  @Test
  public static void TestReverse()
  {
    MyComparator c = new MyComparator();
    Integer[] array = {7, 5, 4, 4, 2, 1};
    Integer[] arrayCopy = array.clone();
    Sort.StoogeSort(arrayCopy, c);
    assertTrue(CheckSorted(arrayCopy));
    assertTrue(CheckEqual(array, arrayCopy));
    arrayCopy = array.clone();
    Sort.HeapSort(arrayCopy, c);
    assertTrue(CheckSorted(arrayCopy));
    assertTrue(CheckEqual(array, arrayCopy));
  }

  @Test
  public static void TestSorted()
  {
    MyComparator c = new MyComparator();
    Integer[] array = {1, 2, 2, 4, 5, 8};
    Integer[] arrayCopy = array.clone();
    Sort.StoogeSort(arrayCopy, c);
    assertTrue(CheckSorted(arrayCopy));
    assertTrue(CheckEqual(array, arrayCopy));
    arrayCopy = array.clone();
    Sort.HeapSort(arrayCopy, c);
    assertTrue(CheckSorted(arrayCopy));
    assertTrue(CheckEqual(array, arrayCopy));
  }

  @Test
  public static void TestShouldBeSorted()
  {
    MyComparator c = new MyComparator();
    Integer[] array = new Integer[10];
    Random rand = new Random(System.currentTimeMillis());
    for (int i = 0; i < array.length; ++i)
    {
      array[i] = rand.nextInt();
    }
    Integer[] arrayCopy = array.clone();
    Sort.StoogeSort(arrayCopy, c);
    assertTrue(CheckSorted(arrayCopy));
    assertTrue(CheckEqual(array, arrayCopy));
    arrayCopy = array.clone();
    Sort.HeapSort(arrayCopy, c);
    assertTrue(CheckSorted(arrayCopy));
    assertTrue(CheckEqual(array, arrayCopy));
  }

  private static <T> boolean CheckSorted(final Integer[] array)
  {
    for (int i = 0; i < array.length - 1; ++i)
    {
      if (array[i] > array[i + 1])
      {
        return false;
      }
    }
    return true;
  }

  private static boolean CheckEqual(final Integer[] array, final Integer[] arrayCopy)
  {
    if (array.length != arrayCopy.length)
    {
      return false;
    }
    for (int i = 0; i < array.length; ++i)
    {
      if (Count(array, array[i]) != Count(arrayCopy, array[i]))
      {
        return false;
      }
    }
    return true;
  }

  private static int Count(final Integer[] array, Integer elem)
  {
    int count = 0;
    for (int i = 0; i < array.length; ++i)
    {
      if (array[i].equals(elem))
      {
        ++count;
      }
    }
    return count;
  }

  public static void main(String[] args)
  {
    TestNull();
    TestReverse();
    TestSorted();
    TestShouldBeSorted();
  }
}
