import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Exercise: 1.1.13
 * Description: Transposes a bi-dimensional array.
 * Compilation: javac EX_1_1_13.java
 * Execution: java EX_1_1_13 <rows> <cols>
 * Example(s):
 *
 * $ java EX_1_1_13 2 3
 * Original ->
 *     5    3    4
 *     5    3    4
 * Transposed ->
 *     5    5
 *     3    3
 *     4    4
 */
public class EX_1_1_13 {
  public static int[][] createTable(int rows, int cols) {
    int[][] table = new int[rows][cols];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        table[i][j] = StdRandom.uniform(rows * cols);
      }
    }

    return table;
  }

  public static void printTable(int[][] a) {
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[i].length; j++) {
        StdOut.printf("%5d", a[i][j]);
      }

      StdOut.println();
    }
  }

  public static int[][] transpose(int[][] a) {
    int rows = a.length;
    int cols = a[0].length;
    int[][] transposed = new int[cols][rows];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        transposed[j][i] = a[i][j];
      }
    }

    return transposed;
  }

  public static void main(String[] args) throws Exception {
    if (args.length != 2) {
      throw new Error("You must provide 2 numbers for <rows> <cols>");
    }

    int rows = Integer.parseInt(args[0]);
    int cols = Integer.parseInt(args[1]);
    int[][] table = createTable(rows, cols);

    StdOut.println("Original ->");
    printTable(table);
    StdOut.println("Transposed ->");
    printTable(transpose(table));
  }
}
