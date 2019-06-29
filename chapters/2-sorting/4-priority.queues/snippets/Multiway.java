import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Type: Snippet
 * Description: A priority-queue client based on indexes (IndexMinPQ)
 * very useful to simulate streaming.
 * Ref: p. 322
 *
 * Compilation: javac Multiway.java
 * Execution: java Multiway [<stream_1>, <stream_2>, <stream_3>, ... , <stream_n> ]
 *
 * $ java Multiway ~/algs4-data/m1.txt ~/algs4-data/m2.txt ~/algs4-data/m3.txt
 * A A B B B C D E F F G H I I J N P Q Q Z
 */

/**
 * Multiway. Merges multiple ordered streams into a single one.
 */
public class Multiway {
  public static void merge(In[] streams) {
    int n = streams.length;
    IndexMinPQ<String> pq = new IndexMinPQ<String>(n);

    // insert the first string from every stream
    // so we can have data in the queue to start with
    for (int i = 0; i < n; i++) {
      if (!streams[i].isEmpty()) {
        pq.insert(i, streams[i].readString());
      }
    }

    // now, until the queue is empty
    // print the and remove the minimum value from the queue
    // and leave room for other new string
    // to be inserted from the streams until they're empty
    while (!pq.isEmpty()) {
      StdOut.print(pq.minKey() + " ");
      int index = pq.delMin();
      if (!streams[index].isEmpty()) {
        pq.insert(index, streams[index].readString());
      }
    }
  }

  public static void main(String[] args) throws Exception {
    if (args.length == 0) {
      throw new Error("You need to provide at least one input stream.");
    }

    int n = args.length;
    In[] streams = new In[n];

    for (int i = 0; i < n; i++) {
      streams[i] = new In(args[i]);
    }

    merge(streams);
  }
}