package com.algo.sorting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author mkarki
 */
class CountSmallerNumbersAfterSelfTest {
    private CountSmallerNumbersAfterSelf countSmallerNumbersAfterSelf;

    @Test
    void testCountSmaller() {
        countSmallerNumbersAfterSelf = new CountSmallerNumbersAfterSelf();
        assertThat(countSmallerNumbersAfterSelf.countSmaller(new int[]{5, 2, 6, 1}), is(Arrays.asList(2, 1, 1, 0)));
    }
}