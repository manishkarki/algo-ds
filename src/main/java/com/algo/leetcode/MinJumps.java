package com.algo.leetcode;

/**
 * @author mkarki
 */
public class MinJumps {

    /**
     * Given an array of integers where each element represents the max number of steps that can be
     * made forward from that element. Write a function to return the minimum number of jumps to reach the end of
     * the array (starting from the first element). If an element is 0, then we cannot move through that element
     *
     * @param arr
     * @return minimum number of jumps required to reach the end
     */
    public int minJumps(int arr[]) {
        if (arr.length <= 1)
            return 0;

        // Return -1 if not possible to jump
        if (arr[0] == 0)
            return -1;

        // initialization
        int maxReach = arr[0];
        int step = arr[0];
        int jump = 1;


        // Start traversing array
        for (int i = 1; i < arr.length; i++) {
            // Check if we have reached the end of the array
            if (i == arr.length - 1)
                return jump;

            // updating maxReach
            maxReach = Math.max(maxReach, i + arr[i]);

            // we use a step to get to the current index
            step--;

            // If no further steps left
            if (step == 0) {
                //  we must have used a jump
                jump++;

                // Check if the current index/position  or lesser index
                // is the maximum reach point from the previous indexes
                if (i >= maxReach) {
                    System.out.println("can't do it anymore, since maxReach is:" + maxReach + " and i is:" + i);
                    return -1;
                }

                // re-initialize the steps to the amount
                // of steps to reach maxReach from position i.
                step = maxReach - i;
            }
        }

        return -1;
    }

    boolean canReachEnd(int[] arr) {
        int maxReachSoFar = 0, lastIndex = arr.length - 1;
        for (int i = 0; i <= maxReachSoFar && maxReachSoFar < lastIndex; i++) {
            maxReachSoFar = Math.max(maxReachSoFar, i + arr[i]);
        }
        return maxReachSoFar >= lastIndex;
    }

    public static void main(String[] args) {
        MinJumps mj = new MinJumps();
        System.out.println(mj.minJumps(new int[]{2, 2, 1, 1, 0, 2, 3}));
        System.out.println(mj.canReachEnd(new int[]{2, 2, 1, 1, 0, 2, 3}));
    }
}
