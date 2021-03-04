package com.algo.arrays;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author mkarki
 */
class SingleRowsKeyboardTest {

    @Test
    void testCalculateTime() {
        assertThat(SingleRowsKeyboard.calculateTime("abcdefghijklmnopqrstuvwxyz", "cba"), is(4));
        assertThat(SingleRowsKeyboard.calculateTime("pqrstuvwxyzabcdefghijklmno", "leetcode"),
                is(73));
    }
}