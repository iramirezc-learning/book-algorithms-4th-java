import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Compilation: javac E1129.java
 * Execution: java E1129 <input_file> <key>
 *
 * $ java E1129 ~/algs4-data/custom/sorted.txt 5
 * Original array: [1, 2, 3, 4, 5, 5, 5, 6]
 * rank: 4
 * count: 3
 * 5 5 5
 *
 * $ java E1129 ~/algs4-data/custom/repeated.txt 5
 * Original array: [5, 5, 5, 5, 5, 5, 5, 5, 5, 5]
 * rank: 0
 * count: 10
 * 5 5 5 5 5 5 5 5 5 5
 */

/**
 * E1129. BinarySearch - Rank & Count
 */
public class E1129 {
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

  /**
   * Returns the number of elements that are smaller than the `key` in the sorted
   * array `a`.
   */
  public static int rank(int[] a, int key) {
    int index = indexOf(a, key);

    if (index == -1)
      return 0;

    while (index >= 0 && a[index] == key) {
      index--;
    }

    return index + 1;
  }

  /**
   * Returns the number of elements equal to `key` in array `a`.
   */
  public static int count(int[] a, int key) {
    int index = indexOf(a, key);

    if (index == -1)
      return 0;

    int count = 1;
    int left = index - 1;
    int right = index + 1;
    int length = a.length;

    // count similar numbers to the left
    while (left >= 0 && a[left] == key) {
      count++;
      left--;
    }

    // count similar numbers to the right
    while (right < length && a[right] == key) {
      count++;
      right++;
    }

    return count;
  }

  public static void main(String[] args) throws Exception {
    if (args.length != 2) {
      throw new Error("You must provide the input file and integer key: <input_file> <key>");
    }
    In in = new In(args[0]);
    int key = Integer.parseInt(args[1]);
    int[] whitelist = in.readAllInts();

    Arrays.sort(whitelist);

    int i = rank(whitelist, key);
    int j = count(whitelist, key);

    StdOut.println("Original array: " + Arrays.toString(whitelist));

    StdOut.println("rank: " + i);
    StdOut.println("count: " + j);

    for (int lastIndex = (i + j - 1); i <= lastIndex; i++) {
      StdOut.printf("%d ", whitelist[i]);
    }

    StdOut.println();
  }
}
