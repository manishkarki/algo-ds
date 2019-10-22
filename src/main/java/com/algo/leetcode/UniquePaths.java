package com.algo.leetcode;

/**
 * @author mkarki
 */
public class UniquePaths {
    /**
     * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
     * <p>
     * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right
     * corner of the grid.
     * <p>
     * How many possible unique paths are there?
     * <p>
     * <p>
     * Note: m and n will be at most 100.
     * <p>
     * Example 1:
     * <p>
     * Input: m = 3, n = 2
     * Output: 3
     * Explanation:
     * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
     * 1. Right -> Right -> Down
     * 2. Right -> Down -> Right
     * 3. Down -> Right -> Right
     * Example 2:
     * <p>
     * Input: m = 7, n = 3
     * Output: 28
     *
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
        if (m == 0 && n == 0) {
            return 0;
        }
        if (m == 0 || n == 0) {
            return 1;
        }
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        assert uniquePaths(6, 4) == 56;
        assert uniquePaths(3, 3) == 6;
    }
}
