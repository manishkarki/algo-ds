package com.algo.string;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author mkarki
 */
class MinDeletionsTest {
    private MinDeletions minDeletions;

    @BeforeEach
    void setup() {
        minDeletions = new MinDeletions();
    }

    @Test
    void minDeletions() {
        assertThat(minDeletions.minDeletions("aab"), is(0));
    }
}