package com.algo.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

/**
 * @author mkarki
 */
class DisappearedNumberTest {

    @Test
    void testGetDisappearedNumbers() {
        assertThat(DisappearedNumber.getDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}), containsInAnyOrder(5, 6));
    }

    /*
        find max len of a subarray with equal number of 0s and 1s
     */
    int maxLen(int arr[], int n) {
        Map<Integer, Integer> sumIndexes = new HashMap<>();

        int sum = 0;

        int max_len = 0;
        int ending_index = -1;

        for (int i = 0; i < n; i++) {
            arr[i] = (arr[i] == 0) ? -1 : 1;
        }

        // Traverse through the given array
        Arrays.stream(arr)
                .forEach(i -> System.out.print(" " + i));
        System.out.println();
        for (int i = 0; i < n; i++) {
            sum += arr[i];

            // To handle sum=0 at last index
            if (sum == 0) {
                max_len = i + 1;
                ending_index = i;
            }

            // If this sum is seen before,
            // then update max_len if required
            if (sumIndexes.containsKey(sum)) {
                if (max_len < i - sumIndexes.get(sum)) {
                    max_len = i - sumIndexes.get(sum);
                    ending_index = i;
                }
            } else // Else put this sum in map with sum as key and current index as i
                sumIndexes.put(sum, i);

        }

        for (int i = 0; i < n; i++) {
            arr[i] = (arr[i] == -1) ? 0 : 1;
        }

        int start = ending_index - max_len + 1;
        System.out.println(start + " to " + ending_index);
        return max_len;
    }

    @Test
    void maxLen() {
        int arr[] = {1, 0, 0, 1, 0, 1, 1};
        int n = arr.length;
        maxLen(arr, n);
    }

}