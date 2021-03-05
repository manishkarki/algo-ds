package com.algo.string;

import java.util.Stack;

/**
 * @author mkarki
 */
public class Balloon {
    /**
     * Given a string text, you want to use the characters of text to form as many instances of the word "balloon"
     * as possible.
     * <p>
     * You can use each character in text at most once. Return the maximum number of instances that can be formed.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * <p>
     * <p>
     * Input: text = "nlaebolko"
     * Output: 1
     * Example 2:
     * <p>
     * <p>
     * <p>
     * Input: text = "loonbalxballpoon"
     * Output: 2
     * Example 3:
     * <p>
     * Input: text = "leetcode"
     * Output: 0
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= text.length <= 10^4
     * text consists of lower case English letters only.
     */
    public static int maxNumberOfBalloons(String text) {
        int[] chars = new int[26]; //count all letters
        for (char c : text.toCharArray()) {
            chars[c - 'a']++;
        }
        //check counts for b, a, l,l,o,o,n
        int min = chars[1];
        min = Math.min(min, chars[0]);
        //l needs two occurrences so we can just check the half count, similar with o
        min = Math.min(min, chars[11] / 2);
        min = Math.min(min, chars[14] / 2);
        min = Math.min(min, chars[13]);

        return min;
    }

    public static String reverseParentheses(String s) {
        Stack<String> stack = new Stack();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            // when '(' is found, push string upto now, instantiate the builder again
            if (c == '(') {
                stack.push(sb.toString());
                sb = new StringBuilder();
            } else if (c == ')') {
                sb = sb.reverse();
                sb.insert(0, stack.pop());
            } else {
                sb.append(c);
            }
        }

        return sb.toString();

    }

    /*
        helper to reverse a char array in-space
     */
    private static void reverseString(char[] chars) {
        int i = 0, j = chars.length - 1;

        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
    }

}
