import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

/**
 * Type: Snippet
 * Description: Performs dot products for sparse vectors.
 * Ref: p. 503
 *
 * Compilation: javac SparseVector.java
 * Execution: java SparseVector
 *
 * $ java SparseVector
 * [0.036000000000000004, 0.297, 0.333, 0.045000000000000005, 0.19269999999999998]
 */

/**
 * SparseVector
 */
public class SparseVector {
  private ST<Integer, Double> st;

  public SparseVector() {
    st = new ST<Integer, Double>();
  }

  public int size() {
    return st.size();
  }

  public void put(int i, double x) {
    st.put(i, x);
  }

  public double get(int i) {
    if (!st.contains(i))
      return 0.0;
    return st.get(i);
  }

  public double dot(double[] that) {
    double sum = 0.0;

    for (int i : st.keys()) {
      sum += that[i] * this.get(i);
    }

    return sum;
  }

  public static void main(String[] args) {
    int n = 5;
    SparseVector[] a;
    a = new SparseVector[n];

    double[] x = { 0.05, 0.04, 0.36, 0.37, 0.19 };
    double[] b = new double[n];

    for (int i = 0; i < n; i++) {
      a[i] = new SparseVector();
    }

    a[0].put(1, .90);
    a[1].put(2, .36);
    a[1].put(3, .36);
    a[1].put(4, .18);
    a[2].put(3, .90);
    a[3].put(0, .90);
    a[4].put(0, .47);
    a[4].put(2, .47);

    // dot product
    for (int i = 0; i < n; i++) {
      b[i] = a[i].dot(x);
    }

    StdOut.println(Arrays.toString(b));
  }
}