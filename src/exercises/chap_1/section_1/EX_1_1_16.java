/**
 * Exercise: 1.1.16
 * Description: Mystery exR1 code
 * Compilation: javac EX_1_1_16.java
 * Execution: java EX_1_1_16 <integer>
 * Example(s):
 *
 * $ java EX_1_1_16 6
 * 311361142246
 */
public class EX_1_1_16 {
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
