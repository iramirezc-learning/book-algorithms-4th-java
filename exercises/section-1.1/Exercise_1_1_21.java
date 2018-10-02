import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Compilation: javac Exercise_1_1_21.java
 * Execution: java Exercise_1_1_21 < <input_stream>
 *
 * $ java Exercise_1_1_21 < ../../data/names.txt
 * isaac         10    10       1.000
 * danni          8     4       2.000
 * peter         10     2       5.000
 * pablo          7     3       2.333
 * krystel        9     5       1.800
 * sue            3     2       1.500
 */

/**
 * Exercise_1_1_21. Table of names
 */
public class Exercise_1_1_21 {
  public static void main(String[] args) {
    while (StdIn.hasNextLine()) {
      String[] line = StdIn.readLine().split("\\s+");
      String name = line[0];
      int n1 = Integer.parseInt(line[1]);
      int n2 = Integer.parseInt(line[2]);
      double n3 = n1 / (double) n2;

      StdOut.printf("%-10s %5d %5d %-5s %3.3f\n", name, n1, n2, "", n3);
    }
  }
}