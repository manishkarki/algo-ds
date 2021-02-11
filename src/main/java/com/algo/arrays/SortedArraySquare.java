package com.algo.arrays;

/**
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 * Example 2:
 * <p>
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in non-decreasing order.
 *
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
