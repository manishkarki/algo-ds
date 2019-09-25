package com.algo.string;

import java.util.Stack;

/**
 * @author mkarki
 */
public class Balloon {
    /**
     * Given a string text, you want to use the characters of text to form as many instances of the word "balloon"
     * as possible.
     *
     * You can use each character in text at most once. Return the maximum number of instances that can be formed.
     *
     *
     *
     * Example 1:
     *
     *
     *
     * Input: text = "nlaebolko"
     * Output: 1
     * Example 2:
     *
     *
     *
     * Input: text = "loonbalxballpoon"
     * Output: 2
     * Example 3:
     *
     * Input: text = "leetcode"
     * Output: 0
     *
     *
     * Constraints:
     *
     * 1 <= text.length <= 10^4
     * text consists of lower case English letters only.
     */
    public int maxNumberOfBalloons(String text) {
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
        int n = s.length();
        Stack<Integer> opened = new Stack<>();
        int[] pair = new int[n];
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '(')
                opened.push(i);
            if (s.charAt(i) == ')') {
                int j = opened.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0, d = 1; i < n; i += d) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                i = pair[i];
                d = -d;
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseParentheses("lee(ct)ode"));
        System.out.println(reverseParentheses("(u(love)i)"));
    }
}
