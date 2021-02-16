package com.algo.arrays;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author mkarki
 */
class HeightCheckerTest {

    @Test
    void testHeightChecker() {
        assertThat(HeightChecker.heightChecker(new int[]{5, 1, 2, 3, 4}), is(5));
        assertThat(HeightChecker.heightChecker(new int[]{1, 2, 3, 4, 5}), is(0));
        assertThat(HeightChecker.heightChecker(new int[]{1, 1, 4, 2, 1, 3}), is(3));
    }
}