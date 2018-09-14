import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise_1_1_11
 */
public class Exercise_1_1_11 {

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

  public static void main(String[] args) {
    int rows = Integer.parseInt(args[0]);
    int cols = Integer.parseInt(args[1]);

    StdOut.println(printBoard(createBoard(rows, cols)));
  }
}