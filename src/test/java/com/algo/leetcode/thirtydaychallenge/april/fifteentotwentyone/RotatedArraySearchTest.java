package com.algo.leetcode.thirtydaychallenge.april.fifteentotwentyone;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author mkarki
 */
class RotatedArraySearchTest {
    private RotatedArraySearch rotatedArraySearch;

    @BeforeEach
    void setup() {
        rotatedArraySearch = new RotatedArraySearch();
    }

    @Test
    void testSearch() {
        assertThat(rotatedArraySearch.search(new int[]{5, 6, 7, 1, 2, 3, 4}, 3), is(5));
        assertThat(rotatedArraySearch.search(new int[]{5, 6, 7, 1, 2, 3, 4}, 4), is(6));
        assertThat(rotatedArraySearch.search(new int[]{5, 6, 7, 1, 2, 3, 4}, 5), is(0));
    }
}