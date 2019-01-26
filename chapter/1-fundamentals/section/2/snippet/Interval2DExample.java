import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Type: Snippet
 * Description: Interval2D test client.
 * Ref: p. 76
 * Compilation: javac Interval2DExample.java
 * Execution: java Interval2DExample <xmin> <xmax> <ymin> <ymax> <trials>
 *
 * $ java Interval2DExample .2 .5 .5 .6 1000
 * 26 hits
 * area = 0.03
 */

/**
 * Interval2DExample
 */
public class Interval2DExample {

  public static void main(String[] args) {
    double xmin = Double.parseDouble(args[0]);
    double xmax = Double.parseDouble(args[1]);
    double ymin = Double.parseDouble(args[2]);
    double ymax = Double.parseDouble(args[3]);
    int trials = Integer.parseInt(args[4]);

    Interval1D xint = new Interval1D(xmin, xmax);
    Interval1D yint = new Interval1D(ymin, ymax);
    Interval2D box = new Interval2D(xint, yint);

    box.draw();

    Counter counter = new Counter("hits");
    for (int t = 0; t < trials; t++) {
      double x = StdRandom.uniform(0.0, 1.0);
      double y = StdRandom.uniform(0.0, 1.0);
      Point2D p = new Point2D(x, y);
      if (box.contains(p)) {
        counter.increment();
      } else {
        p.draw();
      }
    }
    StdOut.println(counter);
    StdOut.printf("area = %.2f\n", box.area());
  }
}