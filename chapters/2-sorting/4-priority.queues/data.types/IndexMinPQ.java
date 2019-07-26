import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

/**
 * Type: ADT
 * Description: Generic Priority Queue with associated Indexes
 * Ref: p. 320, 332, 333, 334
 *
 * Compilation: javac IndexMinPQ.java
 * Execution: java IndexMinPQ [<int_max> < <input_stream>]
 *
 * $ java IndexMinPQ
 * [null, L, P, M, Q, P, X, null]
 *
 * $ java IndexMinPQ 5 < ~/algs4-data/custom/binary-heap-strings.txt
 * Reading from standard input...
 * [null, G, P, S, T, R]
 *
 * $ java IndexMinPQ 5 < ~/algs4-data/custom/binary-heap-numbers.txt
 * Reading from standard input...
 * [null, 5, 7, 6, 8, 9]
 */

/**
 * IndexMinPQ
 */
public class IndexMinPQ<Key extends Comparable<Key>> {
  /**
   * Items with properties
   */
  private Key[] keys;

  /**
   * Binary heap using 1-based indexing.
   * The 'pq' array holds the corresponding index
   * of every key in the 'keys' array
   * while keeping the order of the priority queue
   * pq[i] = index
   * keys[index] = key
   */
  private int[] pq;

  /**
   * Inverse of 'pq', maps the indexes between
   * the 'pq' and the 'keys' arrays.
   * inverse[i] gives the position of keys[i] in pq[]
   * Example:
   * indexes:   [0, 1, 2, 3]
   *            ---------------
   * keys:      [D, E, A, Ø]  // Ø = NULL
   * inverse:   [3, 2, 1, -1] // -1 means empty
   * pq:        [0, 2, 1, 0]  // remember first index is unused
   * pq + keys: [Ø, A, E, D]  // Ø = NULL because first index is unused
   */
  private int inverse[];

  /**
   * Number of elements in the queue
   */
  private int n = 0;

  /**
   * Creates a new IndexMinPQ
   * Ref: p. 333 (exercise 2.4.33)
   */
  public IndexMinPQ(int max) {
    keys = (Key[]) new Comparable[max + 1];
    pq = new int[max + 1];
    inverse = new int[max + 1];

    // intialize inverse array to contain -1
    // -1 means that is empty
    for (int i = 0; i <= max; i++) {
      inverse[i] = -1;
    }
  }

  /**
   * Returns if the priority queue is
   * empty when 'n' reaches 0.
   * Ref: p. 320, 333
   */
  public boolean isEmpty() {
    return n == 0;
  }

  /**
   * Returns if the priority queue is full
   * when 'n + 1' reaches the length of 'pq'
   */
  public boolean isFull() {
    return size() + 1 == pq.length;
  }

  /**
   * Returns the number of keys in the priority queue
   * Ref: p. 320
   */
  public int size() {
    return n;
  }

  /**
   * Bottom-up reheapify. Restablishes the order 
   * of the heap by interchanging a node in 
   * position 'k' with its parent at position 'k/2'
   * only if its smaller.
   * The process continues until the node is greater 
   * than the new parent or becomes the new root: k = 1.
   * Ref. p. 316
   */
  private void swim(int k) {
    while (k > 1 && greater(k / 2, k)) {
      exchange(k / 2, k);
      k = k / 2;
    }
  }

  /**
   * Top-down reheapify. If order is violated because a
   * node in position 'k' becomes greater than any of its
   * children then select the smaller of the children 
   * '2k' or '2k + 1' an place it as the new parent.
   * Continue the process until current node 'k' is 
   * smaller than or equal to its children.
   * Ref. p. 316
   */
  private void sink(int k) {
    // do it until '2k' is smaller or equal 
    // to the last node 'n' returned by size()
    // in other words, if there are any children
    // for 'k' node
    while (2 * k <= size()) {
      int j = 2 * k; // select left child

      // if 'j < n' means that there's no right child
      // if the left child is greater than the right child
      // then select it (since is smaller)
      // by incrementing 'j' by 1
      if (j < n && greater(j, j + 1)) {
        j++;
      }

      // if current node at key 'k' is less than
      // node at key 'j' means that node can become
      // the new parent and exit
      if (!greater(k, j)) {
        break;
      }

      // otherwise interchange nodes at positions 'k' and 'j'
      exchange(k, j);

      // node at position 'k' was moved to position 'j'
      k = j;
    }
  }

  // Methods that changed from the MinPQ implementation
  // ==================================================

  /**
   * Compares if the item in position 'i'
   * is greater than the item in position 'j'.
   * This is the opposite of what MaxPQ does.
   * Ref: p. 309, 332 (exercise 2.4.33)
   */
  private boolean greater(int i, int j) {
    return keyOf(i).compareTo(keyOf(j)) > 0;
  }

