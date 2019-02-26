import edu.princeton.cs.algs4.StdOut;

/**
 * Type: ADT
 * Description: An abstract data type to encapsulate dates.
 * Ref: p. 91, p. 247
 *
 * Compilation: javac Date.java
 * Execution: java Date <month> <day> <year>
 *
 * $ java Date 9 27 1987
 * Your Date is: 9/27/1987
 * Parsed: 9/27/1987
 *
 * equals()
 * Is 9/27/1987 equals to 9/27/1987? true
 * Is 9/27/1987 equals to 9/27/1987? true
 * Is 9/27/1987 equals to null? false
 * Is 9/27/1987 equals to 9/27/1988? false
 * Is 9/27/1987 equals to 10/27/1988? false
 * Is 9/27/1987 equals to 9/26/1988? false
 * compareTo()
 * 9/27/1987 <= 9/27/1987 ? true
 */

/**
 * Date
 */
public class Date implements Comparable<Date> {
  private final int month;
  private final int day;
  private final int year;

  public Date(int m, int d, int y) {
    month = m;
    day = d;
    year = y;
  }

  public Date(String date) {
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
    if (this == x)
      return true;
    if (x == null)
      return false;
    if (this.getClass() != x.getClass())
      return false;
    Date that = (Date) x;
    if (this.year() != that.year())
      return false;
    if (this.month() != that.month())
      return false;
    if (this.day() != that.day())
      return false;
    return true;
  }

  public int compareTo(Date that) {
    if (this.year > that.year)
      return +1;
    if (this.year < that.year)
      return -1;
    if (this.month > that.month)
      return +1;
    if (this.month < that.month)
      return -1;
    if (this.day > that.day)
      return +1;
    if (this.day < that.day)
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

    Date yourDate = new Date(m, d, y);

    StdOut.println("Your Date is: " + yourDate);

    StdOut.println("Parsed: " + new Date(yourDate.toString()) + "\n");

    StdOut.println("equals()");
    Date date = new Date(9, 27, 1987);
    StdOut.printf("Is %s equals to %s? %b\n", yourDate, date, yourDate.equals(date));
    StdOut.printf("Is %s equals to %s? %b\n", yourDate, "9/27/1987", yourDate.equals(new Date(9, 27, 1987)));
    StdOut.printf("Is %s equals to %s? %b\n", yourDate, null, yourDate.equals(null));
    StdOut.printf("Is %s equals to %s? %b\n", yourDate, "9/27/1988", yourDate.equals(new Date(9, 27, 1988)));
    StdOut.printf("Is %s equals to %s? %b\n", yourDate, "10/27/1988", yourDate.equals(new Date(10, 27, 1988)));
    StdOut.printf("Is %s equals to %s? %b\n", yourDate, "9/26/1988", yourDate.equals(new Date(9, 26, 1988)));

    StdOut.println("compareTo()");
    StdOut.printf("%s <= %s ? %s\n", yourDate, date, yourDate.compareTo(date) <= 0);
  }
}