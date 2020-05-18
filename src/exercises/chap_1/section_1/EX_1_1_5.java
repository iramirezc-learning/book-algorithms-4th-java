import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise: 1.1.5
 * Description: Checks if `x` and `y` are strictly between 0 and 1.
 * Compilation: javac EX_1_1_5.java
 * Execution: java EX_1_1_5 <double1> <double2>
 * Examples:
 *
 * $ java EX_1_1_5 0.5 0.2
 * true
 *
 * $ java EX_1_1_5 1.5 0.3
 * false
 * 
 * $ java EX_1_1_5 0.3 1.3
 * false
 */
public class EX_1_1_5 {
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
