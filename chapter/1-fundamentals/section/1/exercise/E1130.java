import java.util.Arrays;
import edu.princeton.cs.algs4.StdOut;

/**
 * Compilation: javac E1130.java
 * Execution: java E1130 <rows> <cols>
 *
 * $ java E1130 21 41
 * // * ***************************************
 * // 
 * // * * * * * * * * * * * * * * * * * * * * *
 * // *  *  *  *  *  *  *  *  *  *  *  *  *  *
 * // * * * * * * * * * * * * * * * * * * * * *
 * // *    *    *    *    *    *    *    *    *
 * // * *** * *** * *** * *** * *** * *** * ***
 * // *      *      *      *      *      *
 * // * * * * * * * * * * * * * * * * * * * * *
 * // *  *  *  *  *  *  *  *  *  *  *  *  *  *
 * // * * *** * * * *** * * * *** * * * *** * *
 * // *          *          *          *
 * // * *** * *** * *** * *** * *** * *** * ***
 * // *            *            *            *
 * // * * * *** * * * * * *** * * * * * *** * *
 * // *  * **  ** *  *  * **  ** *  *  * **  **
 * // * * * * * * * * * * * * * * * * * * * * *
 * // *                *                *
 * // * *** * *** * *** * *** * *** * *** * ***
 * // *                  *                  *
 * // * * *** * * * *** * * * *** * * * *** * *
 * 
 * Reference:
 * - http://mathworld.wolfram.com/RelativelyPrime.html
 * - https://www.mathsisfun.com/definitions/relatively-prime.html
 */

/**
 * E1130. Array with relatively primes.
 */
public class E1130 {
  public static int euclidean(int p, int q) {
    if (q == 0)
      return p;
    int r = p % q;
    return euclidean(q, r);
  }

  public static boolean[][] generateMatrix(int rows, int cols) {
    boolean[][] matrix = new boolean[rows][cols];

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (euclidean(i, j) == 1) {
          matrix[i][j] = true;
        }
      }
    }

    return matrix;
  }

  public static String printTable(boolean[][] m) {
    String tableAsString = "";

    for (int i = 0; i < m.length; i++) {
      for (int j = 0; j < m[i].length; j++) {
        tableAsString += m[i][j] ? " " : "*";
      }
      tableAsString += '\n';
    }

    return tableAsString;
  }

  public static void main(String[] args) throws Exception {
    if (args.length != 2) {
      throw new Error("You must provide two integers: <rows> <cols>");
    }
    int rows = Integer.parseInt(args[0]);
    int cols = Integer.parseInt(args[1]);

    boolean[][] m = generateMatrix(rows, cols);

    StdOut.println(printTable(m));
  }
}