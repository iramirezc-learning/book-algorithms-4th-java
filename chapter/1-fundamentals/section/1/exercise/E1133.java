import java.util.Arrays;

/**
 * Compilation: javac E1133.java
 * Execution: java E1133
 *
 * $ java E1133
 * dot:
 * 122.0
 * 
 * mult (matrix-matrix):
 * [0.0, -10.0]
 * [-3.0, -1.0]
 * 
 * mult (matrix-matrix) 2:
 * [22.0, 28.0]
 * [49.0, 64.0]
 * 
 * mult (matrix-matrix) 3:
 * [9.0, 12.0, 15.0]
 * [19.0, 26.0, 33.0]
 * [29.0, 40.0, 51.0]
 * 
 * transpose:
 * [1.0, 4.0, 7.0]
 * [2.0, 5.0, 8.0]
 * [3.0, 6.0, 9.0]
 * 
 * mult (matrix-vector):
 * [1.0, -3.0]
 * 
 * mult (vector-matrix):
 * [13.0, 31.0, 49.0]
 */

/**
 * E1133. Matrix Library
 */
public class E1133 {
  public static String printMatrix(double[][] a) {
    int n = a.length;
    String s = "";

    for (int i = 0; i < n; i++) {
      s += Arrays.toString(a[i]) + '\n';
    }

    return s;
  }

  public static String printMatrix(double[] a) {
    return Arrays.toString(a);
  }

  /**
   * vector dot product
   * Reference: https://www.mathsisfun.com/algebra/vectors-dot-product.html
   */
  static double dot(double[] x, double[] y) {
    int n = x.length;
    double sum = 0.0;

    for (int i = 0; i < n; i++) {
      sum += x[i] * y[i];
    }

    return sum;
  }

  /**
   * transpose
   */
  static double[][] transpose(double[][] a) {
    int rows = a.length;
    int cols = a[0].length;
    double[][] transposed = new double[cols][rows];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        transposed[j][i] = a[i][j];
      }
    }

    return transposed;
  }

  /**
   * matrix-matrix product
   */
  static double[][] mult(double[][] a, double[][] b) {
    int n = a.length;
    double[][] c = new double[n][n];
    double[][] t = transpose(b);

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        c[i][j] += dot(a[i], t[j]);
      }
    }

    return c;
  }

  /**
   * matrix-vector product
   * Reference: https://mathinsight.org/matrix_vector_multiplication
   */
  static double[] mult(double[][] a, double[] x) {
    int n = a.length;
    double[] c = new double[n];

    for (int i = 0; i < n; i++) {
      c[i] = dot(a[i], x);
    }

    return c;
  }

  /**
   * vector-matrix product
   */
  static double[] mult(double[] y, double[][] a) {
    return mult(a, y);
  }

  public static void main(String[] args) {
    double[] x = { 9, 2, 7 };
    double[] y = { 4, 8, 10 };

    System.out.println("dot:\n" + dot(x, y) + "\n");
    // 122.0

    double[][] a = { { 0, 4, -2 }, { -4, -3, 0 } };
    double[][] b = { { 0, 1 }, { 1, -1 }, { 2, 3 } };
    System.out.println("mult (matrix-matrix):\n" + printMatrix(mult(a, b)));
    // [
    //    [0.0, -10.0],
    //    [-3.0, -1.0]
    // ]

    a = new double[][] { { 1, 2, 3 }, { 4, 5, 6 } };
    b = new double[][] { { 1, 2 }, { 3, 4 }, { 5, 6 } };
    System.out.println("mult (matrix-matrix) 2:\n" + printMatrix(mult(a, b)));
    // [
    //    [22.0, 28.0],
    //    [49.0, 64.0]
    // ]

    System.out.println("mult (matrix-matrix) 3:\n" + printMatrix(mult(b, a)));
    // [
    //    [9.0, 12.0, 15.0],
    //    [19.0, 26.0, 33.0],
    //    [29.0, 40.0, 51.0]
    // ]

    a = new double[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    System.out.println("transpose:\n" + printMatrix(transpose(a)));
    // [
    //   [1.0, 4.0, 7.0],
    //   [2.0, 5.0, 8.0],
    //   [3.0, 6.0, 9.0]
    // ]

    a = new double[][] { { 1, -1, 2 }, { 0, -3, 1 } };
    x = new double[] { 2, 1, 0 };
    System.out.println("mult (matrix-vector):\n" + printMatrix(mult(a, x)) + "\n");
    // [1.0, -3.0]

    a = new double[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    y = new double[] { 2, 1, 3 };
    System.out.println("mult (vector-matrix):\n" + printMatrix(mult(y, a)));
    // [13, 31, 49]
  }
}