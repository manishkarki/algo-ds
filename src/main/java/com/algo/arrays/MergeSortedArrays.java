package com.algo.arrays;

/**
 * Given two sorted integer arrays arr1 and arr2, merge arr2 into arr1 as one sorted array.
 * <p>
 * The number of elements initialized in arr1 and arr2 are m and n respectively. You may assume that arr1 has a size equal to m + n such that it has enough space to hold additional elements from arr2.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr1 = [1,2,3,0,0,0], m = 3, arr2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Example 2:
 * <p>
 * Input: arr1 = [1], m = 1, arr2 = [], n = 0
 * Output: [1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * arr1.length == m + n
 * arr2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= arr1[i], arr2[i] <= 109
 *
 * @author mkarki
 */
public class MergeSortedArrays {
    public static void mergeSortedArrays(int[] arr1, int m, int[] arr2, int n) {
        int len = m + n, index = 1, i = m - 1, j = n - 1;

        while (i >= 0 && j >= 0) {
            if (arr1[i] >= arr2[j]) {
                arr1[len - index] = arr1[i--];
            } else {
                arr1[len - index] = arr2[j--];
            }
            index++;
        }

        while (i >= 0) {
            arr1[len - index] = arr1[i--];
            index++;
        }

        while (j >= 0) {
            arr1[len - index] = arr2[j--];
            index++;
        }
    }
}
