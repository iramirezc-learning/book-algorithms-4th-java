import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;

/**
 * Type: Snippet
 * Description: StdDraw plotting examples.
 * Ref: p. 45
 * Compilation: javac StdDrawExamples.java
 * Execution: java StdDrawExamples <1-3> <numbers>
 *
 * $ java StdDrawExamples 1 100
 *
 * $ java StdDrawExamples 2 50
 *
 * $ java StdDrawExamples 3 50
 */

public class StdDrawExamples {
  public static void functionValues(int n) {
    StdDraw.setXscale(0, n);
    StdDraw.setYscale(0, n * n);
    StdDraw.setPenRadius(0.01);
    for (int i = 1; i <= n; i++) {
      StdDraw.point(i, i);
      StdDraw.point(i, i * i);
      StdDraw.point(i, i * Math.log(i));
    }
  }

  public static void plotValues(double[] a) {
    int n = a.length;

    for (int i = 0; i < n; i++) {
      double x = 1.0 * i / n;
      double y = a[i] / 2.0;
      double rw = 0.5 / n;
      double rh = a[i] / 2.0;
      StdDraw.filledRectangle(x, y, rw, rh);
    }
  }

  public static void main(String[] args) {
    int o = new Integer(args[0]);
    int n = new Integer(args[1]);

    double[] a = new double[n];

    for (int i = 0; i < n; i++) {
      a[i] = StdRandom.uniform();
    }

    switch (o) {
    case 3:
      Arrays.sort(a);
      plotValues(a);
      break;
    case 2:
      plotValues(a);
      break;
    default:
      functionValues(n);
    }
  }
}