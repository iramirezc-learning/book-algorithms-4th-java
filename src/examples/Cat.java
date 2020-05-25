import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;

/**
 * Cat
 * Type: Snippet
 * Description: Concatenates multiple files into one.
 * Section: 1.2
 * Ref: p. 82
 * Compilation: javac Cat.java
 * Execution: java Cat <input_file_1> <input_file_2> <output_file>
 * Example(s):
 *
 * $ java Cat ~/algs4-data/in1.txt ~/algs4-data/in2.txt ../out/out.txt && more ../out/out.txt
 * This is
 * a tiny
 * test.
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
