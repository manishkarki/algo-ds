package com.algo.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * Example 2:
 * <p>
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * Example 3:
 * <p>
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 *
 * @author mkarki
 */
public class ContainsDuplicate {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> numberIndices = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numberIndices.containsKey(nums[i]) && (i - numberIndices.get(nums[i])) <= k) {
                return true;
            }
            numberIndices.put(nums[i], i);
        }
        return false;
    }
}
