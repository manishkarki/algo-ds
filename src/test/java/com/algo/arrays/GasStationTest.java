package com.algo.arrays;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author mkarki
 */
class GasStationTest {

    @Test
    void canCompleteCircuit() {
        assertThat(GasStation.canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}), is(-1));
    }
}