package com.algo.arrays;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author mkarki
 */
class PlusOneTest {

    @Test
    void testPlusOne() {
        int[] numbers = {1, 2, 9};
        assertThat(PlusOne.plusOne(numbers), is(new int[]{1, 3, 0}));
        numbers = new int[]{9, 9, 9, 9};
        assertThat(PlusOne.plusOne(numbers), is(new int[]{1, 0, 0, 0, 0}));
    }
}