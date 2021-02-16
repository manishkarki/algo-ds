package com.algo.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * <p>
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * <p>
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 * <p>
 * Example:
 * <p>
 * Input:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * Output:
 * [5,6]
 *
 * @author mkarki
 */
public class DisappearedNumber {

    public static List<Integer> getDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length < 1) {
            return new ArrayList<>(0);
        }

        List<Integer> disappearedNumbers = new ArrayList<>();

        for (int num : nums) {
            int temp = Math.abs(num) - 1;
            if (nums[temp] > 0)
                nums[temp] = -nums[temp];
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                disappearedNumbers.add(i + 1);
            }
        }

        return disappearedNumbers;
    }
}
