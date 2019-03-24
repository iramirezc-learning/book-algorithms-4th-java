import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

/**
 * Compilation: javac E2433.java
 * Execution: java E2433
 *
 * $ java E2433
 * [null, L, P, M, Q, P, X, null]
 */

/**
 * E2433
 */
public class E2433 {
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
     * Exercise 2.4.33
     */
    public boolean contains(int i) {
      return inverse[i] != -1;
    }

    public Key minKey() {
      return keys[pq[1]];
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

    /**
     * Exercise 2.4.33
     */
    private boolean greater(int i, int j) {
      return keyOf(i).compareTo(keyOf(j)) > 0;
    }

    /**
     * Exercise 2.4.33
     */
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
  }
}