import edu.princeton.cs.algs4.StdOut;

/**
 * Compilation: javac E1207.java
 * Execution: java E1207 <string>
 *
 * $ java E1207 programming
 * programming -> gnimmargorp
 */

/**
 * E1207
 */
public class E1207 {

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