import edu.princeton.cs.algs4.StdOut;

/**
 * Compilation: javac Exercise_1_1_1.java
 * Execution: java Exercise_1_1_1
 *
 * $ java Exercise_1_1_1
 * a) 7
 * b) 200.0000002
 * c) true
 */

/**
 * Exercise_1_1_1. Expressions
 */
public class Exercise_1_1_1 {
  public static void main(String[] args) {

    StdOut.println("a) " + (0 + 15 / 2));
    StdOut.println("b) " + (2.0e-6 * 100000000.1));
    StdOut.println("c) " + (true && false || true && true));
  }
}