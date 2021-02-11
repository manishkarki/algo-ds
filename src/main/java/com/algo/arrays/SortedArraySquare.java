package com.algo.arrays;

/**
 * @author mkarki
 */
public class SortedArraySquare {

    public static int[] sortedSquares(int[] nums) {
        int start = 0, len = nums.length, end = len - 1, index = len - 1;
        int[] retArray = new int[len];
        while (start <= end) {
            if (Math.abs(nums[start]) >= Math.abs(nums[end])) {
                retArray[index--] = nums[start] * nums[start];
                start++;
            } else {
                retArray[index--] = nums[end] * nums[end];
                end--;
            }
        }
        return retArray;
    }
}
