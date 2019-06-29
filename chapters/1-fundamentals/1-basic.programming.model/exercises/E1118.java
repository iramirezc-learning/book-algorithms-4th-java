/**
 * Compilation: javac E1118.java
 * Execution: java E1118
 *
 * $ java E1118
 * a) 50, 33
 * c) 33554432, 177147
 */

/**
 * E1118
 */
public class E1118 {
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