import java.util.Arrays;

import javax.rmi.CORBA.StubDelegate;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Compilation: javac Exercise_1_1_23.java
 * Execution: java Exercise_1_1_23 <whitelist_file> <operator> < <input_stream>
 *
 * $ java Exercise_1_1_23 ../../data/whitelist.txt + < ../../data/targets.txt
 * 12
 * 57
 * 33
 * 16
 * 29
 * 12
 * 33
 * 33
 *
 * $ java Exercise_1_1_23 ../../data/whitelist.txt - < ../../data/targets.txt
 * 84
 * 48
 * 68
 * 10
 * 18
 * 98
 * 23
 * 54
 * 77
 * 11
 */

/**
 * Exercise_1_1_23. Binary Search + (not in the whitelist) - (in the whitelist)
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
    int[] whitelist = in.readAllInts();
    String sense = args[1];

    Arrays.sort(whitelist);

    while (!StdIn.isEmpty()) {
      int key = StdIn.readInt();
      int index = indexOf(whitelist, key);
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