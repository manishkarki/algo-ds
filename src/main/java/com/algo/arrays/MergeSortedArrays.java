package com.algo.arrays;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * The number of elements initialized in nums1 and nums2 are m and n respectively. You may assume that nums1 has a size equal to m + n such that it has enough space to hold additional elements from nums2.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Example 2:
 * <p>
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * Output: [1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[i] <= 109
 *
 * @author mkarki
 */
public class MergeSortedArrays {
    public static void mergeSortedArrays(int[] arr1, int m, int[] arr2, int n) {
        int len = m + n - 1, index = 1, i = m - 1, j = n - 1;

        while (i >= 0 && j >= 0) {
            if (arr1[i] >= arr2[j]) {
                arr1[len - index] = arr1[i--];
            } else {
                arr2[len - index] = arr2[j--];
            }
            index++;
        }

        while (i >= 0) {
            arr1[len - index] = arr1[i--];
            index++;
        }

        while (j >= 0) {
            arr2[len - index] = arr2[j--];
            index++;
        }
    }
}
