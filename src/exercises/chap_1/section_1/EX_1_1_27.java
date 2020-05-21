import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise: 1.1.27
 * Description: Binomial Distribution.
 * Compilation: javac EX_1_1_27.java
 * Execution: java EX_1_1_27 <number1> <number2> <double>
 * Example(s):
 *
 * $ java EX_1_1_27 2 2 0.5
 * 0.25
 * Total calls: 13
 */
public class EX_1_1_27 {
  public static int CALLS = 0;

  /* not optimal */
  public static double binomial(int n, int k, double p) {
    CALLS++;
    // StdOut.println(CALLS);

    if ((n == 0) && (k == 0))
      return 1.0;

    if ((n < 0) || (k < 0))
      return 0.0;

    return (1 - p) * binomial(n - 1, k, p) + p * binomial(n - 1, k - 1, p);
  }

  public static void main(String[] args) throws Exception {
    if (args.length != 3) {
      throw new Error("You must provide 2 ints and 1 double");
    }

    int n = Integer.parseInt(args[0]);
    int k = Integer.parseInt(args[1]);
    double p = Double.parseDouble(args[2]);

    StdOut.println(binomial(n, k, p));
    StdOut.printf("Total calls: %d\n", CALLS);
  }
}
