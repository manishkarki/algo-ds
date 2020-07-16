package com.algo.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author mkarki
 */
class BalancedParenthesesTest {

    private BalancedParentheses balancedParentheses;

    @BeforeEach
    void setup() {
        balancedParentheses = new BalancedParentheses();
    }

    @Test
    void testValidParenthesesWithEmptyString() {
        assertThat(balancedParentheses.isValid(""), is(true));
    }

    @Test
    void testValidParenthesesWithNull() {
        assertThat(balancedParentheses.isValid(null), is(false));
    }

    @Test
    void testValidParentheses() {
        assertThat(balancedParentheses.isValid("{([])}"), is(true));
    }

    @Test
    void testValidParenthesesForWrongInput() {
        assertThat(balancedParentheses.isValid("{]"), is(false));
    }

}