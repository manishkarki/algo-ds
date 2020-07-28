package com.algo.leetcode.thirtydaychallenge.april.fifteentotwentyone;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author mkarki
 */
class ValidParenthesesStringTest {
    private ValidParenthesesString validParenthesesString;

    @BeforeEach
    void setup() {
        validParenthesesString = new ValidParenthesesString();
    }

    @Test
    void testCheckValidStringWhenInputIsEmpty() {
        assertThat(validParenthesesString.checkValidString(""), is(true));
    }

    @Test
    void testCheckValidStringWhenInputIsNull() {
        assertThat(validParenthesesString.checkValidString(null), is(false));
    }

}