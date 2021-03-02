package com.algo.arrays;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author mkarki
 */
public class RotateArrayTest {

    @Test
    void testRotateArray() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        RotateArray.rotate(nums, 3);
        assertThat(nums, is(new int[]{5, 6, 7, 1, 2, 3, 4}));
    }
}
