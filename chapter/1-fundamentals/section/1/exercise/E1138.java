import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Compilation: javac E1138.java
 * Execution: java E1138 <whitelist> <input_data>
 *
 * $ java E1138 ~/algs4-data/largeW.txt ~/algs4-data/largeT.txt
 * BruteForceSearch Total Time:
 *  1124417.406646(ms) = 18.7 minutes!
 * Not found: 367966
 * 
 * BinarySearch Total Time:
 *  2619.593394(ms) = 2.6 seconds
 * Not found: 367966
 */

/**
 * E1138. BinarySearch vs BruteForceSearch
 */
public class E1138 {

  public static int binarySearch(int[] a, int key) {
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

  public static int bruteForceSearch(int[] a, int key) {
    for (int i = 0; i < a.length; i++)
      if (a[i] == key)
        return i;
    return -1;
  }

  public static void runBFS(int[] whitelist, int[] data) {
    int notFound = 0;

    long start = System.nanoTime();
    for (int i = 0; i < data.length; i++) {
      if (bruteForceSearch(whitelist, data[i]) == -1) {
        notFound++;
      }
    }
    long end = System.nanoTime();
    double totalTimeInMS = (end - start) / (double) 1000000;

    StdOut.println("BruteForceSearch Total Time:");
    StdOut.println(" " + totalTimeInMS + "(ms)");
    StdOut.println("Not found: " + notFound + "\n");
  }

  public static void runBS(int[] whitelist, int[] data) {
    int notFound = 0;

    long start = System.nanoTime();
    Arrays.sort(whitelist);
    for (int i = 0; i < data.length; i++) {
      if (binarySearch(whitelist, data[i]) == -1) {
        notFound++;
      }
    }
    long end = System.nanoTime();
    double totalTimeInMS = (end - start) / (double) 1000000;

    StdOut.println("BinarySearch Total Time:");
    StdOut.println(" " + totalTimeInMS + "(ms)");
    StdOut.println("Not found: " + notFound + "\n");
  }

  public static void main(String[] args) throws Exception {
    if (args.length != 2) {
      throw new Error("You must provide: <white_list_file> <input_data>");
    }

    In whitelistFile = new In(args[0]);
    In dataFile = new In(args[1]);
    int[] whitelist = whitelistFile.readAllInts();
    int[] data = dataFile.readAllInts();

    runBFS(whitelist, data);
    runBS(whitelist, data);
  }
}