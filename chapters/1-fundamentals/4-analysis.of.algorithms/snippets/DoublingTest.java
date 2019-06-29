import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Type: Snippet
 * Description: Program to perform experiments with ThreeSum.
 * Ref: p. 177
 * Compilation: javac DoublingTest.java
 * Execution: java DoublingTest
 *
 * $ java DoublingTest
 *     250     0.0
 *     500     0.0
 *    1000     0.1
 *    2000     0.6
 *    4000     5.0
 *    8000    35.3
 * ... (continues)
 */

/**
 * DoublingTest
 */
public class DoublingTest {
  public static double timeTrial(int n) {
    int MAX = 1000000;
    int[] a = new int[n];

    for (int i = 0; i < n; i++) {
      a[i] = StdRandom.uniform(-MAX, MAX);
    }

    StopWatch timer = new StopWatch();
    int count = ThreeSum.count(a);
    return timer.elapsedTime();
  }

  public static void main(String[] args) {
    for (int n = 250; true; n *= 2) {
      double time = timeTrial(n);
      StdOut.printf("%7d %7.1f\n", n, time);
    }
  }
}