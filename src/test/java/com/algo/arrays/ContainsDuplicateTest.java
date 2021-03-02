package com.algo.arrays;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author mkarki
 */
class ContainsDuplicateTest {

    @Test
    void containsNearbyDuplicate() {
        int[] nums = {1, 2, 3, 1};
        assertThat(ContainsDuplicate.containsNearbyDuplicate(nums, 3), is(true));
        nums = new int[]{1, 0, 1, 1};
        assertThat(ContainsDuplicate.containsNearbyDuplicate(nums, 1), is(true));
        nums = new int[]{1, 2, 3, 1, 2, 3};
        assertThat(ContainsDuplicate.containsNearbyDuplicate(nums, 2), is(false));
    }
}