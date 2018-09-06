import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise_1_1_20
 */
public class Exercise_1_1_20 {
  public static int factorial(int n) {
    if (n <= 1)
      return 1;
    return n * factorial(n - 1);
  }

  // I know this method is not recursive,
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
      StdOut.println(ln(i) + " " + Math.log(factorial(i)));
    }
  }
}