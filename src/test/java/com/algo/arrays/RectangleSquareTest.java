package com.algo.arrays;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author mkarki
 */
class RectangleSquareTest {
    private RectangleSquare rectangleSquare;

    @Test
    void testCountGoodRectangles() {
        rectangleSquare = new RectangleSquare();
        int[][] rectangles = {{5, 8}, {3, 9}, {5, 12}, {16, 5}};
        assertThat(rectangleSquare.countGoodRectangles(rectangles), is(3));
    }
}