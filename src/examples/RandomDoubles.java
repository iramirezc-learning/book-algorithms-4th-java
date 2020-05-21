import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.StdRandom;

/**
 * RandomDoubles
 * Description: Create a file with `n` random doubles
 * Compilation: javac RandomDoubles.java
 * Execution: java RandomDoubles <output_file> <max_numbers>
 * Example(s):
 *
 * $ java RandomDoubles ~/algs4-data/custom/doubles.txt 1000
 */
public class RandomDoubles {
  public static void main(String[] args) {
    if (args.length != 2) {
      throw new Error("You must provide: <output_file> <max_numbers>");
    }

    Out out = new Out(args[0]);
    int n = Integer.parseInt(args[1]);

    for (int i = 1; i <= n; i++) {
      out.println(StdRandom.uniform(0.0, n));
    }

    out.close();
  }
}
