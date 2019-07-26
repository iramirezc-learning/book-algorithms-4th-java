import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Type: ADT
 * Description: Symbol Table implementing Unordered Linked Lists
 * Ref: p. 364, 375
 *
 * Compilation: javac SequentialSearchST.java
 * Execution: java SequentialSearchST < <input_stream>
 *
 * $ java SequentialSearchST < ~/algs4-data/custom/search-example.txt
 * Reading from StdIn...
 * L 11
 * P 10
 * M 9
 * X 7
 * H 5
 * C 4
 * R 3
 * A 8
 * E 12
 * S 0
 * size(): 10
 * isEmpty(): false
 * contains('L'): true
 * contains('Z'): false
 * get('L'): 11
 * get('Z'): null
 */

/**
 * SequentialSearchST
 */
public class SequentialSearchST<Key, Value> implements SymbolTable<Key, Value> {
  /**
   * First node in the linked list.
   */
  private Node first;

  /**
   * Linked-list Node
   */
  private class Node {
    Key key;
    Value val;
    Node next;

    public Node(Key key, Value val, Node next) {
      this.key = key;
      this.val = val;
      this.next = next;
    }
  }

  /**
   * Returns the size of the ST.
   * TODO: exercise 3.1.5 (validate)
   */
  public int size() {
    int s = 0;

    for (Node x = first; x != null; x = x.next) {
      s++;
    }

    return s;
  }

  /**
   * Returns if 'key' exists in the ST
   * Ref: p. 364
   */
  public boolean contains(Key key) {
    return get(key) != null;
  }

  /**
   * Returns if the Symbol Table is empty
   * Ref: p. 368
   */
  public boolean isEmpty() {
    return size() == 0;
  }

  /**
   * Returns the value of a given 'key'
   * if exists in the ST; returns null 
   * otherwise;
   */
  public Value get(Key key) {
    for (Node x = first; x != null; x = x.next) {
      if (key.equals(x.key)) {
        return x.val;
      }
    }

    return null;
  }

  /**
   * Inserts a 'key' in the ST;
   * if the 'key' already exists,
   * then it updates its value.
   * Ref: p. 375
   */
  public void put(Key key, Value val) {
    for (Node x = first; x != null; x = x.next) {
      if (key.equals(x.key)) { // if search "hits"
        x.val = val; // update val
        return;
      }
    }
    // search "miss": add new node
    first = new Node(key, val, first);
  }

  /**
   * TODO: exercise 3.1.5
   */
  public Key delete(Key key) {
    return first.key;
  }

  /**
   * Returns an iterator of all keys.
   * TODO: exercise 3.1.5 (validate)
   */
  public Iterable<Key> keys() {
    Queue<Key> queue = new Queue();

    for (Node x = first; x != null; x = x.next) {
      queue.enqueue(x.key);
    }

    return queue;
  }

  /**
   * Basic test client
   * Ref: p. 370
   */
  public static void main(String[] args) {
    SequentialSearchST<String, Integer> st;
    st = new SequentialSearchST<String, Integer>();

    StdOut.println("Reading from StdIn...");

    for (int i = 0; !StdIn.isEmpty(); i++) {
      String key = StdIn.readString();
      st.put(key, i);
    }

    for (String s : st.keys()) {
      StdOut.println(s + " " + st.get(s));
    }

    StdOut.println("size(): " + st.size());
    StdOut.println("isEmpty(): " + st.isEmpty());
    StdOut.println("contains('L'): " + st.contains("L"));
    StdOut.println("contains('Z'): " + st.contains("Z"));
    StdOut.println("get('L'): " + st.get("L"));
    StdOut.println("get('Z'): " + st.get("Z"));
  }
}