import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Compilation: javac E1201.java
 * Execution: java E1201 <n>
 *
 * $ java E1201 100
 * Min distance: 0.010434
 */

/**
 * E1201
 */
public class E1201 {

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