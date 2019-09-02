import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Type: Snippet
 * Description: Creates an Index of Key-values and Value-keys.
 *              using an inverted index.
 * Ref: p. 499
 *
 * Compilation. javac LookupIndex.java
 * Execution: java LookupIndex <file> <separator>
 *
 * $ java LookupIndex ~/algs4-data/aminoI.csv ','
 * Serine
 *  TCT
 *  TCA
 *  TCG
 *  AGT
 *  AGC
 * TCG
 *  Serine
 *
 * $ java LookupIndex ~/algs4-data/movies.txt '/'
 * Bacon, Kevin
 *  Animal House (1978)
 *  Apollo 13 (1995)
 *  Beauty Shop (2005)
 *  Diner (1982)
 *  Few Good Men, A (1992)
 *  Flatliners (1990)
 * ...
 * Apollo 13 (1995)
 *  Corman, Roger
 *  Berkeley, Xander
 *  Lipschultz, Andrew
 *  Goodall, Taylor
 *  Goodall, Matthew Michael
 *  Dean, Loren
 *  Christopher, Tory
 * ...
 */

/**
 * LookupIndex
 */
public class LookupIndex {

  public static void main(String[] args) {
    In in = new In(args[0]);
    String sp = args[1];

    ST<String, Queue<String>> st = new ST<String, Queue<String>>();
    ST<String, Queue<String>> ts = new ST<String, Queue<String>>();

    while (in.hasNextLine()) {
      String[] a = in.readLine().split(sp);
      String key = a[0];

      if (!st.contains(key))
        st.put(key, new Queue<String>());

      for (int i = 1; i < a.length; i++) {
        String val = a[i];

        if (!ts.contains(val))
          ts.put(val, new Queue<String>());
        st.get(key).enqueue(val);
        ts.get(val).enqueue(key);
      }
    }

    while (!StdIn.isEmpty()) {
      String query = StdIn.readLine();

      if (st.contains(query)) {
        for (String s : st.get(query)) {
          StdOut.println(" " + s);
        }
      }

      if (ts.contains(query)) {
        for (String s : ts.get(query)) {
          StdOut.println(" " + s);
        }
      }
    }
  }
}
