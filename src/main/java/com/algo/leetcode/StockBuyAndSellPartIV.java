package com.algo.leetcode;

import java.util.Arrays;

/**
 * @author mkarki
 */
public class StockBuyAndSellPartIV {

    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.
     *
     * Design an algorithm to find the maximum profit. You may complete at most k transactions.
     *
     * Note:
     * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
     *
     * Example 1:
     *
     * Input: [2,4,1], k = 2
     * Output: 2
     * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
     *
     * @param k
     * @param prices
     * @return maxProfit
     */
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k >= len / 2) {
            return quickSolve(prices);
        }

        int[] sells = new int[k + 1];
        int[] buys = new int[k + 1];
        Arrays.fill(buys, Integer.MIN_VALUE);

        for (int price : prices) {
            for (int j = k; j > 0; j--) {
                buys[j] = Math.max(buys[j], sells[j - 1] - price);
                sells[j] = Math.max(sells[j], buys[j] + price);
            }
        }
        return sells[k];
    }

    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        return profit;
    }

    public int maxProfitDP(int k, int[] prices) {
        int len = prices.length;
        if (k >= len / 2) return quickSolve(prices);

        int[][] dp = new int[k + 1][len];
        for (int i = 1; i <= k; i++) {
            int buy =  -prices[0];
            for (int j = 1; j < len; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + buy);
                buy =  Math.max(buy, dp[i - 1][j - 1] - prices[j]);
                System.out.print("  with buy:"+buy);
            }
        }
        return dp[k][len - 1];
    }

    public int maxProfitState(int k, int[] prices) {
        int[] buy = new int[k + 1], sell = new int[k + 1];
        Arrays.fill(buy, Integer.MIN_VALUE);
        for (int price : prices) {
            for (int i = 1; i <= k; i++) {
                buy[i] = Math.max(buy[i], sell[i - 1] - price);
                sell[i] = Math.max(sell[i], buy[i] + price);
            }
        }
        return sell[k];
    }

}
