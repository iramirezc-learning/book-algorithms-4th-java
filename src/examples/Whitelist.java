import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Whitelist
 * Type: Snippet
 * Description: A client for StaticSETofInts that uses Binary Search
 * Section: 1.2
 * Ref: p. 99
 * Compilation: javac Whitelist.java
 * Execution: java Whitelist < <input_file>
 * Example(s):
 *
 * $ java Whitelist ~/algs4-data/largeW.txt < ~/algs4-data/largeT.txt | more
 * 499569
 * 984875
 * 295754
 * 207807
 * 140925
 * 161828
 * ... # truncated
 */
public class Whitelist {
  public static void main(String[] args) throws Exception {
    if (args.length != 1) {
      throw new Error("You must provide: <input_file>");
    }

    In in = new In(args[0]);
    int[] a = in.readAllInts();
    StaticSETofInts set = new StaticSETofInts(a);

    while (!StdIn.isEmpty()) {
      int key = StdIn.readInt();

      if (!set.contains(key)) {
        StdOut.println(key);
      }
    }
  }
}
