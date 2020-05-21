import java.util.Arrays;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Exercise: 1.1.37
 * Description: Bad shuffling
 * Compilation: javac EX_1_1_37.java
 * Execution: java EX_1_1_37 <m> <n>
 * Example(s):
 *
 * $ java EX_1_1_37 5 1000
 * Shuffle Check:
 * [181, 211, 207, 200, 201]
 * [258, 166, 182, 201, 193]
 * [211, 220, 185, 166, 218]
 * [192, 212, 212, 188, 196]
 * [158, 191, 214, 245, 192]
 *
 * n/m: 200.000000
 */
public class EX_1_1_37 {
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
    for (int j = 0; j < shuffled.length; j++) {
      table[shuffled[j]][j]++;
    }
  }

  public static void main(String[] args) {
    if (args.length != 2) {
      throw new Error("You must provide two integers: <m> <n>");
    }

    int m = Integer.parseInt(args[0]);
    int n = Integer.parseInt(args[1]);
    int[][] table = new int[m][m];

    // BAD shuffle array `n` times
    for (int i = 1; i <= n; i++) {
      int[] array = createArray(m);

      badShuffle(array);
      checkShuffle(table, array);
    }

    StdOut.println("Shuffle Check:\n" + printMatrix(table));
    StdOut.printf("n/m: %f\n", (double) n / m);
  }
}
