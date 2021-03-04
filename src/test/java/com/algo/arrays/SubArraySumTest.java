package com.algo.arrays;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author mkarki
 */
public class SubArraySumTest {

    @Test
    void testSubArraySum() {
        assertThat(SubArraySum.subarraySum(new int[]{1, 2, 3}, 3), is(2));
    }

    @Test
    void testSubArraySumII() {
        assertThat(SubArraySum.subArraySumII(new int[]{1, 2, 3}, 3), is(2));
        assertThat(SubArraySum.subArraySumII(new int[]{1, 1, 1}, 3), is(1));
        assertThat(SubArraySum.subArraySumII(new int[]{3, 2, 7, -1, 6}, 5), is(2));
    }

    @Test
    void testSubArraySumWithZero() {
        assertThat(SubArraySum.subArrayWithZeroSumExists(new int[]{1, 2, 3}), is(false));
        assertThat(SubArraySum.subArrayWithZeroSumExists(new int[]{0, 2, 3}), is(true));
        assertThat(SubArraySum.subArrayWithZeroSumExists(new int[]{-3, 2, 3, 1, 6}), is(false));
    }
}
