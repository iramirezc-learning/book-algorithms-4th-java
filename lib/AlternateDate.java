import edu.princeton.cs.algs4.StdOut;

/**
 * Type: ADT
 * Description: An abstract data type to encapsulate dates (alternative implementation).
 * Ref: p. 91
 * Compilation: javac AlternateDate.java
 * Execution: java AlternateDate <month> <day> <year>
 *
 * $ java AlternateDate 9 27 1987
 * 9/27/1897
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

  public static void main(String[] args) {
    int m = Integer.parseInt(args[0]);
    int d = Integer.parseInt(args[1]);
    int y = Integer.parseInt(args[2]);

    AlternateDate birthday = new AlternateDate(m, d, y);

    StdOut.println(birthday);
  }
}