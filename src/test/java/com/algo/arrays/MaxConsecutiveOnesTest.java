package com.algo.arrays;

import org.junit.jupiter.api.Test;

import static com.algo.arrays.MaxConsecutiveOnes.getMaxConsecutiveOnes;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author mkarki
 */
public class MaxConsecutiveOnesTest {


    @Test
    public void testMaxConsecutiveOnes() {
        assertThat(getMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}), is(3));
    }
}
