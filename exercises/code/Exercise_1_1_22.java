import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise_1_1_22. Binary Search - Recursive Implementation
 */
public class Exercise_1_1_22 {
  public static int indexOf(int[] a, int target) {
    return indexOf(a, target, 0, a.length - 1, 1);
  }

  public static int indexOf(int[] a, int target, int lo, int hi, int calls) {
    String format = "%" + calls + "s %d) -> lo: %-3d hi: %-3d\n";
    StdOut.printf(format, "", calls, lo, hi);

    if (lo > hi)
      return -1;
    int mid = lo + (hi - lo) / 2;
    if (a[mid] > target) {
      return indexOf(a, target, lo, mid - 1, ++calls);
    } else if (a[mid] < target) {
      return indexOf(a, target, mid + 1, hi, ++calls);
    } else {
      return mid;
    }
  }

  public static void main(String[] args) {
    In in = new In(args[0]);
    int[] whitelist = in.readAllInts();

    Arrays.sort(whitelist);

    while (!StdIn.isEmpty()) {
      int key = StdIn.readInt();
      if (indexOf(whitelist, key) == -1)
        StdOut.println(key);
    }
  }
}