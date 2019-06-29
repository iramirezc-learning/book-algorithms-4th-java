import java.util.Arrays;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Compilation: javac E1137.java
 * Execution: java E1137 <m> <n>
 *
 * $ java E1137 5 1000
 * Initial array: [0, 1, 2, 3, 4]
 * 
 * Shuffle Check:
 * [188, 211, 175, 199, 227]
 * [198, 198, 223, 194, 187]
 * [197, 209, 197, 184, 213]
 * [193, 191, 200, 232, 184]
 * [224, 191, 205, 191, 189]
 *
 * n/m: 200.000000
 */

/**
 * E1137. Bad shuffling
 */
public class E1137 {
  public static void badShuffle(int[] a) {
    int n = a.length;

    for (int i = 0; i < n; i++) {
      int r = StdRandom.uniform(n);
      int temp = a[i];
      a[i] = a[r];
      a[r] = temp;
    }
  }

  public static String printMatrix(int[][] a) {
    int n = a.length;
    String s = "";

    for (int i = 0; i < n; i++) {
      s += Arrays.toString(a[i]) + '\n';
    }

    return s;
  }

  public static int[] createArray(int size) {
    int[] array = new int[size];

    for (int i = 0; i < size; i++) {
      array[i] = i;
    }

    return array;
  }

  public static void checkShuffle(int[][] table, int[] shuffled) {
    for (int i = 0; i < table.length; i++) {
      for (int j = 0; j < shuffled.length; j++) {
        if (shuffled[j] == i) {
          table[i][j]++;
        }
      }
    }
  }

  public static void main(String[] args) {
    if (args.length != 2) {
      throw new Error("You must provide two integers: <m> <n>");
    }

    int m = Integer.parseInt(args[0]);
    int n = Integer.parseInt(args[1]);

    int[] array = createArray(m);
    int[][] table = new int[m][m];

    StdOut.println("Initial array: " + Arrays.toString(array) + "\n");

    // BAD shuffle array `n` times
    for (int i = 1; i <= n; i++) {
      badShuffle(array);
      // StdOut.println("Shuffle " + i + ": " + Arrays.toString(array) + "\n");
      checkShuffle(table, array);
    }

    StdOut.println("Shuffle Check:\n" + printMatrix(table));
    StdOut.printf("n/m: %f\n", (double) n / m);
  }
}