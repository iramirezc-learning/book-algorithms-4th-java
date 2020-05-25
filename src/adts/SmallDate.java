import edu.princeton.cs.algs4.StdOut;

/**
 * SmallDate
 * Type: ADT
 * Description: An abstract data type to encapsulate dates (alternative implementation).
 * Section: 1.2
 * Ref: p. 91
 * Compilation: javac SmallDate.java
 * Execution: java SmallDate <month> <day> <year>
 * Example(s):
 *
 * $ java SmallDate 9 27 1987
 * new SmallDate(9, 27, 1987): 9/27/1987
 *
 * equals()
 * Is 9/27/1987 equals to null ? false
 * Is 9/27/1987 equals to 9/27/1987 ? true
 * Is 9/27/1987 equals to 9/27/1988 ? false
 * Is 9/27/1987 equals to 9/27/1986 ? false
 *
 * compareTo()
 * 9/27/1987 compareTo 9/27/1987 ? 0
 * 9/27/1987 compareTo 9/27/1988 ? -1
 * 9/27/1987 compareTo 9/27/1986 ? 1
 */
public class SmallDate implements Comparable<SmallDate> {
  private final int value;

  public SmallDate(int m, int d, int y) {
    value = y * 512 + m * 32 + d;
  }

  public int month() {
    return (value / 32) % 16;
  }

  public int day() {
    return value % 32;
  }

  public int year() {
    return value / 512;
  }

  public String toString() {
    return month() + "/" + day() + "/" + year();
  }

  public boolean equals(Object x) {
    if (this == x)
      return true;

    if (x == null)
      return false;

    if (this.getClass() != x.getClass())
      return false;

    SmallDate that = (SmallDate) x;

    if (this.year() != that.year())
      return false;

    if (this.month() != that.month())
      return false;

    if (this.day() != that.day())
      return false;

    return true;
  }

  public int compareTo(SmallDate that) {
    if (this.year() > that.year())
      return +1;

    if (this.year() < that.year())
      return -1;

    if (this.month() > that.month())
      return +1;

    if (this.month() < that.month())
      return -1;

    if (this.day() > that.day())
      return +1;

    if (this.day() < that.day())
      return -1;

    return 0;
  }

  public static void main(String[] args) throws Exception {
    if (args.length != 3) {
      throw new Error("You must provide: <month> <day> <year>");
    }

    int m = Integer.parseInt(args[0]);
    int d = Integer.parseInt(args[1]);
    int y = Integer.parseInt(args[2]);

    SmallDate yourDate = new SmallDate(m, d, y);
    SmallDate equal = new SmallDate(m, d, y);
    SmallDate greater = new SmallDate(m, d, y + 1);
    SmallDate smaller = new SmallDate(m, d, y - 1);

    StdOut.println("new SmallDate(" + m + ", " + d + ", " + y + "): " + yourDate);

    StdOut.println("\nequals()");
    StdOut.printf("Is %s equals to %s ? %b\n", yourDate, null, yourDate.equals(null));
    StdOut.printf("Is %s equals to %s ? %b\n", yourDate, equal, yourDate.equals(equal));
    StdOut.printf("Is %s equals to %s ? %b\n", yourDate, greater, yourDate.equals(greater));
    StdOut.printf("Is %s equals to %s ? %b\n", yourDate, smaller, yourDate.equals(smaller));

    StdOut.println("\ncompareTo()");
    StdOut.printf("%s compareTo %s ? %d\n", yourDate, equal, yourDate.compareTo(equal));
    StdOut.printf("%s compareTo %s ? %d\n", yourDate, greater, yourDate.compareTo(greater));
    StdOut.printf("%s compareTo %s ? %d\n", yourDate, smaller, yourDate.compareTo(smaller));
  }
}
