import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Type: Snippet
 * Description: Deletes duplicates keys from Standard Input
 * Ref: p. 490
 *
 * Compilation. javac DeDup.java
 * Execution: java DeDup < <standard_input>
 *
 * $ java DeDup < ~/algs4-data/tinyTale.txt
 * it
 * was
 * the
 * best
 * of
 * times
 * worst
 * age
 * wisdom
 * foolishness
 * epoch
 * belief
 * incredulity
 * season
 * light
 * darkness
 * spring
 * hope
 * winter
 * despair
 */

/**
 * DeDup
 */
public class DeDup {
  public static void main(String[] args) {
    HashSET<String> set;
    set = new HashSET<String>();

    while (!StdIn.isEmpty()) {
      String key = StdIn.readString();

      if (!set.contains(key)) {
        set.add(key);
        StdOut.println(key);
      }
    }
  }
}