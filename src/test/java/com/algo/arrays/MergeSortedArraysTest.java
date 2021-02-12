package com.algo.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author mkarki
 */
class MergeSortedArraysTest {

    @Test
    void testMergeSortedArrays() {
        int[] arr1 = {1, 2, 3, 0, 0, 0};
        MergeSortedArrays.mergeSortedArrays(arr1, 3, new int[]{2, 5, 6}, 3);
        Arrays.stream(arr1)
                .forEach(elem -> System.out.print(" " + elem));
        System.out.println();
    }
}