import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Type: Snippet
 * Description: Reads a CSV file and prints the key-value pairs.
 * Ref: p. 495
 *
 * Compilation. javac LookupCSV.java
 * Execution: java LookupCSV <csv_file> <col1> <col2>
 *
 * $ java LookupCSV ~/algs4-data/ip.csv 1 0
 * 128.112.136.35
 * www.cs.princeton.edu
 *
 * $ java LookupCSV ~/algs4-data/amino.csv 0 3
 * TCC
 * Serine
 *
 * $ java LookupCSV ~/algs4-data/DJIA.csv 0 3
 * 29-Oct-29
 * 212.33
 */

/**
 * LookupCSV
 */
public class LookupCSV {

  public static void main(String[] args) {
    In in = new In(args[0]);
    int keyColumn = Integer.parseInt(args[1]);
    int valColumn = Integer.parseInt(args[2]);

    ST<String, String> st = new ST<String, String>();

    while (in.hasNextLine()) {
      String line = in.readLine();
      String[] tokens = line.split(",");
      String key = tokens[keyColumn];
      String val = tokens[valColumn];

      st.put(key, val);
    }

    while (!StdIn.isEmpty()) {
      String query = StdIn.readString();

      if (st.contains(query)) {
        StdOut.println(st.get(query));
      }
    }

  }
}