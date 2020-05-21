import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;

/**
 * Type: Snippet
 * Description: StdDraw plotting examples.
 * Chapter: 1
 * Section: 1
 * Ref: p. 45
 * Compilation: javac StdDrawExamples.java
 * Execution: java StdDrawExamples <1-3> <numbers>
 * Example(s):
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
      StdDraw.setPenColor(StdDraw.BLUE);
      StdDraw.point(i, i);
      StdDraw.setPenColor(StdDraw.RED);
      StdDraw.point(i, i * i);
      StdDraw.setPenColor(StdDraw.GREEN);
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

  public static void main(String[] args) throws Exception {
    if (args.length != 2) {
      throw new Error("You must provide: <1-3> <int_n>");
    }

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
