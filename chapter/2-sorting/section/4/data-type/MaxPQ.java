import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

/**
 * Type: ADT
 * Description: Generic Priority Queue
 * Ref: p. 309, 315, 316, 318
 *
 * Compilation: javac MaxPQ.java
 * Execution: java MaxPQ [<int_max> < <input_stream>]
 *
 * $ java MaxPQ
 * [null, P, M, L, A, E, E, null]
 *
 * $ java MaxPQ 12 < ~/algs4-data/custom/binary-heap-strings.txt
 * Reading from standard input...
 * [null, T, S, R, P, N, O, A, E, I, H, G, null]
 */

/**
 * MaxPQ
 */
public class MaxPQ<Key extends Comparable<Key>> {
  /**
   * Heap-Ordered complete binary tree
   */
  private Key[] pq;

  /**
   * Size of the queue
   * items will be stored in pq[1..n] with pq[0] unused
   */
  private int n = 0;

  public MaxPQ() {
    // TODO: implement
  }

  /**
   * Initializes the queue with size of max + 1
   * Recall that item pq[0] is not used
   */
  public MaxPQ(int max) {
    pq = (Key[]) new Comparable[max + 1];
  }

  public MaxPQ(Key[] a) {
    // TODO: implement
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
   * Ref:  p. 318
   */
  public int size() {
    return n;
  }

  /**
   * Compares if the item in position 'i'
   * is less thant the item in position 'j'.
   * Ref: p. 315
   */
  private boolean less(int i, int j) {
    return pq[i].compareTo(pq[j]) < 0;
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
   * Bottom-up reheapify. Restablishes the order of the heap
   * by interchanging a node in position 'k'
   * with its parent at position 'k/2' only if its larger.
   * The process continues until the node is lesser than 
   * the new parent or becomes the new root: k = 1.
   * Ref. p. 316
   */
  private void swim(int k) {
    while (k > 1 && less(k / 2, k)) {
      exchange(k / 2, k);
      k = k / 2;
    }
  }

  /**
   * Top-down reheapify. If order is violated because a
   * node in position 'k' becomes smaller than any of its
   * children then select the larger of the children 
   * '2k' or '2k + 1' an place it as the new parent.
   * Continue the process until current node 'k' is 
   * greather than or equal to its children.
   * Ref. p. 316
   */
  private void sink(int k) {
    // do it until '2k' is smaller or equal 
    // to the last node 'n'
    while (2 * k <= n) {
      int j = 2 * k; // select left child

      // if 'j < n' means that there's no right child
      // if there's a right child and is greater
      // than the left child, then select it 
      // by incrementing 'j' by 1
      if (j < n && less(j, j + 1)) {
        j++;
      }

      // if current node at key 'k' is greater than
      // node at key 'j' means that node can become
      // the new parent and exit
      if (!less(k, j)) {
        break;
      }

      // otherwise interchange nodes at positions 'k' and 'j'
      exchange(k, j);

      // node at position 'k' was moved to position 'j'
      k = j;
    }
  }

  /**
   * Returns the maximum value stored in the queue
   * that happens to be the item at postion 1
   * Ref: p. 309
   */
  public Key max() {
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
   * Returns the max value from the queue
   * and restablishes the order by using
   * the method 'sink'.
   * Ref: p. 318
   */
  public Key delMax() {
    // Retrieve max from top
    Key max = max();
    // Exchange with the last item
    // and decrement the size of the queue
    exchange(1, n--);
    // Avoid loitering
    // in the position where the last item
    // was stored
    pq[n + 1] = null;
    // Restores heap order
    sink(1);

    return max;
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
    MaxPQ<String> queue;

    if (args.length == 0) {
      queue = new MaxPQ<String>(7);

      // Ref: p. 319
      queue.insert("P");
      queue.insert("Q");
      queue.insert("E");
      queue.delMax();
      queue.insert("X");
      queue.insert("A");
      queue.insert("M");
      queue.delMax();
      queue.insert("P");
      queue.insert("L");
      queue.insert("E");
      queue.delMax();

      StdOut.println(queue);
    } else if (args.length == 1) {
      int max = Integer.parseInt(args[0]);

      queue = new MaxPQ<String>(max);

      StdOut.println("Reading from standard input...");

      while (StdIn.hasNextLine() && !queue.isFull()) {
        queue.insert(StdIn.readLine());
      }

      StdOut.println(queue);
    }
  }
}