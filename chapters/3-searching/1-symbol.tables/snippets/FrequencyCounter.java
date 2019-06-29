import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Type: Snippet
 * Description: A SequentialSearchST client that
 * counts the frequency of occurrence of the strings
 * in StdIn.
 * Ref: p. 372
 *
 * Compilation: javac FrequencyCounter.java
 * Execution: java FrequencyCounter <int_min_len> < <std_input>
 *
 * $ java FrequencyCounter 1 < ~/algs4-data/tinyTale.txt
 * Total words: 60
 * Total words with at least 1 length: 60
 * Total distinct words: 20
 * Max: of 10
 *
 * $ java FrequencyCounter 8 < ~/algs4-data/tale.txt
 * Total words: 135643
 * Total words with at least 8 length: 14346
 * Total distinct words: 5126
 * Max: business 122
 *
 * $ java FrequencyCounter 10 < ~/algs4-data/leipzig1M.txt
 * [takes like forever....]
 */

/**
 * FrequencyCounter
 */
public class FrequencyCounter {
  public static void main(String[] args) throws Exception {
    if (args.length < 0) {
      throw new Error("You must provide <int_minumum_string_length>");
    }

    int minLen = Integer.parseInt(args[0]);
    SequentialSearchST<String, Integer> st;
    st = new SequentialSearchST<String, Integer>();
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