import edu.princeton.cs.algs4.StdOut;

/**
 * Type: ADT
 * Description: An ADT to encapsulate Dates implmenting Comparable interface.
 * Ref: p. 247
 *
 * Compilation: javac Date.java
 * Execution: java Date <month> <day> <year>
 *
 * $ java Date 9 15 1900
 * 9/15/1900
 * 9/15/1900 <= 9/16/1810 ? false
 */

/**
 * Date
 */
public class Date implements Comparable<Date> {

  private final int day;
  private final int month;
  private final int year;

  public Date(int m, int d, int y) {
    day = d;
    month = m;
    year = y;
  }

  public int day() {
    return day;
  }

  public int month() {
    return month;
  }

  public int year() {
    return year;
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

  public String toString() {
    return month + "/" + day + "/" + year;
  }

  public static void main(String[] args) throws Exception {
    if (args.length != 3) {
      throw new Error("You must provide: <month> <day> <year>");
    }

    int m = Integer.parseInt(args[0]);
    int d = Integer.parseInt(args[1]);
    int y = Integer.parseInt(args[2]);

    Date date1 = new Date(m, d, y);

    StdOut.println(date1);

    Date date2 = new Date(9, 16, 1810);

    StdOut.printf("%s <= %s ? %s\n", date1, date2, date1.compareTo(date2) <= 0);
  }
}