package com.algo.leetcode.thirtydaychallenge.april.fifteentotwentyone;

/**
 * @author mkarki
 */
public class RotatedArraySearch {
    /**
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
     * <p>
     * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
     * <p>
     * You are given a target value to search. If found in the array return its index, otherwise return -1.
     * <p>
     * You may assume no duplicate exists in the array.
     * <p>
     * Your algorithm's runtime complexity must be in the order of O(log n).
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [4,5,6,7,0,1,2], target = 0
     * Output: 4
     * Example 2:
     * <p>
     * Input: nums = [4,5,6,7,0,1,2], target = 3
     * Output: -1
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int low, int high, int target) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;

        if (nums[mid] == target) {
            return mid;
        }

        // if first subArray is sorted
        if (nums[low] <= nums[mid]) {
            if (target >= nums[low] && target <= nums[mid]) {
                return search(nums, low, mid - 1, target);
            }
            return search(nums, mid + 1, high, target);
        }

        // if first subArray(nums[low..mid] is not sorted then nums[mid+1...high] must be sorted
        if (target >= nums[mid] && target <= nums[high]) {
            return search(nums, mid + 1, high, target);
        }

        return search(nums, low, mid - 1, target);
    }
}
