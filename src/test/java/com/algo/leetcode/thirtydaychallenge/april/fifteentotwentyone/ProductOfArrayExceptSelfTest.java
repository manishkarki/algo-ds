package com.algo.leetcode.thirtydaychallenge.april.fifteentotwentyone;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author mkarki
 */
class ProductOfArrayExceptSelfTest {
    private ProductOfArrayExceptSelf productOfArrayExceptSelf;

    @BeforeEach
    void setup() {
        productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
    }

    @Test
    void testGetProductOfArrayExceptSelf() {
        int[] input = new int[]{4, 5, 1, 8, 2};
        productOfArrayExceptSelf.printArray(input);
        assertThat(productOfArrayExceptSelf.getProductExceptSelf(input),
                is(new int[]{80, 64, 320, 40, 160}));
    }

}