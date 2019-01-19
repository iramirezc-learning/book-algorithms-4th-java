import edu.princeton.cs.algs4.StdOut;

/**
 * Compilation: javac E1105.java
 * Execution: java E1105 <duble1> <double2>
 *
 * $ java E1105 0.5 0.2
 * true
 *
 * $ java E1105 1.5 0.3
 * false
 * 
 * $ java E1105 0.3 1.3
 * false
 */

/**
 * E1105. Checks if `x` and `y` are stricly between 0 an 1
 */
public class E1105 {
  public static boolean isInBounds(double n) {
    return n > 0 && n < 1;
  }

  public static void main(String[] args) throws Exception {
    if (args.length != 2) {
      throw new Exception("Must provide exactly 2 doubles");
    }

    double x = Double.parseDouble(args[0]);
    double y = Double.parseDouble(args[1]);

    boolean result = isInBounds(x) && isInBounds(y);

    StdOut.println(result);
  }
}