import edu.princeton.cs.algs4.StdOut;

/**
 * Compilation: javac E1103.java
 * Execution: java E1103 <number1> <number2> <number3>
 *
 * $ java E1103 5 5 5
 * equal
 *
 * $ java E1103 5 1 5
 * not equal
 */

/**
 * E1103. Checks if the three numbers provided are equal.
 */
public class E1103 {
  public static void main(String[] args) throws Exception {
    if (args.length != 3) {
      throw new Exception("Must provide exactly 3 numbers");
    }

    int n1 = Integer.parseInt(args[0]);
    int n2 = Integer.parseInt(args[1]);
    int n3 = Integer.parseInt(args[2]);

    boolean result = n1 == n2 && n2 == n3;

    StdOut.println(result ? "equal" : "not equal");
  }
}