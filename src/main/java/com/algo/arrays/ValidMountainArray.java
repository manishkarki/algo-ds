package com.algo.arrays;

/**
 * Given an array of integers arr, return true if and only if it is a valid mountain array.
 * <p>
 * Recall that arr is a mountain array if and only if:
 * <p>
 * arr.length >= 3
 * There exists some i with 0 < i < arr.length - 1 such that:
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [2,1]
 * Output: false
 * Example 2:
 * <p>
 * Input: arr = [3,5,5]
 * Output: false
 * Example 3:
 * <p>
 * Input: arr = [0,3,2,1]
 * Output: true
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr.length <= 104
 * 0 <= arr[i] <= 104
 *
 * @author mkarki
 */
public class ValidMountainArray {
    public static boolean validMountainArray(int[] arr) {
        int step = 0, len = arr.length;

        while (step + 1 < len && arr[step] < arr[step + 1]) {
            step++;
        }
        // make sure up to a certain point there's an increasing steps
        if (step == 0 || step == len - 1) {
            return false;
        }

        while (step + 1 < len && arr[step] > arr[step + 1]) {
            step++;
        }

        return step == len - 1;
    }
}
