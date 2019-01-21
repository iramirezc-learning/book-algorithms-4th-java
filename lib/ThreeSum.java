import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Type: Snippet
 * Description: Count triples that sum to 0.
 * Ref: p. 173
 * Compilation: javac ThreeSum.java
 * Execution: java ThreeSum <file>
 *
 * $ java ThreeSum ~/algs4-data/1Kints.txt
 * 70
 * 
 * $ java ThreeSum ~/algs4-data/2Kints.txt
 * 528
 *
 * $ java ThreeSum ~/algs4-data/4Kints.txt
 * 4039
 *
 * $ java ThreeSum ~/algs4-data/1Mints.txt
 * ...?s
 */

/**
 * ThreeSum
 */
public class ThreeSum {

  public static int count(int[] a) {
    int n = a.length;
    int count = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        for (int k = j + 1; k < n; k++) {
          if (a[i] + a[j] + a[k] == 0) {
            count++;
          }
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