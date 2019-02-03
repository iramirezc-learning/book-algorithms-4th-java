import edu.princeton.cs.algs4.StdOut;

/**
 * Type: ADT
 * Description: An abstract data type to encapsulate dates.
 * Ref: p. 91
 *
 * Compilation: javac Date.java
 * Execution: java Date <month> <day> <year>
 *
 * $ java Date 9 27 1987
 * 9/27/1897
 */

/**
 * Date
 */
public class Date {
  private final int month;
  private final int day;
  private final int year;

  public Date(int m, int d, int y) {
    month = m;
    day = d;
    year = y;
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

  public static void main(String[] args) throws Exception {
    if (args.length != 3) {
      throw new Error("You must provide: <month> <day> <year>");
    }

    int m = Integer.parseInt(args[0]);
    int d = Integer.parseInt(args[1]);
    int y = Integer.parseInt(args[2]);

    Date birthday = new Date(m, d, y);

    StdOut.println(birthday);
  }
}