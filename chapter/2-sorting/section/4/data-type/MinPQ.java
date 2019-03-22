import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

/**
 * Type: ADT
 * Description: Generic Priority Queue
 * Ref: p. 311
 *
 * Compilation: javac MinPQ.java
 * Execution: java MinPQ [<int_max> < <input_stream>]
 *
 * $ java MinPQ
 * [null, L, P, M, Q, P, X, null]
 *
 * $ java MinPQ 5 < ~/algs4-data/custom/binary-heap-strings.txt
 * Reading from standard input...
 * [null, G, P, S, T, R]
 *
 * $ java MinPQ 5 < ~/algs4-data/custom/binary-heap-numbers.txt
 * Reading from standard input...
 * [null, 5, 7, 6, 8, 9]
 */

/**
 * MinPQ
 */
public class MinPQ<Key extends Comparable<Key>> {
  /**
   * Heap-Ordered complete binary tree
   */
  private Key[] pq;

  /**
   * Size of the queue
   * items will be stored in pq[1..n] with pq[0] unused
   */
  private int n = 0;

  /**
   * TODO: implement
   */
  public MinPQ() {
  }

  /**
   * Initializes the queue with size of max + 1
   * Recall that item pq[0] is not used
   */
  public MinPQ(int max) {
    pq = (Key[]) new Comparable[max + 1];
  }

  /**
   * TODO: implement
   */
  public MinPQ(Key[] a) {
  }

  /**
   * Returns if the queue is empty
   * when 'n' reaches 0.
   * Ref: p. 318
   */
  public boolean isEmpty() {
    return n == 0;
  }

  /**
   * Returns if the queue is full
   * when 'n + 1' reaches the length of 'pq'
   */
  public boolean isFull() {
    return size() + 1 == pq.length;
  }

  /**
   * Returns the size of the queue 'n'
   * Ref: p. 318
   */
  public int size() {
    return n;
  }

  /**
   * Compares if the item in position 'i'
   * is greater than the item in position 'j'.
   * This is the opposite of what MaxPQ does.
   * Ref: p. 309
   */
  private boolean greater(int i, int j) {
    return pq[i].compareTo(pq[j]) > 0;
  }

  /**
   * Interchanges the items in positions 'i' and 'j'.
   * This works the same way 'exchange' works for sorting algorithms.
   * Ref: p. 315
   */
  private void exchange(int i, int j) {
    Key t = pq[i];
    pq[i] = pq[j];
    pq[j] = t;
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

  /**
   * Returns the minimum value stored in the queue
   * that happens to be the item at postion 1
   */
  public Key min() {
    return pq[1];
  }

  /**
   * Inserts a new item at position 'n + 1',
   * increments 'n', then it fixes the order
   * in the queue by using the 'swim' method.
   * Ref: p. 318
   */
  public void insert(Key v) {
    pq[++n] = v;
    swim(n);
  }

  /**
   * Returns the min value from the queue
   * and restablishes the order by using
   * the method 'sink'.
   * Ref: p. 318
   */
  public Key delMin() {
    // Retrieve min from top
    Key min = min();
    // Exchange with the last item
    // and decrement the size of the queue
    exchange(1, n--);
    // Avoid loitering
    // in the position where the last item
    // was stored
    pq[n + 1] = null;
    // Restores heap order
    sink(1);

    return min;
  }

  /**
   * Returns the queue as an serialized array
   */
  public String toString() {
    return Arrays.toString(pq);
  }

  /**
   * Test client
   */
  public static void main(String[] args) {
    MinPQ<String> queue;

    if (args.length == 0) {
      queue = new MinPQ<String>(7);

      // Ref: p. 319
      queue.insert("P");
      queue.insert("Q");
      queue.insert("E");
      queue.delMin();
      queue.insert("X");
      queue.insert("A");
      queue.insert("M");
      queue.delMin();
      queue.insert("P");
      queue.insert("L");
      queue.insert("E");
      queue.delMin();

      StdOut.println(queue);
    } else if (args.length == 1) {
      int max = Integer.parseInt(args[0]);

      queue = new MinPQ<String>(max);

      StdOut.println("Reading from standard input...");

      while (StdIn.hasNextLine()) {
        if (queue.isFull()) {
          queue.delMin();
        } else {
          // TODO: it does not makes sense
          // to insert a key that is less than 
          // the minimum in the queue for this
          // exercise, it will be immediatly
          // removed anyways when quque is full
          queue.insert(StdIn.readLine());
        }
      }

      StdOut.println(queue);
    }
  }
}