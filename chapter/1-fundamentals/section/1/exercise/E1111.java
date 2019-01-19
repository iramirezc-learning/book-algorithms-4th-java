import edu.princeton.cs.algs4.StdOut;

/**
 * Compilation: javac E1111.java
 * Execution: java E1111 <rows> <cols>
 *
 * $ java E1111 5 5
 *   1  2  3  4  5
 * 1       *
 * 2 *  *        *
 * 3 *
 * 4    *     *  *
 * 5
 */

/**
 * E1111. Prints a board with header and row columns. Prints `*` for
 * true, whitespace for false.
 */
public class E1111 {

  public static boolean[][] createBoard(int rows, int cols) {
    boolean[][] a = new boolean[rows][cols];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        a[i][j] = Math.random() > 0.5;
      }
    }

    return a;
  }

  public static String printBoard(boolean[][] board) {
    String cols = " ";
    String s = "";

    for (int i = 0; i < board.length; i++) {
      s += (i + 1);
      for (int j = 0; j < board[i].length; j++) {
        if (i == 0)
          cols += (" " + (j + 1) + " ");
        s += board[i][j] ? " * " : "   ";
      }
      if (i == 0)
        cols += '\n';
      s += '\n';
    }

    return cols + s;
  }

  public static void main(String[] args) throws Exception {
    if (args.length != 2) {
      throw new Error("You must provide 2 numbers for <rows> <cols>");
    }
    int rows = Integer.parseInt(args[0]);
    int cols = Integer.parseInt(args[1]);

    StdOut.println(printBoard(createBoard(rows, cols)));
  }
}