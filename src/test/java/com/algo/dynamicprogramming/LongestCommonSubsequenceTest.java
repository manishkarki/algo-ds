package com.algo.dynamicprogramming;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author mkarki
 */
class LongestCommonSubsequenceTest {
    private LongestCommonSubsequence lcs;

    @BeforeEach
    void setup() {
        lcs = new LongestCommonSubsequence();
    }

    @Test
    void testLCSIfOneStringIsNull() {
        String second = "abcdef";
        assertEquals(lcs.getLongestSubsequence(null, second), 0);
    }

    @Test
    void testLCSIfOneStringIsEmpty() {
        String first = "";
        String second = "abcdef";
        assertEquals(lcs.getLongestSubsequence(first, second), 0);
    }

    @Test
    void testLCSForValidEntries() {
        String first = "AGGTAB";
        String second = "GXTXAYB";

        assertEquals(4, lcs.getLongestSubsequence(first, second));
    }

}