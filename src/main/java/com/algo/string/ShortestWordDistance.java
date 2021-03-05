package com.algo.string;

/**
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 * <p>
 * Example:
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * <p>
 * Input: word1 = “coding”, word2 = “practice”
 * Output: 3
 * Input: word1 = "makes", word2 = "coding"
 * Output: 1
 *
 * @author mkarki
 */
public class ShortestWordDistance {

    public static int shortestDistance(String[] words, String word1, String word2) {
        int index1 = -1, index2 = -1, ans = words.length;

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word1.equals(word)) {
                index1 = i;
            } else if (word2.equals(word)) {
                index2 = i;
            }

            if (index1 != -1 && index2 != -1) {
                ans = Math.min(ans, Math.abs(index1 - index2));
            }
        }
        return ans;
    }

}
