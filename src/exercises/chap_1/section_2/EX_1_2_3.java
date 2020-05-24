import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Exercise: 1.2.3
 * Description: Interval2D client
 * Compilation: javac EX_1_2_3.java
 * Execution: java EX_1_2_3 <int_n> <double_min> <double_max>
 * Example(s):
 *
 * $ java EX_1_2_3 5 .3 .7
 * Total intersections: 2
 * Total contained: 1
 */
public class EX_1_2_3 {
  public static double[] getRandomMinAndMax(double min, double max) {
    double[] values = new double[2];

    double xMin = StdRandom.uniform(min, max);
    double xMax = StdRandom.uniform(min, max);
    double temp;

    if (xMin > xMax) {
      temp = xMin;
      xMin = xMax;
      xMax = temp;
    }

    values[0] = xMin;
    values[1] = xMax;

    return values;
  }

  public static int countIntersections(Interval2D box, Interval2D[] intervals, int limit) {
    int count = 0;

    for (int i = 0; i < limit; i++) {
      if (box.intersects(intervals[i])) {
        count++;
      }
    }

    return count;
  }

  public static boolean isContained(Point2D x, Point2D y, Interval2D interval) {
    if (!interval.contains(x))
      return false;

    if (!interval.contains(y))
      return false;

    return true;
  }

  public static int countContained(Point2D x, Point2D y, Interval2D[] intervals, int limit) {
    int count = 0;

    for (int i = 0; i < limit; i++) {
      if (isContained(x, y, intervals[i])) {
        count++;
      }
    }

    return count;
  }

  public static void main(String[] args) throws Exception {
    if (args.length != 3) {
      throw new Error("You must provide: <int_n> <double_min> <double_max>");
    }

    int n = Integer.parseInt(args[0]);
    double min = Double.parseDouble(args[1]);
    double max = Double.parseDouble(args[2]);

    Interval2D[] intervals = new Interval2D[n];
    int totalIntersections = 0;
    int totalContained = 0;

    for (int i = 0; i < n; i++) {
      double[] x = getRandomMinAndMax(min, max);
      Interval1D xint = new Interval1D(x[0], x[1]);

      double[] y = getRandomMinAndMax(min, max);
      Interval1D yint = new Interval1D(y[0], y[1]);

      Point2D xp = new Point2D(x[0], y[0]);
      Point2D yp = new Point2D(x[1], y[1]);

      Interval2D box = new Interval2D(xint, yint);

      box.draw();

      totalIntersections += countIntersections(box, intervals, i);
      // TODO: when the first box is smaller than the next ones,
      // then it wont be considered as contained
      // even if in the drawing appears inside another box.
      totalContained += countContained(xp, yp, intervals, i);

      intervals[i] = box;
    }

    StdOut.printf("Total intersections: %d\n", totalIntersections);
    StdOut.printf("Total contained: %d\n", totalContained);
  }
}
