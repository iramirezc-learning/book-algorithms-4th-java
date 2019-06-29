import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

/**
 * Compilation: javac E2434.java
 * Execution: java E2434
 *
 * $ java E2434
 * [null, L, P, M, Q, P, X, null]
 * Change minIndex: 5 with 'Z'
 * [null, M, P, X, Q, P, Z, null]
 * Delete index: 1 which should be 'Q'
 * [null, M, P, X, Z, P, null, null]
 */

/**
 * E2434
 */
public class E2434 {
  private static class IndexMinPQ<Key extends Comparable<Key>> {
    private Key[] keys;
    private int[] pq;
    private int[] inverse;
    private int n;

    public IndexMinPQ(int max) {
      keys = (Key[]) new Comparable[max + 1];
      pq = new int[max + 1];
      inverse = new int[max + 1];

      for (int i = 0; i <= max; i++) {
        inverse[i] = -1;
      }
    }

    public void insert(int i, Key key) {
      n++;
      pq[n] = i;
      inverse[i] = n;
      keys[i] = key;
      swim(n);
    }

    /**
     * Exercise 2.4.34
     */
    public void changeKey(int i, Key key) {
      keys[i] = key;
      swim(inverse[i]);
      sink(inverse[i]);
    }

    public boolean contains(int i) {
      return inverse[i] != -1;
    }

    /**
     * Exercise 2.4.34
     */
    public void delete(int i) {
      int index = inverse[i];
      exchange(index, n--);
      keys[i] = null; // avoid loitering
      pq[n + 1] = 0; // clean trashy index
      inverse[i] = -1; // set as empty
      swim(index);
      sink(index);
    }

    public Key minKey() {
      return keys[pq[1]];
    }

    /**
     * Exercise 2.4.34
     */
    public int minIndex() {
      return pq[1];
    }

    public int delMin() {
      int min = pq[1];
      exchange(1, n--);
      sink(1);
      inverse[pq[n + 1]] = -1;
      keys[pq[n + 1]] = null;
      return min;
    }

    public boolean isEmpty() {
      return n == 0;
    }

    public int size() {
      return n;
    }

    public Key keyOf(int i) {
      return keys[pq[i]];
    }

    private boolean greater(int i, int j) {
      return keyOf(i).compareTo(keyOf(j)) > 0;
    }

    private void exchange(int i, int j) {
      int ti = pq[i];
      int tj = pq[j];
      pq[i] = tj;
      pq[j] = ti;

      int t = inverse[ti];
      inverse[ti] = inverse[tj];
      inverse[tj] = t;
    }

    private void swim(int k) {
      while (k > 1 && greater(k / 2, k)) {
        exchange(k / 2, k);
        k = k / 2;
      }
    }

    private void sink(int k) {
      while (2 * k <= size()) {
        int j = 2 * k;

        if (j < n && greater(j, j + 1)) {
          j++;
        }

        if (!greater(k, j)) {
          break;
        }

        exchange(k, j);

        k = j;
      }
    }

    public String toString() {
      Key[] pqKeys = (Key[]) new Comparable[keys.length];

      for (int i = 1; i <= n; i++) {
        pqKeys[i] = keyOf(i);
      }

      return Arrays.toString(pqKeys);
    }
  }

  public static void main(String[] args) {
    IndexMinPQ<String> queue = new IndexMinPQ<String>(7);

    queue.insert(queue.size(), "P"); // 0
    queue.insert(queue.size(), "Q"); // 1
    queue.insert(queue.size(), "E"); // 2
    queue.insert(queue.delMin(), "X"); // 2
    queue.insert(queue.size(), "A"); // 3
    queue.insert(queue.size(), "M"); // 4
    queue.insert(queue.delMin(), "P"); // 3
    queue.insert(queue.size(), "L"); // 5
    queue.insert(queue.size(), "E"); // 6
    queue.delMin(); // 6

    StdOut.println(queue);

    StdOut.printf("Change minIndex: %d with 'Z'\n", queue.minIndex());
    queue.changeKey(queue.minIndex(), "Z");
    StdOut.println(queue);
    StdOut.printf("Delete index: %d which should be 'Q'\n", 1);
    queue.delete(1);
    StdOut.println(queue);
  }
}