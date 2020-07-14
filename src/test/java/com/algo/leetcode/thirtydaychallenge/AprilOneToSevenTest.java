package com.algo.leetcode.thirtydaychallenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}