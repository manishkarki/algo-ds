package com.algo.arrays;

import java.util.Arrays;
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
        int sum = 0, maxLength = 0, endIndex = -1;
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

    /**
     * Given an array of alphanumeric characters. The task is to find the longest contiguous sub-array which has
     * equal numbers of letters (alphabets) and numbers (numeric digits). Print the starting and ending index of
     * this sub-array. If there are multiple results, output the one with the lowest starting index.
     * <p>
     * Examples:
     * <p>
     * Input: arr[] = {‘A’, ‘B’, ‘X’, ‘4’, ‘6’, ‘X’, ‘a’}
     * Output: 1 4
     * The required sub-array is {‘B’, ‘X’, ‘4’, ‘6’}.
     * {‘X’, ‘4’, ‘6’, ‘X’} is also a valid sub-array of maximum
     * length but its starting index is not minimum.
     * <p>
     * Input: arr[] = {‘1’, ‘2’, ‘a’, ‘b’, ‘c’, ‘1’, ‘n’, ‘c’, ‘1’, ‘2’}
     * Output: 0 9
     */
    public static SubArrayResponse getLargestSubArrayWithEqualAlphabetsAndNumbers(int[] arr) {
        int maxSize = -1, sum, start = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Character.isAlphabetic(arr[i]) ? -1 : 1;
        }

        for (int i = 0; i < arr.length; i++) {
            sum = arr[i];

            for (int j = i + 1; j < arr.length; j++) {
                sum += arr[j];

                if (sum == 0 && maxSize < (j - i + 1)) {
                    maxSize = j - i + 1;
                    start = i;
                }
            }
        }

        return new SubArrayResponse(maxSize, new int[]{start, start + maxSize - 1});
    }

    static class SubArrayResponse {
        int maxSize;
        int[] indices;

        public SubArrayResponse(int maxSize, int[] indices) {
            this.maxSize = maxSize;
            this.indices = indices;
        }

        @Override
        public String toString() {
            return "SubArrayResponse{" +
                    "maxSize=" + maxSize +
                    ", indices=" + Arrays.toString(indices) +
                    '}';
        }
    }


}
