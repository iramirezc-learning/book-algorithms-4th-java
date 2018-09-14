import edu.princeton.cs.algs4.StdOut;

/**
 * Compilation: javac Exercise_1_1_19.java
 * Execution: java Exercise_1_1_19
 *
 * $ java Exercise_1_1_19
 * fib(0) = 0
 * fib(1) = 1
 * fib(2) = 1
 * fib(3) = 2
 * fib(4) = 3
 * fib(5) = 5
 * fib(6) = 8
 * fib(7) = 13
 * fib(8) = 21
 * fib(9) = 34
 * fib(10) = 55
 * fib(11) = 89
 * fib(12) = 144
 * ...
 * fib(89) = 1779979416004714189
 */

/**
 * Exercise_1_1_19. Fibonacci Dynamic
 */
public class Exercise_1_1_19 {
  public static long fibonacci(int n) {
    if (n == 0)
      return 0;
    if (n == 1)
      return 1;
    return fibonacci(n - 1) + fibonacci(n - 2);
  }

  public static long betterFibonacci(int n, long[] fib) {
    if (fib[n] == -1)
      fib[n] = betterFibonacci(n - 1, fib) + betterFibonacci(n - 2, fib);

    return fib[n];
  }

  public static long[] FIB;

  public static void main(String[] args) {
    int N = 90;
    FIB = new long[N];

    for (int i = 0; i < FIB.length; i++) {
      FIB[i] = -1;
    }

    // initialize first two numbers
    FIB[0] = 0;
    FIB[1] = 1;

    for (int n = 0; n < N; n++) {
      StdOut.println("fib(" + n + ") = " + betterFibonacci(n, FIB));
    }
  }
}