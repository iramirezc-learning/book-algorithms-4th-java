import edu.princeton.cs.algs4.StdOut;

public class Euclidean {
  public static int gcd(int p, int q) {
    if (q == 0)
      return p;
    int r = p % q;
    return gcd(q, r);
  }

  public static void main(String[] args) {
    int p = 15996751;
    int q = 3870378;
    int expected = 4057;

    int result = gcd(p, q);

    StdOut.printf("gcd(%d, %d) == %d ? %b\n", p, q, expected, expected == result);
  }
}