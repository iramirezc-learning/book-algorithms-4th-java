import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Compilation: javac ThreeSum.java
 * Execution: java ThreeSum <file>
 *
 * $ java ThreeSum ../data/1Mints.txt
 */

/**
 * ThreeSum
 */
public class ThreeSum {

  public static int count(int[] a) {
    int n = a.length;
    int count = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < n; k++) {
          count++;
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    In in = new In(args[0]);
    int[] a = in.readAllInts();
    StdOut.println(count(a));
  }
}