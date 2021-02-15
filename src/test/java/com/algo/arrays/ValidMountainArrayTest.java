package com.algo.arrays;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author mkarki
 */
class ValidMountainArrayTest {

    @Test
    void testIfValidMountainArray() {
        assertThat(ValidMountainArray.validMountainArray(new int[]{1, 2, 3, 4, 2, 1}), is(true));
        assertThat(ValidMountainArray.validMountainArray(new int[]{1, 2, 3, 4, 5, 6}), is(false));
    }

}