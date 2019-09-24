package com.algo.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author mkarki
 */
class PrisonCellsAfterNDaysTest {
    private PrisonCellsAfterNDays prisonCellsAfterNDays;

    @BeforeEach
    void setup() {
        prisonCellsAfterNDays = new PrisonCellsAfterNDays();
    }

    @Test
    void prisonAfterNDays() {
        int[] originalCellAt0thDay = {0, 1, 0, 1, 1, 0, 0, 1};

        Arrays.stream(prisonCellsAfterNDays.prisonAfterNDays(originalCellAt0thDay, 2))
                .boxed()
                .forEach(System.out::print);
    }

    @Test
    void randomTest() {
        int[] nums = {4, 4, 4, 1, 4};
        List<List<Integer>> retList = new LinkedList<>();
        for (int i = 0; i < (1 << nums.length); i++) {
            String binary = String.format("%" + nums.length + "s", Integer.toBinaryString(i))
                    .replace(' ', '0');
            char[] result = binary.toCharArray();
            List<Integer> subset = new LinkedList<>();
            for (int j = 0; j < result.length; j++) {
                if (result[j] != '0') {
                    subset.add(nums[j]);
                }
            }
            if (!retList.contains(subset)) {
                retList.add(subset);
            }
        }
//        System.out.println(retList);
        System.out.println(subsetsWithDup1(nums));
    }

    public List<List<Integer>> subsetsWithDup1(int[] nums) {
        List<List<Integer>> subsets = new LinkedList<>();
        int len = nums.length;
        if (nums == null || len == 0) {
            return subsets;
        }

        Arrays.sort(nums);
        subsets.add(new LinkedList<>());// first, need to add the subset of num[0]
        subsets.add(new LinkedList<>());
        subsets.get(1).add(nums[0]);

        int alreadyAdded = 1; // this is the number of lists that the previous number was added in.
        // if the current number is same as the prev one, it'll be only added in the
        // lists that has the prev number.

        for (int i = 1; i < len; ++i) {
            int size = subsets.size();

            //if current number is not equal to previous, then only add to all
            if (nums[i] != nums[i - 1]) {
                alreadyAdded = size; // this means add num[i] to all lists in ans;
            }
            for (int k = (size - alreadyAdded); k < size; ++k) {
                List<Integer> l = new LinkedList<>(subsets.get(k));
                l.add(nums[i]);
                subsets.add(l);
            }
        }
        return subsets;
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        List<List<Integer>> retList = new LinkedList<>();
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> subset = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    subset.add(nums[j]);
                }
            }
            if (!retList.contains(subset)) {
                retList.add(subset);
            }
        }
        return retList;
    }
}