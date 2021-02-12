package com.algo.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author mkarki
 */
class DuplicateZeroesTest {

    @Test
    void testDuplicateZeroes() {
        int[] originalArr = {1, 0, 2, 3, 0, 4, 5, 0};
        DuplicateZeroes.duplicateZeros(originalArr);
        Arrays.stream(originalArr)
                .forEach(ele -> System.out.print(" " + ele));

        System.out.println();
    }

}