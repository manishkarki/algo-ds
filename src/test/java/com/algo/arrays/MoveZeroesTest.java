package com.algo.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author mkarki
 */
public class MoveZeroesTest {

    @Test
    void testMoveZeroesToTheEnd() {
        int[] nums = {1, 0, 3, 4, 0, 5, 0, 0, 8, 9, 10};

        MoveZeroes.moveZeroes(nums);
        Arrays.stream(nums)
                .forEach(i -> System.out.print(" " + i));
    }

}
