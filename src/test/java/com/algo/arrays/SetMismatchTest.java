package com.algo.arrays;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author mkarki
 */
class SetMismatchTest {

    @Test
    void testFindErrorNums() {
        assertThat(SetMismatch.findErrorNums(new int[]{1, 2, 2, 4}), is(new int[]{2, 3}));
        assertThat(SetMismatch.findErrorNums(new int[]{1, 1}), is(new int[]{1, 2}));
    }

    @Test
    void test() {
        System.out.println(longestCommonPrefix(new String[]{"leets", "leetcode", "leet", "leeds"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }
}