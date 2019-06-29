import edu.princeton.cs.algs4.StdOut;

/**
 * Compilation: javac E1110.java
 * Error: variable a might not have been initialized
 */

/**
 * E1110
 */
public class E1110 {

  public static void main(String[] args) {
    int[] a;
    for (int i = 0; i < 10; i++)
      a[i] = i * i; // <- error happens here
  }
}