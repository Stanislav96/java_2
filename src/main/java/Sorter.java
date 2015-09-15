import java.util.Comparator;

/**
 * Created by User on 14.09.2015.
 */
public interface Sorter {
  <T> void sort(final T[] array, final Comparator<T> c);
}