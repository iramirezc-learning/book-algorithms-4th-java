import edu.princeton.cs.algs4.StdOut;

/**
 * Compilation: javac E1214.java
 * Execution: java E1214
 *
 * $ java E1214
 * equals()
 * Is 'Isaac 2/25/2019 500.0' equals to 'Isaac 2/25/2019 500.0'? true
 * Is 'Isaac 2/25/2019 500.0' equals to 'Isaac 2/25/2019 500.0'? true
 * Is 'Isaac 2/25/2019 500.0' equals to 'null'? false
 * Is 'Isaac 2/25/2019 500.0' equals to '1/1/2019'? false
 * Is 'Isaac 2/25/2019 500.0' equals to 'Isaac 3/25/2019 500.0'? false
 * Is 'Isaac 2/25/2019 500.0' equals to 'Nahum 2/25/2019 500.0'? false
 * Is 'Isaac 2/25/2019 500.0' equals to 'Isaac 2/25/2019 499.0'? false
 */

/**
 * E1214. Add equals() method to Transaction
 */
public class E1214 {
  private static class Transaction {
    private final String who;
    private final Date when;
    private final double amount;

    public Transaction(String who, Date when, double amount) {
      this.who = who;
      this.when = when;
      this.amount = amount;
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
    StdOut.println("equals()");

    Transaction t1 = new Transaction("Isaac", new Date(2, 25, 2019), 500);
    Transaction t2 = new Transaction("Isaac", new Date(2, 25, 2019), 500);
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
  }
}