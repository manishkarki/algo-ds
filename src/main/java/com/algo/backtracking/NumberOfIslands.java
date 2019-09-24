package com.algo.backtracking;

/**
 * @author mkarki
 */
public class NumberOfIslands {

    /**
     * Given a boolean 2D matrix, find the number of islands. A group of connected 1s forms an island.
     * For example, the below matrix contains 5 islands
     *
     * Example:
     *
     * Input : mat[][] = {{1, 1, 0, 0, 0},
     *                    {0, 1, 0, 0, 1},
     *                    {1, 0, 0, 1, 1},
     *                    {0, 0, 0, 0, 0},
     *                    {1, 0, 1, 0, 1}
     * Output : 5
     * @param mat
     * @return
     */
    public int getNumberOfIslands(int[][] mat) {
        //if matrix doesn't exist
        if(mat == null) {
            return 0;
        }
        int row = mat.length;
        int col = mat[0].length;
        //this to hold the state if it has been encountered before or not
        boolean[][] visited = new boolean[row][col];

        int count = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                //if the cell hasn't been visited before but can be visited do the DFS on that
                if(mat[i][j] == 1 && !visited[i][j]) {
                    dfs(mat, i, j, visited);
                    //after DFS all the cells within the proximity has been visited and wouldn't count more than once
                    //so reference it as one island
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int[][] mat, int i, int j, boolean[][] visited) {
        //these are the possible axes from the given cell that can be visited
        int[] xAxes = {0, 0, 1, -1};
        int[] yAxes = {-1, 1, 0, 0};

        visited[i][j] = true;

        for(int k = 0; k < 4; k++) {
            if(isSafe(mat, i + xAxes[k], j + yAxes[k], visited)) {
                dfs(mat, i + xAxes[k], j + yAxes[k], visited);
            }
        }
    }

    private boolean isSafe(int[][] mat, int i, int j, boolean[][] visited) {
        //check if the cell is land
        return i >= 0 && i < mat.length && j >=0 && j < mat[i].length && mat[i][j] ==1 && !visited[i][j];
    }
}
