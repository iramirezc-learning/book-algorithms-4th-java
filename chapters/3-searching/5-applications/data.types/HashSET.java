import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Type: ADT
 * Description: Hash SET based on LinearProbingHashST.
 * Ref: p. 470, 489
 *
 * Compilation: javac HashSET.java
 * Execution: java HashSET < <input_stream>
 *
 * $ java HashSET < ~/algs4-data/custom/search-example.txt
 * A 1
 * C 3
 * E 5
 * H 8
 * L 12
 * M 13
 * P 16
 * R 18
 * S 19
 * X 24
 */

public class HashSET<Key> {
  private static final int INIT_CAPACITY = 4;

  private int n; // number of keys in the symbol table
  private int m; // size of linear probing table
  private Key[] keys; // the keys

  /**
   * Initializes an empty symbol table.
   */
  public HashSET() {
    this(INIT_CAPACITY);
  }

  /**
   * Initializes an empty symbol table with the specified initial capacity.
   *
   * @param capacity the initial capacity
   */
  public HashSET(int capacity) {
    m = capacity;
    n = 0;
    keys = (Key[]) new Object[m];
  }

  /**
   * Returns the number of keys in this symbol table.
   *
   * @return the number of keys in this symbol table
   */
  public int size() {
    return n;
  }

  /**
   * Returns true if this symbol table is empty.
   *
   * @return {@code true} if this symbol table is empty;
   *         {@code false} otherwise
   */
  public boolean isEmpty() {
    return size() == 0;
  }

  /**
   * Returns true if this symbol table contains the specified key.
   *
   * @param  key the key
   * @return {@code true} if this symbol table contains {@code key};
   *         {@code false} otherwise
   * @throws IllegalArgumentException if {@code key} is {@code null}
   */
  public boolean contains(Key key) {
    if (key == null)
      throw new IllegalArgumentException("argument to contains() is null");
    return get(key) != -1;
  }

  /**
   * Hash function for keys
   * @param key the key to be hash
   * @return the hash value between 0 and M-1
   */
  private int hash(Key key) {
    return (key.hashCode() & 0x7fffffff) % m;
  }

  /**
   * Resizes the hash table to the given capacity by re-hashing all of the keys
   * @param capacity new capacity for the hash table.
   */
  private void resize(int capacity) {
    HashSET<Key> temp = new HashSET<Key>(capacity);
    for (int i = 0; i < m; i++) {
      if (keys[i] != null) {
        temp.add(keys[i]);
      }
    }
    keys = temp.keys;
    m = temp.m;
  }

  /**
   * Inserts the specified key into the symbol table.
   * Exits if the key is already in the symbol table.
   *
   * @param  key the key
   * @throws IllegalArgumentException if {@code key} is {@code null}
   */
  public void add(Key key) {
    if (key == null)
      throw new IllegalArgumentException("first argument to add() is null");

    // double table size if 50% full
    if (n >= m / 2)
      resize(2 * m);

    int i;
    for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
      if (keys[i].equals(key)) {
        return;
      }
    }
    keys[i] = key;
    n++;
  }

  /**
   * Returns the index associated with the specified key.
   *
   * @param key the key
   * @return the index associated with {@code key};
   *         {@code null} if no such index
   * @throws IllegalArgumentException if {@code key} is {@code null}
   */
  private int get(Key key) {
    if (key == null)
      throw new IllegalArgumentException("argument to get() is null");
    for (int i = hash(key); keys[i] != null; i = (i + 1) % m)
      if (keys[i].equals(key))
        return i;
    return -1;
  }

  /**
   * Removes the specified key from this symbol table
   * (if the key is in this symbol table).
   *
   * @param  key the key to be removed
   * @throws IllegalArgumentException if {@code key} is {@code null}
   */
  public void delete(Key key) {
    if (key == null)
      throw new IllegalArgumentException("argument to delete() is null");
    if (!contains(key))
      return;

    // find position i of key
    int i = hash(key);
    while (!key.equals(keys[i])) {
      i = (i + 1) % m;
    }

    // delete key
    keys[i] = null;

    // rehash all keys in same cluster
    i = (i + 1) % m;
    while (keys[i] != null) {
      // delete keys[i] and reinsert
      Key keyToRehash = keys[i];
      keys[i] = null;
      n--;
      add(keyToRehash);
      i = (i + 1) % m;
    }

    n--;

    // halves size of array if it's 12.5% full or less
    if (n > 0 && n <= m / 8)
      resize(m / 2);
  }

  /**
   * Returns all keys in this symbol table as an {@code Iterable}.
   * To iterate over all of the keys in the symbol table named {@code st},
   * use the foreach notation: {@code for (Key key : st.keys())}.
   *
   * @return all keys in this symbol table
   */
  public Iterable<Key> keys() {
    Queue<Key> queue = new Queue<Key>();
    for (int i = 0; i < m; i++)
      if (keys[i] != null)
        queue.enqueue(keys[i]);
    return queue;
  }

  /**
   * Unit tests the {@code HashSET} data type.
   *
   * @param args the command-line arguments
   */
  public static void main(String[] args) {
    HashSET<String> st = new HashSET<String>();
    for (int i = 0; !StdIn.isEmpty(); i++) {
      String key = StdIn.readString();
      st.add(key);
    }

    // print keys
    for (String s : st.keys())
      StdOut.println(s + " " + st.get(s));
  }
}