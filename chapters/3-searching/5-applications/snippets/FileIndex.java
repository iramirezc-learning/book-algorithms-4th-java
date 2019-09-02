import java.io.File;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Type: Snippet
 * Description: Tells in which files a word exists.
 * Ref: p. 501
 *
 * Compilation. javac FileIndex.java
 * Execution: java FileIndex <file1> <file2> <file_n>
 *
 * $ java FileIndex ~/algs4-data/ex*.txt
 * age
 *  ex3.txt
 *  ex4.txt
 * best
 *  ex1.txt
 * it
 *  ex1.txt
 *  ex2.txt
 *  ex3.txt
 *  ex4.txt
 */

/**
 * FileIndex
 */
public class FileIndex {

  public static void main(String[] args) {
    ST<String, SET<File>> st = new ST<String, SET<File>>();

    for (String filename : args) {
      File file = new File(filename);
      In in = new In(file);

      while (!in.isEmpty()) {
        String word = in.readString();
        if (!st.contains(word)) {
          st.put(word, new SET<File>());
        }
        SET<File> set = st.get(word);
        set.add(file);
      }
    }

    while (!StdIn.isEmpty()) {
      String query = StdIn.readLine();

      if (st.contains(query)) {
        SET<File> set = st.get(query);

        for (File file : set.keys()) {
          StdOut.println(" " + file.getName());
        }
      }
    }
  }
}
