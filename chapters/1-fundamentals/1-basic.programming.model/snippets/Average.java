import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Type: Snippet
 * Description: Sample StdIn client.
 * Ref: p. 39
 * Compilation: javac Average.java
 * Execution: java Average < <standard_input>
 *
 * $ java Average
 * 118.49
 * 132.06
 * 188.11
 * 181.88
 * 109.22
 * <ctrl-d>
 * Average is: 145.95200
 *
 * Pipe from Standard Ouput -> Standard Input
 * $ java RandomSeq 5 100 200 | java Average
 * Average is 166.88600
 */

/**
 * Average
 */
public class Average {
  public static void main(String[] args) {
    double sum = 0.0;
    int count = 0;

    while (!StdIn.isEmpty()) {
      sum += StdIn.readDouble();
      count++;
    }
    double avg = sum / count;
    StdOut.printf("Average is %.5f\n", avg);
  }
}