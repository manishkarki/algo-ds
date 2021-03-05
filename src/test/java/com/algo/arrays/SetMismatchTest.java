package com.algo.arrays;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author mkarki
 */
class SetMismatchTest {

    @Test
    void testFindErrorNums() {
        assertThat(SetMismatch.findErrorNums(new int[]{1, 2, 2, 4}), is(new int[]{2, 3}));
        assertThat(SetMismatch.findErrorNums(new int[]{1, 1}), is(new int[]{1, 2}));
    }
}