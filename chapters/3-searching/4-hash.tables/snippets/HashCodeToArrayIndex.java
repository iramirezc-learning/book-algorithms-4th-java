import com.sun.javafx.css.StyleCache.Key;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Type: Snippet
 * Description: An implementation to convert Java's default implementation of hashCode to return an array index.
 * Ref: p. 461
 * 
 * Compilation: javac HashCodeToArrayIndex.java
 * Execution: java HashCodeToArrayIndex <your_string>
 *
 * $ java HashCodeToArrayIndex SEARCHXMPL
 * S - 3
 * E - 4
 * A - 0
 * R - 2
 * C - 2
 * H - 2
 * X - 3
 * M - 2
 * P - 0
 * L - 1
 */

/**
 * HashCodeToArrayIndex
 */
public class HashCodeToArrayIndex<Key> {
  static final int m = 5;

  private int hashCode(Key x) {
    return (x.hashCode() & 0x7fffffff) % m;
  }

  public static void main(String[] args) throws Exception {
    if (args.length < 0) {
      throw new Error("You must provide at least <any_string>");
    }

    String s = args[0];
    HashCodeToArrayIndex hash = new HashCodeToArrayIndex();

    for (int i = 0; i < s.length(); i++) {
      String c = "" + s.charAt(i);
      StdOut.printf("%s - %d\n", c, hash.hashCode(c));
    }
  }
}
