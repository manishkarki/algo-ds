package com.algo.sorting;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author mkarki
 */
class NumberOfSwapsTest {
    private NumberOfSwaps numberOfSwaps;

    @Test
    void getNumberOfSwaps() {
        numberOfSwaps = new NumberOfSwaps();
        assertThat(numberOfSwaps.getNumberOfSwaps(new int[]{5, 4, 1, 2}), is(5));
    }
}