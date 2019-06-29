import edu.princeton.cs.algs4.StdOut;

/**
 * Compilation: javac E1101.java
 * Execution: java E1101
 *
 * $ java E1101
 * a) 7
 * b) 200.0000002
 * c) true
 */

/**
 * E1101. Expressions
 */
public class E1101 {
  public static void main(String[] args) {

    StdOut.println("a) " + (0 + 15 / 2));
    StdOut.println("b) " + (2.0e-6 * 100000000.1));
    StdOut.println("c) " + (true && false || true && true));
  }
}