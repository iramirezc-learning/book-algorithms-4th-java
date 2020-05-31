import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * FixedCapacityStackOfStrings
 * Type: ADT
 * Description: A Fixed-Capacity Stack of Strings
 * Section: 1.3
 * Ref: p. 133
 * Compilation: javac FixedCapacityStackOfStrings.java
 * Execution: java FixedCapacityStackOfStrings < <standard_input>
 * Example(s):
 *
 * $ java FixedCapacityStackOfStrings < ~/algs4-data/tobe.txt
 * to be not that or be (2 strings left on stack)
 */
public class FixedCapacityStackOfStrings {
  private String[] stack;
  private int n;

  public FixedCapacityStackOfStrings(int size) {
    stack = new String[size];
  }

  public boolean isEmpty() {
    return n == 0;
  }

  public int size() {
    return n;
  }

  public void push(String item) {
    stack[n++] = item;
  }

  public String pop() {
    return stack[--n];
  }

  public static void main(String[] args) {
    FixedCapacityStackOfStrings stack;
    stack = new FixedCapacityStackOfStrings(100);

    StdOut.println("Reading from Standard Input...");

    while (!StdIn.isEmpty()) {
      String s = StdIn.readString();

      if (s.equals("-") && !stack.isEmpty()) {
        StdOut.printf(stack.pop() + " ");
      } else {
        stack.push(s);
      }
    }

    StdOut.printf("(%d strings left on stack)\n", stack.size());
  }
}
