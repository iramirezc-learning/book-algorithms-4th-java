import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise: 1.2.14
 * Description: Implementation of equals for Transaction
 * Compilation: javac EX_1_2_14.java
 * Execution: java EX_1_2_14
 * Example(s):
 *
 * $ java EX_1_2_14
 * equals()
 * Is 'Isaac 9/27/2019 99.99' equals to 'Isaac 9/27/2019 99.99' ? true
 * Is 'Isaac 9/27/2019 99.99' equals to 'Isaac 9/27/2019 99.99' ? true
 * Is 'Isaac 9/27/2019 99.99' equals to 'null' ? false
 * Is 'Isaac 9/27/2019 99.99' equals to 'Nahum 9/27/2019 99.99' ? false
 * Is 'Isaac 9/27/2019 99.99' equals to 'Isaac 5/23/2020 99.99' ? false
 * Is 'Isaac 9/27/2019 99.99' equals to 'Isaac 9/27/2019 199.98' ? false
 */
public class EX_1_2_14 {
  public static void main(String[] args) {
    Transaction transaction1 = new Transaction("Isaac", new BasicDate(9, 27, 2019), 99.99);
    Transaction t1 = transaction1;
    Transaction equal = new Transaction(t1.toString());
    Transaction diffOwner = new Transaction("Nahum", t1.when(), t1.amount());
    Transaction diffDate = new Transaction(t1.who(), new BasicDate(5, 23, 2020), t1.amount());
    Transaction greater = new Transaction(t1.who(), t1.when(), t1.amount() * 2);
    Transaction smaller = new Transaction(t1.who(), t1.when(), t1.amount() / 2);

    StdOut.println("equals()");
    StdOut.printf("Is '%s' equals to '%s' ? %b\n", t1, transaction1, t1.equals(transaction1)); // true
    StdOut.printf("Is '%s' equals to '%s' ? %b\n", t1, equal, t1.equals(equal)); // true
    StdOut.printf("Is '%s' equals to '%s' ? %b\n", t1, null, t1.equals(null)); // false
    StdOut.printf("Is '%s' equals to '%s' ? %b\n", t1, diffOwner, t1.equals(diffOwner)); // false
    StdOut.printf("Is '%s' equals to '%s' ? %b\n", t1, diffDate, t1.equals(diffDate)); // false
    StdOut.printf("Is '%s' equals to '%s' ? %b\n", t1, greater, t1.equals(greater)); // false
  }
}
