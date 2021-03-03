package com.algo.arrays;

import java.util.Arrays;

/**
 * Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.
 * <p>
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 * <p>
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * Example 3:
 * <p>
 * Input: digits = [0]
 * Output: [1]
 *
 * @author mkarki
 */
public class PlusOne {

    public static int[] plusOne(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            // set all the 9s at the end of the array to 0
            if (arr[i] == 9) {
                arr[i] = 0;
            }
            // right most digit is a non 9, so increase and then return the array
            else {
                arr[i]++;
                return arr;
            }
        }
        Arrays.stream(arr)
                .boxed()
                .mapToInt(Integer::intValue)
                .forEach(i -> System.out.print(i + " "));
        // we'll only come here if the number represented by array were all 9s
        arr = new int[arr.length + 1];
        arr[0] = 1;
        return arr;
    }
}
