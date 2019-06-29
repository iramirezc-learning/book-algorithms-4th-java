import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Type: Snippet
 * Description: Whitelist. A client for StaticSETofInts that uses Binary Search
 * Ref: p. 99
 * 
 * Compilation: javac Whitelist.java
 * Execution: java Whitelist < <input_file>
 * 
 * $ java Whitelist ~/algs4-data/tinyW.txt < ~/algs4-data/tinyT.txt
 * 50
 * 99
 * 13
 */

/**
 * Whitelist
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