package com.algo.arrays;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author mkarki
 */
class EquilibriumIndexTest {

    @Test
    void testGetEquilibriumIndex() {
        int arr[] = {-7, 1, 5, 2, -4, 3, 0};
        assertThat(EquilibriumIndex.getEquilibriumIndex(arr), is(3));
    }
}