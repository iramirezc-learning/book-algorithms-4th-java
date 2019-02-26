import edu.princeton.cs.algs4.StdOut;

/**
 * Compilation: javac E1219.java
 * Execution: java E1219
 *
 * $ java E1219
 * Is 'Isaac 2/25/2019 500.0' equals to 'Isaac 2/25/2019 500.0'? true
 */

/**
 * E1219. Transaction with parse Constructor
 */
public class E1219 {
  private static class Transaction {
    private final String who;
    private final Date when;
    private final double amount;

    public Transaction(String who, Date when, double amount) {
      this.who = who;
      this.when = when;
      this.amount = amount;
    }

    public Transaction(String transaction) {
      String[] parts = transaction.split(" ");
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
  }

  public static void main(String[] args) {
    Transaction t1 = new Transaction("Isaac", new Date(2, 25, 2019), 500);
    Transaction t2 = new Transaction(t1.toString());

    StdOut.printf("Is '%s' equals to '%s'? %b\n", t1, t2, t1.equals(t2)); // true
  }
}