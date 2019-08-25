import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Type: ADT
 * Description: Hash Table using separate chaining.
 * Ref: p. 465
 *
 * Compilation: javac SeparateChainingHashST.java
 * Execution: java SeparateChainingHashST < <input_stream>
 *
 * $ java SeparateChainingHashST < ~/algs4-data/custom/search-example.txt
 * TODO: 
 */

/**
 * SeparateChainingHashST
 */
public class SeparateChainingHashST<Key, Value> {

  private int m;

  private SequentialSearchST<Key, Value>[] st;

  public SeparateChainingHashST() {
    this(997);
  }

  public SeparateChainingHashST(int m) {
    this.m = m;

    st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m];

    for (int i = 0; i < m; i++) {
      st[i] = new SequentialSearchST();
    }
  }

  private int hash(Key key) {
    return (key.hashCode() & 0x7fffffff) % m;
  }

  public Value get(Key key) {
    return (Value) st[hash(key)].get(key);
  }

  public void put(Key key, Value val) {
    st[hash(key)].put(key, val);
  }

  public Iterable<Key> keys() {
    // TODO: See exercise 3.4.19
  }

  /**
   * Basic test client
   */
  public static void main(String[] args) {
    SeparateChainingHashST<String, Integer> t;
    t = new SeparateChainingHashST<String, Integer>();

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