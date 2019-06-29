import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;

/**
 * Type: Snippet
 * Description: Finds the median in an array,
 * selecting the 'k' smallest items in a[]
 * Ref: p. 346
 *
 * Compilation. javac FindMedian.java
 * Execution: java FindMedian <int_k> < <standard_input>
 *
 * $ java FindMedian 5 < ~/algs4-data/tiny.txt
 * Median is: O
 * Resulting array: [E, A, E, L, M, O, P, T, R, S, X]
 *
 * $ java FindMedian 3 < ~/algs4-data/words3.txt
 * Median is: bug
 * Resulting array: [all, bad, bed, bug, dad, dim, egg, ..., yet, sky, was]
 */

/**
 * FindMedian
 */
public class FindMedian {
  public static void exchange(Comparable[] a, int i, int j) {
    Comparable t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  public static boolean less(Comparable a, Comparable b) {
    return a.compareTo(b) < 0;
  }

  public static int partition(Comparable[] a, int lo, int hi) {
    int i = lo;
    int j = hi + 1;
    Comparable v = a[lo];

    while (true) {
      while (less(a[++i], v)) {
        if (i == hi) {
          break;
        }
      }

      while (less(v, a[--j])) {
        if (j == lo) {
          break;
        }
      }

      if (i >= j) {
        break;
      }

      exchange(a, i, j);
    }

    exchange(a, lo, j);

    return j;
  }

  public static Comparable select(Comparable[] a, int k) {
    StdRandom.shuffle(a);
    int lo = 0;
    int hi = a.length - 1;

    while (hi > lo) {
      int j = partition(a, lo, hi);

      if (j == k) {
        return a[k];
      } else if (j > k) {
        hi = j - 1;
      } else if (j < k) {
        lo = j + 1;
      }
    }

    return a[k];
  }

  public static void main(String[] args) throws Exception {
    if (args.length == 0) {
      throw new Error("You must provide: <int_n>");
    }

    int k = Integer.parseInt(args[0]);

    String[] a = StdIn.readAllStrings();

    Comparable median = select(a, k);

    StdOut.println("Median is: " + median);

    StdOut.println("Resulting array: " + Arrays.toString(a));
  }
}