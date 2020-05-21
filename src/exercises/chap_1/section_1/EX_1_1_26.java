import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise 1.1.26
 * Description: Testing Ascending Order
 * Compilation: javac EX_1_1_26.java
 * Execution: java EX_1_1_26
 * Example(s):
 *
 * $ java EX_1_1_26
 * a: 1, b: 2, c: 3
 * ascending order? true
 */
public class EX_1_1_26 {
  public static void main(String[] args) {
    int a = 3;
    int b = 2;
    int c = 1;
    int t;

    if (a > b) {
      t = a;
      a = b;
      b = t;
    }

    if (a > c) {
      t = a;
      a = c;
      c = t;
    }

    if (b > c) {
      t = b;
      b = c;
      c = t;
    }

    StdOut.printf("a: %d, b: %d, c: %d\n", a, b, c);
    StdOut.printf("ascending order? %b\n", a < b && a < c && b < c);
  }
}
