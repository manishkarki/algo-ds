package com.algo.sorting;

/**
 * Given an array and a sorting algorithm, the sorting algorithm will do a selection swap.
 * Find the number of swaps to sort the array.
 * <p>
 * Example 1:
 * Input: [5, 4, 1, 2]
 * Output: 5
 *
 * @author mkarki
 */
public class NumberOfSwaps {
    // this is the variation of Count SmallerNumberAfterSelf, once we have that array which represents count
    // of numbers smalled than self, we can simply sum it up and return the result
    public int getNumberOfSwaps(int[] arr) {
        CountSmallerNumbersAfterSelf countSmallerNumbersAfterSelf = new CountSmallerNumbersAfterSelf();

        return countSmallerNumbersAfterSelf.countSmaller(arr)
                .stream()
                .mapToInt(Integer::intValue)
//                .sum();
                .reduce(0, (a, b) -> a + b);
    }
}
