import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;

/**
 * Type: ADT
 * Description: Generic Queue implementation based on a linked-list ADT.
 * Ref: p. 150, 151, 155
 *
 * Compilation: javac Queue.java
 * Execution: java Queue < <standard_input>
 *
 * $ java Queue < ~/algs4-data/tobe.txt
 * to be or not to be (2 left on queue)
 */

/**
 * Queue
 */
public class Queue<Item> implements Iterable<Item> {
  private Node first;
  private Node last;
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
     * Pointer to nex Node
     */
    Node next;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public int size() {
    return n;
  }

  public void enqueue(Item item) {
    Node oldLast = last;
    last = new Node();
    last.item = item;
    last.next = null;
    if (isEmpty()) {
      first = last;
    } else {
      oldLast.next = last;
    }
    n++;
  }

  public Item dequeue() {
    Item item = first.item;
    first = first.next;
    n--;
    if (isEmpty()) {
      last = null;
    }
    return item;
  }

  /**
   * Returns an iterator
   */
  public Iterator<Item> iterator() {
    return new ListIterator();
  }

  /**
   * Nested class to implement Iterable interface
   */
  private class ListIterator implements Iterator<Item> {
    /**
     * Current Node in the iterator.
     */
    private Node current = first;

    /**
     * Next element in the iterator is the current Node
     * if current Node is null, then hasNext returns false.
     */
    public boolean hasNext() {
      return current != null;
    }

    public void remove() {
      /* do nothing */
    }

    /**
     * Returns the item in the current Node
     * and sets the next Node
     */
    public Item next() {
      Item item = current.item;
      current = current.next;
      return item;
    }
  }

  /**
   * Test client
   */
  public static void main(String[] args) {
    Queue<String> q = new Queue<String>();

    while (!StdIn.isEmpty()) {
      String item = StdIn.readString();

      if (item.equals("-") && !q.isEmpty()) {
        StdOut.printf(q.dequeue() + " ");
      } else {
        q.enqueue(item);
      }
    }

    StdOut.println("(" + q.size() + " left on queue)");
  }
}