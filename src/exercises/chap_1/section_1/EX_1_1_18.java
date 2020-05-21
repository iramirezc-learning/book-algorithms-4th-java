/**
 * Exercise: 1.1.18
 * Description: Mystery code
 * Compilation: javac EX_1_1_18.java
 * Execution: java EX_1_1_18
 * Example(s):
 *
 * $ java EX_1_1_18
 * a) 50, 33
 * d) 33554432, 177147
 */
public class EX_1_1_18 {
  public static int mystery(int a, int b) {
    if (b == 0)
      return 0;

    if (b % 2 == 0)
      return mystery(a + a, b / 2);

    return mystery(a + a, b / 2) + a;
  }

  public static int mystery2(int a, int b) {
    if (b == 0)
      return 1;

    if (b % 2 == 0)
      return mystery2(a * a, b / 2);

    return mystery2(a * a, b / 2) * a;
  }

  public static void main(String[] args) {
    System.out.println("a) " + mystery(2, 25) + ", " + mystery(3, 11));
    System.out.println("d) " + mystery2(2, 25) + ", " + mystery2(3, 11));
  }
}
