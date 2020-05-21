import java.util.Arrays;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Exercise: 1.1.36
 * Description: ShuffleTest: Empirical shuffle check
 * Compilation: javac EX_1_1_36.java
 * Execution: java EX_1_1_36 <m> <n>
 * Example(s):
 *
 * $ java EX_1_1_36 5 1000
 * Shuffle Check:
 * [199, 199, 193, 222, 187]
 * [204, 225, 181, 176, 214]
 * [179, 188, 224, 196, 213]
 * [203, 196, 187, 215, 199]
 * [215, 192, 215, 191, 187]
 * 
 * n/m: 200.000000
 */
public class EX_1_1_36 {
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
    for (int j = 0; j < shuffled.length; j++) {
      table[shuffled[j]][j]++;
    }
  }

  public static void main(String[] args) throws Exception {
    if (args.length != 2) {
      throw new Error("You must provide two integers: <m> <n>");
    }

    int m = Integer.parseInt(args[0]);
    int n = Integer.parseInt(args[1]);
    int[][] table = new int[m][m];

    // shuffle array `n` times
    for (int i = 1; i <= n; i++) {
      int[] array = createArray(m);

      StdRandom.shuffle(array);
      // StdOut.println("Shuffle " + i + ": " + Arrays.toString(array) + "\n");
      checkShuffle(table, array);
    }

    StdOut.println("Shuffle Check:\n" + printMatrix(table));
    StdOut.printf("n/m: %f\n", (double) n / m);
  }
}
