import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Type: Algorithm
 * Description: Merge Sort Bottom-Up Algorithm
 * Ref: p. 278
 * 
 * Compilation: javac MergeBUSort.java
 * Execution: java MergeBUSort < <input_file>
 * 
 * $ java MergeBUSort < ~/algs4-data/tiny.txt
 * A E E L M O P R S T X
 * isSorted? true
 * 
 * $ java MergeBUSort < ~/algs4-data/words3.txt
 * all bad bed bug dad dim dug ... yes yet zoo
 * isSorted? true
 */

/**
 * MergeBUSort
 */
public class MergeBUSort {
  public static Comparable aux[];

  public static void sort(Comparable[] a) {
    aux = new Comparable[a.length];
    int n = a.length;

    for (int len = 1; len < n; len *= 2) {
      for (int lo = 0; lo < n - len; lo += len + len) {
        merge(a, lo, lo + len - 1, Math.min(lo + len + len - 1, n - 1));
      }
    }
  }

  private static void merge(Comparable[] a, int lo, int mid, int hi) {
    int i = lo;
    int j = mid + 1;

    for (int k = lo; k <= hi; k++) {
      aux[k] = a[k];
    }

    for (int k = lo; k <= hi; k++) {
      if (i > mid) {
        a[k] = aux[j++];
      } else if (j > hi) {
        a[k] = aux[i++];
      } else if (less(aux[j], aux[i])) {
        a[k] = aux[j++];
      } else {
        a[k] = aux[i++];
      }
    }
  }

  private static boolean less(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
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