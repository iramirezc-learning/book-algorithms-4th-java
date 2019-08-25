import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Type: ADT
 * Description: Hash Table using Linear Probing.
 * Ref: p. 470
 *
 * Compilation: javac LinearProbingHashST.java
 * Execution: java LinearProbingHashST < <input_stream>
 *
 * $ java LinearProbingHashST < ~/algs4-data/custom/search-example.txt
 * TODO: 
 */

/**
 * LinearProbingHashST
 */
public class LinearProbingHashST<Key, Value> {
  private static final int INIT_CAPACITY = 16;

  private int n; // number of key-value pairs in the table
  private int m = 16; // size of linear-probing table
  private Keys[] keys; // the keys
  private Value[] vals; // the vals

  public LinearProbingHashST() {
    this(INIT_CAPACITY);
  }

  public LinearProbingHashST(int cap) {
    m = cap;
    n = 0;
    keys = (Key[]) new Object[m];
    vals = (Value[]) new Object[m];
  }

  private int hash(Key key) {
    return (key.hashCode() & 0x7fffffff) % m;
  }

  /**
   * Ref: p. 474
   */
  private void resize(int cap) {
    LinearProbingHashST<Key, Value> t;
    t = new LinearProbingHashST<Key, Value>(cap);

    for (int i = 0; i < m; i++) {
      if (keys[i] != null) {
        // insert only the key-values in the new table
        t.put(keys[i], vals[i]);
      }
    }

    keys = t.keys;
    vals = t.vals;
    m = t.m;
  }

  public void put(Key key, Value val) {
    if (n >= m / 2) {
      resize(2 * m);
    }

    int i;

    for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
      if (keys[i].equals(key)) {
        // if key is found, replace its value
        vals[i] = val;
        return;
      }
    }

    // insert new key-value
    keys[i] = key;
    vals[i] = val;
    n++;
  }

  public Value get(Key key) {
    for (int i = hash(key); keys[i] != null; i = (i + 1) % m) {
      if (keys[i].equals(key)) {
        return vals[i];
      }
    }

    return null;
  }

  /**
   * Ref: p. 471
   */
  public void delete(Key key) {
    if (!contains(key)) {
      return;
    }

    int i = hash(key);

    // find the key ignoring probes
    while (!key.equals(keys[i])) {
      i = (i + 1) % m;
    }

    // remove key-value
    keys[i] = null;
    vals[i] = null;

    // go to the next one after deleted
    i = (i + 1) % m;

    // reinsert probes to the right
    while (keys[i] != null) {
      Key keyToRedo = keys[i];
      Value valToRedo = vals[i];
      keys[i] = null;
      vals[i] = null;
      n--;
      put(keyToRedo, valToRedo);
      i = (i + 1) % m;
    }

    // decrement count of key-vals
    n--;

    // resize the arrays by half
    // if n is small enough
    if (n > 0 && n <= m / 8) {
      resize(m / 2);
    }
  }

  /**
   * Basic test client
   */
  public static void main(String[] args) {
    LinearProbingHashST<String, Integer> t;
    t = new LinearProbingHashST<String, Integer>();

    StdOut.println("Reading from StdIn...");

    for (int i = 0; !StdIn.isEmpty(); i++) {
      String key = StdIn.readString();
      t.put(key, i);
    }

    for (String s : t.keys()) {
      StdOut.println(s + " " + t.get(s));
    }

    // TODO: complete test client
  }
}