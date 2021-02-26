package com.algo.arrays;

/**
 * Equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes. For example, in an array A:
 * <p>
 * Example :
 * <p>
 * Input: A[] = {-7, 1, 5, 2, -4, 3, 0}
 * Output: 3
 * 3 is an equilibrium index, because:
 * A[0] + A[1] + A[2] = A[4] + A[5] + A[6]
 * <p>
 * Input: A[] = {1, 2, 3}
 * Output: -1
 *
 * @author mkarki
 */
public class EquilibriumIndex {

    public static int getEquilibriumIndex(int[] arr) {
        int sum = 0, leftSum = 0;

        for (int i : arr) {
            sum += i;
        }

        for (int i = 0; i < arr.length; i++) {
            // sum would be right sum
            sum -= arr[i];

            if (leftSum == sum) {
                return i;
            }
            // update left sum for next iteration
            leftSum += arr[i];
        }

        return -1;
    }

}
