package com.algo.string;

import java.util.HashSet;
import java.util.Set;

/**
 * A string s is called good if there are no two different characters in s that have the same frequency.
 * <p>
 * Given a string s, return the minimum number of characters you need to delete to make s good.
 * <p>
 * The frequency of a character in a string is the number of times it appears in the string. For example, in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "aab"
 * Output: 0
 * Explanation: s is already good.
 * Example 2:
 * <p>
 * Input: s = "aaabbbcc"
 * Output: 2
 * Explanation: You can delete two 'b's resulting in the good string "aaabcc".
 * Another way it to delete one 'b' and one 'c' resulting in the good string "aaabbc".
 * Example 3:
 * <p>
 * Input: s = "ceabaacb"
 * Output: 2
 * Explanation: You can delete both 'c's resulting in the good string "eabaab".
 * Note that we only care about characters that are still in the string at the end (i.e. frequency of 0 is ignored).
 *
 * @author mkarki
 */
public class MinDeletions {

    public int minDeletions(String s) {
        int[] counts = new int[26];

        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }

        Set<Integer> ref = new HashSet<>();
        int minDeletions = 0;
        for (int i = 0; i < counts.length; i++) {
            while (counts[i] != 0 && ref.contains(counts[i])) {
                counts[i]--;
                minDeletions++;
            }
            ref.add(counts[i]);
        }
        return minDeletions;
    }
}
