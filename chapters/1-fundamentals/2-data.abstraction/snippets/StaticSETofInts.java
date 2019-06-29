import java.util.Arrays;

/**
 * Type: Snippet
 * Description: Binary Search as an OO program.
 * Ref: p. 99
 * 
 * Compilation: javac StaticSETofInts.java
 */

/**
 * StaticSETofInts
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
    return indexOf(key) != -1;
  }

  public int indexOf(int key) {
    int lo = 0;
    int hi = a.length - 1;

    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (key < a[mid]) {
        hi = mid - 1;
      } else if (key > a[mid]) {
        lo = mid + 1;
      } else {
        return mid;
      }
    }

    return -1;
  }
}