import edu.princeton.cs.algs4.StdOut;

/**
 * Compilation: javac Exercise_1_1_27.java
 * Execution: java Exercise_1_1_27 <number1> <number2> <double>
 *
 * $ java Exercise_1_1_27 2 2 0.5
 * 0.25
 * Total calls: 13
 */

/**
 * Exercise_1_1_27. Binomial Distribution.
 */
public class Exercise_1_1_27 {

  public static int CALLS = 0;

  /* not optimal */
  public static double binomial(int n, int k, double p) {
    CALLS++;

    if ((n == 0) && (k == 0))
      return 1.0;
    if ((n < 0) || (k < 0))
      return 0.0;
    return (1 - p) * binomial(n - 1, k, p) + p * binomial(n - 1, k - 1, p);
  }

  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    int k = Integer.parseInt(args[1]);
    double p = Double.parseDouble(args[2]);

    StdOut.println(binomial(n, k, p));
    StdOut.printf("Total calls: %d\n", CALLS);
  }
}