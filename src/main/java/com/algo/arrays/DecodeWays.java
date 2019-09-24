package com.algo.arrays;

/**
 * @author mkarki
 */
public class DecodeWays {

    /**
     * A message containing letters from A-Z is being encoded to numbers using the following mapping:
     * 'A' -> 1
     * 'B' -> 2
     * ...
     * 'Z' -> 26
     * Given an encoded message containing digits, determine the total number of ways to decode it.
     * For example,
     * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
     * The number of ways decoding "12" is 2
     * @param s
     * @return
     */
    public int numberOfWaysToDecodeDP(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        int len = s.length();
        int [] dp = new int[len + 1];
        dp[1] = s.charAt(0) != 0 ? 1 : 0;
        dp[0] = 1;

        for(int i = 2; i <= len; i++) {
            int oneChar = Integer.valueOf(s.substring(i-1, i));
            int twoChar = Integer.valueOf(s.substring(i-2, i));

            if(oneChar >= 1 && oneChar <=9) {
                dp[i] += dp[i-1];
            }

            if(twoChar >= 10 && twoChar <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        for(int i = 0; i < dp.length; i++) {
            System.out.print(dp[i]+" ");
        }
        System.out.println();
        return dp[len];
    }

    public int waysToDecode(String s) {
        int first = 1, second = s.charAt(0) == '*' ? 9 : s.charAt(0) == '0' ? 0 : 1;

        for(int i = 2; i <= s.length(); i++) {
            int temp = second;
            int firstChar = Integer.valueOf(s.substring(i-1, i));
            int secondChar = Integer.valueOf(s.substring(i-2, i));

            if(firstChar >= 1 && firstChar <=9) {
                second = second + first;
            }

            if(secondChar >= 10 && secondChar <= 26) {
                second = first + second;
            }
            first = temp;
        }
        return second;
    }
}
