package com.algo.leetcode.thirtydaychallenge.april.fifteentotwentyone;

/**
 * this question is available here
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3302/
 *
 * @author mkarki
 */
public class NumberOfIsland {

    /**
     * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: grid = [
     * ["1","1","1","1","0"],
     * ["1","1","0","1","0"],
     * ["1","1","0","0","0"],
     * ["0","0","0","0","0"]
     * ]
     * Output: 1
     * Example 2:
     * <p>
     * Input: grid = [
     * ["1","1","0","0","0"],
     * ["1","1","0","0","0"],
     * ["0","0","1","0","0"],
     * ["0","0","0","1","1"]
     * ]
     * Output: 3
     */
    public int getIslandsNum(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int islandCount = 0;
        int row = grid.length, col = grid[0] != null ? grid[0].length : 0;
        int[][] visited = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // if the island can be visited but hasn't been visited yet, do the visit in depth(DFS)
                if (grid[i][j] == '1' && visited[i][j] != 1) {
                    dfs(grid, i, j, visited);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    private void dfs(char[][] grid, int i, int j, int[][] visited) {
        int[] xAxes = {0, 0, 1, -1};
        int[] yAxes = {-1, 1, 0, 0};

        visited[i][j] = 1;
        for (int k = 0; k < 4; k++) {
            //traverse to all the traversable index and make sure we follow to the depth to count it as a single one
            if (isSafe(grid, i + xAxes[k], j + yAxes[k], visited)) {
                dfs(grid, i + xAxes[k], j + yAxes[k], visited);
            }
        }
    }

    private boolean isSafe(char[][] grid, int i, int j, int[][] visited) {
        //check if the cell is land
        return i >= 0 && i < grid.length && j >= 0 && j < grid[i].length && grid[i][j] == '1' && visited[i][j] != 1;
    }
}
