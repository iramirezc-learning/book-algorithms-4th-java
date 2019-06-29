import edu.princeton.cs.algs4.StdOut;

/**
 * Compilation: javac E2121.java
 * Execution: java E2121
 *
 * $ java E2121
 * Transaction1: Isaac 2/25/2019 99.99
 * Transaction2: Danni 5/13/2019 10000
 * Is 'Isaac 2/25/2019 99.99' <= 'Danni 5/13/2019 10000.0' ? true
 * Is 'Danni 5/13/2019 10000.0' <= 'Isaac 2/25/2019 99.99' ? false
 */

/**
 * E2121. Comparable Transactions
 */
public class E2121 {
  private static class Transaction implements Comparable<Transaction> {
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

    public int compareTo(Transaction that) {
      if (this.amount() > that.amount())
        return +1;
      if (this.amount() < that.amount())
        return -1;
      return 0;
    }
  }

  public static void main(String[] args) {
    Transaction t1 = new Transaction("Isaac", new Date(2, 25, 2019), 99.99);
    Transaction t2 = new Transaction("Danni", new Date(5, 13, 2019), 10000);

    StdOut.printf("Transaction1: %s\n", t1);
    StdOut.printf("Transaction2: %s\n", t2);
    StdOut.printf("Is '%s' <= '%s' ? %s\n", t1, t2, t1.compareTo(t2) <= 0);
    StdOut.printf("Is '%s' <= '%s' ? %s\n", t2, t1, t2.compareTo(t1) <= 0);
  }
}