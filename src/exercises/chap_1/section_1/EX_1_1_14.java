import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise: 1.1.14
 * Description: Integer logarithm not larger than lg_2(n).
 * Compilation: javac EX_1_1_14.java
 * Execution: java EX_1_1_14 <number>
 * Example(s):
 *
 * $ java EX_1_1_14 10
 * 3
 */
public class EX_1_1_14 {
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
