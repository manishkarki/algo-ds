package com.algo.leetcode.thirtydaychallenge;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mkarki
 */
public class AprilOneToSeven {
    /**
     * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
     * <p>
     * Note:
     * <p>
     * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
     * <p>
     * Example 1:
     * <p>
     * Input: [2,2,1]
     * Output: 1
     * Example 2:
     * <p>
     * Input: [4,1,2,1,2]
     * Output: 4
     */
    public int singleNumber(int[] nums) {
        //this is the classical use of xor logic, the one that's duplicated will cross out while leaving the one that
        //appears just once as a residue
        if (nums == null || nums.length <= 0) {
            return 0;
        }

        int ref = 0;
        for (int num : nums) {
            ref ^= num;
        }

        return ref;
    }

    /**
     * Write an algorithm to determine if a number n is "happy".
     * <p>
     * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
     * <p>
     * Return True if n is a happy number, and False if not.
     * <p>
     * Example:
     * <p>
     * Input: 19
     * Output: true
     * Explanation:
     * 12 + 92 = 82
     * 82 + 22 = 68
     * 62 + 82 = 100
     * 12 + 02 + 02 = 1
     */
    public boolean isHappy(int n) {
        Set<Integer> nums = new HashSet<>();

        while (true) {
            int result = 0;
            while (n > 0) {
                result += Math.pow(n % 10, 2);
                n /= 10;
            }

            if (!nums.add(result)) {
                return false;
            } else if (result == 1) {
                return true;
            } else {
                n = result;
            }
        }
    }

    /**
     * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
     * <p>
     * Example:
     * <p>
     * Input: [-2,1,-3,4,-1,2,1,-5,4],
     * Output: 6
     * Explanation: [4,-1,2,1] has the largest sum = 6.
     * Follow up:
     * <p>
     * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle
     */
    public int maxSubArraySum(int[] nums) {
        if (nums == null || nums.length <= 0) {
            throw new IllegalArgumentException("input cannot be null or empty, please provide a valid input");
        }
        int maxSubArraySum = nums[0], curSum = 0;

        for (int num : nums) {
            if (curSum < 0) {
                curSum = 0;
            }
            curSum += num;
            maxSubArraySum = Math.max(curSum, maxSubArraySum);
        }
        return maxSubArraySum;
    }

}
