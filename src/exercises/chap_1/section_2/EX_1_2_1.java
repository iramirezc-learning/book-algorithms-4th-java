import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Exercise: 1.2.1
 * Description: Point2D Client
 * Compilation: javac EX_1_2_1.java
 * Execution: java EX_1_2_1 <n>
 * Example(s):
 *
 * $ java EX_1_2_1 10000
 * Min distance: 0.000079
 */
public class EX_1_2_1 {
  public static Point2D[] generateRandomPoints(int n) {
    StdDraw.setPenColor(StdDraw.BLACK);

    Point2D[] points = new Point2D[n];

    for (int i = 0; i < n; i++) {
      double x = StdRandom.uniform(0.0, 1.0);
      double y = StdRandom.uniform(0.0, 1.0);
      Point2D p = new Point2D(x, y);

      p.draw();
      points[i] = p;
    }

    return points;
  }

  /**
   * A brute force approach
   * to get the closest pair
   * of point.
   */
  public static double getMinDistance(Point2D[] points) throws Exception {
    if (points.length < 2) {
      throw new Error("You must provide at least two points.");
    }

    double minDistance = points[0].distanceTo(points[1]);
    int length = points.length;

    for (int i = 0; i < length - 1; i++) {
      for (int j = i + 1; j < length; j++) {
        double distance = points[i].distanceTo(points[j]);

        if (distance < minDistance) {
          minDistance = distance;
        }
      }
    }

    return minDistance;
  }

  public static void main(String[] args) throws Exception {
    if (args.length != 1) {
      throw new Error("You must provide: <int_n>");
    }

    int n = Integer.parseInt(args[0]);
    Point2D[] points = generateRandomPoints(n);

    StdOut.printf("Min distance: %f\n", getMinDistance(points));
  }
}
