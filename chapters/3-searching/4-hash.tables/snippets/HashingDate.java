import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Type: Snippet
 * Description: A basic Hashing algorithm for Compound Keys
 * Ref: p. 460
 * 
 * Compilation: javac HashingDate.java
 * Execution: java HashingDate <day> <month> <year>
 *
 * $ java HashingDate 27 9 1987
 * Date: 27-09-1987
 * Hash: 83
 */

/**
 * HashingDate
 */
public class HashingDate {
  public static String padZero(int n) {
    if (n < 10) {
      return "0" + n;
    }
    return "" + n;
  }

  public static void main(String[] args) throws Exception {
    if (args.length != 3) {
      throw new Error("You must provide <day> <month> <year> as integer values");
    }

    int R = 31; // a small prime integer
    int m = 97; // a prime number to perform modular arithmetic

    int day = Integer.parseInt(args[0]);
    int month = Integer.parseInt(args[1]);
    int year = Integer.parseInt(args[2]);

    int hash = (((day * R + month) % m) * R + year) % m;

    StdOut.printf("%s-%s-%4d\n", padZero(day), padZero(month), year);
    StdOut.println("Hash: " + hash);
  }
}
