/**
 * Exercise: 1.1.17
 * Description: Mystery exR2 code
 * Compilation: javac EX_1_1_17.java
 * Execution: java EX_1_1_17
 * Example(s):
 *
 * $ java EX_1_1_17
 * Exception in thread "main" java.lang.StackOverflowError
 */
public class EX_1_1_17 {
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
