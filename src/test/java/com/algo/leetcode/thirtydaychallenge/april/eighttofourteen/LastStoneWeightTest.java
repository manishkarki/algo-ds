package com.algo.leetcode.thirtydaychallenge.april.eighttofourteen;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author mkarki
 */
class LastStoneWeightTest {

    private LastStoneWeight lastStoneWeight;

    @BeforeEach
    void setup() {
        lastStoneWeight = new LastStoneWeight();
    }

    @Test
    void testLastStoneWeightWhenNullWeights() {
        assertThat(lastStoneWeight.lastStoneWeight(null), is(0));
    }

    @Test
    void testLastStoneWeight() {
        int[] stones = new int[]{2, 7, 4, 1, 8, 1};

        assertThat(lastStoneWeight.lastStoneWeight(stones), is(1));
    }

}