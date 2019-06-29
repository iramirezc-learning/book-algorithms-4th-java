import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Type: Snippet
 * Description: Sample Bag client.
 * Ref: p. 125
 * Compilation: javac Stats.java
 * Execution: java Stats < <standard_input>
 *
 * $ java Stats
 * Reading from Standard Input...
 * $ 100
 * $ 99
 * $ 101
 * $ 120
 * $ 98
 * $ 107
 * $ 109
 * $ 81
 * $ 101
 * $ 90
 * $ <ctrl-d>
 * Mean: 100.60
 * Stddev: 10.51
 */

/**
 * Stats
 */
public class Stats {

  public static void main(String[] args) {
    Bag<Double> numbers = new Bag<Double>();

    StdOut.println("Reading from Standard Input...");

    while (!StdIn.isEmpty()) {
      numbers.add(StdIn.readDouble());
    }

    int n = numbers.size();

    double sum = 0.0;

    for (double x : numbers) {
      sum += x;
    }

    double mean = sum / n;

    sum = 0.0;

    for (double x : numbers) {
      sum += (x - mean) * (x - mean);
    }

    double stddev = Math.sqrt(sum / (n - 1));

    StdOut.printf("Mean: %.2f\n", mean);
    StdOut.printf("Stddev: %.2f\n", stddev);
  }
}