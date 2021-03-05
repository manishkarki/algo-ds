package com.algo.string;

import org.junit.jupiter.api.Test;

import static com.algo.string.ShortestWordDistance.shortestDistance;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author mkarki
 */
class ShortestWordDistanceTest {

    @Test
    void testShortestDistance() {
        assertThat(shortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "coding", "practice"), is(3));
        assertThat(shortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "makes", "coding"), is(1));
        assertThat(shortestDistance(new String[]{"a", "c", "a", "b"}, "a", "b"), is(1));
    }
}