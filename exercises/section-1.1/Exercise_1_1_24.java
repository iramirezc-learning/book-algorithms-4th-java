import edu.princeton.cs.algs4.StdOut;

/**
 * Compilation: javac Exercise_1_1_24.java
 * Execution: java Exercise_1_1_24 <number1> <number2>
 *
 * $ java Exercise_1_1_24 12 16
 * p: 12 q: 16
 * p: 16 q: 12
 * p: 12 q: 4
 * p: 4 q: 0
 * gcd(12, 16) = 4
 */

/**
 * Exercise_1_1_24. Euclidean with printed recursive calls.
 */
public class Exercise_1_1_24 {
  public static int gcd(int p, int q) {
    StdOut.printf("p: %d q: %d\n", p, q);

    if (q == 0)
      return p;
    int r = p % q;
    return gcd(q, r);
  }

  public static void main(String[] args) {
    int p = Integer.parseInt(args[0]);
    int q = Integer.parseInt(args[1]);

    StdOut.printf("gcd(%d, %d) = %d\n", p, q, gcd(p, q));
  }
}