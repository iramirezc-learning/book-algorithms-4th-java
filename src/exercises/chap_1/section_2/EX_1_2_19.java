import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise: 1.2.19
 * Description: Implementation of parse constructors
 *     for Transaction and BasicDate.
 * Compilation: javac EX_1_2_19.java
 * Execution: java EX_1_2_19
 * Example(s):
 *
 * $ java EX_1_2_19
 * Transaction from String
 * Transaction: Isaac 9/27/2019 99.99
 * Parsed Transaction:
 * new Transaction('Isaac 9/27/2019 99.99'): Isaac 9/27/2019 99.99
 *
 * BasicDate from String
 * BasicDate: 9/27/2019
 * Parsed BasicDate:
 * new BasicDate('9/27/2019'): 9/27/2019
 */
public class EX_1_2_19 {
  public static void main(String[] args) {
    BasicDate date = new BasicDate(9, 27, 2019);
    Transaction transaction = new Transaction("Isaac", date, 99.99);

    StdOut.println("Transaction from String");
    StdOut.printf("Transaction: %s\n", transaction);
    StdOut.println("Parsed Transaction:");
    StdOut.printf("new Transaction('%s'): %s\n", transaction, new Transaction(transaction.toString()));

    StdOut.println("\nBasicDate from String");
    StdOut.printf("BasicDate: %s\n", date);
    StdOut.println("Parsed BasicDate:");
    StdOut.printf("new BasicDate('%s'): %s\n", date, new BasicDate(date.toString()));
  }
}
