package com.algo.leetcode;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author mkarki
 */
class StockBuyAndSellTest {

    @Test
    void testMaxProfit() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        assertThat(StockBuyAndSell.maxProfit(prices), is(5));
        prices = new int[]{7, 6, 4, 3, 1};
        assertThat(StockBuyAndSell.maxProfit(prices), is(0));
    }
}