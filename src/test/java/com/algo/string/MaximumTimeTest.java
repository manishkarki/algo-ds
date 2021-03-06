package com.algo.string;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author mkarki
 */
class MaximumTimeTest {
    private MaximumTime maximumTime;

    @Test
    void testMaximumTime() {
        maximumTime = new MaximumTime();
        assertThat(maximumTime.maximumTime("2?:?0"), is("23:50"));
        assertThat(maximumTime.maximumTime("0?:3?"), is("09:39"));
        assertThat(maximumTime.maximumTime("2?:??"), is("23:59"));
    }
}