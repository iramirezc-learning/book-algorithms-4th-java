import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Compilation: javac VisualAccumulatorTest.java
 * Execution: java VisualAccumulatorTest <trials>
 *
 * $ java VisualAccumulatorTest 1000
 * Mean (1000 values): 0.50118
 */

/**
 * VisualAccumulatorTest
 */
public class VisualAccumulatorTest {

  public static void main(String[] args) {
    int trials = Integer.parseInt(args[0]);

    VisualAccumulator a = new VisualAccumulator(trials, 1.0);

    for (int t = 0; t < trials; t++) {
      a.addDataValue(StdRandom.uniform(0.0, 1.0));
    }

    StdOut.println(a);
  }
}