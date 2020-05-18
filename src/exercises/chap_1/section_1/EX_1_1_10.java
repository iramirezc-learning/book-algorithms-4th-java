import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise: 1.1.10
 * Description: Not Compiling Code
 * Compilation: javac EX_1_1_10.java
 * EX_1_1_10.java:15: error: variable a might not have been initialized
 * ...
 * 1 error
 */
public class EX_1_1_10 {

  public static void main(String[] args) {
    int[] a;

    for (int i = 0; i < 10; i++) {
      // error happens here. commented for compiling
      // a[i] = i * i;
    }
  }
}
