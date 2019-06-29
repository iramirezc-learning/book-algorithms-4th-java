import edu.princeton.cs.algs4.StdOut;

/**
 * Compilation: javac E1106.java
 * Execution: java E1106
 *
 * $ java E1106
 * 0 1 1 2 3 4 8 13 21 34 55 89 144 233 377 610
 */

/**
 * E1106. Mystery Code
 */
public class E1106 {
  public static void main(String[] args) {
    int f = 0;
    int g = 1;

    for (int i = 0; i <= 15; i++) {
      StdOut.println(f);
      f = f + g;
      g = f - g;
    }
  }
}