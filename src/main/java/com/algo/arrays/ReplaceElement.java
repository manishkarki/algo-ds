package com.algo.arrays;

/**
 * Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.
 * <p>
 * After doing so, return the array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [17,18,5,4,6,1]
 * Output: [18,6,6,6,1,-1]
 * Explanation:
 * - index 0 --> the greatest element to the right of index 0 is index 1 (18).
 * - index 1 --> the greatest element to the right of index 1 is index 4 (6).
 * - index 2 --> the greatest element to the right of index 2 is index 4 (6).
 * - index 3 --> the greatest element to the right of index 3 is index 4 (6).
 * - index 4 --> the greatest element to the right of index 4 is index 5 (1).
 * - index 5 --> there are no elements to the right of index 5, so we put -1.
 * Example 2:
 * <p>
 * Input: arr = [400]
 * Output: [-1]
 * Explanation: There are no elements to the right of index 0.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr.length <= 104
 * 1 <= arr[i] <= 105
 *
 * @author mkarki
 */
public class ReplaceElement {

    public static int[] replaceElementsBruteForce(int[] arr) {
        int[] retArray = new int[arr.length];
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            int maxInRight = -1;
            for (int j = i + 1; j < arr.length; j++) {
                maxInRight = Math.max(maxInRight, arr[j]);
            }
            retArray[index++] = maxInRight;
        }

        return retArray;
    }

    public static int[] replaceElements(int[] arr) {
        int maxInRight = -1;

        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = maxInRight;
            maxInRight = Math.max(maxInRight, temp);
        }
        return arr;
    }
}
