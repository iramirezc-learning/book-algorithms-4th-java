import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * FixedCapacityStack
 * Type: ADT
 * Description: A Fixed-Capacity Generic Stack
 * Section: 1.3
 * Ref: p. 135
 * Compilation: javac FixedCapacityStack.java
 * Execution: java FixedCapacityStack < <standard_input>
 * Example(s):
 *
 * $ java FixedCapacityStack < ~/algs4-data/tobe.txt
 * to be not that or be (2 left on stack)
 */
public class FixedCapacityStack<Item> {
  private Item[] stack;
  private int n = 0;

  public FixedCapacityStack(int size) {
    stack = (Item[]) new Object[size];
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
    FixedCapacityStack<String> stack;
    stack = new FixedCapacityStack<String>(100);

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
