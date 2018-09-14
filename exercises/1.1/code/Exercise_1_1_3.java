import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise_1_1_3
 */
public class Exercise_1_1_3 {
  public static void main(String[] args) throws Exception {
    if (args.length != 3) {
      throw new Exception("Must provide exactly 3 numbers");
    }

    int n1 = Integer.parseInt(args[0]);
    int n2 = Integer.parseInt(args[1]);
    int n3 = Integer.parseInt(args[2]);

    boolean result = n1 == n2 && n2 == n3;

    StdOut.println(result ? "equal" : "not equal");
  }
}