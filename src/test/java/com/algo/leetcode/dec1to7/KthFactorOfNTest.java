package com.algo.leetcode.dec1to7;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author mkarki
 */
class KthFactorOfNTest {

    private final KthFactorOfN kthFactorOfN = new KthFactorOfN();

    @Test
    void testKthFactor() {
        assertThat(kthFactorOfN.kthFactor(12, 5), is(6));
        assertThat(kthFactorOfN.kthFactor(12, 4), is(4));
        assertThat(kthFactorOfN.kthFactor(12, 3), is(3));
        assertThat(kthFactorOfN.kthFactor(1000, 4), is(5));
    }

}