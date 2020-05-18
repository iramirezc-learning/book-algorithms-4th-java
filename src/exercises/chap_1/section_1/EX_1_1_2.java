import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise: 1.1.2
 * Description: Data Types
 * Compilation: javac EX_1_1_2.java
 * Execution: java EX_1_1_2
 * Example:
 *
 * $ java EX_1_1_2
 * a) (double) 1.618
 * b) (double) 10.0
 * c) (boolean) true
 * d) (int) 6
 */
public class EX_1_1_2 {
  public static void tellMeTheType(double val) {
    StdOut.println("(double) " + val);
  }

  public static void tellMeTheType(boolean val) {
    StdOut.println("(boolean) " + val);
  }

  public static void tellMeTheType(int val) {
    StdOut.println("(int) " + val);
  }

  public static void main(String[] args) {

    StdOut.print("a) ");
    tellMeTheType((1 + 2.236) / 2);
    StdOut.print("b) ");
    tellMeTheType((1 + 2 + 3 + 4.0));
    StdOut.print("c) ");
    tellMeTheType((4.1 >= 4));
    StdOut.print("d) ");
    tellMeTheType((1 + 2 + 3));
  }
}
