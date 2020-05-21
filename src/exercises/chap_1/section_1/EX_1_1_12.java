import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise: 1.1.12
 * Description: Mystery code
 * Compilation: javac EX_1_1_12.java
 * Execution: java EX_1_1_12
 * Example(s):
 *
 * $ java EX_1_1_12
 * 0 1 2 3 4 4 3 2 1 0
 */
public class EX_1_1_12 {
  public static void main(String[] args) {
    int[] a = new int[10];
    for (int i = 0; i < 10; i++)
      a[i] = 9 - i;
    for (int i = 0; i < 10; i++)
      a[i] = a[a[i]];
    for (int i = 0; i < 10; i++)
      System.out.println(a[i]);
  }
}
