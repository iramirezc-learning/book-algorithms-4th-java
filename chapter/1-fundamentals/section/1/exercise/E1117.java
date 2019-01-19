/**
 * Compilation: javac E1117.java
 * Execution: java E1117
 *
 * $ java E1117
 * Exception in thread "main" java.lang.StackOverflowError
 */

/**
 * E1117
 */
public class E1117 {
  public static String exR2(int n) {
    String s = exR2(n - 3) + n + exR2(n - 2) + n;
    if (n <= 0)
      return "";
    return s;
  }

  public static void main(String[] args) {
    System.out.println(exR2(6));
  }
}