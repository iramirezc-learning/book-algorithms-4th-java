import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import java.awt.Color;
import java.util.Arrays;

/**
 * Compilation: javac E1132.java
 * Execution: java E1132 <int_intervals> <double_low> <double_high> < <input_file>
 *
 * $ java E1132 10 0 1000 < ~/algs4-data/custom/doubles.txt
 * Histogram: [112, 98, 78, 100, 99, 118, 104, 104, 99, 88]
 * Max: 118.0 Interval Size: 100.0
 */

/**
 * E1132
 */
public class E1132 {
  public static Color[] COLORS = { StdDraw.MAGENTA, StdDraw.GREEN, StdDraw.BLUE, StdDraw.RED };

  public static void plotValues(int[] h, double yMax) {
    int n = h.length;
    double xWidth = 0.5 / n;

    for (int i = 0; i < n; i++) {
      double x1 = (1.0 * i / n) + xWidth;
      double y1 = h[i] / (yMax * 2);
      double y2 = h[i] / (yMax * 2);
      StdDraw.setPenColor(COLORS[i % 4]);
      StdDraw.filledRectangle(x1, y1, xWidth, y2);
    }
  }

  public static void main(String[] args) throws Exception {
    if (args.length != 3) {
      throw new Error("You must provide: <integer> <double> <double>");
    }

    int n = Integer.parseInt(args[0]);
    double lo = Double.parseDouble(args[1]);
    double hi = Double.parseDouble(args[2]);

    lo = Math.min(lo, hi);
    hi = Math.max(lo, hi);

    double range = hi - lo;

    double intervalSize = range / n;

    int[] histogram = new int[n];

    double yMax = 0.0;

    while (!StdIn.isEmpty()) {
      double number = StdIn.readDouble();
      if (number >= lo && number <= hi) {
        for (int i = 0; i < n; i++) {
          double limit = lo + intervalSize * (i + 1);
          if (number > limit) {
            continue;
          } else {
            histogram[i]++;
            if (histogram[i] > yMax) {
              yMax = histogram[i];
            }
            break;
          }
        }
      }
    }

    System.out.println("Histogram: " + Arrays.toString(histogram));
    System.out.println("Max: " + yMax + " Interval Size: " + intervalSize);
    plotValues(histogram, yMax);
  }
}