import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise_1_1_14
 */
public class Exercise_1_1_14 {

  public static int lg(int n) {
    int exp = 0;
    int result = 1;
    int BASE = 2;

    while (result * BASE <= n) {
      result *= BASE;
      exp++;
    }

    return exp;
  }

  public static void main(String[] args) {
    StdOut.println(lg(Integer.parseInt(args[0])));
  }
}