import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * InnerBinarySearch
 */
public class BinarySearch {
  public static int indexOf(int[] a, int key) {
    int lo = 0;
    int hi = a.length - 1;

    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (key < a[mid])
        hi = mid - 1;
      else if (key > a[mid])
        lo = mid + 1;
      else
        return mid;
    }
    return -1;
  }

  public static void main(String[] args) {
    In in = new In(args[0]);
    int[] whilelist = in.readAllInts();

    Arrays.sort(whilelist);

    while (!StdIn.isEmpty()) {
      int key = StdIn.readInt();
      if (indexOf(whilelist, key) == -1)
        StdOut.println(key);
    }
  }
}
