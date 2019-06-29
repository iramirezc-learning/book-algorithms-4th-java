/**
 * Compilation: javac E1116.java
 * Execution: java E1116 <integer>
 *
 * $ java E1116 6
 * 311361142246
 */

/**
 * E1116
 */
public class E1116 {
  public static String exR1(int n) {
    if (n <= 0)
      return "";
    return exR1(n - 3) + n + exR1(n - 2) + n;
  }

  public static void main(String[] args) throws Exception {
    if (args.length != 1) {
      throw new Error("You must provide a integer number");
    }
    int n = Integer.parseInt(args[0]);
    System.out.println(exR1(n));
  }
}