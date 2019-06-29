import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Type: Algorithm
 * Description: QuickSort3Way Algorithm
 * Ref: p. 299
 * 
 * Compilation: javac QuickSort3Way.java
 * Execution: java QuickSort3Way < <input_file>
 *
 * $ java QuickSort3Way < ~/algs4-data/tiny.txt
 * A E E L M O P R S T X
 * isSorted? true
 *
 * $ java QuickSort3Way < ~/algs4-data/words3.txt
 * all bad bed bug dad dim dug ... yes yet zoo
 * isSorted? true
 */

/**
 * QuickSort3Way
 */
public class QuickSort3Way {
  public static void sort(Comparable[] a) {
    StdRandom.shuffle(a);
    sort(a, 0, a.length - 1);
  }

  private static void sort(Comparable[] a, int lo, int hi) {
    if (hi <= lo)
      return;

    int lt = lo;
    int i = lo + 1;
    int gt = hi;
    Comparable v = a[lo];

    while (i <= gt) {
      int cmp = a[i].compareTo(v);

      if (cmp < 0) {
        exchange(a, lt++, i++);
      } else if (cmp > 0) {
        exchange(a, i, gt--);
      } else {
        i++;
      }
    }

    sort(a, lo, lt - 1);
    sort(a, gt + 1, hi);
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