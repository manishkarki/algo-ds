package com.algo.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author mkarki
 */
class DecodeWaysTest {

    private DecodeWays decodeWays;

    @BeforeEach
    void setUp() {
        decodeWays = new DecodeWays();
    }

    @Test
    void testNumberOfWaysToDecode() {
        int count = 0;
        String s = "3e4f2e";
        //decode string
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                count = count * 10 + c - '0';
            } else {
                while(count > 0) {
                    sb.append(c);
                    count--;
                }
            }
        }
        System.out.println(sb);

        // encode string
        int encodeCount = 1;
        StringBuilder encodeBuilder = new StringBuilder();
        String str = "ebbbacddd";

        for(int i = 1; i <= str.length(); i++) {
            if(i == str.length() || str.charAt(i) != str.charAt(i - 1)) {
                encodeBuilder.append(encodeCount).append(str.charAt(i - 1));
                encodeCount = 1;
            } else {
                ++encodeCount;
            }
        }
        System.out.println(encodeBuilder.toString());
    }
    @Test
    void testNumberOfWaysToDecodeDP() {
        assertEquals(3, decodeWays.numberOfWaysToDecodeDP("123"));
        assertEquals(3, decodeWays.numberOfWaysToDecodeDP("226"));
        assertEquals(2, decodeWays.numberOfWaysToDecodeDP("12"));
    }
}