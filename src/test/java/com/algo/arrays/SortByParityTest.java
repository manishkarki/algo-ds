package com.algo.arrays;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author mkarki
 */
class SortByParityTest {

    @Test
    void testSortByParity() {
        int[] originalArr = {3, 1, 2, 4};
        int[] expectedArr = {4, 2, 1, 3};
        assertThat(SortByParity.sortArrayByParity(originalArr), is(expectedArr));
    }

}