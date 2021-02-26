package com.algo.arrays;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

/**
 * @author mkarki
 */
class DisappearedNumberTest {

    @Test
    void testGetDisappearedNumbers() {
        assertThat(DisappearedNumber.getDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}), containsInAnyOrder(5, 6));
    }

}