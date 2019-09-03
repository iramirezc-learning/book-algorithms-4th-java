import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

/**
 * Type: Snippet
 * Description: Standard implementation of matrix-vector multiplication.
 * Ref: p. 502
 *
 * Compilation: javac MatrixVector.java
 * Execution: java MatrixVector
 *
 * $ java MatrixVector
 * [0.036000000000000004, 0.297, 0.333, 0.045000000000000005, 0.19269999999999998]
 */

/**
 * MatrixVector
 */
public class MatrixVector {
  public static void main(String[] args) {
    int n = 5;
    double[][] a = { { 0, 0.90, 0, 0, 0 }, { 0, 0, 0.36, 0.36, 0.18 }, { 0, 0, 0, 0.90, 0 }, { 0.90, 0, 0, 0, 0 },
        { 0.47, 0, 0.47, 0, 0 } };
    double[] x = { 0.05, 0.04, 0.36, 0.37, 0.19 };
    double[] b = new double[n];

    // dot product
    for (int i = 0; i < n; i++) {
      double sum = 0.0;
      for (int j = 0; j < n; j++) {
        sum += a[i][j] * x[j];
      }
      b[i] = sum;
    }

    StdOut.println(Arrays.toString(b));
  }
}