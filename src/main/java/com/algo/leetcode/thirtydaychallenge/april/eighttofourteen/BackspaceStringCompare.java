package com.algo.leetcode.thirtydaychallenge.april.eighttofourteen;

/**
 * This is the question 2 of April 8-14 of leetcode
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3291/
 *
 * @author mkarki
 */
public class BackspaceStringCompare {

    /**
     * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
     * <p>
     * Note that after backspacing an empty text, the text will continue empty.
     * <p>
     * Example 1:
     * <p>
     * Input: S = "ab#c", T = "ad#c"
     * Output: true
     * Explanation: Both S and T become "ac".
     * Example 2:
     * <p>
     * Input: S = "ab##", T = "c#d#"
     * Output: true
     * Explanation: Both S and T become "".
     * Example 3:
     * <p>
     * Input: S = "a##c", T = "#a#c"
     * Output: true
     * Explanation: Both S and T become "c".
     * Example 4:
     * <p>
     * Input: S = "a#c", T = "b"
     * Output: false
     * Explanation: S becomes "c" while T becomes "b".
     * Note:
     * <p>
     * 1 <= S.length <= 200
     * 1 <= T.length <= 200
     * S and T only contain lowercase letters and '#' characters.
     * Follow up:
     * <p>
     * Can you solve it in O(N) time and O(1) space?
     *
     * @param s
     * @param t
     * @return
     */
    public boolean backspaceCompare(String s, String t) {

    }
}
