import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

/**
 * Type: Snippet
 * Description: Typical string-processing code
 * Ref: p. 81
 *
 * Compilation: javac StringUtils.java
 * Execution: java StringUtils < ~/algs4-data/custom/cats.txt
 *
 * $ java StringUtils
 * isPalindrome('abc'): false
 * isPalindrome('aba'): true
 * 
 * getFileName('meme.jpg'): meme
 * getExtensionName('meme.jpg'): jpg
 *
 * filterBy('cat'):
 * cats are awesome
 * cats will dominate the world
 * 
 * getWords('Cats  are  so  cute'): [Cats, are, so, cute]
 * 
 * isSorted(['animal', 'boat', 'car']): true
 * isSorted(['boat', 'car', 'animal']): false
 */

/**
 * StringUtils
 */
public class StringUtils {
  /**
   * is the string a Palindrome?
   */
  public static boolean isPalindrome(String s) {
    int n = s.length();
    for (int i = 0; i < n / 2; i++) {
      if (s.charAt(i) != s.charAt(n - 1 - i)) {
        return false;
      }
    }
    return true;
  }

  /**
   * extract file name from a string
   */
  public static String getFileName(String s) {
    int dot = s.indexOf(".");
    String base = s.substring(0, dot);

    return base;
  }

  /**
   * extract the extension from a string
   */
  public static String getExtensionName(String s) {
    int dot = s.indexOf(".");
    String extension = s.substring(dot + 1, s.length());

    return extension;
  }

  /**
   * print all lines from standard input that contain 
   * a string specified on the command line.
   */
  public static void filterBy(String query) {
    while (!StdIn.isEmpty()) {
      String s = StdIn.readLine();
      if (s.contains(query)) {
        StdOut.println(s);
      }
    }
  }

  /**
   * creates an array of the words (strings) on a string delimited by whitespace
   */
  public static String[] getWords(String text) {
    String[] words = text.split("\\s+");
    return words;
  }

  /**
   * checks wheter an array of strings is in alphabetical order
   */
  public static boolean isSorted(String[] a) {
    for (int i = 1; i < a.length; i++) {
      if (a[i - 1].compareTo(a[i]) > 0)
        return false;
    }
    return true;
  }

  public static void main(String[] args) {
    StdOut.println("isPalindrome('abc'): " + isPalindrome("abc"));
    StdOut.println("isPalindrome('aba'): " + isPalindrome("aba"));
    StdOut.println();

    StdOut.println("getFileName('meme.jpg'): " + getFileName("meme.jpg"));
    StdOut.println("getExtensionName('meme.jpg'): " + getExtensionName("meme.jpg"));
    StdOut.println();

    StdOut.println("filterBy('cat'):");
    filterBy("cat");
    StdOut.println();

    StdOut.println("getWords('Cats  are  so  cute'): " + Arrays.toString(getWords("Cats  are  so  cute")));
    StdOut.println();

    String[] sorted = { "animal", "boat", "car" };
    String[] notSorted = { "boat", "car", "animal" };
    StdOut.println("isSorted(['animal', 'boat', 'car']): " + isSorted(sorted));
    StdOut.println("isSorted(['boat', 'car', 'animal']): " + isSorted(notSorted));
  }
}