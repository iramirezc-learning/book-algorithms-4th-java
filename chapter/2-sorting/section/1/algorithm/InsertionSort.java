import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Type: Algorithm
 * Description: InsertionSort Algorithm
 * Ref: p. 251
 *
 * Compilation: javac InsertionSort.java
 * Execution: java InsertionSort < <input_file>
 *
 * $ java InsertionSort < ~/algs4-data/tiny.txt
 * A E E L M O P R S T X
 * isSorted? true
 *
 * $ java InsertionSort < ~/algs4-data/words3.txt
 * all bad bed bug dad dim dug ... yes yet zoo
 * isSorted? true
 */

/**
 * InsertionSort
 */
public class InsertionSort {
  public static void sort(Comparable[] a) {
    int n = a.length;

    for (int i = 1; i < n; i++) {
      for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
        exchange(a, j, j - 1);
      }
    }
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