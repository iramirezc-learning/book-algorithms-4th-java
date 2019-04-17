import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Type: ADT
 * Description: Binary Search Tree Symbol Table
 * Ref: p. 398, 399, 407, 409, 411, 413
 *
 * Compilation: javac BST.java
 * Execution: java BST < <input_stream>
 *
 * $ java BST < ~/algs4-data/custom/search-example.txt
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
 * size('A', 'X'): 10
 * size('A', 'Z'): 10
 * size('D', 'O'): 4
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
 * floor('A'): A
 * floor('N'): M
 * ceiling('N'): P
 * Exception in thread "main" java.util.NoSuchElementException
 *         at BST.ceiling(BST.java:259)
 *         at BST.main(BST.java:561)
 */

/**
 * BST. Binary Search Tree Symbol Table
 */
public class BST<Key extends Comparable<Key>, Value> {
  /**
   * Root of the BST
   */
  private Node root;

  /**
   * Node ADT for every node in the BST.
   */
  private class Node {
    // identifier for this node
    private Key key;
    // value stored on this node
    private Value val;
    // subtree of nodes smaller than this node
    private Node left;
    // subtree of nodes greather than this node
    private Node right;
    // number of nodes in the subtree rooted here
    private int n;

    public Node(Key key, Value val, int n) {
      this.key = key;
      this.val = val;
      this.n = n;
    }
  }

  /**
   * Returns the size of the BST
   */
  public int size() {
    return size(root);
  }

  /**
   * Returns the size of a given
   * node.
   */
  private int size(Node x) {
    if (x == null)
      return 0;
    else
      return x.n;
  }

  /**
   * Returns the count of all
   * the keys between the range
   * lo-hi.
   */
  public int size(Key lo, Key hi) {
    Queue<Key> q = new Queue<Key>();
    keys(root, q, lo, hi);

    return q.size();
  }

  /**
   * Returns if the BST is empty
   */
  public boolean isEmpty() {
    return size() == 0;
  }

  /**
   * Returns the value of a given key
   * starting from the root.
   */
  public Value get(Key key) {
    return get(root, key);
  }

  /**
   * Returns the value of a given key,
   * looking into the subtree of
   * rooted as 'x' Node.
   * Returns null if Key is not present
   * in the subtree rooted as 'x'.
   */
  private Value get(Node x, Key key) {
    if (x == null)
      return null;

    int compare = key.compareTo(x.key);

    if (compare < 0) {
      return get(x.left, key);
    } else if (compare > 0) {
      return get(x.right, key);
    } else {
      return x.val;
    }
  }

  /**
   * Returns if 'key' exits in the BST.
   */
  public boolean contains(Key key) {
    return get(key) != null;
  }

  /**
   * Inserts or updates the 'key' with value 'val'
   * starting from the root.
   */
  public void put(Key key, Value val) {
    root = put(root, key, val);
  }

  /**
   * Updates the value of 'key' if found.
   * Otherwise inserts a new node in the
   * subtree rooted as 'x'.
   * Finally, increments the count 'n' of Node 'x'.
   */
  private Node put(Node x, Key key, Value val) {
    if (x == null)
      return new Node(key, val, 1);

    int compare = key.compareTo(x.key);

    if (compare < 0) {
      x.left = put(x.left, key, val);
    } else if (compare > 0) {
      x.right = put(x.right, key, val);
    } else {
      x.val = val;
    }

    x.n = size(x.left) + size(x.right) + 1;

    return x;
  }

  /**
   * Returns the min key of the BST.
   */
  public Key min() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    Node x = min(root);

