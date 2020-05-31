import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Reverse
 * Type: Snippet
 * Description: Sample Stack client.
 * Section: 1.3
 * Ref: p. 127
 * Compilation: javac Reverse.java
 * Execution: java Reverse < <standard_input>
 * Example(s):
 *
 * $ java Reverse
 * Reading from Standard Input...
 * > 1
 * > 2
 * > 3
 * > 4
 * > 5
 * > <ctrl-d>
 * (5 items in the Stack):
 * 5
 * 4
 * 3
 * 2
 * 1
 */
public class Reverse {
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<Integer>();

    StdOut.println("Reading from Standard Input...");

    while (!StdIn.isEmpty()) {
      stack.push(StdIn.readInt());
    }

    StdOut.printf("(%d items in the Stack):\n", stack.size());

    for (int i : stack) {
      StdOut.printf("%d\n", i);
    }
  }
}
