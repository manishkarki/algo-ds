package com.algo.arrays;

import java.util.Arrays;

/**
 * Given an array of n positive integers and a positive integer k, the task is to find the maximum subarray size such
 * that all subarrays of that size have sum of elements less than or equals to k.
 * <p>
 * Examples :
 * <p>
 * Input :  arr[] = {1, 2, 3, 4} and k = 8.
 * Output : 2
 * Sum of subarrays of size 1: 1, 2, 3, 4.
 * Sum of subarrays of size 2: 3, 5, 7.
 * Sum of subarrays of size 3: 6, 9.
 * Sum of subarrays of size 4: 10.
 * So, maximum subarray size such that all subarrays
 * of that size have the sum of elements less than 8 is 2.
 * <p>
 * Input :  arr[] = {1, 2, 10, 4} and k = 8.
 * Output : -1
 * There is an array element with value greater than k,
 * so subarray sum cannot be less than k.
 * <p>
 * Input :  arr[] = {1, 2, 10, 4} and K = 14
 * Output : 2
 *
 * @author mkarki
 */
public class MaximumSubArraySize {
    static int binarySearch(int prefixSum[], int n, int k) {
        // Initialize result
        int ans = -1;

        // Do Binary Search for largest
        // subarray size
        int left = 1, right = n;
        while (left <= right) {
            int mid = (left + right) / 2;

            // Check for all subarrays after mid
            int i;
            for (i = mid; i <= n; i++) {

                // Checking if all the subarrays
                // of a size is less than k.
                if (prefixSum[i] - prefixSum[i - mid] > k)
                    break;
            }

            // All subarrays of size mid have
            // sum less than or equal to k
            if (i == n + 1) {
                left = mid + 1;
                ans = mid;
            } else {
                // We found a subrray of size mid
                // with sum greater than k
                right = mid - 1;
            }
        }

        return ans;
    }

    // Return the maximum subarray size, such
    // that all subarray of that size have
    // sum less than K.
    static int maxSize(int arr[], int n, int k) {

        // Initialize prefix sum array as 0.
        int prefixsum[] = new int[n + 1];
        Arrays.fill(prefixsum, 0);

        // Finding prefix sum of the array.
        for (int i = 0; i < n; i++)
            prefixsum[i + 1] = prefixsum[i] + arr[i];

        return binarySearch(prefixsum, n, k);
    }

}
