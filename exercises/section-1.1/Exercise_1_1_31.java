import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Compilation: javac Exercise_1_1_31.java
 * Execution: java Exercise_1_1_31 <n> <p>
 *
 * $ java Exercise_1_1_31 10 0.5
 * 
 * Reference:
 * - https://introcs.cs.princeton.edu/java/stdlib/javadoc/StdDraw.html
 * - https://stackoverflow.com/questions/18610350/android-dividing-circle-into-n-equal-parts-and-know-the-coordinates-of-each-divi
 * - https://github.com/aistrate/AlgorithmsSedgewick/blob/master/1-Fundamentals/1-1-BasicProgModel/Ex_1_1_31.java
 */

/**
 * Exercise_1_1_31. Random connections.
 */
public class Exercise_1_1_31 {
  public static void drawRandomConnections(int n, double p) {
    double[] pointsX = new double[n];
    double[] pointsY = new double[n];

    double CENTER_X = 0.5;
    double CENTER_Y = 0.5;
    double RADIUS = 0.5;

    // Canvas Scale
    StdDraw.setScale(-0.05, 1.05);
    // Pen Radius
    StdDraw.setPenRadius(0.05);

    // set the pen color to Green
    StdDraw.setPenColor(StdDraw.GREEN);

    // calculate the arc size
    double arcSize = 360 / (double) n;

    // draw `n` equally spaced dots on the circumference of the circle
    for (int i = 0; i < n; i++) {
      double angle = Math.toRadians(i * arcSize);
      double pointX = CENTER_X + RADIUS * Math.cos(angle);
      double pointY = CENTER_Y + RADIUS * Math.sin(angle);

      pointsX[i] = pointX;
      pointsY[i] = pointY;

      StdDraw.point(pointX, pointY);
    }

    // set the pen color to Gray and pen radius to 0.25
    StdDraw.setPenColor(StdDraw.GRAY);
    StdDraw.setPenRadius(0.0125);

    // draw a line connecting each pair of points with probability `p`
    // from aistrate's code
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        if (StdRandom.bernoulli(p)) {
          StdDraw.line(pointsX[i], pointsY[i], pointsX[j], pointsY[j]);
        }
      }
    }
  }

  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    double p = Double.parseDouble(args[1]);

    p = Math.max(0, Math.min(1, p));

    drawRandomConnections(n, p);
  }
}