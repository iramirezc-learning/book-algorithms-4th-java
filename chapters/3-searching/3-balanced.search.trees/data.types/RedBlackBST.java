import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Type: ADT
 * Description: Red-Black Binary Search Tree
 * Ref: p. 433, 434, 436, 439
 *
 * Compilation: javac RedBlackBST.java
 * Execution: java RedBlackBST < <input_stream>
 *
 * $ java RedBlackBST < ~/algs4-data/custom/search-example.txt
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
 * Manual testing:
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
 */

/**
 * RedBlackBST. Red-Black Binary Search Tree
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {
  private static final boolean RED = true;
  private static final boolean BLACK = false;

  /**
   * Root of the RB-BST
   */
  private Node root;

  /**
   * Node ADT for every node in the RB-BST.
   * Ref: p. 433
   */
  private class Node {
    // identifier for this node
    private Key key;
    // value stored in this node
    private Value val;
    // subtree of nodes smaller than this node
    private Node left;
    // subtree of nodes greater than this node
    private Node right;
    // number of nodes in the subtree from this node
    private int n;
    // color of this node (left link from its parent)
    private boolean color;

    // Node Constructor
    public Node(Key key, Value val, int n, boolean color) {
      this.key = key;
      this.val = val;
      this.n = n;
      this.color = color;
    }
  }

  /**
   * Returns the size of the RB-BST
   */
  public int size() {
    return size(root);
  }

  /**
   * Returns the size of a given node.
   */
  private int size(Node x) {
    if (x == null)
      return 0;
    else
      return x.n;
  }

  public int size(Key lo, Key hi) {
    Queue<Key> q = new Queue<Key>();

    keys(root, q, lo, hi);

    return q.size();
  }

  /**
   * Returns if the Red Black BST is empty.
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
   * looking into the subtree of the given
   * node 'x'.
   * Returns null when not found.
   */
  private Value get(Node x, Key key) {
    if (x == null) // when reached a null node
      return null; // key is not found

    int compare = key.compareTo(x.key);

    if (compare < 0) { // if is smaller than
      return get(x.left, key); // go to left subtree
    } else if (compare > 0) { // if is greater than
      return get(x.right, key); // go to the right subtree
    } else { // if key found
      return x.val; // return its value
    }
  }

  /**
   * Returns if a given key exists in the RB-BST.
   */
  public boolean contains(Key key) {
    return get(key) != null;
  }

  /**
   * Returns the min key in the RB-BST.
   */
  public Key min() {
    if (isEmpty())
      throw new NoSuchElementException();

    Node x = min(root);

    return x.key;
  }

  /**
   * Returns the node that contains
   * the min key starting form the
   * given node 'x'.
   */
  private Node min(Node x) {
    if (x.left == null)
      return x;
    return min(x.left);
  }

  /**
   * Returns the max key in the RB-BST.
   */
  public Key max() {
    if (isEmpty())
      throw new NoSuchElementException();

    Node x = max(root);

    return x.key;
  }

  /**
   * Returns the node containing the
   * max key starting from the given
   * node 'x'.
   */
  private Node max(Node x) {
    if (x.right == null)
      return x;
    return max(x.right);
  }

  /**
   * Returns the largest key found
   * that is smaller or equal to the given 'key'.
   */
  public Key floor(Key key) {
    Node x = floor(root, key);

    if (x == null)
      throw new NoSuchElementException();

    return x.key;
  }

  /**
   * Returns the node with the largest key
   * that is less than or equal to the given 'key'
   * starting from node 'x'.
   * Example: if BST contains keys (in order):
   * - A B C D E F G
   * - floor(H) = G // is the largest key found which is less than H
   * - floor(A) = A // is the largest key found which is equal to A
   */
  private Node floor(Node x, Key key) {
    if (x == null)
      return null;

    int compare = key.compareTo(x.key);

    if (compare == 0)
      return x;

    if (compare < 0)
      return floor(x.left, key);

    // if key is greater than current node's key
    // go to the right, where they are larger.
    // remember we are looking for the "largest" key
    Node t = floor(x.right, key);
    // if a node was found
    if (t != null)
      // return it
      return t;
    else
      // other wise return current node,
      // which can the largest
      return x;
  }

  /**
   * Returns the smallest key
   * in the RB-BST which is
   * greater than or equal to the
   * given 'key'.
   */
  public Key ceiling(Key key) {
    Node x = ceiling(root, key);

    if (x == null)
      throw new NoSuchElementException();
    return x.key;
  }

  /**
   * Returns the node containing
   * the smallest key in the given 'x'
   * subtree, which is greater than or
   * equal to the given 'key'.
   *  * Example: if BST contains keys (in order):
   * - B C D E F G H
   * - ceiling(A) = B // is the smallest key found which is greater than A
   * - ceiling(F) = F // is equal to F
   */
  private Node ceiling(Node x, Key key) {
    if (x == null)
      return null;

    int compare = key.compareTo(x.key);

    // if the key exists in the RB-BST
    // then there wont be any other key
    // that is smaller but greater at the same time.
    if (compare == 0)
      return x;

    // if key is greater than current node's key
    // then go to the right
    if (compare > 0)
      return ceiling(x.right, key);

    // if key is smaller than the current node's key
    // then go to the left
    Node t = ceiling(x.left, key);
    // if there was a smaller node
    if (t != null)
      return t; // return it
    else
      return x; // otherwise return current node
  }

  /**
   * Returns the key of the corresponding
   * node at 'k'-th position.
   */
  public Key select(int k) {
    if (k < 0 || k >= size())
      throw new IllegalArgumentException("index 'k' can not be less than 0 or greater that to the RB-BST size.");

    Node x = select(root, k);
    return x.key;
  }

  /**
   * Returns the node
   * at position 'k'-th
   * given the subtree 'x'
   */
  private Node select(Node x, int k) {
    if (x == null)
      return null;

    // get the size of the subtree on the left
    int s = size(x.left);
    // if the left subtree size is greater than the rank 'k'...
    if (s > k)
      // then, the node can be in the left subtree
      return select(x.left, k);
    // if the left subtree size is smaller than the rank 'k'...
    else if (s < k)
      // then, the node can be in the right subtree
      // subtract the left subtree size 's'
      // and the current node (1) from 'k'
      // so that we limit the sub size.
      return select(x.right, k - s - 1);
    // otherwise, current node 'x' is at 'k' position
    else
      return x;
  }

  /**
   * Returns the total keys
   * in the RB-BST
   * that are smaller than
   * the provided 'key'.
   */
  public int rank(Key key) {
    return rank(root, key);
  }

  /**
   * Returns the total keys
   * in the subtree x
   * that are smaller than
   * the provided 'key'
   */
  private int rank(Node x, Key key) {
    if (x == null)
      return 0;

    int compare = key.compareTo(x.key);

    // if the key is smaller than
    // current node's key
    // then go to the left subtree.
    if (compare < 0)
      return rank(x.left, key);
    // if the key is greater than
    // current node's key
    // then go to the right
    // but add 1, because wee need
    // to count current parent.
    // and the size of the left subtree
    else if (compare > 0) {
      return 1 + size(x.left) + rank(x.right, key);
    }
    // if the key is the same,
    // then return the size of its left subtree
    else
      return size(x.left);
  }

  /**
   * Prints all the keys
   * in the RB-BST in order.
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
   * Returns an iterator of
   * all keys (ordered)
   * in the RB-BST.
   */
  public Iterable<Key> keys() {
    return keys(min(), max());
  }

  /**
   * Returns an iterator of all keys
   * in the 'lo'-'hi' range.
   */
  public Iterable<Key> keys(Key lo, Key hi) {
    Queue<Key> queue = new Queue<Key>();
    keys(root, queue, lo, hi);
    return queue;
  }

  /**
   * Queues the keys within the lo-hi range
   * by iterating (recursively) first, on
   * the left subtree, second the current node 'x',
   * and finally (if in range) the right subtree.
   */
  private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
    if (x == null)
      return;

    int compareLo = lo.compareTo(x.key);
    int compareHi = hi.compareTo(x.key);

    if (compareLo < 0)
      keys(x.left, queue, lo, hi);
    if (compareLo <= 0 && compareHi >= 0)
      queue.enqueue(x.key);
    if (compareHi > 0)
      keys(x.right, queue, lo, hi);
  }

  // Operations for RB-BST
  // ==================================================

  /**
   * Tells if a node is RED color.
   * Ref: p. 433
   */
  private boolean isRed(Node x) {
    if (x == null)
      return false;

    return x.color == RED;
  }

  /**
   * Rotates a node to be the left
   * from its right node when the link
   * between them is red.
   * Ref: p. 434
   */
  private Node rotateLeft(Node h) {
    // Node x will be h.right which is greater than h
    // that'd why we are doing the rotation
    Node x = h.right;
    // h.right should now contain the nodes between h and x
    // which they are stored in x.left
    h.right = x.left;
    // now, the new left for x will be node h
    // because x is greater than h
    x.left = h;
    // x will assume the color of h
    // it can be red or black
    x.color = h.color;
    // node h definitely will change its color to red
    // because now is attached as a red link to x
    h.color = RED;
    // because x is replacing the position of h
    // the subtree size will be the same for x
    // because x now will be the "parent" of h
    x.n = h.n;
    // update the new subtree size for h
    // remember that we add 1 to count the node itself
    h.n = 1 + size(h.left) + size(h.right);
    // return the new parent x
    return x;
  }

  /**
   * This is the opposite of rotateLeft
   * Ref: p. 434
   */
  private Node rotateRight(Node h) {
    Node x = h.left;

    h.left = x.right;
    x.right = h;
    x.color = h.color;
    h.color = RED;
    x.n = h.n;
    h.n = 1 + size(h.left) + size(h.right);

    return x;
  }

  /**
   * Flips colors of children to black
   * when splitting a 4-node.
   * Ref: p. 436
   */
  public void flipColors(Node h) {
    h.color = RED;
    h.left.color = BLACK;
    h.right.color = BLACK;
  }

  /**
   * Inserts or updates the 'key' with value 'val'
   * to the RB-BST starting from the root.
   */
  public void put(Key key, Value val) {
    root = put(root, key, val);
    // Keeping the root black
    // Ref: p. 437
    root.color = BLACK;
  }

  private Node put(Node h, Key key, Value val) {
    if (h == null) {
      // Do standard insert with red link to parent
      return new Node(key, val, 1, RED);
    }

    int compare = key.compareTo(h.key);

    if (compare < 0) {
      // insertion will go to the left
      h.left = put(h.left, key, val);
    } else if (compare > 0) {
      // insertion will go to the right
      h.right = put(h.right, key, val);
    } else {
      // replace the current value
      // when key already exists
      h.val = val;
    }

    // operations for RB-BST
    if (isRed(h.right) && !isRed(h.left))
      h = rotateLeft(h);
    if (isRed(h.left) && isRed(h.left.left))
      h = rotateRight(h);
    if (isRed(h.left) && isRed(h.right))
      flipColors(h);

    h.n = 1 + size(h.left) + size(h.right);

    return h;
  }

  // TODO: public void deleteMin()

  // TODO: private Node deleteMin(Node x)

  // TODO: public void deleteMax()

  // TODO: private Node deleteMax(Node x)

  // TODO: public void delete(Key key)

  // TODO: private Node delete(Node x, Key key)

  /**
   * Basic test client
   * Ref: p. 370 (same from BST)
   */
  public static void main(String[] args) {
    RedBlackBST<String, Integer> rb;

    rb = new RedBlackBST<String, Integer>();

    StdOut.println("Reading from StdIn...");

    for (int i = 0; !StdIn.isEmpty(); i++) {
      String key = StdIn.readString();
      rb.put(key, i);
    }

    for (String s : rb.keys()) {
      StdOut.println(s + " " + rb.get(s));
    }

    StdOut.println("Manual testing:");

    StdOut.println("size(): " + rb.size());
    StdOut.println("size('A', 'X'): " + rb.size("A", "X"));
    StdOut.println("size('A', 'Z'): " + rb.size("A", "Z"));
    StdOut.println("size('D', 'O'): " + rb.size("D", "O"));
    StdOut.println("size('H', 'R'): " + rb.size("H", "R"));
    StdOut.println("isEmpty(): " + rb.isEmpty());
    StdOut.println("contains('L'): " + rb.contains("L"));
    StdOut.println("contains('Z'): " + rb.contains("Z"));
    StdOut.println("get('L'): " + rb.get("L"));
    StdOut.println("get('Z'): " + rb.get("Z"));
    StdOut.println("min(): " + rb.min());
    StdOut.println("max(): " + rb.max());
    StdOut.println("rank('A'): " + rb.rank("A"));
    StdOut.println("rank('L'): " + rb.rank("L"));
    StdOut.println("rank('Z'): " + rb.rank("Z"));
    StdOut.println("select(0): " + rb.select(0));
    StdOut.println("floor('A'): " + rb.floor("A"));
    StdOut.println("floor('N'): " + rb.floor("N"));
    StdOut.println("ceiling('N'): " + rb.ceiling("N"));
    StdOut.println("ceiling('Z'): " + rb.ceiling("Z")); // Throws Exception
  }
}