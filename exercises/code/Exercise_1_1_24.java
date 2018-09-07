import edu.princeton.cs.algs4.StdOut;

/**
 * Euclidean
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