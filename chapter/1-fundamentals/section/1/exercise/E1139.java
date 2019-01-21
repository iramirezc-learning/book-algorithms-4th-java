import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;

/**
 * Compilation: javac E1139.java
 * Execution: java E1139 <trials>
 *
 * $ java E1139 100
 * Trials: 100
 * n:      1000 Total findings:       104 Average:         1
 * n:     10000 Total findings:     10978 Average:       109
 * n:    100000 Total findings:   1051252 Average:     10512
 * n:   1000000 Total findings:  67072495 Average:    670724
 */

/**
 * E1139
 */
public class E1139 {
  public static int binarySearch(int[] a, int key) {
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

  public static int[] generateArray(int size) {
    int[] array = new int[size];
    int sixDigits = 100000;
    int sixDigitsLimit = sixDigits * 10;

    for (int i = 0; i < array.length; i++) {
      array[i] = StdRandom.uniform(sixDigits, sixDigitsLimit);
    }

    return array;
  }

  public static void main(String[] args) throws Exception {
    if (args.length != 1) {
      throw new Error("You must provide: <int_trials>");
    }

    int trials = Integer.parseInt(args[0]);
    int nMin = (int) Math.pow(10, 3);
    int nMax = (int) Math.pow(10, 6);

    StdOut.printf("Trials: %d\n", trials);

    do {
      int findings = 0;
      // run trials for n
      for (int i = 1; i <= trials; i++) {
        int[] a1 = generateArray(nMin);
        Arrays.sort(a1);
        int[] a2 = generateArray(nMin);
        // run binarySearch
        for (int key = 0; key < a2.length; key++) {
          if (binarySearch(a1, a2[key]) >= 0) {
            findings++;
          }
        }
      }

      // print results
      int average = findings / trials;
      StdOut.printf("n: %9d Total findings: %9d Average: %9d\n", nMin, findings, average);
      // go to next value for `n`
      nMin = nMin * 10;
    } while (nMin <= nMax);
  }
}