import edu.princeton.cs.algs4.StdOut;

/**
 * Compilation: javac E1206.java
 * Execution: java E1206 <string1> <string2>
 *
 * $ java E1206 ACTGACG gacgact
 * true
 */

/**
 * E1206
 */
public class E1206 {

  public static boolean isCircularShift(String s, String t) {
    return s.length() == t.length() && (s + s).toLowerCase().indexOf(t.toLowerCase()) >= 0;
  }

  public static void main(String[] args) throws Exception {
    if (args.length != 2) {
      throw new Error("You must provide two strings: <string1> <string2>");
    }

    String s = args[0];
    String t = args[1];

    StdOut.printf("'%s' & '%s' = %s\n", s, t, isCircularShift(s, t));
  }
}