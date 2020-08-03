package com.algo.leetcode.thirtydaychallenge.april.fifteentotwentyone;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author mkarki
 */
class MinPathSumTest {
    private MinPathSum minPathSum;

    @BeforeEach
    void setup() {
        minPathSum = new MinPathSum();
    }

    @Test
    void testMinPathSum() {
        int[][] grid = new int[][]{
                new int[]{1, 3, 1},
                new int[]{1, 5, 1},
                new int[]{4, 2, 1}
        };
        long startTime = System.currentTimeMillis();
        assertThat(minPathSum.minPathSum(grid), is(7));
        System.out.println("time taken by v1:" + (System.currentTimeMillis() - startTime));
    }

    @Test
    void testMinPathSumV2() {
        int[][] grid = new int[][]{
                new int[]{1, 3, 1},
                new int[]{1, 5, 1},
                new int[]{4, 2, 1}
        };
        long startTime = System.currentTimeMillis();
        assertThat(minPathSum.minPathSumV2(grid), is(7));
        System.out.println("time taken by v2:" + (System.currentTimeMillis() - startTime));
    }
}