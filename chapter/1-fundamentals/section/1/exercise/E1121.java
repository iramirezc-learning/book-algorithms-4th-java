import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Compilation: javac E1121.java
 * Execution: java E1121 < <input_stream>
 *
 * $ java E1121 < ./data/names.txt
 * isaac         10    10       1.000
 * danni          8     4       2.000
 * peter         10     2       5.000
 * pablo          7     3       2.333
 * krystel        9     5       1.800
 * sue            3     2       1.500
 */

/**
 * E1121. Table of names
 */
public class E1121 {
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