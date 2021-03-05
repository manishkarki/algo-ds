package com.algo.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * There is a special keyboard with all keys in a single row.
 * <p>
 * Given a string keyboard of length 26 indicating the layout of the keyboard (indexed from 0 to 25),
 * initially your finger is at index 0. To type a character, you have to move your finger to the index
 * of the desired character. The time taken to move your finger from index i to index j is |i - j|.
 * <p>
 * You want to type a string word. Write a function to calculate how much time it takes to type it with one finger.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: keyboard = "abcdefghijklmnopqrstuvwxyz", word = "cba"
 * Output: 4
 * Explanation: The index moves from 0 to 2 to write 'c' then to 1 to write 'b' then to 0 again to write 'a'.
 * Total time = 2 + 1 + 1 = 4.
 * Example 2:
 * <p>
 * Input: keyboard = "pqrstuvwxyzabcdefghijklmno", word = "leetcode"
 * Output: 73
 * <p>
 * <p>
 * Constraints:
 * <p>
 * keyboard.length == 26
 * keyboard contains each English lowercase letter exactly once in some order.
 * 1 <= word.length <= 10^4
 * word[i] is an English lowercase letter.
 *
 * @author mkarki
 */
public class SingleRowsKeyboard {

    public static int calculateTime(String keyboard, String word) {
        Map<Character, Integer> indexes = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            indexes.put(keyboard.charAt(i), i);
        }
        int time = 0, prevIndex = 0;
        for (char c : word.toCharArray()) {
            time += Math.abs(indexes.get(c) - prevIndex);
            prevIndex = indexes.get(c);
        }
        return time;
    }

    public static int missingNumber(int[] nums) {
        int sum = 0;
        int n = nums.length;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return n * (n + 1) / 2 - sum;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{0, 1, 3}));
        System.out.println(missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }

}
