package com.algo.leetcode.dec1to7;

import java.util.Arrays;

/**
 * Given two positive integers n and k.
 * <p>
 * A factor of an integer n is defined as an integer i where n % i == 0.
 * <p>
 * Consider a list of all factors of n sorted in ascending order, return the kth factor in this list or return -1 if n has less than k factors.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 12, k = 3
 * Output: 3
 * Explanation: Factors list is [1, 2, 3, 4, 6, 12], the 3rd factor is 3.
 * Example 2:
 * <p>
 * Input: n = 7, k = 2
 * Output: 7
 * Explanation: Factors list is [1, 7], the 2nd factor is 7.
 * Example 3:
 * <p>
 * Input: n = 4, k = 4
 * Output: -1
 * Explanation: Factors list is [1, 2, 4], there is only 3 factors. We should return -1.
 * Example 4:
 * <p>
 * Input: n = 1, k = 1
 * Output: 1
 * Explanation: Factors list is [1], the 1st factor is 1.
 * Example 5:
 * <p>
 * Input: n = 1000, k = 3
 * Output: 4
 * Explanation: Factors list is [1, 2, 4, 5, 8, 10, 20, 25, 40, 50, 100, 125, 200, 250, 500, 1000].
 *
 * @author mkarki
 */
public class KthFactorOfN {

    public int kthFactor(int n, int k) {
        // we don't need factors more than k
        int[] factors = new int[k];
        Arrays.fill(factors, -1);
        int index = 0;
        for (int i = 1; i <= n && index < k; i++) {
            if (n % i == 0) {
                factors[index++] = i;
            }
        }

        return factors[k - 1];
    }

}
