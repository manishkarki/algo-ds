package com.algo.arrays;

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * <p>
 * Follow up:
 * <p>
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 * <p>
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 2 * 104
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 *
 * @author mkarki
 */
public class RotateArray {

    /*
            rotate all elements k times
            time complexity O(n * k)
            space complexity O(1)
     */
    public static void rotateArray(int[] nums, int k) {
        int len = nums.length, previous, temp;
        k %= len;
        // [1,2,3,4,5,6,7], k = 3
        for (int i = 0; i < k; i++) {
            previous = nums[len - 1];
            for (int j = 0; j < len; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

    /*
        using extra array, we can solve this in O(n)
     */
    public static void rotateArrayII(int[] nums, int k) {
        int[] retArr = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            retArr[(i + k) % nums.length] = nums[i];
        }
        // now copy over the array to original
        for (int i = 0; i < nums.length; i++) {
            nums[i] = retArr[i];
        }
    }

    /*
        we can use an approach of reversing first all the numbers in the array,
         then k numbers and finally n - k numbers
     */
    public static void rotateArrayIII(int[] nums, int k) {
        k %= nums.length;
        reverseArray(nums, 0, nums.length - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, nums.length - 1);
    }

    private static void reverseArray(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
