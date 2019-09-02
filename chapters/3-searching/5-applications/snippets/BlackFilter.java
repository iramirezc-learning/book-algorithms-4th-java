import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Type: Snippet
 * Description: Prints only the words that are NOT in the list.
 * Ref: p. 491
 *
 * Compilation. javac BlackFilter.java
 * Execution: java BlackFilter <black_list> < <standard_input>
 *
 * $ java BlackFilter ~/algs4-data/list.txt < ~/algs4-data/tinyTale.txt
 * best times worst times
 * age wisdom age foolishness
 * epoch belief epoch incredulity
 * season light season darkness
 * spring hope winter despair
 */

/**
 * BlackFilter
 */
public class BlackFilter {
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

      if (!set.contains(word)) {
        StdOut.println(word);
      }
    }
  }
}