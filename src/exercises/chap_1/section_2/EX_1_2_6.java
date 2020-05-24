import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise: 1.2.6
 * Description: Circular Shift
 * Compilation: javac EX_1_2_6.java
 * Execution: java EX_1_2_6 <string1> <string2>
 * Example(s):
 *
 * $ java EX_1_2_6 ACTGACG gacgact
 * 'ACTGACG' & 'gacgact' = true
 */
public class EX_1_2_6 {
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
