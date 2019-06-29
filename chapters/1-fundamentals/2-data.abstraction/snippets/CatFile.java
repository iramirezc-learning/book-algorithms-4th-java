import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;

/**
 * Type: Snippet
 * Description: Concatenates multiple files into one.
 * Ref: p. 82
 * Compilation: javac CatFile.java
 * Execution: java CatFile <input_file_1> <input_file_2> <output_file>
 *
 * $ java CatFile ~/algs4-data/in1.txt ~/algs4-data/in2.txt ~/algs4-data/out/out.txt
 * $ more ../out/out.txt
 * This is
 * a tiny
 * test.
 */

/**
 * CatFile
 */
public class CatFile {
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