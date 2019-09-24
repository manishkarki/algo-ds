package com.algo.leetcode;

import org.junit.jupiter.api.Test;

import static com.algo.backtracking.RatMaze.countPaths;

/**
 * @author mkarki
 */
class RatMazeTest {

    @Test
    void testRatInAGivenMaze() {
        int maze[][] = {{0, 0, 0, 0},
                {0, -1, 0, 0},
                {-1, 0, 0, 0},
                {0, 0, 0, 0}};
        System.out.println(countPaths(maze));
    }

}