package com.algo.arrays;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author mkarki
 */
public class SubArraySumTest {

    @Test
    void testSubArraySum() {
        assertThat(SubArraySum.subarraySum(new int[]{1, 2, 3}, 3), is(2));
    }
}
