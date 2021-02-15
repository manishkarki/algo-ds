package com.algo.arrays;

/**
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
 * <p>
 * You may return any answer array that satisfies this condition.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 *
 * @author mkarki
 */
public class SortByParity {

    public static int[] sortArrayByParity(int[] A) {
        int i = 0, j = A.length - 1;

        while (i < j) {
            // check if the pointer at start points to an odd number
            if (A[i] % 2 > A[j] % 2) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }

            // increment start pointer if the number is even
            if (A[i] % 2 == 0) {
                i++;
            }
            // increment tail pointer if the number is odd
            if (A[j] % 2 == 1) {
                j--;
            }
        }

        return A;
    }
}
