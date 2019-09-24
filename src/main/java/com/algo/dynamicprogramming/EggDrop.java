package com.algo.dynamicprogramming;

/**
 * @author mkarki
 */
public class EggDrop {

    /**
     * There are n number of eggs and building which has k floors.
     * Write an algorithm to find the minimum number of drops is required to know the floor from which if egg is dropped, it will break
     * @param eggs
     * @param floors
     * @return minimum number of drops to know the dropable floor
     */
    public int calculateMinAttempts(int eggs, int floors) {
        int[][] dp = new int[eggs + 1][floors + 1];
        for(int i=0; i <= floors; i++){
            dp[1][i] = i;
        }

        int c;
        for(int egg = 2; egg < eggs ; egg++) {
            for(int floor = 2; floor <= floors; floor++) {
                dp[egg][floor] = Integer.MAX_VALUE;
                for(int k = 1; k <= floor; k++) {
                    c = 1 + Math.min(dp[egg-1][k - 1], dp[egg][floor - k]);
                    if(c < dp[egg][floor]) {
                        dp[egg][floor] = c;
                    }
                }

            }
        }
        return dp[eggs][floors];
    }
}
