import edu.princeton.cs.algs4.StdOut;

/**
 * Euclidean
 * Type: Algorithm
 * Description: Finds the Greatest Common Divisor of two positive integers.
 * Section: 1.1
 * Ref: p. 4
 * Compilation: javac Euclidean.java
 * Execution: java Euclidean <number1> <number2>
 * Example(s):
 *
 * $ java Euclidean 12 16
 * 4
 */
public class Euclidean {
  public static int gcd(int p, int q) {
    if (q == 0)
      return p;

    int r = p % q;

    return gcd(q, r);
  }

  public static void main(String[] args) {
    int p = Integer.parseInt(args[0]);
    int q = Integer.parseInt(args[1]);

    StdOut.printf("%d\n", gcd(p, q));
  }
}
