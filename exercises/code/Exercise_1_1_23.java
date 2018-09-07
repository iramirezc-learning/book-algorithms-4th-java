import java.util.Arrays;

import javax.rmi.CORBA.StubDelegate;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise_1_1_23
 */
public class Exercise_1_1_23 {

  public static int indexOf(int[] a, int target) {
    return indexOf(a, target, 0, a.length - 1);
  }

  public static int indexOf(int[] a, int target, int lo, int hi) {
    if (lo > hi)
      return -1;
    int mid = lo + (hi - lo) / 2;
    if (a[mid] > target) {
      return indexOf(a, target, lo, mid - 1);
    } else if (a[mid] < target) {
      return indexOf(a, target, mid + 1, hi);
    } else {
      return mid;
    }
  }

  public static void main(String[] args) {
    In in = new In(args[0]);
    int[] whilelist = in.readAllInts();
    String sense = args[1];

    Arrays.sort(whilelist);

    while (!StdIn.isEmpty()) {
      int key = StdIn.readInt();
      int index = indexOf(whilelist, key);
      // not in the whitelist
      if (sense.equals("+") && index == -1) {
        StdOut.println(key);
        // in the whitelist
      } else if (sense.equals("-") && index != -1) {
        StdOut.println(key);
      }
    }
  }
}