    return x.key;
  }

  /**
   * Returns the min key of a
   * subtree rooted as 'x'.
   */
  private Node min(Node x) {
    // if no more smaller children
    // then this node is the min Node
    if (x.left == null)
      return x;
    // otherwise continue traversing
    // the left subtree
    return min(x.left);
  }

  /**
   * Returns the max key of the BST.
   */
  public Key max() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    Node x = max(root);

    return x.key;
  }

  /**
   * Returns the max key in a
   * subtree rooted as 'x'.
   */
  private Node max(Node x) {
    // if no more greater children
    // then this node is the max
    if (x.right == null)
      return x;
    // otherwise continue traversing
    // the right subtree
    return max(x.right);
  }

  /**
   * Returns the largest key that is less than
   * or equal to the given 'key' starting from
   * root. An Exception is thrown if BST is empty.
   */
  public Key floor(Key key) {
    Node x = floor(root, key);
    if (x == null)
      throw new NoSuchElementException();
    return x.key;
  }

  /**
   * Returns the largest key that is less than
   * or equal to the given 'key' starting at 
   * root node 'x'.
   */
  private Node floor(Node x, Key key) {
    if (x == null)
      return null;

    int compare = key.compareTo(x.key);

    // if keys are equal, then return current node
    if (compare == 0)
      return x;
    // if key is smaller than current node's key
    // then go to the left
    if (compare < 0)
      return floor(x.left, key);
    // if key is greater than current node's key
    // then go to the right
    Node t = floor(x.right, key);
    // If a node was found, then return it
    if (t != null)
      return t;
    // otherwise return current node 'x'
    else
      return x;
  }

  /**
   * Returns the smallest key that is greater than
   * or equal to the given 'key' starting from
   * root. An Exception is thrown if BST is empty.
   */
  public Key ceiling(Key key) {
    Node x = ceiling(root, key);
    if (x == null)
      throw new NoSuchElementException();
    return x.key;
  }

  /**
   * Returns the smallest key that is greater than
   * or equal to the given 'key' starting from
   * root node 'x'.
   */
  private Node ceiling(Node x, Key key) {
    if (x == null)
      return null;

    int compare = key.compareTo(x.key);
    // if key is equal, then return current node
    if (compare == 0)
      return x;
    // if key is greater than the current node's key
    // then go to the left
    if (compare > 0)
      return ceiling(x.right, key);
    // if key is smaller than the current node's key
    // then go to the left
    Node t = ceiling(x.left, key);
    // if a node was found, return it.
    if (t != null)
      return t;
    // otherwise return current node 'x'
    else
      return x;
  }

  /**
   * Returns the node's key at position 'k'
   */
  public Key select(int k) {
    if (k < 0 || k >= size())
      throw new IllegalArgumentException("index 'k' can not be less than 0 or greater than or equal to the BST size");

    Node x = select(root, k);
    return x.key;
  }

  /**
   * Returns the node at position 'k'
   */
  private Node select(Node x, int k) {
    if (x == null)
      return null;
    // get the size of the subtree on the left
    int s = size(x.left);
    // if the left size is greater than the rank,
    if (s > k)
      // then, the node can be in the left subtree.
      return select(x.left, k);
    // if the left size is smaller than the rank,
    else if (s < k)
      // then, the node can be in the right subtree.
      // substract the left subtree size 's'
      // and the current parent (1) from 'k'
      // discarding all those nodes.
      return select(x.right, k - s - 1);
    // otherwise the node is the current
    else
      return x;
  }

  /**
   * Returns the total keys that are less than
   * the 'key' provided. Starting from the root.
   */
  public int rank(Key key) {
    return rank(root, key);
  }

  /**
   * Returns the total keys that are less than
   * the 'key' provided. Starting at root 'x'.
   */
  private int rank(Node x, Key key) {
    if (x == null)
      return 0;

    int compare = key.compareTo(x.key);

    // if the key is smaller than the current node
    // then, go to the left subtree
    if (compare < 0)
      return rank(x.left, key);
    // if the key is greater than the current node
    // then, go to the right subtree but add the
    // size of the left subtree plus the parent (1)
    else if (compare > 0)
      return 1 + size(x.left) + rank(x.right, key);
    // if the key is the same, then return
    // the size of the smaller left subtree
    else
      return size(x.left);
  }

  /**
   * Deletes the min key in the BST
   * starting from the root.
   */
  public void deleteMin() {
    if (isEmpty())
      throw new NoSuchElementException();
    root = deleteMin(root);
  }

  /**
   * Deletes the min key starting
   * from the given root 'x'.
   */
  private Node deleteMin(Node x) {
    if (x.left == null)
      return x.right;

    x.left = deleteMin(x.left);
    x.n = 1 + size(x.left) + size(x.right);

    return x;
  }

  /**
   * Deletes the max key in the BST
   * starting from the root.
   */
  public void deleteMax() {
    if (isEmpty())
      throw new NoSuchElementException();
    root = deleteMax(root);
  }

  /**
   * Deletes the max key starting
   * from the given root 'x'.
   */
  private Node deleteMax(Node x) {
    if (x.right == null)
      return x.left;

    x.right = deleteMax(x.right);
    x.n = 1 + size(x.left) + size(x.right);

    return x;
  }

  /**
   * Deletes 'key' from the BST
   * starting from the root.
   */
  public void delete(Key key) {
    root = delete(root, key);
  }

  /**
   * Deletes 'key' from the BST
   * starting from the root 'x';
   */
  private Node delete(Node x, Key key) {
    if (x == null)
      return null;

    int compare = key.compareTo(x.key);

    if (compare < 0) {
      x.left = delete(x.left, key);
    } else if (compare > 0) {
      x.right = delete(x.right, key);
    } else {

      // if node 'x' doesn't have greater children,
      // then return smaller children
      if (x.right == null)
        return x.left;
      // if node 'x' doesn't have smaller children,
      // then return greater children
      if (x.left == null)
        return x.right;

      // if node 'x' has both children
      // then use the T. Hibbard's technique
      // by selecting the smallest succesor
      // from the right subtree.

      // save current node 'x'
      Node t = x;
      // now 'x' will be the smallest key
      // in the right children
      x = min(t.right);
      // the new 'x.right' will be the subtree
      // without the min key we just retrieved
      x.right = deleteMin(t.right);
      // left children remains the same
      // as the original node
      x.left = t.left;
    }

    x.n = 1 + size(x.left) + size(x.right);

    return x;
  }

  /**
   * Prints the BST keys in order.
   * Ref: p. 412
   */
  private void print(Node x) {
    if (x == null)
      return;

    print(x.left);
    StdOut.println(x.key);
    print(x.right);
  }

  /**
   * Returns an iterator of all keys
   * in order from the BST.
   */
  public Iterable<Key> keys() {
    return keys(min(), max());
  }

  /**
   * Returns an iterator of all keys
   * in range of 'lo' and 'hi' in order.
   */
  public Iterable<Key> keys(Key lo, Key hi) {
    Queue<Key> queue = new Queue<Key>();
    keys(root, queue, lo, hi);
    return queue;
  }

  /**
   * Queues the keys that fall into the range
   * lo-hi by iterating (recursively) first on
   * the left subtree, second the root, and finally
   * (if in range) the right subtree.
   */
  private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
    if (x == null)
      return;

    int compareLo = lo.compareTo(x.key);
    int compareHi = hi.compareTo(x.key);

    // if the lower key from the range
    // is smaller than the current node's key
    // then keep looking to the left
    if (compareLo < 0)
      keys(x.left, queue, lo, hi);
    // if the current key is in the range lo-hi
    // then add it to the queue.
    if (compareLo <= 0 && compareHi >= 0)
      queue.enqueue(x.key);
    // if the higher key from the range
    // is greater than the current node's key
    // then keep looking to the right
    if (compareHi > 0)
      keys(x.right, queue, lo, hi);
  }

  /**
   * Basic test client
   * Ref: p. 370
   */
  public static void main(String[] args) {
    BST<String, Integer> bst;
    bst = new BST<String, Integer>();

    StdOut.println("Reading from StdIn...");

    for (int i = 0; !StdIn.isEmpty(); i++) {
      String key = StdIn.readString();
      bst.put(key, i);
    }

    for (String s : bst.keys()) {
      StdOut.println(s + " " + bst.get(s));
    }

    StdOut.println("size(): " + bst.size());
    StdOut.println("size('A', 'X'): " + bst.size("A", "X"));
    StdOut.println("size('A', 'Z'): " + bst.size("A", "Z"));
    StdOut.println("size('D', 'O'): " + bst.size("D", "O"));
    StdOut.println("size('H', 'R'): " + bst.size("H", "R"));
    StdOut.println("isEmpty(): " + bst.isEmpty());
    StdOut.println("contains('L'): " + bst.contains("L"));
    StdOut.println("contains('Z'): " + bst.contains("Z"));
    StdOut.println("get('L'): " + bst.get("L"));
    StdOut.println("get('Z'): " + bst.get("Z"));
    StdOut.println("min(): " + bst.min());
    StdOut.println("max(): " + bst.max());
    StdOut.println("rank('A'): " + bst.rank("A"));
    StdOut.println("rank('L'): " + bst.rank("L"));
    StdOut.println("rank('Z'): " + bst.rank("Z"));
    StdOut.println("select(0): " + bst.select(0));
    StdOut.println("floor('A'): " + bst.floor("A"));
    StdOut.println("floor('N'): " + bst.floor("N"));
    StdOut.println("ceiling('N'): " + bst.ceiling("N"));
    StdOut.println("ceiling('Z'): " + bst.ceiling("Z")); // Throws Exception
  }

}