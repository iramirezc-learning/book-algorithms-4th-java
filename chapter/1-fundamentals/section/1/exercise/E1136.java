import java.util.Arrays;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Compilation: javac E1136.java
 * Execution: java E1136 <m> <n>
 *
 * $ java E1136 5 10
 * ???
 */

/**
 * E1136. Empirical shuffle check
 */
public class E1136 {
  public static int[] createTable(int size) {
    int[] table = new int[size];

    for (int i = 0; i < size; i++) {
      table[i] = i;
    }

    return table;
  }

  public static void main(String[] args) throws Exception {
    if (args.length != 2) {
      throw new Error("You must provide two integers.");
    }

    int m = Integer.parseInt(args[0]);
    int n = Integer.parseInt(args[1]);

    // shuffle table `n` times
    for (int i = 0; i < n; i++) {
      StdOut.println("Shuffle: " + i);

      int[] table = createTable(m);

      StdOut.println(" Initial table:");
      StdOut.println(" " + Arrays.toString(table));

      StdRandom.shuffle(table);

      StdOut.println(" Randomized table:");
      StdOut.println(" " + Arrays.toString(table));
      StdOut.println();
    }

    // TODO: complete experiments
  }
}