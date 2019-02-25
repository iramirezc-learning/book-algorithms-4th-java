import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;

/**
 * Type: ADT
 * Description: A Resizable Generic Array Stack
 * Ref: p. 141
 *
 * Compilation: javac ResizableArrayStack.java
 * Execution: java ResizableArrayStack < <standard_input>
 *
 * $ java ResizableArrayStack < ~/algs4-data/tobe.txt
 * to be not that or be (2 left on stack)
 */

/**
* ResizableArrayStack
*/
public class ResizableArrayStack<Item> implements Iterable<Item> {
  private Item[] stack = (Item[]) new Object[1];
  private int n = 0;

  public boolean isEmpty() {
    return n == 0;
  }

  public int size() {
    return n;
  }

  public void resize(int max) {
    Item[] temp = (Item[]) new Object[max];

    for (int i = 0; i < n; i++) {
      temp[i] = stack[i];
    }

    stack = temp;
  }

  public void push(Item item) {
    if (n == stack.length) {
      resize(stack.length * 2);
    }
    stack[n++] = item;
  }

  public Item pop() {
    Item item = stack[--n];
    stack[n] = null; // avoid loitering
    if (n > 0 && n == stack.length / 4) {
      resize(stack.length / 2);
    }
    return item;
  }

  /**
   * Returns an Iterator to traverse the array in reverse order
   */
  public Iterator<Item> iterator() {
    return new ReverseArrayIterator();
  }

  /**
   * Nested class to implement Iterable interface
   */
  private class ReverseArrayIterator implements Iterator<Item> {
    private int i = n - 1;

    public boolean hasNext() {
      return i >= 0;
    }

    public Item next() {
      return stack[i--];
    }

    public void remove() {
      /* do nothing */
    }
  }

  /**
   * Test client
   */
  public static void main(String[] args) {
    ResizableArrayStack<String> s = new ResizableArrayStack<String>();

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