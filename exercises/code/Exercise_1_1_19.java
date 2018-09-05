import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise_1_1_19. Fibonacci
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
      StdOut.println(n + " " + betterFibonacci(n, FIB));
    }
  }
}