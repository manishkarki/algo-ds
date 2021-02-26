package com.algo.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * Example 2:
 * <p>
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 *
 * @author mkarki
 */
public class SubArraySum {
    public static int subarraySum(int[] nums, int k) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];

                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int subArraySumII(int[] nums, int k) {
        int count = 0, sum = 0;
        Map<Integer, Integer> sumCount = new HashMap<>();
        sumCount.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sumCount.containsKey(sum - k)) {
                count += sumCount.get(sum - k);
            }
            sumCount.put(sum, sumCount.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    /**
     * Given an array of positive and negative numbers, find if there is a subarray (of size at-least one) with 0 sum.
     * <p>
     * Examples :
     * <p>
     * Input: {4, 2, -3, 1, 6}
     * Output: true
     * Explanation:
     * There is a subarray with zero sum from index 1 to 3.
     * <p>
     * Input: {4, 2, 0, 1, 6}
     * Output: true
     * Explanation:
     * There is a subarray with zero sum from index 2 to 2.
     * <p>
     * Input: {-3, 2, 3, 1, 6}
     * Output: false
     */
    public static boolean subArrayWithZeroSumExists(int[] arr) {
        int sum = 0;
        Set<Integer> sums = new HashSet<>();

        for (int num : arr) {
            sum += num;

            if (sum == 0 || num == 0 || sums.contains(sum)) {
                return true;
            }

            sums.add(sum);
        }

        return false;
    }
}
