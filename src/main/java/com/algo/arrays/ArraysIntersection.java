package com.algo.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 * <p>
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Note:
 * <p>
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:
 * <p>
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 *
 * @author mkarki
 */
public class ArraysIntersection {

    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> nums = new ArrayList<>();

        for (int num : nums1) {
            nums.add(num);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (nums.contains(nums2[i])) {
                res.add(nums2[i]);
            }
        }

        return res.stream()
                .mapToInt(Integer::intValue).toArray();

    }

    public static void main(String[] args) {
        int[] arr1 = {4, 9, 5};
        int[] arr2 = {9, 4, 9, 8, 4};
        System.out.println(intersect(arr1, arr2));
    }
}
