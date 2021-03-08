package com.algo.string;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author mkarki
 */
class LongestCommonPrefixTest {

    private LongestCommonPrefix longestCommonPrefix;

    @BeforeEach
    void setup() {
        longestCommonPrefix = new LongestCommonPrefix();
    }

    @Test
    void commonPrefix() {
        String[] arr = {"geeksforgeeks", "geeks", "geek", "geezer"};
        int n = arr.length;

        long startTime = System.currentTimeMillis();
        String ans = longestCommonPrefix.commonPrefix(arr, n);
        System.out.println("time taken by trie:" + (System.currentTimeMillis() - startTime));
        assertThat(ans, is("gee"));
    }

    @Test
    void longestCommonPrefix() {
        String[] arr = {"geeksforgeeks", "geeks", "geek", "geezer"};
        System.out.println("*******v2************");
        long startTime = System.currentTimeMillis();
        String ans = longestCommonPrefix.longestCommonPrefix(arr);
        System.out.println("time taken by v2:" + (System.currentTimeMillis() - startTime));

        assertThat(ans, is("gee"));
    }
}