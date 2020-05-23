import edu.princeton.cs.algs4.StdOut;

/**
 * BasicDate
 * Type: ADT
 * Description: An abstract data type to encapsulate dates.
 * Chapter: 1
 * Section: 2
 * Ref: p. 91, p.103, p. 247
 * Compilation: javac BasicDate.java
 * Execution: java BasicDate <month> <day> <year>
 * Example(s):
 *
 * $ java BasicDate 9 27 1987
 * new BasicDate(9, 27, 1987): 9/27/1987
 * new BasicDate('9/27/1987'): 9/27/1987
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
public class BasicDate implements Comparable<BasicDate> {
  private final int month;
  private final int day;
  private final int year;

  public BasicDate(int m, int d, int y) {
    month = m;
    day = d;
    year = y;
  }

  public BasicDate(String date) {
    String[] fields = date.split("/");

    month = Integer.parseInt(fields[0]);
    day = Integer.parseInt(fields[1]);
    year = Integer.parseInt(fields[2]);
  }

  public int month() {
    return month;
  }

  public int day() {
    return day;
  }

  public int year() {
    return year;
  }

  public String toString() {
    return month() + "/" + day() + "/" + year();
  }

  public boolean equals(Object x) {
    if (this == x) // if same reference
      return true;

    if (x == null) // if target is null
      return false;

    if (this.getClass() != x.getClass()) // if classes are different
      return false;

    BasicDate that = (BasicDate) x;

    if (this.year() != that.year())
      return false;

    if (this.month() != that.month())
      return false;

    if (this.day() != that.day())
      return false;

    return true;
  }

  public int compareTo(BasicDate that) {
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

    BasicDate yourDate = new BasicDate(m, d, y);
    BasicDate equal = new BasicDate(yourDate.toString());
    BasicDate greater = new BasicDate(m, d, y + 1);
    BasicDate smaller = new BasicDate(m, d, y - 1);

    StdOut.println("new BasicDate(" + m + ", " + d + ", " + y + "): " + yourDate);
    StdOut.println("new BasicDate('" + yourDate.toString() + "'): " + new BasicDate(yourDate.toString()));

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
