package com.algo.leetcode.thirtydaychallenge;

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
}
