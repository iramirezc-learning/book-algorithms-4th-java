import edu.princeton.cs.algs4.StdOut;

/**
 * Compilation: javac E1109.java
 * Execution: java E1109 <number1>
 *
 * $ java E1109 15
 * 15 -> 1111
 */

/**
 * E1109. Integer to Binary String
 */
public class E1109 {
  public static String toBinaryString(int n) {
    String s = "";

    for (int k = n; k > 0; k /= 2) {
      s = (k % 2) + s;
    }

    return s;
  }

  public static void main(String[] args) throws Exception {
    if (args.length != 1) {
      throw new Error("You must provide at least 1 number");
    }

    int n = Integer.parseInt(args[0]);

    StdOut.printf("%d -> %s\n", n, toBinaryString(n));
  }
}