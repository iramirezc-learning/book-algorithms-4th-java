import edu.princeton.cs.algs4.StdOut;

/**
 * Transaction
 * Type: ADT
 * Description: An abstract data type to encapsulate transactions.
 * Section: 1.2
 * Ref: p. 79
 * Compilation: javac Transaction.java
 * Execution: java Transaction
 * Example(s):
 *
 * $ java Transaction
 * Transaction 1: Isaac 9/27/2019 99.99
 * Transaction 2: Danni 5/13/2019 10000.0
 *
 * Parsed Transactions:
 * new Transaction('Isaac 9/27/2019 99.99'): Isaac 9/27/2019 99.99
 * new Transaction('Turing     6/17/1990     644.08'): Turing 6/17/1990 644.08
 *
 * equals()
 * Is 'Isaac 9/27/2019 99.99' equals to 'Isaac 9/27/2019 99.99' ? true
 * Is 'Isaac 9/27/2019 99.99' equals to 'Isaac 9/27/2019 99.99' ? true
 * Is 'Isaac 9/27/2019 99.99' equals to 'null' ? false
 * Is 'Isaac 9/27/2019 99.99' equals to 'Nahum 9/27/2019 99.99' ? false
 * Is 'Isaac 9/27/2019 99.99' equals to 'Isaac 5/23/2020 99.99' ? false
 * Is 'Isaac 9/27/2019 99.99' equals to 'Isaac 9/27/2019 199.98' ? false
 *
 * compareTo()
 * Is 'Isaac 9/27/2019 99.99' compareTo 'Isaac 9/27/2019 99.99' ? 0
 * Is 'Isaac 9/27/2019 99.99' compareTo 'Isaac 9/27/2019 49.995' ? 1
 * Is 'Isaac 9/27/2019 99.99' compareTo 'Isaac 9/27/2019 199.98' ? -1
 */
public class Transaction implements Comparable<Transaction> {
  private final String who;
  private final BasicDate when;
  private final double amount;

  public Transaction(String who, BasicDate when, double amount) {
    this.who = who;
    this.when = when;
    this.amount = amount;
  }

  public Transaction(String transaction) {
    String[] parts = transaction.split("\\s+");

    this.who = parts[0];
    this.when = new BasicDate(parts[1]);
    this.amount = Double.parseDouble(parts[2]);
  }

  public String who() {
    return who;
  }

  public BasicDate when() {
    return when;
  }

  public double amount() {
    return amount;
  }

  public String toString() {
    return who() + " " + when() + " " + amount();
  }

  public boolean equals(Object t) {
    if (this == t)
      return true;

    if (t == null)
      return false;

    if (this.getClass() != t.getClass())
      return false;

    Transaction that = (Transaction) t;

    if (!this.who().equals(that.who()))
      return false;

    if (!this.when().equals(that.when()))
      return false;

    if (this.amount() != that.amount())
      return false;

    return true;
  }

  public int compareTo(Transaction that) {
    if (this.amount() > that.amount())
      return +1;

    if (this.amount() < that.amount())
      return -1;

    return 0;
  }

  public static void main(String[] args) {
    Transaction transaction1 = new Transaction("Isaac", new BasicDate(9, 27, 2019), 99.99);
    Transaction transaction2 = new Transaction("Danni", new BasicDate(5, 13, 2019), 10000);

    StdOut.printf("Transaction 1: %s\n", transaction1);
    StdOut.printf("Transaction 2: %s\n", transaction2);

    String stringTransaction1 = transaction1.toString();
    String stringTransaction2 = "Turing     6/17/1990     644.08";

    StdOut.println("\nParsed Transactions:");
    StdOut.printf("new Transaction('%s'): %s\n", stringTransaction1, new Transaction(stringTransaction1));
    StdOut.printf("new Transaction('%s'): %s\n", stringTransaction2, new Transaction(stringTransaction2));

    StdOut.println("\nequals()");

    Transaction t1 = transaction1;
    Transaction equal = new Transaction(t1.toString());
    Transaction diffOwner = new Transaction("Nahum", t1.when(), t1.amount());
    Transaction diffDate = new Transaction(t1.who(), new BasicDate(5, 23, 2020), t1.amount());
    Transaction greater = new Transaction(t1.who(), t1.when(), t1.amount() * 2);
    Transaction smaller = new Transaction(t1.who(), t1.when(), t1.amount() / 2);

    StdOut.printf("Is '%s' equals to '%s' ? %b\n", t1, transaction1, t1.equals(transaction1)); // true
    StdOut.printf("Is '%s' equals to '%s' ? %b\n", t1, equal, t1.equals(equal)); // true
    StdOut.printf("Is '%s' equals to '%s' ? %b\n", t1, null, t1.equals(null)); // false
    StdOut.printf("Is '%s' equals to '%s' ? %b\n", t1, diffOwner, t1.equals(diffOwner)); // false
    StdOut.printf("Is '%s' equals to '%s' ? %b\n", t1, diffDate, t1.equals(diffDate)); // false
    StdOut.printf("Is '%s' equals to '%s' ? %b\n", t1, greater, t1.equals(greater)); // false

    StdOut.println("\ncompareTo()");
    StdOut.printf("Is '%s' compareTo '%s' ? %d\n", t1, equal, t1.compareTo(equal));
    StdOut.printf("Is '%s' compareTo '%s' ? %d\n", t1, smaller, t1.compareTo(smaller));
    StdOut.printf("Is '%s' compareTo '%s' ? %d\n", t1, greater, t1.compareTo(greater));
  }
}
