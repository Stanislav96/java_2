import java.util.Comparator;

/**
 * Created by User on 14.09.2015.
 */
public class Sort
{
  public static <T> void HeapSort(final T[] array, Comparator<T> c)
  {
    if (array == null)
    {
      return;
    }
    for (int i = 1; i <= array.length / 2; ++i)
    {
      ShiftDown(array, array.length / 2 - i, array.length - 1, c);
    }
    for (int i = 0; i < array.length - 1; ++i)
    {
      swap(array, 0, array.length - i - 1);
      ShiftDown(array, 0, array.length - i - 2, c);
    }
  }
  private static <T> void ShiftDown(final T[] array, int i, int last, Comparator<T> c)
  {
    while (i <= (last + 1) / 2 - 1)
    {
      int maxChild = 2 * i + 1;
      if (2 * i + 2 <= last && c.compare(array[2 * i + 2], array[2 * i + 1]) > 0)
      {
        maxChild = 2 * i + 2;
      }
      if (c.compare(array[maxChild], array[i]) > 0)
      {
        swap(array, i, maxChild);
        i = maxChild;
      }
      else
      {
        break;
      }
    }
  }

  public static <T> void StoogeSort(final T[] array, Comparator<T> c)
  {
    if (array == null)
    {
      return;
    }
    StoogeSort(array, c, 0, array.length - 1);
  }
  private static <T> void StoogeSort(final T[] array, Comparator<T> c, int first, int last)
  {
    if (first == last)
    {
      return;
    }
    if (c.compare(array[first], array[last]) == 1)
    {
      swap(array, first, last);
    }
    if (first + 1 == last)
    {
      return;
    }
    int index = (last - first + 1) / 3;
    StoogeSort(array, c, first, last - index);
    StoogeSort(array, c, first + index, last);
    StoogeSort(array, c, first, last - index);
  }

  private static <T> void swap(final T[] array, int first, int last)
  {
    T tmp = array[first];
    array[first] = array[last];
    array[last] = tmp;
  }
}
