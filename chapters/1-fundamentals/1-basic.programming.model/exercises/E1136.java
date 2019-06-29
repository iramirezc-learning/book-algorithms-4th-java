import java.util.Arrays;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Compilation: javac E1136.java
 * Execution: java E1136 <m> <n>
 *
 * $ java E1136 5 1000
 * Initial array: [0, 1, 2, 3, 4]
 * 
 * Shuffle Check:
 * [225, 210, 180, 194, 191]
 * [198, 189, 195, 204, 214]
 * [199, 197, 228, 197, 179]
 * [188, 206, 204, 200, 202]
 * [190, 198, 193, 205, 214]
 *
 * n/m: 200.000000
 */

/**
 * E1136. ShuffleTest: Empirical shuffle check
 */
public class E1136 {
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

  public static void main(String[] args) throws Exception {
    if (args.length != 2) {
      throw new Error("You must provide two integers: <m> <n>");
    }

    int m = Integer.parseInt(args[0]);
    int n = Integer.parseInt(args[1]);

    int[] array = createArray(m);
    int[][] table = new int[m][m];

    StdOut.println("Initial array: " + Arrays.toString(array) + "\n");

    // shuffle array `n` times
    for (int i = 1; i <= n; i++) {
      StdRandom.shuffle(array);
      // StdOut.println("Shuffle " + i + ": " + Arrays.toString(array) + "\n");
      checkShuffle(table, array);
    }

    StdOut.println("Shuffle Check:\n" + printMatrix(table));
    StdOut.printf("n/m: %f\n", (double) n / m);
  }
}