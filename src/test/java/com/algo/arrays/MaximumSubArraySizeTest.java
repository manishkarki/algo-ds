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
        assertThat(MaximumSubArraySize.maxSize(arr, arr.length, 14), is(2));
    }

    @Test
    void testSubArrayMaxSize() {
        int[] arr = {1, 2, 13, 4};
        // since there's a single element with value greater than k, subarray can't have sum < k, this should return 0
        assertThat(MaximumSubArraySize.subArrayMaxSize(arr, arr.length, 8), is(0));

        arr = new int[]{1, 2, 3, 4};
//        assertThat(MaximumSubArraySize.subArrayMaxSize(arr, arr.length, 8), is(2));
    }
}