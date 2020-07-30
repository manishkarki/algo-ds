package com.algo.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author mkarki
 */
class SubArraySumTest {

    private SubArraySum subArraySum;

    @BeforeEach
    void setup() {
        subArraySum = new SubArraySum();
    }

    @Test
    void testGetSubArrayWithSumNullArray() {
        assertThrows(IllegalArgumentException.class,
                () -> subArraySum.getSubArrayWithSum(null, 23));
    }

    @Test
    void testGetSubArrayWithSumZero() {
        assertThat(subArraySum.getSubArrayWithSum(new int[]{15, 2, 4, 8, 9, 5, 10, 23}, 0), is(Arrays.asList()));
    }

    @Test
    void testGetSubArrayWithSum() {
        assertThat(subArraySum.getSubArrayWithSum(new int[]{15, 2, 4, 8, 9, 5, 10, 23}, 23), is(Arrays.asList(1, 4)));
    }
}