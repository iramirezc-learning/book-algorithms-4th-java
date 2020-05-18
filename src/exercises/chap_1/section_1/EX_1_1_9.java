import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise: 1.1.9
 * Description: Integer to Binary String
 * Compilation: javac EX_1_1_9.java
 * Execution: java EX_1_1_9 <number1>
 * Example(s):
 *
 * $ java EX_1_1_9 15
 * 15 -> 1111
 */
public class EX_1_1_9 {
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
