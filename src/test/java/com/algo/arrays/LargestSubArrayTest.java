package com.algo.arrays;

import org.junit.jupiter.api.Test;

import static com.algo.arrays.LargestSubArray.getLargestSubArrayWithEqualAlphabetsAndNumbers;
import static com.algo.arrays.LargestSubArray.getLargestSubArrayWithEqualAlphabetsAndNumbersII;
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
        arr = new int[]{0, 0, 1, 1, 0};
        assertThat(LargestSubArray.getMaxLenWithEqualNumberOfZeroesAndOnes(arr), is(4));
    }

    @Test
    void testGetLargestSubArrayWithEqualAlphaAndNum() {
        int[] arr = {'A', 'B', 'X', 4, 6, 'X', 'a'};
        LargestSubArray.SubArrayResponse subArrayResponse = getLargestSubArrayWithEqualAlphabetsAndNumbers(arr);
        System.out.println(subArrayResponse);
        assertThat(subArrayResponse.indices, is(new int[]{1, 4}));
        assertThat(subArrayResponse.maxSize, is(4));
        arr = new int[]{1, 2, 'a', 'b', 'c', 1, 'n', 'c', 1, 2};
        subArrayResponse = getLargestSubArrayWithEqualAlphabetsAndNumbers(arr);
        System.out.println(subArrayResponse);
    }

    @Test
    void testGetLargestSubArrayWithEqualAlphaAndNumII() {
        int[] arr = {'A', 'B', 'X', 4, 6, 'X', 'a'};
        LargestSubArray.SubArrayResponse subArrayResponse = getLargestSubArrayWithEqualAlphabetsAndNumbersII(arr);
        System.out.println(subArrayResponse);
        assertThat(subArrayResponse.indices, is(new int[]{1, 4}));
        assertThat(subArrayResponse.maxSize, is(4));
        arr = new int[]{1, 2, 'a', 'b', 'c', 1, 'n', 'c', 1, 2, 'p', 'q', 2, 3};
        subArrayResponse = getLargestSubArrayWithEqualAlphabetsAndNumbersII(arr);
        System.out.println(subArrayResponse);
        assertThat(subArrayResponse.indices, is(new int[]{0, 13}));
        assertThat(subArrayResponse.maxSize, is(14));
    }

}