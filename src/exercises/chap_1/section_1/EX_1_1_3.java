import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise: 1.1.3
 * Description: Checks if the three numbers provided are equal.
 * Compilation: javac EX_1_1_3.java
 * Execution: java EX_1_1_3 <number1> <number2> <number3>
 * Examples:
 *
 * $ java EX_1_1_3 5 5 5
 * equal
 *
 * $ java EX_1_1_3 5 1 5
 * not equal
 */
public class EX_1_1_3 {
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
