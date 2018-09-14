import edu.princeton.cs.algs4.StdOut;

/**
 * Compilation: javac Exercise_1_1_9.java
 * Execution: java Exercise_1_1_9 <number1>
 *
 * $ java Exercise_1_1_9 15
 * 15 -> 1111
 */

/**
 * Exercise_1_1_9. Integer to Binary String
 */
public class Exercise_1_1_9 {
  public static String toBinaryString(int n) {
    String s = "";

    for (int k = n; k > 0; k /= 2) {
      s = (k % 2) + s;
    }

    return s;
  }

  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);

    StdOut.printf("%d -> %s\n", n, toBinaryString(n));
  }
}