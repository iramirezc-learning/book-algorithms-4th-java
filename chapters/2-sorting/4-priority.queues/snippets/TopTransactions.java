import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Type: Snippet
 * Description: A priority-queue client (MinPQ).
 * Ref: p. 311
 * Compilation: javac TopTransactions.java
 * Execution: java TopTransactions <int_n> < <standard_input>
 *
 * $ java TopTransactions 5 < ~/algs4-data/tinyBatch.txt
 * Reading from Standard Input...
 *
 * Top Transactions:
 * Thompson 2/27/2000 4747.08
 * vonNeumann 2/12/1994 4732.35
 * vonNeumann 1/11/1999 4409.74
 * Hoare 8/18/1992 4381.21
 * vonNeumann 3/26/2002 4121.85
 */

/**
 * TopTransactions. Prints the top m lines in the input stream.
 */
public class TopTransactions {

  public static void main(String[] args) throws Exception {
    if (args.length != 1) {
      throw new Error("You must provide <int_m>");
    }

    int m = Integer.parseInt(args[0]);
    // queue should have one item extra
    // so we can remove the min value when size exceeds
    MinPQ<Transaction> queue = new MinPQ<Transaction>(m + 1);
    Stack<Transaction> stack = new Stack<Transaction>();

    StdOut.println("Reading from Standard Input...");

    // Keep the top 'm' entries on the queue.
    while (StdIn.hasNextLine()) {
      queue.insert(new Transaction(StdIn.readLine()));
      // remove minimum if there are 'm + 1'
      // entries on the queue.
      if (queue.size() > m) {
        queue.delMin();
      }
    }

    // store in the stack the min value
    // from the queue until queue is empty
    // that will place them in reversed order
    // from greatest to smallest
    while (!queue.isEmpty()) {
      stack.push(queue.delMin());
    }

    StdOut.println("\nTop Transactions:");

    // print transactions from the greatest to the smallest
    for (Transaction t : stack) {
      StdOut.println(t);
    }
  }
}