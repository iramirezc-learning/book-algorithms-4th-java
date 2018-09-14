import edu.princeton.cs.algs4.StdOut;

/**
 * Compilation: javac Exercise_1_1_14.java
 * Execution: java Exercise_1_1_14 <number>
 *
 * $ java Exercise_1_1_14 10
 * 3
 */

/**
 * Exercise_1_1_14. Integer logarithm not larget than lg_2(n).
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