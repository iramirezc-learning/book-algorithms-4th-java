import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Type: Algorithm
 * Description: HeapSort Algorithm based on priority queues
 * Ref: p. 324
 *
 * Compilation: javac HeapSort.java
 * Execution: java HeapSort < <input_file>
 *
 * $ java HeapSort < ~/algs4-data/tiny.txt
 * A E E L M O P R S T X
 * isSorted? true
 *
 * $ java HeapSort < ~/algs4-data/words3.txt
 * all bad bed bug dad dim dug ... yes yet zoo
 * isSorted? true
 */

/**
 * HeapSort. Using heap construction and sortdown process.
 */
public class HeapSort {
  /**
   * Creates a copy of the array 'a'
   * to an array 'pq' so it can be used
   * as priority queue. Finally it copies
   * back all the elements to the original
   * array.
   */
  public static void sort(Comparable[] a) {
    int len = a.length;
    Comparable[] pq = new Comparable[len + 1];

    // copy all elements leaving pq[0] empty
    for (int i = 0; i < len; i++) {
      pq[i + 1] = a[i];
    }

    sort(pq, pq.length - 1);

    // copy all elements back in the original array but sorted
    for (int i = 1; i < pq.length; i++) {
      a[i - 1] = pq[i];
    }
  }

  /**
   * Actual implementation of HeapSort
   */
  public static void sort(Comparable[] pq, int n) {
    // construct the heap using the sink-based approach
    // sink elements from k / 2 to 1
    for (int k = n / 2; k >= 1; k--) {
      sink(pq, k, n);
    }

    // sortdown process
    while (n > 1) {
      // change the max element in the pq with the last item in the queue
      exchange(pq, 1, n);
      // then sink again the last element but reduce the size of the queue
      sink(pq, 1, --n);
    }
  }

  /**
   * Top-down reheapify. If order is violated because a
   * node in position 'k' becomes smaller than any of its
   * children then select the larger of the children 
   * '2k' or '2k + 1' an place it as the new parent.
   * Continue the process until current node 'k' is 
   * greather than or equal to its children.
   * Ref. p. 316
   */
  private static void sink(Comparable[] a, int k, int n) {
    while (2 * k <= n) {
      int j = 2 * k;

      if (j < n && less(a[j], a[j + 1])) {
        j++;
      }

      if (!less(a[k], a[j])) {
        break;
      }

      exchange(a, k, j);

      k = j;
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
    StdOut.println("Reading from standard input...");
    String[] a = StdIn.readAllStrings();
    sort(a);
    assert isSorted(a);
    show(a);
    StdOut.printf("isSorted? %s\n", isSorted(a));
  }
}