package com.algo.string;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author mkarki
 */
class BalloonTest {

    @Test
    void testMaxNumberOfBalloons() {
        assertThat(Balloon.maxNumberOfBalloons("nlaebolko"), is(1));
        assertThat(Balloon.maxNumberOfBalloons("loonbalxballpoon"), is(2));
        assertThat(Balloon.maxNumberOfBalloons("leetcode"), is(0));
    }

    @Test
    void testReverseParentheses() {
        assertThat(Balloon.reverseParentheses("lee(ct)ode"), is("leetcode"));
    }
}