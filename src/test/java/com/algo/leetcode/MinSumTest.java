package com.algo.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author mkarki
 */
class MinSumTest {
    private MinSum minSum;

    @BeforeEach
    void init() {
        minSum = new MinSum();
    }

    @Test
    void testWhenGridIsNullMinSumThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> minSum.sum(null));
    }

    @Test
    void testWhenGridHasValidNumbers() {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        assertEquals(7, minSum.sum(grid));
    }

}