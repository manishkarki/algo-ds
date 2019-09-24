package com.algo.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author mkarki
 */
class StockBuyAndSellPart3Test {
    private StockBuyAndSellPart3 stockBuyAndSellPart3;

    @BeforeEach
    void setup() {
        stockBuyAndSellPart3 = new StockBuyAndSellPart3();
    }

    @Test
    void testForValidInput() {
        assertEquals(6, stockBuyAndSellPart3.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
        assertEquals(2, stockBuyAndSellPart3.maxProfit(new int[]{2, 1, 2, 0, 1}));
        // NOTE: The following input values will be used for testing your solution.

    }

    @Test
    void testNonRepeating() {
        assertEquals('c', nonRepeating("abcab")); // should return 'c'
        assertEquals(null, nonRepeating("abab")); // should return null
        assertEquals('c', nonRepeating("aabbbc")); // should return null
        assertEquals('d', nonRepeating("aabbdbc")); // should return null
    }

    // Implement your solution below.
    public static Character nonRepeating(String s) {
        Map<Character, Integer> counter = new HashMap<>();
        if (s == null || s.length() == 0) {
            return null;
        }
        for (Character c : s.toCharArray()) {
            counter.compute(c, (key, val) -> (val == null) ? 1 : val + 1);
        }
        System.out.println(counter);
        for (Character c : s.toCharArray()) {
            if (counter.get(c) == 1) {
                return c;
            }
        }
        return null;
    }
}