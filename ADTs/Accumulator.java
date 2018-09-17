import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Compilation: javac Accumulator.java
 * Execution: java Accumulator <trials>
 *
 * $ java Accumulator 1000
 * Mean (1000 values): 0.49295
 */

/**
 * Accumulator
 */
public class Accumulator {
  private double sum;
  private int n;

  public void addDataValue(double value) {
    n++;
    sum += value;
  }

  public double mean() {
    return sum / n;
  }

  public String toString() {
    String s = "Mean (" + n + " values): ";
    return s + String.format("%7.5f", mean());
  }

  public static void main(String[] args) {
    int trials = Integer.parseInt(args[0]);
    Accumulator a = new Accumulator();

    for (int t = 0; t < trials; t++) {
      a.addDataValue(StdRandom.uniform(0.0, 1.0));
    }

    StdOut.println(a);
  }
}