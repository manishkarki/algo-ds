package com.algo.leetcode.thirtydaychallenge.april;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author mkarki
 */
class AprilOneToSevenTest {
    private AprilOneToSeven aprilOneToSeven;

    @BeforeEach
    void setup() {
        aprilOneToSeven = new AprilOneToSeven();
    }

    @Test
    public void testSingleNumberWithCorrectInput() {
        assertEquals(3, aprilOneToSeven.singleNumber(new int[]{2, 4, 7, 9, 6, 6, 3, 4, 2, 7, 9}));
    }

    @Test
    public void testSingleNumberWithNull() {
        assertEquals(0, aprilOneToSeven.singleNumber(null));
    }

    @Test
    public void testIsHappy() {
        assertEquals(true, aprilOneToSeven.isHappy(19));
    }

    @Test
    public void testIsHappyNegative() {
        assertEquals(false, aprilOneToSeven.isHappy(0));
    }

    @Test
    public void testMaxSubArraySumWithNullArray() {
        Throwable throwable = assertThrows(IllegalArgumentException.class, () -> aprilOneToSeven.maxSubArraySum(null));
        assertEquals("input cannot be null or empty, please provide a valid input", throwable.getMessage());
    }

    @Test
    public void testMaxSubArraySum() {
        assertEquals(6, aprilOneToSeven.maxSubArraySum(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    @Test
    public void testMoveZeroesToTheEnd() {
        int[] actualArr = new int[]{1, 3, 0, 5, 8, 0, 10, 12};
        int[] actualCopy = actualArr.clone();
        aprilOneToSeven.moveZeroesToTheEnd(actualArr);
        assertThat(actualArr, not(equalTo(actualCopy)));
    }

    @Test
    public void testMaxProfit() {
        int[] costs = new int[]{7, 1, 5, 3, 6, 4};
        assertThat(aprilOneToSeven.maxProfit(costs), is(equalTo(7)));
    }
}