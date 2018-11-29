import edu.princeton.cs.algs4.StdOut;

/**
 * Type: Snippet
 * Description: Typical implementations of static methods.
 * Ref: p. 23
 * Compilation: javac MathUtils.java
 * Execution: java MathUtils
 *
 * $ java MathUtils
 * abs(-9): 9
 * abs(-7.0): 7.0
 * isPrime(7): true
 * sqrt(25): 5.0
 * hypotenuse(3.0, 5.0): 5.830951894845301
 * harmonic(5): 2.283333333333333
 */

/**
 * MathUtils
 */
public class MathUtils {

  // absolute value of a int value
  public static int abs(int x) {
    if (x < 0)
      return -x;
    else
      return x;
  }

  // absolute value of a double value
  public static double abs(double x) {
    if (x < 0.0)
      return -x;
    else
      return x;
  }

  // primality test
  public static boolean isPrime(long n) {
    if (n < 2)
      return false;

    for (long i = 2; i * i <= n; i++)
      if (n % i == 0)
        return false;

    return true;
  }

  // Square root (Newton's method)
  public static double sqrt(double c) {
    if (c < 0.0)
      return Double.NaN;

    double eps = 1e-15;
    double t = c;

    while (Math.abs(t - c / t) > eps * t)
      t = (c / t + t) / 2.0;

    return t;
  }

  // hypotenuse of a right triangle
  public static double hypotenuse(double a, double b) {
    return Math.sqrt(a * a + b * b);
  }

  // harmonic number Ref: p. 185
  public static double harmonic(int n) {
    double sum = 0.0;

    for (int i = 1; i <= n; i++) {
      sum += 1.0 / i;
    }

    return sum;
  }

  public static void main(String[] args) {
    StdOut.println("abs(-9): " + abs(-9));
    StdOut.println("abs(-7.0): " + abs(-7.0));
    StdOut.println("isPrime(7): " + isPrime(7));
    StdOut.println("sqrt(25): " + sqrt(25));
    StdOut.println("hypotenuse(3.0, 5.0): " + hypotenuse(3.0, 5.0));
    StdOut.println("harmonic(5): " + harmonic(5));
  }
}