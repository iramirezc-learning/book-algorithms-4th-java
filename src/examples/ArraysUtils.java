import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

/**
 * ArraysUtils
 * Type: Snippet
 * Description: Typical array-processing code.
 * Chapter: 1
 * Section: 1
 * Ref: p. 21
 * Compilation: javac ArraysUtils.java
 * Execution: java ArraysUtils
 * Example(s):
 *
 * $ java ArraysUtils
 * Array a)
 * max: 5.0
 * average: 3.0
 * reversed: [5.0, 4.0, 3.0, 2.0, 1.0]
 *
 * Array b)
 * max: 6.0
 * average: 3.2
 * reversed: [6.0, 4.0, 3.0, 2.0, 1.0]
 *
 * Matrix Multiplication:
 * [30.0, 36.0, 42.0]
 * [66.0, 81.0, 96.0]
 * [102.0, 126.0, 150.0]
 */
public class ArraysUtils {
  public static double findMax(double[] a) {
    double max = a[0];

    for (int i = 1; i < a.length; i++) {
      if (a[i] > max) {
        max = a[i];
      }
    }

    return max;
  }

  public static double average(double[] a) {
    int n = a.length;
    double sum = 0.0;

    for (int i = 0; i < n; i++)
      sum += a[i];

    double average = sum / n;

    return average;
  }

  public static double[] copy(double[] a) {
    int n = a.length;
    double[] b = new double[n];

    for (int i = 0; i < n; i++) {
      b[i] = a[i];
    }

    return b;
  }

  public static double[] reverse(double[] a) {
    int n = a.length;

    for (int i = 0; i < n / 2; i++) {
      double temp = a[i];

      a[i] = a[n - i - 1];
      a[n - i - 1] = temp;
    }

    return a;
  }

  public static double[][] squareMatrixMultiplication(double[][] a, double[][] b) {
    int n = a.length;
    double[][] c = new double[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < n; k++) {
          c[i][j] += a[i][k] * b[k][j];
        }
      }
    }

    return c;
  }

  public static String printMatrix(double[][] a) {
    int n = a.length;
    String s = "";

    for (int i = 0; i < n; i++) {
      s += Arrays.toString(a[i]) + '\n';
    }

    return s;
  }

  public static void main(String[] args) {
    double[] numbers = { 1, 2, 3, 4, 5 };
    double[] copyNumbers = copy(numbers);

    copyNumbers[4] = 6;

    StdOut.println("Array a)");
    StdOut.println("max: " + findMax(numbers));
    StdOut.println("average: " + average(numbers));
    StdOut.println("reversed: " + Arrays.toString(reverse(numbers)));
    StdOut.println();

    StdOut.println("Array b)");
    StdOut.println("max: " + findMax(copyNumbers));
    StdOut.println("average: " + average(copyNumbers));
    StdOut.println("reversed: " + Arrays.toString(reverse(copyNumbers)));
    StdOut.println();

    double[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

    StdOut.println("Matrix Multiplication:");
    StdOut.println(printMatrix(squareMatrixMultiplication(a, a)));
  }
}
