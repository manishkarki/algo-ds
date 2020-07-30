package com.algo.leetcode.thirtydaychallenge.april.fifteentotwentyone;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author mkarki
 */
public class NumberOfIslandTest {
    private NumberOfIsland numberOfIsland;

    @BeforeEach
    void setup() {
        numberOfIsland = new NumberOfIsland();
    }

    @Test
    void testNumberOfIslandWithNullInput() {
        assertThat(numberOfIsland.getIslandsNum(null), is(0));
        assertThat(numberOfIsland.getIslandsNum(new char[][]{}), is(0));
        assertThat(numberOfIsland.getIslandsNum(new char[][]{null}), is(0));
    }

    @Test
    void testNumberOfIsland() {
        assertThat(numberOfIsland.getIslandsNum(new char[][]{new char[]{'1', '1', '1', '1', '0'},
                new char[]{'1', '1', '0', '1', '0'},
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'0', '0', '0', '0', '0'}}), is(1));
    }
}
