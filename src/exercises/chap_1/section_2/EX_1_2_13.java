import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise: 1.2.13
 * Description: Implementation of Transaction
 * Compilation: javac EX_1_2_13.java
 * Execution: java EX_1_2_13
 * Example(s):
 * 
 * $ java EX_1_2_13
 * Transaction 1: Isaac 9/27/2019 99.99
 * Transaction 2: Danni 5/13/2019 10000.0
 */
public class EX_1_2_13 {
  public static void main(String[] args) {
    Transaction transaction1 = new Transaction("Isaac", new BasicDate(9, 27, 2019), 99.99);
    Transaction transaction2 = new Transaction("Danni", new BasicDate(5, 13, 2019), 10000);

    StdOut.printf("Transaction 1: %s\n", transaction1);
    StdOut.printf("Transaction 2: %s\n", transaction2);
  }
}
