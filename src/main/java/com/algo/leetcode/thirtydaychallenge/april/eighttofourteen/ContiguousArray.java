package com.algo.leetcode.thirtydaychallenge.april.eighttofourteen;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mkarki
 */
public class ContiguousArray {

    /**
     * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
     * <p>
     * Example 1:
     * Input: [0,1]
     * Output: 2
     * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
     * Example 2:
     * Input: [0,1,0]
     * Output: 2
     * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
     * Note: The length of the given binary array will not exceed 50,000.
     *
     * @param nums
     * @return
     */
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> countIndexes = new HashMap<>();
        int maxlen = 0, sum = 0;
        // if sum = x at position i and has already been encountered say at position j,
        //      it means subArray (i, j] has equal number of 0s and 1s i.e maxLen = i - indexThat has the same sum
        // sum == 0 means, from beginning of an array until this point, equal number of 0s and 1s were found
        for (int i = 0; i < nums.length; i++) {
            sum = sum + (nums[i] == 1 ? 1 : -1);
            if (sum == 0) {
                maxlen = i + 1;
            }
            if (countIndexes.containsKey(sum)) {
                maxlen = Math.max(maxlen, i - countIndexes.get(sum));
            } else {
                countIndexes.put(sum, i);
            }
        }
        return maxlen;
    }
}


