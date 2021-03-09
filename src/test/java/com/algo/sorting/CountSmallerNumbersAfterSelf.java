package com.algo.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [5,2,6,1]
 * Output: [2,1,1,0]
 * Explanation:
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 * Example 2:
 * <p>
 * Input: nums = [-1]
 * Output: [0]
 * Example 3:
 * <p>
 * Input: nums = [-1,-1]
 * Output: [0,0]
 *
 * @author mkarki
 */
public class CountSmallerNumbersAfterSelf {
    static class Number {
        int index;
        int val;

        public Number(int i, int v) {
            index = i;
            val = v;
        }
    }

    private static List<Number> mergeSort(List<Number> nums, int[] smaller) {
        if (nums.size() <= 1) {
            return nums;
        }
        int mid = nums.size() / 2;
        List<Number> left = mergeSort(nums.subList(0, mid), smaller);
        List<Number> right = mergeSort(nums.subList(mid, nums.size()), smaller);
        return merge(left, right, smaller);
    }

    private static List<Number> merge(List<Number> left, List<Number> right, int[] smaller) {
        List<Number> result = new ArrayList<>();
        int l = 0;
        int r = 0;
        while (l < left.size() || r < right.size()) {
            if (r >= right.size() || (l < left.size() && left.get(l).val <= right.get(r).val)) {
                result.add(left.get(l));
                smaller[left.get(l).index] += r;
                l++;
            } else {
                result.add(right.get(r));
                r++;
            }
        }
        return result;
    }

    public List<Integer> countSmaller(int[] nums) {
        int[] smaller = new int[nums.length];
        List<Number> numbers = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            numbers.add(new Number(i, nums[i]));
        }

        mergeSort(numbers, smaller);
        return Arrays.stream(smaller)
                .boxed()
                .collect(Collectors.toList());
    }

}
