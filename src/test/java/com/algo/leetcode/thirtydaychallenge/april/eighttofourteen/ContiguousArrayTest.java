package com.algo.leetcode.thirtydaychallenge.april.eighttofourteen;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author mkarki
 */
class ContiguousArrayTest {

    private ContiguousArray contiguousArray;

    @BeforeEach
    void setup() {
        contiguousArray = new ContiguousArray();
    }

    @Test
    void testMaxLenWhenInputIsNull() {
        Throwable throwable = assertThrows(IllegalArgumentException.class,
                () -> contiguousArray.findMaxLength(null));
        assertThat(throwable.getMessage(), is("inputs cannot be null or empty"));
    }

    @Test
    void testMaxLen() {
        assertThat(contiguousArray.findMaxLength(new int[]{0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1}), is(10));
    }

}