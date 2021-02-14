package com.algo.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).
 * <p>
 * More formally check if there exists two indices i and j such that :
 * <p>
 * i != j
 * 0 <= i, j < arr.length
 * num == 2 * arr[j]
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [10,2,5,3]
 * Output: true
 * Explanation: N = 10 is the double of M = 5,that is, 10 = 2 * 5.
 * Example 2:
 * <p>
 * Input: arr = [7,1,14,11]
 * Output: true
 * Explanation: N = 14 is the double of M = 7,that is, 14 = 2 * 7.
 * Example 3:
 * <p>
 * Input: arr = [3,1,7,11]
 * Output: false
 * Explanation: In this case does not exist N and M, such that N = 2 * M.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= arr.length <= 500
 * -10^3 <= num <= 10^3
 *
 * @author mkarki
 */
public class ArraySearch {

    public static boolean checkIfExist(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int num : arr) {
            if (count.containsKey(num)) {
                count.put(num, count.get(num) + 1);
            } else {
                count.put(num, 1);
            }
        }

        for (int num : arr) {
            if (num != 0 && count.containsKey(num) && count.containsKey(num * 2)) {
                return true;
            } else if (num == 0 && count.containsKey(num) && count.get(num) > 1) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkIfExists(int[] arr) {
        Set<Integer> count = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (count.contains(num * 2) || (num % 2 == 0 && count.contains(num / 2))) {
                return true;
            }
            count.add(num);
        }
        return false;
    }
}
