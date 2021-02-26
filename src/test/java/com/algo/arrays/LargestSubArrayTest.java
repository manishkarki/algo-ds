package com.algo.arrays;

import org.junit.jupiter.api.Test;

/**
 * @author mkarki
 */
class LargestSubArrayTest {

    @Test
    void testMaxLenWithEqualZeroesAndOnes() {
        int arr[] = {1, 0, 0, 1, 0, 1, 1};
        LargestSubArray.getMaxLenWithEqualNumberOfZeroesAndOnes(arr);
    }

}