  /**
   * Interchanges the items in positions 'i' and 'j'.
   * This works the same way 'exchange' works for sorting algorithms.
   * Ref: p. 315, 332 (exercise 2.4.33)
   */
  private void exchange(int i, int j) {
    int _i = pq[i];
    int _j = pq[j];
    // iterchange the indexes int the 'pq'
    pq[i] = _j;
    pq[j] = _i;

    // update the new location of the 'pq' indexes
    // in the inversed array.
    int t = inverse[_i];
    inverse[_i] = inverse[_j];
    inverse[_j] = t;
  }

  /**
   * Inserts a 'key' and associates it with the index 'i'
   * Ref: p. 320, 333 (exercise 2.4.33)
   */
  public void insert(int i, Key key) {
    n++;
    pq[n] = i;
    inverse[i] = n;
    keys[i] = key;
    swim(n);
    // NOTE: no need to sink since insertion
    // always goes to the end of the queue 'pq'.
  }

  /**
   * Changes the key associated with
   * index 'i' to new Key 'key'
   * Ref: p. 320, 334 (exercise 2.4.34)
   */
  public void changeKey(int i, Key key) {
    keys[i] = key;
    swim(inverse[i]);
    sink(inverse[i]);
  }

  /**
   * Returns if index 'i' is associated with some key
   * Ref: p. 320, 333 (exercise 2.4.33)
   */
  public boolean contains(int i) {
    return inverse[i] != -1;
  }

  /**
   * Remove 'i' and its associated key
   * Ref: p. 320, 334 (exercise 2.4.34)
   */
  public void delete(int i) {
    if (!contains(i))
      return;

    int index = inverse[i];
    exchange(index, n--);
    keys[i] = null; // avoid loitering
    pq[n + 1] = 0; // clean trashy index
    inverse[i] = -1; // set as empty
    swim(index);
    sink(index);
  }

  /**
   * Returns the minimal key
   * Ref: p. 320, 333 (exercise 2.4.33)
   */
  public Key minKey() {
    return keys[minIndex()];
  }

  /**
   * Returns the minimal key's index
   * Ref: p. 320, 334 (exercise 2.4.34)
   */
  public int minIndex() {
    return pq[1];
  }

  /**
   * Removes the minimal key and return its index
   * Ref: p. 320, 333 (exercise 2.4.33)
   */
  public int delMin() {
    // Retrieve min from top
    int min = minIndex();
    // Exchange with the last item
    // and decrement the size of the queues
    exchange(1, n--);
    // Restores the heap order
    sink(1);

    int index = pq[n + 1];
    inverse[index] = -1; // set as empty
    keys[index] = null; // avoid loitering
    // pq[n + 1] will be replaced at the next insertion

    return min;
  }

  /**
   * Returns the key associated with index 'i' in 'pq'
   */
  public Key keyOf(int i) {
    return keys[pq[i]];
  }

  /**
   * Prints the state of the 'keys', 'inverse' and 'pq' arrays.
   */
  public void debug() {
    String sKeys = Arrays.toString(keys);
    String sInverse = Arrays.toString(inverse);
    String sPq = Arrays.toString(pq);
    StdOut.printf("keys: %s\ninverse: %s\npq: %s\n%s\n\n", sKeys, sInverse, sPq, toString());
  }

  /**
   * Converts the IndexMinPQ to string.
   */
  public String toString() {
    Key[] pqKeys = (Key[]) new Comparable[keys.length];

    for (int i = 1; i <= n; i++) {
      pqKeys[i] = keyOf(i);
    }

    return Arrays.toString(pqKeys);
  }

  public static void main(String[] args) {
    IndexMinPQ<String> queue;

    if (args.length == 0) {
      queue = new IndexMinPQ<String>(7);

      // Ref: p. 319
      queue.insert(queue.size(), "P");
      queue.insert(queue.size(), "Q");
      queue.insert(queue.size(), "E");
      queue.insert(queue.delMin(), "X");
      queue.insert(queue.size(), "A");
      queue.insert(queue.size(), "M");
      queue.insert(queue.delMin(), "P");
      queue.insert(queue.size(), "L");
      queue.insert(queue.size(), "E");
      queue.delMin();

      StdOut.println(queue);
    } else if (args.length == 1) {
      int max = Integer.parseInt(args[0]);

      queue = new IndexMinPQ<String>(max);

      StdOut.println("Reading from standard input...");

      int index = -1;

      while (StdIn.hasNextLine()) {
        if (queue.isFull()) {
          queue.insert(queue.delMin(), StdIn.readLine());
        } else {
          queue.insert(queue.size(), StdIn.readLine());
        }
      }

      StdOut.println(queue);
    }
  }
}