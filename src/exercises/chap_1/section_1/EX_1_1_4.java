import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise: 1.1.4
 * Description: Syntax Errors
 * Compilation: javac EX_1_1_4.java
 * ...
 * 4 errors
 */
public class EX_1_1_4 {
  public static void a() {
    int a = 5;
    int b = 4;
    int c;

    // Syntax error: commented for compiling
    // if (a > b) then c = 0;
  }

  public static void b() {
    int a = 5;
    int b = 4;
    int c;

    // Syntax error: commented for compiling
    // if a > b { c = 0; }
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

    // Syntax error: commented for compiling
    // if (a > b) c = 0 else b = 0;
  }

  public static void main(String[] args) {
    System.out.println("This won't compile");
  }
}
