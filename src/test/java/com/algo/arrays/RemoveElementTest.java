package com.algo.arrays;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author mkarki
 */
public class RemoveElementTest {

    @Test
    void testRemoveElement() {
        int[] origArr = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        assertThat(RemoveElement.removeElement(origArr, 2), is(5));
    }
}
