package com.algo.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author mkarki
 */
class StockBuyAndSellPartIVTest {
    private StockBuyAndSellPartIV stockBuyAndSellPartIV;

    @BeforeEach
    void setup() {
        stockBuyAndSellPartIV = new StockBuyAndSellPartIV();
    }

    @Test
    void testStockBuyAndSellWith0Transactions() {
        int [] price = {2,4,1};
        stockBuyAndSellPartIV.maxProfit(2, price);
    }
    @Test
    void testStockBuyAndSellWith2Transactions() {
        int [] price = {3,2,6,5,0,3};
        assertEquals(7, stockBuyAndSellPartIV.maxProfit(2, price));
        assertEquals(7, stockBuyAndSellPartIV.maxProfitDP(2, price));
    }

}