import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Compilation: javac E1209.java
 * Execution: java E1209 <whitelist_file> < <input_file>
 *
 * $ java E1209 ~/algs4-data/tinyW.txt < ~/algs4-data/tinyT.txt | more
 * 50
 * 99
 * 13
 * 18 keys examined with Binary Search
 */

/**
 * E1209. Binary Search + Counter
 */
public class E1209 {
  /**
   * BinarySearch
   */
  public static int indexOf(int[] a, int key, Counter counter) {
    int lo = 0;
    int hi = a.length - 1;

    counter.increment();

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

  public static void main(String[] args) throws Exception {
    if (args.length != 1) {
      throw new Error("You must provide the <white_list_file_name>");
    }

    In in = new In(args[0]);
    int[] whitelist = in.readAllInts();

    Arrays.sort(whitelist);

    Counter counter = new Counter("keys examined with Binary Search");

    while (!StdIn.isEmpty()) {
      int key = StdIn.readInt();
      if (indexOf(whitelist, key, counter) == -1)
        StdOut.println(key);
    }

    StdOut.println(counter);
  }
}