import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Type: Snippet
 * Description: A Binary Search Tree client that
 * counts the frequency of occurrence of the strings
 * in StdIn.
 * Ref: p. 372, 405
 * 
 * Compilation: javac FrequencyCounterBST.java
 * Execution: java FrequencyCounterBST <int_min_length> < <std_input>
 *
 * $ java FrequencyCounterBST 1 < ~/algs4-data/tinyTale.txt
 * Total words: 60
 * Total words with at least 1 length: 60
 * Total distinct words: 20
 * Max: it 10
 *
 * $ java FrequencyCounterBST 8 < ~/algs4-data/tale.txt
 * Total words: 135643
 * Total words with at least 8 length: 14346
 * Total distinct words: 5126
 * Max: business 122
 *
 * $ java FrequencyCounterBST 10 < ~/algs4-data/leipzig1M.txt
 * Total words: 21191455
 * Total words with at least 10 length: 1610829
 * Total distinct words: 165555
 * Max: government 24763
 *
 * $ java FrequencyCounterBST 8 < ~/algs4-data/leipzig1M.txt
 * Total words: 21191455
 * Total words with at least 8 length: 4239597
 * Total distinct words: 299593
 * Max: government 24763
 */

/**
 * FrequencyCounterBST
 */
public class FrequencyCounterBST {
  public static void main(String[] args) throws Exception {
    if (args.length < 0) {
      throw new Error("You must provide <int_minumum_string_length>");
    }

    int minLen = Integer.parseInt(args[0]);
    BST<String, Integer> bst;
    bst = new BST<String, Integer>();
    int totalWords = 0;
    int wordsMinLength = 0;

    while (!StdIn.isEmpty()) {
      // get the word from standard input
      String word = StdIn.readString();

      totalWords++;

      // check if word has minum length
      if (word.length() < minLen)
        continue;

      // check if word is in the ST
      if (!bst.contains(word))
        bst.put(word, 1);
      else
        bst.put(word, bst.get(word) + 1);

      wordsMinLength++;
    }

    // find a key with the highest frequency count
    String max = "";

    bst.put(max, 0);

    for (String key : bst.keys()) {
      if (bst.get(key) > bst.get(max))
        max = key;
    }

    StdOut.println("Total words: " + totalWords);
    StdOut.println("Total words with at least " + minLen + " length: " + wordsMinLength);
    StdOut.println("Total distinct words: " + (bst.size() - 1)); // removes "" (empty key)
    StdOut.println("Max: " + max + " " + bst.get(max));
  }
}
