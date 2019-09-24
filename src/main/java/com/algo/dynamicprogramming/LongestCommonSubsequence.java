package com.algo.dynamicprogramming;

import java.util.Arrays;

/**
 * @author mkarki
 */
public class LongestCommonSubsequence {

    /**
     * Given two sequences, find the length of longest subsequence present in both of them.
     * A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
     *
     * For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”
     * @param input1
     * @param input2
     * @return length of the maximum subsequence
     */
    public int getLongestSubsequence(String input1, String input2) {
        if(input1 == null || input2 == null || input1.length() == 0 || input2.length() == 0) {
            return 0;
        }

        int len1 = input1.length();
        int len2 = input2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];
        for(int i = 0 ; i < len2; i++) {
            dp[0][i] = 0;
        }
        for(int i = 0 ; i < len1; i++) {
            dp[i][0] = 0;
        }

        for(int i = 1; i < dp.length; i++) {
            char c1 = input1.charAt(i - 1);
            for(int j = 1; j < dp[i].length; j++) {
                if(c1 == input2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
