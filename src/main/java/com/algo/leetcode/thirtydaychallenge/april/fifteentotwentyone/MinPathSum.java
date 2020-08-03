package com.algo.leetcode.thirtydaychallenge.april.fifteentotwentyone;

/**
 * @author mkarki
 */
public class MinPathSum {
    /**
     * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
     * <p>
     * Note: You can only move either down or right at any point in time.
     * <p>
     * Example:
     * <p>
     * Input:
     * [
     * [1,3,1],
     * [1,5,1],
     * [4,2,1]
     * ]
     * Output: 7
     * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        return minPathSum(grid, grid.length - 1, grid[0].length - 1);
    }

    private int minPathSum(int[][] grid, int m, int n) {
        if (m < 0 || n < 0) {
            return Integer.MAX_VALUE;
        } else if (m == 0 && n == 0) {
            return grid[m][n];
        } else {
            return grid[m][n] + Math.min(minPathSum(grid, m - 1, n), minPathSum(grid, m, n - 1));
        }
    }

    //we can clearly see there are overlapping solutions here which can be avoided using dp
    public int minPathSumV2(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        return minPathSumV2(grid, grid.length - 1, grid[0].length - 1);
    }

    private int minPathSumV2(int[][] grid, int m, int n) {
        int[][] minPathSum = new int[m + 1][n + 1];
        minPathSum[0][0] = grid[0][0];

        for (int i = 1; i <= m; i++) {
            minPathSum[i][0] = minPathSum[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j <= n; j++) {
            minPathSum[0][j] = minPathSum[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                minPathSum[i][j] = grid[i][j] + Math.min(minPathSum[i - 1][j], minPathSum[i][j - 1]);
            }
        }
        return minPathSum[m][n];
    }
}
