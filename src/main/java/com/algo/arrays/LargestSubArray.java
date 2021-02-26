package com.algo.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array containing only 0s and 1s, find the largest subarray which contains equal no of 0s and 1s. The expected time complexity is O(n).
 * Examples:
 * <p>
 * Input: arr[] = {1, 0, 1, 1, 1, 0, 0}
 * Output: 1 to 6
 * (Starting and Ending indexes of output subarray)
 * <p>
 * Input: arr[] = {1, 1, 1, 1}
 * Output: No such subarray
 * <p>
 * Input: arr[] = {0, 0, 1, 1, 0}
 * Output: 0 to 3 Or 1 to 4
 *
 * @author mkarki
 */
public class LargestSubArray {

    public static int getMaxLenWithEqualNumberOfZeroesAndOnes(int[] arr) {
        // if o is found , put -1 else 1
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] == 0) ? -1 : 1;
        }
        int sum = 0, maxLength = Integer.MIN_VALUE, endIndex = -1;
        Map<Integer, Integer> sumIndexes = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // To handle sum=0 at last index
            if (sum == 0) {
                maxLength = i + 1;
                endIndex = i;
            }

            // If this sum is seen before,
            // then update max_len if required
            if (sumIndexes.containsKey(sum)) {
                if (maxLength < i - sumIndexes.get(sum)) {
                    maxLength = i - sumIndexes.get(sum);
                    endIndex = i;
                }
            } else // Else put this sum in map with sum as key and current index as i
                sumIndexes.put(sum, i);

        }

        // convert the arr to its original form
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] == 1) ? 1 : 0;
        }

        int startIndex = endIndex + 1 - maxLength;

        System.out.println("max sub array found between index:" + startIndex + " and end:" + endIndex);

        return maxLength;
    }
}
