import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise: 1.2.4
 * Description: Mystery Code
 * Compilation: javac EX_1_2_4.java
 * Execution: java EX_1_2_4
 * Example(s):
 *
 * $ java EX_1_2_4
 * world
 * hello
 */
public class EX_1_2_4 {
  public static void main(String[] args) {
    String string1 = "hello";
    String string2 = string1;

    string1 = "world";
    StdOut.println(string1);
    StdOut.println(string2);
  }
}
