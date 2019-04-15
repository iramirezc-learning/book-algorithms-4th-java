import java.util.Arrays;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Type: ADT
 * Description: Binary Search in Ordered Symbol Table
 * Ref: p. 364, 368, 370, 379, 381, 382
 *
 * Compilation: javac BinarySearchST.java
 * Execution: java BinarySearchST < <input_stream>
 *
 * $ java BinarySearchST 3 < ~/algs4-data/custom/search-example.txt
 * Reading from StdIn...
 * A 8
 * C 4
 * E 12
 * H 5
 * L 11
 * M 9
 * P 10
 * R 3
 * S 0
 * X 7
 * size(): 10
 * size('A', 'Z'): 10
 * size('D', 'O'): 4
 * size('A', 'X'): 10
 * size('H', 'R'): 5
 * isEmpty(): false
 * contains('L'): true
 * contains('Z'): false
 * get('L'): 11
 * get('Z'): null
 * min(): A
 * max(): X
 * rank('A'): 0
 * rank('L'): 4
 * rank('Z'): 10
 * select(0): A
 * floor('A'): null
 * floor('N'): M
 * ceiling('N'): P
 * ceiling('Z'): null
 */

/**
 * BinarySearchST
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> implements OrderedSymbolTable<Key, Value> {
  private Key[] keys;
  private Value[] vals;
  private int n;

  public BinarySearchST() {
    this(1);
  }

  public BinarySearchST(int size) {
    if (size <= 0) {
      throw new Error("Size must be greater than 0");
    }

    keys = (Key[]) new Comparable[size];
    vals = (Value[]) new Object[size];
  }

  /**
   * Resizes the Symbol Table length.
   */
  private void resize(int max) {
    Key[] tempKeys = (Key[]) new Comparable[max];
    Value[] tempVals = (Value[]) new Object[max];

    for (int i = 0; i < n; i++) {
      tempKeys[i] = keys[i];
      tempVals[i] = vals[i];
    }

    keys = tempKeys;
    vals = tempVals;
  }

  /**
   * Returns the size of the Symbol Table
   * Ref: p. 364
   */
  public int size() {
    return n;
  }

  /**
   * Returns the size of the Symbol Table
   * between the 'lo' and the 'hi' keys.
   * Ref: p. 364
   */
  public int size(Key lo, Key hi) {
    if (hi.compareTo(lo) < 0)
      return 0;
    else if (contains(hi))
      return rank(hi) - rank(lo) + 1;
    else
      return rank(hi) - rank(lo);
  }

  /**
   * Returns if the Symbol Table is empty
   * Ref: p. 364
   */
  public boolean isEmpty() {
    return size() == 0;
  }

  /**
   * Returns the total of number keys
   * that are less than the 'key' provided.
   * Ref: p. 381
   */
  public int rank(Key key) {
    int lo = 0;
    int hi = n - 1;

    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      int compare = key.compareTo(keys[mid]);

      if (compare < 0)
        hi = mid - 1;
      else if (compare > 0)
        lo = mid + 1;
      else
        return mid;
    }

    return lo;
  }

  /**
   * Returns the value of a key,
   * if not present, returns null
   */
  public Value get(Key key) {
    if (isEmpty())
      return null;

    int i = rank(key);

    if (i < n && key.compareTo(keys[i]) == 0)
      return vals[i];
    else
      return null;
  }

  /**
   * Returns if 'key' exists in the ST
   * Ref: p. 364
   */
  public boolean contains(Key key) {
    return get(key) != null;
  }

  /**
   * Search for key, update if key found,
   * grow table if new.
   */
  public void put(Key key, Value val) {
    int i = rank(key);

    if (i < n && key.compareTo(keys[i]) == 0) {
      vals[i] = val;
      return;
    } else {
      if (n == keys.length) {
        resize(2 * keys.length);
      }

      for (int j = n; j > i; j--) {
        keys[j] = keys[j - 1];
        vals[j] = vals[j - 1];
      }

      keys[i] = key;
      vals[i] = val;
      n++;
    }
  }

  /**
   * Returns the minimum key
   */
  public Key min() {
    return keys[0];
  }

  /**
   * Returns the max key
   */
  public Key max() {
    return keys[n - 1];
  }

  /**
   * Returns the key at position 'k'
   */
  public Key select(int k) {
    return keys[k];
  }

  /**
   * Finds the smallest key that is greater
   * than or equal to the given key.
   */
  public Key ceiling(Key key) {
    int i = rank(key);

    if (i < n)
      return keys[i];
    else
      return null;
  }

  /**
   * Finds the largest key that is less
   * than or equal to the given key.
   * TODO: exercise 3.1.17 (validate)
   */
  public Key floor(Key key) {
    int i = rank(key);

    if (i == 0)
      return null;
    else
      return keys[i - 1];
  }

  /**
   * Deletes the 'key' from the ST
   * TODO: exercise 3.1.16
   */
  public Key delete(Key key) {
    int i = rank(key);
    return keys[i];
  }

  /**
   * Deletes the min key.
   * Ref: p. 368
   */
  public void deleteMin() {
    delete(min());
  }

  /**
   * Deletes the max key
   * Ref: p. 368
   */
  public void deleteMax() {
    delete(max());
  }

  /**
   * Returns an iterator of all keys.
   * Ref: p. 368
   */
  public Iterable<Key> keys() {
    return keys(min(), max());
  }

  /**
   * Returns an iterator of keys
   * between loKey and hiKey.
   */
  public Iterable<Key> keys(Key loKey, Key hiKey) {
    Queue<Key> queue = new Queue<Key>();
    int loRank = rank(loKey);
    int hiRank = rank(hiKey);

    for (int i = loRank; i < hiRank; i++) {
      queue.enqueue(keys[i]);
    }

    if (contains(hiKey)) {
      queue.enqueue(keys[hiRank]);
    }

    return queue;
  }

  /**
   * Prints the Key-Values arrays.
   */
  public void debug() {
    String[] kv = new String[keys.length];

    for (int i = 0; i < kv.length; i++) {
      kv[i] = keys[i] + ": " + vals[i];
    }

    StdOut.println(Arrays.toString(kv));
  }

  /**
   * Basic test client
   * Ref: p. 370
   */
  public static void main(String[] args) {
    int size = 1;

    if (args.length > 0) {
      size = Integer.parseInt(args[0]);
    }

    BinarySearchST<String, Integer> st;
    st = new BinarySearchST<String, Integer>(size);

    StdOut.println("Reading from StdIn...");

    for (int i = 0; !StdIn.isEmpty(); i++) {
      String key = StdIn.readString();
      st.put(key, i);
    }

    for (String s : st.keys()) {
      StdOut.println(s + " " + st.get(s));
    }

    StdOut.println("size(): " + st.size());
    StdOut.println("size('A', 'X'): " + st.size("A", "X"));
    StdOut.println("size('A', 'Z'): " + st.size("A", "Z"));
    StdOut.println("size('D', 'O'): " + st.size("D", "O"));
    StdOut.println("size('H', 'R'): " + st.size("H", "R"));
    StdOut.println("isEmpty(): " + st.isEmpty());
    StdOut.println("contains('L'): " + st.contains("L"));
    StdOut.println("contains('Z'): " + st.contains("Z"));
    StdOut.println("get('L'): " + st.get("L"));
    StdOut.println("get('Z'): " + st.get("Z"));
    StdOut.println("min(): " + st.min());
    StdOut.println("max(): " + st.max());
    StdOut.println("rank('A'): " + st.rank("A"));
    StdOut.println("rank('L'): " + st.rank("L"));
    StdOut.println("rank('Z'): " + st.rank("Z"));
    StdOut.println("select(0): " + st.select(0));
    StdOut.println("floor('A'): " + st.floor("A"));
    StdOut.println("floor('N'): " + st.floor("N"));
    StdOut.println("ceiling('N'): " + st.ceiling("N"));
    StdOut.println("ceiling('Z'): " + st.ceiling("Z"));
  }
}