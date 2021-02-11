package com.algo.arrays;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author mkarki
 */
class SortedArraySquareTest {

    @Test
    public void testSquareOfSortedArray() {
        assertThat(SortedArraySquare.sortedSquares(new int[]{-4, -1, 0, 3, 10}), is(new int[]{0, 1, 9, 16, 100}));
    }

}