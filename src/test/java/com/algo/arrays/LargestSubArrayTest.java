package com.algo.arrays;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author mkarki
 */
class LargestSubArrayTest {

    @Test
    void testMaxLenWithEqualZeroesAndOnes() {
        int arr[] = {1, 0, 0, 1, 0, 1, 1};
        assertThat(LargestSubArray.getMaxLenWithEqualNumberOfZeroesAndOnes(arr), is(6));
        arr = new int[]{1, 1, 1, 1};
        assertThat(LargestSubArray.getMaxLenWithEqualNumberOfZeroesAndOnes(arr), is(0));
    }

}