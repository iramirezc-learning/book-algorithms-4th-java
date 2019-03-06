import edu.princeton.cs.algs4.StdOut;

/**
 * Type: ADT
 * Description: An abstract data type to encapsulate transactions.
 * Ref: p. 79
 *
 * Compilation: javac Transaction.java
 * Execution: java Transaction
 *
 * $ java Transaction
 * Transaction1: Isaac 2/25/2019 99.99
 * Parsed Transaction1: Isaac 2/25/2019 99.99
 * Transaction2: Danni 5/13/2019 10000.0
 *
 * equals()
 * Is 'Isaac 2/25/2019 500.0' equals to 'Isaac 2/25/2019 500.0'? true
 * Is 'Isaac 2/25/2019 500.0' equals to 'Isaac 2/25/2019 500.0'? true
 * Is 'Isaac 2/25/2019 500.0' equals to 'null'? false
 * Is 'Isaac 2/25/2019 500.0' equals to '1/1/2019'? false
 * Is 'Isaac 2/25/2019 500.0' equals to 'Isaac 3/25/2019 500.0'? false
 * Is 'Isaac 2/25/2019 500.0' equals to 'Nahum 2/25/2019 500.0'? false
 * Is 'Isaac 2/25/2019 500.0' equals to 'Isaac 2/25/2019 499.0'? false
 *
 * compareTo()
 * Is 'Isaac 2/25/2019 499.0' <= 'Nahum 2/25/2019 500.0' ? true
 */

/**
 * Transaction
 */
public class Transaction implements Comparable<Transaction> {
  private final String who;
  private final Date when;
  private final double amount;

  public Transaction(String who, Date when, double amount) {
    this.who = who;
    this.when = when;
    this.amount = amount;
  }

  public Transaction(String transaction) {
    String[] parts = transaction.split("\\s+");
    this.who = parts[0];
    this.when = new Date(parts[1]);
    this.amount = Double.parseDouble(parts[2]);
  }

  public String who() {
    return who;
  }

  public Date when() {
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
    Transaction transaction1 = new Transaction("Isaac", new Date(2, 25, 2019), 99.99);
    Transaction transaction2 = new Transaction("Danni", new Date(5, 13, 2019), 10000);

    StdOut.printf("Transaction1: %s\n", transaction1);
    StdOut.printf("Transaction2: %s\n", transaction2);

    StdOut.println("\nParsed Transactions:");
    StdOut.printf("Transaction1: %s\n", new Transaction(transaction1.toString()));
    StdOut.printf("Trimmed: %s\n", new Transaction("Turing      6/17/1990   644.08"));

    StdOut.println("\nequals()");

    Transaction t1 = new Transaction("Isaac", new Date(2, 25, 2019), 500);
    Transaction t2 = new Transaction(t1.toString()); // parsed
    Transaction t3 = new Transaction("Isaac", new Date(3, 25, 2019), 500);
    Transaction t4 = new Transaction("Nahum", new Date(2, 25, 2019), 500);
    Transaction t5 = new Transaction("Isaac", new Date(2, 25, 2019), 499);

    StdOut.printf("Is '%s' equals to '%s'? %b\n", t1, t1, t1.equals(t1)); // true
    StdOut.printf("Is '%s' equals to '%s'? %b\n", t1, t2, t1.equals(t2)); // true

    StdOut.printf("Is '%s' equals to '%s'? %b\n", t1, null, t1.equals(null)); // false
    StdOut.printf("Is '%s' equals to '%s'? %b\n", t1, "1/1/2019", t1.equals(new Date(1, 1, 2019))); // false
    StdOut.printf("Is '%s' equals to '%s'? %b\n", t1, t3, t1.equals(t3)); // false
    StdOut.printf("Is '%s' equals to '%s'? %b\n", t1, t4, t1.equals(t4)); // false
    StdOut.printf("Is '%s' equals to '%s'? %b\n", t1, t5, t1.equals(t5)); // false

    StdOut.println("\ncompareTo()");
    StdOut.printf("Is '%s' <= '%s' ? %s\n", t5, t4, t5.compareTo(t4) <= 0);
  }
}