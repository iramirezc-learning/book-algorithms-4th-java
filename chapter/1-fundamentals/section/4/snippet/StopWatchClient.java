import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Type: Snippet
 * Description: A simple StopWatch client
 * Ref: p. 175
 *
 * Compilation: javac StopWatchClient.java
 * Execution: java StopWatchClient <int_n>
 * 
 * $ java StopWatchClient 1000
 * 77 triples 0.304 seconds
 * 
 * $ java StopWatchClient 2000
 * 507 triples 2.292 seconds
 */

/**
 * StopWatchClient
 */
public class StopWatchClient {
  public static void main(String[] args) throws Exception {
    if (args.length != 1) {
      throw new Error("You must provide: <int_n>");
    }

    int n = Integer.parseInt(args[0]);
    int[] a = new int[n];

    for (int i = 0; i < n; i++) {
      a[i] = StdRandom.uniform(-1000000, 1000000);
    }

    StopWatch timer = new StopWatch();
    int count = ThreeSum.count(a);
    double time = timer.elapsedTime();
    StdOut.println(count + " triples " + time + " seconds");
  }
}