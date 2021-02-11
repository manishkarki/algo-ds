package com.algo.arrays;

import org.junit.jupiter.api.Test;

import static com.algo.arrays.EvenDigits.getEvenNumberOfDigits;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author mkarki
 */
class EvenDigitsTest {

    @Test
    void testEvenNumbers() {
        assertThat(getEvenNumberOfDigits(new int[]{12, 345, 2, 6, 7896}), is(2));
        assertThat(getEvenNumberOfDigits(new int[]{555, 901, 482, 1771}), is(1));
    }

}