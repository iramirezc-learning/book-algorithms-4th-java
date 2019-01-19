import edu.princeton.cs.algs4.StdOut;

/**
 * Compilation: javac E1104.java
 * Error: 4 Syntaxis errors
 */

/**
 * E1104
 */
public class E1104 {
  public static void a() {
    int a = 5;
    int b = 4;
    int c;

    if (a > b) then c = 0; // Syntax error
  }

  public static void b() {
    int a = 5;
    int b = 4;
    int c;

    if a > b { c = 0; } // Syntax error
  }

  public static void c() {
    int a = 5;
    int b = 4;
    int c;

    if (a > b)
      c = 0;
  }

  public static void d() {
    int a = 5;
    int b = 4;
    int c;

    if (a > b) c = 0 else b = 0; // Syntax error
  }

  public static void main(String[] args) {
    System.out.println("This won't compile");
  }
}