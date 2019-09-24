package com.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mkarki
 */
public class StockBuyAndSellPart3 {

    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.
     *
     * Design an algorithm to find the maximum profit. You may complete at most two transactions.
     *
     * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
     *
     * Example 1:
     *
     * Input: [3,3,5,0,0,3,1,4]
     * Output: 6
     * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
     *              Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        //initial check for nulls and an empty array
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int maxProfit = 0;
        List<Integer> profits = new ArrayList<>();
        int lowestPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - lowestPrice);
            profits.add(maxProfit);
            lowestPrice = Math.min(lowestPrice, prices[i]);
        }

        int maxPriceSoFar = Integer.MIN_VALUE;
        for(int j = prices.length - 1; j > 0; j--) {
            maxPriceSoFar = Math.max(maxPriceSoFar, prices[j]);
            maxProfit = Math.max(maxProfit, maxPriceSoFar - prices[j] + profits.get(j - 1));
        }
        return maxProfit;
    }

}
