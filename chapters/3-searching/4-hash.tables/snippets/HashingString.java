import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Type: Snippet
 * Description: A basic Hashing String Key algorithm.
 * Ref: p. 460
 * 
 * Compilation: javac HashingString.java
 * Execution: java HashingString <string_1> <string_2> ... <string_n>
 *
 * $ java HashingString hello world hashing function
 * String: hello
 * Hash: 95
 * String: world
 * Hash: 7
 * String: hashing
 * Hash: 74
 * String: function
 * Hash: 20
 */

/**
 * HashingString
 */
public class HashingString {
  public static void main(String[] args) throws Exception {
    if (args.length < 0) {
      throw new Error("You must provide at least <any_string>");
    }

    int R = 31; // a small prime integer
    int m = 97; // a prime number to perform modular arithmetic

    for (int i = 0; i < args.length; i++) {
      String s = args[i];
      int hash = 0;

      for (int c = 0; c < s.length(); c++) {
        hash = (R * hash + s.charAt(c)) % m;
      }

      StdOut.println("String: " + s);
      StdOut.println("Hash: " + hash);
    }
  }
}
