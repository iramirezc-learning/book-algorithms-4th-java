import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise 1.1.24
 * Description: Euclidean with printed recursive calls.
 * Compilation: javac EX_1_1_24.java
 * Execution: java EX_1_1_24 <int1> <int2>
 * Example(s):
 *
 * $ java EX_1_1_24 12 16
 * p: 12 q: 16
 * p: 16 q: 12
 * p: 12 q: 4
 * p: 4 q: 0
 * gcd(12, 16) = 4
 */
public class EX_1_1_24 {
  public static int gcd(int p, int q) {
    StdOut.printf("p: %d q: %d\n", p, q);

    if (q == 0)
      return p;

    int r = p % q;

    return gcd(q, r);
  }

  public static void main(String[] args) throws Exception {
    if (args.length != 2) {
      throw new Error("You must provide two integers.");
    }

    int p = Integer.parseInt(args[0]);
    int q = Integer.parseInt(args[1]);

    StdOut.printf("gcd(%d, %d) = %d\n", p, q, gcd(p, q));
  }
}
