import java.util.ArrayList;
import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Compilation: javac Exercise_1_1_28.java
 * Execution: java Exercise_1_1_28 <whitelist_file> < <input_stream>
 *
 * $ java Exercise_1_1_28 ../../data/whitelist.txt < ../../data/targets.txt
 * 12
 * 57
 * 33
 * 16
 * 29
 * 12
 * 33
 * 33
 */

/**
 * Exercise_1_1_28. BinarySearch - Remove duplicates.
 */
public class Exercise_1_1_28 {
  public static int indexOf(int[] a, int key) {
    int lo = 0;
    int hi = a.length - 1;

    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (key < a[mid])
        hi = mid - 1;
      else if (key > a[mid])
        lo = mid + 1;
      else
        return mid;
    }
    return -1;
  }

  public static void main(String[] args) {
    In in = new In(args[0]);
    int[] whitelist = in.readAllInts();

    Arrays.sort(whitelist);

    // save indexes of duplicated values
    ArrayList<Integer> duplicateIndexes = new ArrayList<Integer>();

    for (int i = 0; i < whitelist.length; i++) {
      if (Arrays.binarySearch(whitelist, whitelist[i]) != i) {
        duplicateIndexes.add(i);
      }
    }

    // copy unique values
    int[] uniqueWhitelist = new int[whitelist.length - duplicateIndexes.size()];
    int currentIndex = 0;

    for (int i = 0; i < whitelist.length; i++) {
      if (duplicateIndexes.indexOf(i) == -1) {
        uniqueWhitelist[currentIndex++] = whitelist[i];
      }
    }

    while (!StdIn.isEmpty()) {
      int key = StdIn.readInt();
      if (indexOf(uniqueWhitelist, key) == -1)
        StdOut.println(key);
    }
  }
}
