import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise_1_1_21
 */
public class Exercise_1_1_21 {
  public static void main(String[] args) {
    while (StdIn.hasNextLine()) {
      String [] line = StdIn.readLine().split("\\s+");
      String name = line[0];
      int n1 = Integer.parseInt(line[1]);
      int n2 = Integer.parseInt(line[2]);
      double n3 =  n1 / (double) n2;

      StdOut.printf("%-10s %5d %5d %-5s %3.3f\n", name, n1, n2, "", n3);
    }
  }
}