package com.algo.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @author mkarki
 */
public class SubArraySum {

    /**
     * Given an unsorted array of integers, find a subarray which adds to a given number. If there are more than one subarrays with the sum as the given number, print any of them.
     * <p>
     * Examples:
     * <p>
     * Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
     * Output: [2, 4]
     * Explanation: Sum of elements between indices
     * 2 and 4 is 20 + 3 + 10 = 33
     * <p>
     * Input: arr[] = {10, 2, -2, -20, 10}, sum = -10
     * Output: Sum found between indexes 0 to 3
     * Explanation: Sum of elements between indices
     * 0 and 3 is 10 + 2 - 2 - 20 = -10
     * <p>
     * Input: arr[] = {-10, 0, 2, -2, -20, 10}, sum = 20
     * Output: []
     * Explanation: There is no subarray with the given sum
     */
    public List<Integer> getSubArrayWithSum(int[] arr, int sum) {
        if (arr == null) {
            throw new IllegalArgumentException("input arr can't be null");
        }

        int curr_sum = arr[0], start = 0, len = arr.length;
        for (int i = 1; i <= len; i++) {
            while (curr_sum > sum && start < (i - 1)) {
                curr_sum -= arr[start++];
            }

            if (curr_sum == sum) {
                return Arrays.asList(start, i - 1);
            }

            if (i < len) {
                curr_sum += arr[i];
            }
        }

        return Arrays.asList();
    }
}
