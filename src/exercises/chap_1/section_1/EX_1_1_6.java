import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise: 1.1.6
 * Description: Mystery Code
 * Compilation: javac EX_1_1_6.java
 * Execution: java EX_1_1_6
 * Example(s):
 *
 * $ java EX_1_1_6
 * 0 1 1 2 3 4 8 13 21 34 55 89 144 233 377 610
 */
public class EX_1_1_6 {
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
