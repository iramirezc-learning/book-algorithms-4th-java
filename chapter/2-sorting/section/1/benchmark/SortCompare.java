import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Type: Benchmark
 * Description: Runs two different sorting algorithms and compares their running times.
 * Ref: p. 256
 *
 * Compilation: javac SortCompare.java
 * Execution: java SortCompare <alg1> <alg2> <n> <trials>
 *
 * $ java SortCompare Insertion Selection 1000 100
 * For 1000 random Doubles
 *     Insertion is 1.2 times faster than Selection
 *
 * $ java SortCompare Shell Insertion 1000 100
 * For 1000 random Doubles
 *     Shell is 4.1 times faster than Insertion
 */

/**
 * SortCompare
 */
public class SortCompare {
  public static double time(String algorithm, Double[] a) {
    StopWatch timer = new StopWatch();
    if (algorithm.equals("Insertion")) {
      InsertionSort.sort(a);
    }
    if (algorithm.equals("Selection")) {
      SelectionSort.sort(a);
    }
    if (algorithm.equals("Shell")) {
      ShellSort.sort(a);
    }
    return timer.elapsedTime();
  }

  public static double timeRandomInput(String algorithm, int n, int trials) {
    double total = 0.0;
    Double[] a = new Double[n];

    for (int t = 0; t < trials; t++) {
      for (int i = 0; i < n; i++) {
        a[i] = StdRandom.uniform(0.0, 1.0);
      }
      total += time(algorithm, a);
    }

    return total;
  }

  public static void main(String[] args) throws Exception {
    if (args.length != 4) {
      throw new Error("You must provide: <name_algorithm_1> <name_algorithm_2> <n> <trials>");
    }

    String algorithm1 = args[0];
    String algorithm2 = args[1];
    int n = Integer.parseInt(args[2]);
    int trials = Integer.parseInt(args[3]);

    double time1 = timeRandomInput(algorithm1, n, trials);
    double time2 = timeRandomInput(algorithm2, n, trials);
    double ratio = time2 / time1;

    StdOut.printf("For %d random Doubles\n    %s is", n, algorithm1);
    StdOut.printf(" %.1f times faster than %s\n", ratio, algorithm2);
  }
}