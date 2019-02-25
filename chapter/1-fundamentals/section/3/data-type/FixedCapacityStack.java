import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Type: ADT
 * Description: A Fixed-Capacity Generic Stack
 * Ref: p. 135
 *
 * Compilation: javac FixedCapacityStack.java
 * Execution: java FixedCapacityStack < <standard_input>
 *
 * $ java FixedCapacityStack < ~/algs4-data/tobe.txt
 * to be not that or be (2 left on stack)
 */

/**
 * FixedCapacityStack
 */
public class FixedCapacityStack<Item> {
  private Item[] stack;
  private int n = 0;

  public FixedCapacityStack(int capacity) {
    stack = (Item[]) new Object[capacity];
  }

  public boolean isEmpty() {
    return n == 0;
  }

  public int size() {
    return n;
  }

  public void push(Item item) {
    stack[n++] = item;
  }

  public Item pop() {
    return stack[--n];
  }

  public static void main(String[] args) {
    FixedCapacityStack<String> stack = new FixedCapacityStack<String>(100);

    StdOut.println("Reading from Standard Input...");

    while (!StdIn.isEmpty()) {
      String s = StdIn.readString();

      if (s.equals("-") && !stack.isEmpty()) {
        StdOut.printf(stack.pop() + " ");
      } else {
        stack.push(s);
      }
    }

    StdOut.printf("(%d left on stack)\n", stack.size());
  }
}