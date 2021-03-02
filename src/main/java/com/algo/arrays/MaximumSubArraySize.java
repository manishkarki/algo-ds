package com.algo.arrays;

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
}
