package com.algo.dummy.main;

/**
 * @author mkarki
 */
public class MinFlips {
    /**
     * There are N coins, each showing either heads or tails. We would like all the coins to form a sequence
     * of alternating heads and tails. What is the minimum number of coins that must be reversed to achieve this?
     * e.g:
     * Given Array A = [1, 0, 1, 0, 1, 1], it should return 1
     * Given Array A = [1, 1, 0, 1, 1], it should return 2
     * Given Array A = [0, 1, 0], it should return 0
     *
     * @param A
     * @return
     */
    public int solution(int[] A) {
        return Math.min(getNumberOfReverse(A, 0), getNumberOfReverse(A, 1));
    }

    public static int getNumberOfReverse(int[] A, int target) {
        int countFlip = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != target) {
                countFlip++;
            }
            // flip for next iteration
            target = (target == 0) ? 1 : 0;
        }
        return countFlip;
    }

    public static void main(String[] args) {
        MinFlips minFlips = new MinFlips();
        System.out.println(minFlips.solution(new int[]{1, 0, 1, 0, 1, 1}));
        System.out.println(minFlips.solution(new int[]{1, 1, 0, 1, 1}));
        System.out.println(minFlips.solution(new int[]{0, 1, 0}));
    }


}
