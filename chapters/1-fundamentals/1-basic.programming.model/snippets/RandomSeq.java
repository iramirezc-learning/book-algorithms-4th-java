import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Type: Snippet
 * Description: Sample StdOut client.
 * Ref: p. 37
 * Compilation: javac RandomSeq.java
 * Execution: java RandomSeq <numbers> <lo> <hi>
 *
 * $ java RandomSeq 5 100.0 200.0
 * 155.24
 * 193.57
 * 112.01
 * 122.01
 * 117.86
 */

/**
 * RandomSeq
 */
public class RandomSeq {

  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    double lo = Double.parseDouble(args[1]);
    double hi = Double.parseDouble(args[2]);

    for (int i = 0; i < n; i++) {
      double x = StdRandom.uniform(lo, hi);
      StdOut.printf("%.2f\n", x);
    }
  }
}