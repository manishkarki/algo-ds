package com.algo.arrays;

/**
 * You are given an array rectangles where rectangles[i] = [li, wi] represents the ith rectangle of length li and width wi.
 * <p>
 * You can cut the ith rectangle to form a square with a side length of k if both k <= li and k <= wi. For example, if you have a rectangle [4,6], you can cut it to get a square with a side length of at most 4.
 * <p>
 * Let maxLen be the side length of the largest square you can obtain from any of the given rectangles.
 * <p>
 * Return the number of rectangles that can make a square with a side length of maxLen.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: rectangles = [[5,8],[3,9],[5,12],[16,5]]
 * Output: 3
 * Explanation: The largest squares you can get from each rectangle are of lengths [5,3,5,5].
 * The largest possible square is of length 5, and you can get it out of 3 rectangles.
 * Example 2:
 * <p>
 * Input: rectangles = [[2,3],[3,7],[4,3],[3,7]]
 * Output: 3
 *
 * @author mkarki
 */
public class RectangleSquare {

    public int countGoodRectangles(int[][] rectangles) {
        int[] smaller = new int[rectangles.length];

        int index = 0;
        for (int[] rectangle : rectangles) {
            if (rectangle[0] > rectangle[1]) {
                smaller[index++] = rectangle[1];
            } else {
                smaller[index++] = rectangle[0];
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < smaller.length; i++) {
            if (max < smaller[i]) {
                max = smaller[i];
            }
        }

        int count = 0;
        for (int small : smaller) {
            if (small == max) {
                count++;
            }
        }
        return count;
    }
}
