package com.algo.leetcode;

/**
 * @author mkarki
 */
public class MinSum {
    /**
     * Given a m x n grid filled with non-negative numbers,
     * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
     *
     * Note: You can only move either down or right at any point in time.
     *
     * Example:
     *
     * Input:
     * [
     *   [1,3,1],
     *   [1,5,1],
     *   [4,2,1]
     * ]
     * Output: 7
     * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
     * @param grid
     * @return
     */
    public int sum(int[][] grid) {
        //we'll check if we're on the first row or first column, we can only travel from one path,
        //so we just add that as the cost or sum in the path, else in other cases we just add current cell's
        //value from the minimum among top or left
        if(grid == null) {
            throw new IllegalArgumentException("grid can't be null");
        }
        if(grid.length == 0) {
            return 0;
        }

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0 ; j < grid[i].length; j++) {
                if(i != 0 && j ==0) {
                    grid[i][j] += grid[i - 1][j];
                }
                if(i == 0 && j != 0) {
                    grid[i][j] += grid[i][j - 1];
                }
                if(i != 0 && j != 0) {
                    grid[i][j] += Math.min(grid[i][j - 1], grid[i-1][j]);
                }
            }
        }
        return grid[grid.length -1][grid[0].length - 1];
    }
}
