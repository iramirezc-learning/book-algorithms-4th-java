import edu.princeton.cs.algs4.StdOut;

/**
 * Compilation: javac E1114.java
 * Execution: java E1114 <number>
 *
 * $ java E1114 10
 * 3
 */

/**
 * E1114. Integer logarithm not larget than lg_2(n).
 */
public class E1114 {

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

  public static void main(String[] args) throws Exception {
    if (args.length != 1) {
      throw new Error("You must provide a integer");
    }
    StdOut.println(lg(Integer.parseInt(args[0])));
  }
}