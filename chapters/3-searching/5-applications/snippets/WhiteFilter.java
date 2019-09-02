import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Type: Snippet
 * Description: Prints only the words that are in the list.
 * Ref: p. 491
 *
 * Compilation. javac WhiteFilter.java
 * Execution: java WhiteFilter <white_list> < <standard_input>
 *
 * $ java WhiteFilter ~/algs4-data/list.txt < ~/algs4-data/tinyTale.txt
 * it was the of it was the of
 * it was the of it was the of
 * it was the of it was the of
 * it was the of it was the of
 * it was the of it was the of
 */

/**
 * WhiteFilter
 */
public class WhiteFilter {
  public static void main(String[] args) {
    int i = 0;
    HashSET<String> set;
    set = new HashSET<String>();
    In in = new In(args[0]);

    while (!in.isEmpty()) {
      set.add(in.readString());
    }

    while (!StdIn.isEmpty()) {
      String word = StdIn.readString();

      if (set.contains(word)) {
        StdOut.println(word);
      }
    }
  }
}