import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;

/**
 * Type: ADT
 * Description: Generic Bag implementation based on a linked-list ADT.
 * Ref: p. 155
 *
 * Compilation: javac Bag.java
 * Execution: java Bag
 *
 * $ java Bag < ~/algs4-data/tobe.txt
 * (8 items in the Bag)
 */

/**
 * Bag
 */
public class Bag<Item> implements Iterable<Item> {
  /**
   * First item on the Bag
   */
  private Node first;
  /**
   * Number of items
   */
  private int n;

  /**
   * Nested class to define Nodes
   */
  private class Node {
    /**
     * Item stored in this Node
     */
    Item item;
    /**
     * Pointer to next Node
     */
    Node next;
  }

  private class ListIterator implements Iterator<Item> {
    /**
     * Current Node in the iterator.
     */
    private Node current = first;

    /**
     * Iterator hasNext when the current Node
     * is not Null
     */
    public boolean hasNext() {
      return current != null;
    }

    public void remove() {
      /* do nothing */
    }

    /**
     * Returns the item in the current Node
     * and updates current to be the next Node
     */
    public Item next() {
      Item item = current.item;
      current = current.next;
      return item;
    }
  }

  /**
   * Adds an item on the Bag
   */
  public void add(Item item) {
    Node oldFirst = first;
    first = new Node();
    first.item = item;
    first.next = oldFirst;
    n++;
  }

  /**
   * Checks if the Bag is empty
   */
  public boolean isEmpty() {
    return first == null;
  }

  /**
   * Returns the size of the Bag
   */
  public int size() {
    return n;
  }

  /**
   * Returns an iterator for the Bag
   */
  public Iterator<Item> iterator() {
    return new ListIterator();
  }

  /**
   * Test client
   */
  public static void main(String[] args) {
    Bag<String> b = new Bag<String>();

    while (!StdIn.isEmpty()) {
      String item = StdIn.readString();

      if (!item.equals("-")) {
        b.add(item);
      }
    }

    StdOut.printf("(%d items in the Bag)\n", b.size());
  }
}