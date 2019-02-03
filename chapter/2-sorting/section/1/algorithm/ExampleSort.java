import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Type: Snippet
 * Description: This example provides the conventions to implement array sorts.
 * Ref: p. 245
 * 
 * Compilation: javac ExampleSort.java
 * Execution: java ExampleSort < <input_file>
 * 
 * $ java ExampleSort < ~/algs4-data/tiny.txt
 * A E E L M O P R S T X
 */

/**
 * ExampleSort
 */
public class ExampleSort {
  public static void sort(Comparable[] a) {
    // implementation goes here
    // for now, let's sort with bubble sort
    int len = a.length;
    for (int i = 0; i < len - 1; i++) {
      for (int j = i + 1; j < len; j++) {
        if (less(a[j], a[i]))
          exchange(a, i, j);
      }
    }
  }

  private static boolean less(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
  }

  private static void exchange(Comparable[] a, int i, int j) {
    Comparable t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  private static void show(Comparable[] a) {
    for (int i = 0; i < a.length; i++) {
      StdOut.print(a[i] + " ");
    }
    StdOut.println();
  }

  private static boolean isSorted(Comparable[] a) {
    for (int i = 1; i < a.length; i++) {
      if (less(a[i], a[i - 1]))
        return false;
    }
    return true;
  }

  public static void main(String[] args) {
    String[] a = StdIn.readAllStrings();
    sort(a);
    assert isSorted(a);
    show(a);
    StdOut.printf("isSorted? %s\n", isSorted(a));
  }
}