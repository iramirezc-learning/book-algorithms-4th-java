import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Compilation: javac E2101.java
 * Execution: java E2101
 * 0 -> E A S Y Q U E S T I O N
 * 1 -> A E S Y Q U E S T I O N
 * 2 -> A E S Y Q U E S T I O N
 * 3 -> A E E Y Q U S S T I O N
 * 4 -> A E E I Q U S S T Y O N
 * 5 -> A E E I N U S S T Y O Q
 * 6 -> A E E I N O S S T Y U Q
 * 7 -> A E E I N O Q S T Y U S
 * 8 -> A E E I N O Q S T Y U S
 * 9 -> A E E I N O Q S S Y U T
 * 10 -> A E E I N O Q S S T U Y
 * A E E I N O Q S S T U Y
 * isSorted? true
 */

/**
 * E2101. Selection Sort
 */
public class E2101 {
  public static void sort(Comparable[] a) {
    int len = a.length;

    for (int i = 0; i < len - 1; i++) {
      int min = i;

      for (int j = i + 1; j < len; j++) {
        if (less(a[j], a[min])) {
          min = j;
        }
      }
      StdOut.print(i + " -> ");
      show(a);
      exchange(a, i, min);
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
    String phrase = "EASYQUESTION";
    String[] chars = phrase.split("");
    sort(chars);
    show(chars);
    StdOut.printf("isSorted? %s\n", isSorted(chars));
  }
}
