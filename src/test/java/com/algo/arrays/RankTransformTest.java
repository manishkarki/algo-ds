package com.algo.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author mkarki
 */
class RankTransformTest {
    private RankTransform rankTransform;

    @BeforeEach
    void setup() {
        rankTransform = new RankTransform();
    }

    @Test
    void arrayRankTransform() {
        int[] arr = {40, 10, 20, 30};

        assertThat(rankTransform.arrayRankTransform(arr), is(new int[]{4, 1, 2, 3}));
    }
}