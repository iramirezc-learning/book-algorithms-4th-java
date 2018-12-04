import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;

/**
 * Type: Snippet
 * Description: Concatenates multiple files into one.
 * Ref: p. 82
 * Compilation: javac Cat.java
 * Execution: java Cat <input_file_1> <input_file_2> <output_file>
 *
 * $ java Cat ../data/in1.txt ../data/in2.txt ../out/out.txt
 * $ more ../out/out.txt
 * This is
 * a tiny
 * test.
 */

/**
 * Cat
 */
public class Cat {
  public static void main(String[] args) {
    // copy input files to out (last argument)
    Out out = new Out(args[args.length - 1]);
    for (int i = 0; i < args.length - 1; i++) {
      // copy input file named on the ith arg to out.
      In in = new In(args[i]);
      String s = in.readAll();
      out.println(s);
      in.close();
    }
    out.close();
  }
}