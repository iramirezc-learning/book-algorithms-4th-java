import edu.princeton.cs.algs4.StdOut;

/**
 * Compilation: javac E1120.java
 * Execution: java E1120
 *
 * $ java E1120
 * ln(1!) = 0 Math.log(1!) = 0.0
 * ln(2!) = 0 Math.log(2!) = 0.6931471805599453
 * ln(3!) = 1 Math.log(3!) = 1.791759469228055
 * ln(4!) = 3 Math.log(4!) = 3.1780538303479458
 * ln(5!) = 4 Math.log(5!) = 4.787491742782046
 * ln(6!) = 6 Math.log(6!) = 6.579251212010101
 * ln(7!) = 8 Math.log(7!) = 8.525161361065415
 * ln(8!) = 10 Math.log(8!) = 10.60460290274525
 * ln(9!) = 12 Math.log(9!) = 12.801827480081469
 * ln(10!) = 15 Math.log(10!) = 15.104412573075516
 */

/**
 * E1120. Natural Logarithm of n!
 */
public class E1120 {
  public static int factorial(int n) {
    if (n <= 1)
      return 1;
    return n * factorial(n - 1);
  }

  // TODO: I know this method is not recursive,
  // I might come later to fix it.
  // ln(3!) = ln(3) + ln(2) + ln(1)
  public static int ln(int n) {
    int nFactorial = factorial(n);
    int exp = 0;
    double result = 1.0;

    while (result * Math.E <= nFactorial) {
      result *= Math.E;
      exp++;
    }

    return exp;
  }

  public static void main(String[] args) {
    for (int i = 1; i <= 10; i++) {
      StdOut.println("ln(" + i + "!) = " + ln(i) + " Math.log(" + i + "!) = " + Math.log(factorial(i)));
    }
  }
}