import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise: 1.1.23
 * Description. Binary Search + (not in the whitelist) - (in the whitelist)
 * Compilation: javac EX_1_1_23.java
 * Execution: java EX_1_1_23 <whitelist_file> <operator> < <input_stream>
 * Example(s):
 *
 * $ java EX_1_1_23 ~/algs4-data/tinyW.txt + < ~/algs4-data/tinyT.txt
 * 50
 * 99
 * 13
 *
 * $ java EX_1_1_23 ~/algs4-data/tinyW.txt - < ~/algs4-data/tinyT.txt
 * 23
 * 10
 * 18
 * 23
 * 98
 * 84
 * 11
 * 10
 * 48
 * 77
 * 54
 * 98
 * 77
 * 77
 * 68
 */
public class EX_1_1_23 {
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

  public static void main(String[] args) throws Exception {
    if (args.length != 2) {
      throw new Error("You must provide the path to the whitelist and the control operator: <whitelist> <+/->");
    }

    In in = new In(args[0]);
    String sense = args[1];
    int[] whitelist = in.readAllInts();

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
