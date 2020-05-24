import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise: 1.2.7
 * Description: Mystery
 * Compilation: javac EX_1_2_7.java
 * Execution: java EX_1_2_7 <string>
 * Example(s):
 *
 * $ java EX_1_2_7 programming
 * programming -> gnimmargorp
 */
public class EX_1_2_7 {
  public static String mystery(String s) {
    int n = s.length();

    if (n <= 1)
      return s;

    String a = s.substring(0, n / 2);
    String b = s.substring(n / 2, n);

    return mystery(b) + mystery(a);
  }

  public static void main(String[] args) throws Exception {
    if (args.length < 1) {
      throw new Error("You must provide a: <string>");
    }

    String s = args[0];

    StdOut.printf("%s -> %s\n", s, mystery(s));
  }
}
