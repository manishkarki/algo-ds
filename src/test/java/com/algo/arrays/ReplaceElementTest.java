package com.algo.arrays;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author mkarki
 */
class ReplaceElementTest {

    @Test
    void testReplaceElementsOnRight() {
        assertThat(ReplaceElement.replaceElements(new int[]{17, 18, 5, 4, 6, 1}), is(new int[]{18, 6, 6, 6, 1, -1}));
    }

}