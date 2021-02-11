package com.algo.arrays;

/**
 * @author mkarki
 */
public class MaxConsecutiveOnes {
    public static int getMaxConsecutiveOnes(int[] arr) {
        int maxConsecutiveOnes = 0;

        for (int i = 0; i < arr.length; i++) {
            int localMaxima = 0;
            while (i < arr.length && arr[i] == 1) {
                localMaxima++;
                i++;
            }

            if (localMaxima > maxConsecutiveOnes) {
                maxConsecutiveOnes = localMaxima;
            }
        }

        return maxConsecutiveOnes;
    }
}
