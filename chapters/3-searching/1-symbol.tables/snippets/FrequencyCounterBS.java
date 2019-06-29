import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Type: Snippet
 * Description: A BinarySearchST client that
 * counts the frequency of occurrence of the strings
 * in StdIn.
 * Ref: p. 372
 * 
 * Compilation: javac FrequencyCounterBS.java
 * Execution: java FrequencyCounterBS <int_min_length> < <std_input>
 *
 * $ java FrequencyCounterBS 1 < ~/algs4-data/tinyTale.txt
 * Total words: 60
 * Total words with at least 1 length: 60
 * Total distinct words: 20
 * Max: it 10
 *
 * $ java FrequencyCounterBS 8 < ~/algs4-data/tale.txt
 * Total words: 135643
 * Total words with at least 8 length: 14346
 * Total distinct words: 5126
 * Max: business 122
 *
 * $ java FrequencyCounterBS 10 < ~/algs4-data/leipzig1M.txt
 * Total words: 21191455
 * Total words with at least 10 length: 1610829
 * Total distinct words: 165555
 * Max: government 24763
 *
 * $ java FrequencyCounterBS 8 < ~/algs4-data/leipzig1M.txt
 * Total words: 21191455
 * Total words with at least 8 length: 4239597
 * Total distinct words: 299593
 * Max: government 24763
 */

/**
 * FrequencyCounterBS
 */
public class FrequencyCounterBS {
  public static void main(String[] args) throws Exception {
    if (args.length < 0) {
      throw new Error("You must provide <int_minumum_string_length>");
    }

    int minLen = Integer.parseInt(args[0]);
    BinarySearchST<String, Integer> st;
    st = new BinarySearchST<String, Integer>();
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
      if (!st.contains(word))
        st.put(word, 1);
      else
        st.put(word, st.get(word) + 1);

      wordsMinLength++;
    }

    // find a key with the highest frequency count
    String max = "";

    st.put(max, 0);

    for (String key : st.keys()) {
      if (st.get(key) > st.get(max))
        max = key;
    }

    StdOut.println("Total words: " + totalWords);
    StdOut.println("Total words with at least " + minLen + " length: " + wordsMinLength);
    StdOut.println("Total distinct words: " + (st.size() - 1)); // removes "" (empty key)
    StdOut.println("Max: " + max + " " + st.get(max));
  }
}