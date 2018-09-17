import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Compilation: javac Counter.java
 * Execution: java Counter <trials>
 *
 * $ java Counter 10
 * 7 heads
 * 3 tails
 * delta: 4
 */

/**
 * Counter
 */
public class Counter {
  private final String name;
  private int count;

  public Counter(String id) {
    name = id;
  }

  public void increment() {
    count++;
  }

  public int tally() {
    return count;
  }

  public String toString() {
    return count + " " + name;
  }

  public static void main(String[] args) {
    int trials = Integer.parseInt(args[0]);
    Counter heads = new Counter("heads");
    Counter tails = new Counter("tails");

    for (int i = 0; i < trials; i++) {
      if (StdRandom.bernoulli(0.5)) {
        heads.increment();
      } else {
        tails.increment();
      }
    }

    StdOut.println(heads);
    StdOut.println(tails);
    int delta = heads.tally() - tails.tally();
    StdOut.println("delta: " + Math.abs(delta));
  }
}