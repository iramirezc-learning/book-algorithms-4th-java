import java.util.Arrays;

/**
 * StaticSETofInts
 * Type: Snippet
 * Description: Binary Search as an OO program.
 * Section: 1.2
 * Ref: p. 99
 * Compilation: javac StaticSETofInts.java
 */
public class StaticSETofInts {
  private int[] a;

  public StaticSETofInts(int[] keys) {
    a = new int[keys.length];

    for (int i = 0; i < keys.length; i++) {
      a[i] = keys[i];
    }

    Arrays.sort(a);
  }

  public boolean contains(int key) {
    return BinarySearch.indexOf(a, key) != -1;
  }
}
