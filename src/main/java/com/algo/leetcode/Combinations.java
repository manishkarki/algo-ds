package com.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author mkarki
 */
public class Combinations {

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combs = new ArrayList<>();
        combine(combs, new ArrayList<>(), 1, n, k);
        return combs;
    }

    public static void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
        if (k == 0) {
            combs.add(new ArrayList<>(comb));
            return;
        }
        for (int i = start; i <= n; i++) {
            comb.add(i);
            combine(combs, comb, i + 1, n, k - 1);
            comb.remove(comb.size() - 1);
            System.out.println(combs);
            if(i == 4) {
                System.out.println("start:"+start );
            }
        }
    }

    public static void main(String[] args) {
//        combine(4, 2);
        Integer a = 1;
        Integer b = 2;
//        System.out.println(a.compareTo(b));
        Combinations c = new Combinations();
        c.call();
        System.out.println(3 | 5);
    }

    void call() {
        int[] n_tests = {6};
        int[][] edges = {{1, 2}, {2, 3}, {4, 5}, {3, 5}, {1, 6}, {2, 4}};
        int[][] edgesToRepair = {{1, 6, 410}, {2, 4, 800}, {3, 4, 79}};
        List<Integer> arr = new ArrayList<>(Arrays.asList(27,57,37,49,58));
        int x = 45;
        Collections.sort(arr, (a, b) -> a == b ? a - b : Math.abs(a-x) - Math.abs(b-x));
        System.out.println(arr);
    }


}
