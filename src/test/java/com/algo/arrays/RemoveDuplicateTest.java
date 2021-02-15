package com.algo.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author mkarki
 */
class RemoveDuplicateTest {

    @Test
    void testRemoveDuplicates() {
        int[] arr = {1, 1, 2};
        assertThat(RemoveDuplicate.removeDuplicates(arr), is(2));
        Arrays.stream(arr)
                .forEach(ele -> System.out.print(" " + ele));
        //since we don't care the element after the given len
        // we can only check the element until length
    }

}