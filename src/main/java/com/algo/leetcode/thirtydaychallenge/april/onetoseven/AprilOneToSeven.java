package com.algo.leetcode.thirtydaychallenge.april.onetoseven;

import java.util.*;

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

    /**
     * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     * <p>
     * Example:
     * <p>
     * Input: [0,1,0,3,12]
     * Output: [1,3,12,0,0]
     * Note:
     * <p>
     * You must do this in-place without making a copy of the array.
     * Minimize the total number of operations.
     */
    public void moveZeroesToTheEnd(int[] nums) {
        if (nums == null || nums.length <= 0) {
            System.out.println("there's nothing to do, exiting");
            return;
        }

        int countNonZero = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[countNonZero++] = num;
            }
        }

        while (countNonZero < nums.length) {
            nums[countNonZero++] = 0;
        }
    }

    /**
     * Say you have an array of prices for which the ith element is the price of a given stock on day i.
     * <p>
     * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
     * <p>
     * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
     * <p>
     * Example 1:
     * <p>
     * Input: [7,1,5,3,6,4]
     * Output: 7
     * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
     * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
     * Example 2:
     * <p>
     * Input: [1,2,3,4,5]
     * Output: 4
     * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
     * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
     * engaging multiple transactions at the same time. You must sell before buying again.
     * Example 3:
     * <p>
     * Input: [7,6,4,3,1]
     * Output: 0
     * Explanation: In this case, no transaction is done, i.e. max profit = 0.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= prices.length <= 3 * 10 ^ 4
     * 0 <= prices[i] <= 10 ^ 4
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

    /**
     * Given an array of strings, group anagrams together.
     * <p>
     * Example:
     * <p>
     * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
     * Output:
     * [
     * ["ate","eat","tea"],
     * ["nat","tan"],
     * ["bat"]
     * ]
     * Note:
     * <p>
     * All inputs will be in lowercase.
     * The order of your output does not matter.
     */
    public List<List<String>> groupAnagrams(String[] args) {
        if (args == null || args.length <= 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> anagrams = new HashMap<>();
        int[] charCount = new int[26];
        for (String arg : args) {
            for (char c : arg.toCharArray()) {
                charCount[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append(charCount[i]);
            }
            String key = sb.toString();
            if (!anagrams.containsKey(key)) {
                anagrams.put(key, new ArrayList<>());
            }
            anagrams.get(key).add(arg);
            Arrays.fill(charCount, 0);
        }
        return new LinkedList<>(anagrams.values());
    }


}
