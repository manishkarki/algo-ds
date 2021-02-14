package com.algo.arrays;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author mkarki
 */
public class ArraySearchTest {

    @Test
    void testElement() {
//        assertThat(ArraySearch.checkIfExist(new int[] {3, 1, 7, 11}), is(false));
        assertThat(ArraySearch.checkIfExist(new int[]{-2, 0, 10, -19, 4, 6, -8}), is(false));
        assertThat(ArraySearch.checkIfExist(new int[]{0, 0}), is(true));
    }
}
