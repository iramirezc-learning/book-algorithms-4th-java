import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Type: Algorithm
 * Description: QuickSort Algorithm
 * Ref: p. 289, p. 291
 * 
 * Compilation: javac QuickSort.java
 * Execution: java QuickSort < <input_file>
 * 
 * $ java QuickSort < ~/algs4-data/tiny.txt
 * A E E L M O P R S T X
 * isSorted? true
 * 
 * $ java QuickSort < ~/algs4-data/words3.txt
 * all bad bed bug dad dim dug ... yes yet zoo
 * isSorted? true
 */

/**
 * QuickSort
 */
public class QuickSort {
  public static void sort(Comparable[] a) {
    StdRandom.shuffle(a);
    sort(a, 0, a.length - 1);
  }

  private static void sort(Comparable[] a, int lo, int hi) {
    if (hi <= lo)
      return;

    int j = partition(a, lo, hi);
    sort(a, lo, j - 1);
    sort(a, j + 1, hi);
  }

  private static int partition(Comparable[] a, int lo, int hi) {
    int i = lo;
    int j = hi + 1;
    Comparable v = a[lo];

    while (true) {
      while (less(a[++i], v)) {
        if (i == hi)
          break;
      }

      while (less(v, a[--j])) {
        if (j == lo)
          break;
      }

      if (i >= j)
        break;

      exchange(a, i, j);
    }

    exchange(a, lo, j);

    return j;
  }

  private static boolean less(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
  }

  private static void exchange(Comparable[] a, int i, int j) {
    Comparable t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  private static void show(Comparable[] a) {
    for (int i = 0; i < a.length; i++) {
      StdOut.print(a[i] + " ");
    }
    StdOut.println();
  }

  private static boolean isSorted(Comparable[] a) {
    for (int i = 1; i < a.length; i++) {
      if (less(a[i], a[i - 1]))
        return false;
    }
    return true;
  }

  public static void main(String[] args) {
    String[] a = StdIn.readAllStrings();
    sort(a);
    assert isSorted(a);
    show(a);
    StdOut.printf("isSorted? %s\n", isSorted(a));
  }
}