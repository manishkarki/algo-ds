package com.algo.leetcode.thirtydaychallenge.april.fifteentotwentyone;

import java.util.stream.IntStream;

/**
 * @author mkarki
 */
public class ProductOfArrayExceptSelf {
    /**
     * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
     * <p>
     * Example:
     * <p>
     * Input:  [1,2,3,4]
     * Output: [24,12,8,6]
     * Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.
     * <p>
     * Note: Please solve it without division and in O(n).
     * <p>
     * Follow up:
     * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
     */
    public int[] getProductExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];

        ans[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            // ans[i - 1] already contains the product of elements to the left of 'i - 1'
            ans[i] = nums[i - 1] * ans[i - 1];
        }
        printArray(ans);
        int R = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] *= R;
            R *= nums[i];
        }

        return ans;
    }

    protected void printArray(int[] arr) {
        IntStream.range(0, arr.length)
                .forEach(i -> System.out.print(arr[i] + "\t"));
        System.out.println();
    }
}
