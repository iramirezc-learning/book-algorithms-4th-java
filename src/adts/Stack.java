import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;

/**
 * Stack
 * Type: ADT
 * Description: Generic Stack implementation based on a linked-list ADT.
 * Section: 1.3
 * Ref: p. 147, 149, 155
 * Compilation: javac Stack.java
 * Execution: java Stack < <input_file>
 * Example(s):
 *
 * $ java Stack < ~/algs4-data/tobe.txt
 * to be not that or be (2 left on stack)
 */
public class Stack<Item> implements Iterable<Item> {
  /**
   * First item on the Stack
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
     * Pointer to nex Node
     */
    Node next;
  }

  /**
   * Checks if the Stack is empty
   */
  public boolean isEmpty() {
    return first == null;
  }

  /**
   * Returns the size of the Stack
   */
  public int size() {
    return n;
  }

  /**
   * Add an item to the Stack as first.
   */
  public void push(Item item) {
    Node oldFirst = first;
    first = new Node();
    first.item = item;
    first.next = oldFirst;
    n++;
  }

  /**
   * Removes and returns the first item from the Stack
   */
  public Item pop() {
    Item item = first.item;
    first = first.next;
    n--;
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
    Stack<String> s = new Stack<String>();

    while (!StdIn.isEmpty()) {
      String item = StdIn.readString();

      if (item.equals("-") && !s.isEmpty()) {
        StdOut.printf(s.pop() + " ");
      } else {
        s.push(item);
      }
    }

    StdOut.println("(" + s.size() + " left on stack)");
  }
}
