import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * VisualAccumulator
 * Type: ADT
 * Description: An abstract data type for accumulating data values (visual version).
 * Ref: p. 95
 * Compilation: javac VisualAccumulator.java
 * Execution: java VisualAccumulator <trial>
 * Example(s):
 *
 * $ java VisualAccumulator 2000
 * Mean (2000 values): 0.509789
 */
public class VisualAccumulator {
  private double sum;
  private int n;

  public VisualAccumulator(int trials, double max) {
    StdDraw.setXscale(0, trials);
    StdDraw.setYscale(0, max);
    StdDraw.setPenRadius(0.005);
  }

  public void addDataValue(double value) {
    n++;
    sum += value;
    StdDraw.setPenColor(StdDraw.DARK_GRAY);
    StdDraw.point(n, value);
    StdDraw.setPenColor(StdDraw.RED);
    StdDraw.point(n, mean());
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
    VisualAccumulator a = new VisualAccumulator(trials, 1.0);

    for (int t = 0; t < trials; t++) {
      a.addDataValue(StdRandom.uniform(0.0, 1.0));
    }

    StdOut.println(a);
  }
}
