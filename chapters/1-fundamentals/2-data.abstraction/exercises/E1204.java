import edu.princeton.cs.algs4.StdOut;

/**
 * Compilation: javac E1204.java
 * Execution: java E1204
 *
 * $ java E1204
 * world
 * hello
 */

/**
 * E1204
 */
public class E1204 {

  public static void main(String[] args) {
    String string1 = "hello";
    String string2 = string1;
    string1 = "world";
    StdOut.println(string1);
    StdOut.println(string2);
  }
}