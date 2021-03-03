package com.algo.arrays;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author mkarki
 */
class MaximumSubArraySizeTest {

    @Test
    void testMaxSize() {
        int arr[] = {1, 2, 10, 4};
        int n = arr.length;
        int k = 14;
        assertThat(MaximumSubArraySize.maxSize(arr, n, k), is(2));
    }
}