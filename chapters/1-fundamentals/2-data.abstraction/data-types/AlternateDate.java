import edu.princeton.cs.algs4.StdOut;

/**
 * Type: ADT
 * Description: An abstract data type to encapsulate dates (alternative implementation).
 * Ref: p. 91
 *
 * Compilation: javac AlternateDate.java
 * Execution: java AlternateDate <month> <day> <year>
 *
 * $ java AlternateDate 9 27 1987
 * 9/27/1897
 * Is 9/27/1987 equals to 9/27/1987? true
 * Is 9/27/1987 equals to 9/27/1987? true
 * Is 9/27/1987 equals to null? false
 * Is 9/27/1987 equals to 9/27/1988? false
 * Is 9/27/1987 equals to 10/27/1988? false
 * Is 9/27/1987 equals to 9/26/1988? false
 */

/**
 * AlternateDate
 */
public class AlternateDate {
  private final int value;

  public AlternateDate(int m, int d, int y) {
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
    AlternateDate that = (AlternateDate) x;
    if (this.year() != that.year())
      return false;
    if (this.month() != that.month())
      return false;
    if (this.day() != that.day())
      return false;
    return true;
  }

  public static void main(String[] args) throws Exception {
    if (args.length != 3) {
      throw new Error("You must provide: <month> <day> <year>");
    }

    int m = Integer.parseInt(args[0]);
    int d = Integer.parseInt(args[1]);
    int y = Integer.parseInt(args[2]);

    AlternateDate birthday = new AlternateDate(m, d, y);

    StdOut.println(birthday);

    AlternateDate date = new AlternateDate(9, 27, 1987);
    StdOut.printf("Is %s equals to %s? %b\n", date, date, date.equals(date));
    StdOut.printf("Is %s equals to %s? %b\n", date, "9/27/1987", date.equals(new AlternateDate(9, 27, 1987)));
    StdOut.printf("Is %s equals to %s? %b\n", date, null, date.equals(null));
    StdOut.printf("Is %s equals to %s? %b\n", date, "9/27/1988", date.equals(new AlternateDate(9, 27, 1988)));
    StdOut.printf("Is %s equals to %s? %b\n", date, "10/27/1988", date.equals(new AlternateDate(10, 27, 1988)));
    StdOut.printf("Is %s equals to %s? %b\n", date, "9/26/1988", date.equals(new AlternateDate(9, 26, 1988)));
  }
}