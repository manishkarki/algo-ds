package com.algo.leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
            if (i == 4) {
                System.out.println("start:" + start);
            }
        }
    }

    public static void expand(String str, int low, int high, List<String> set) {
        while (low >= 0 && high < str.length()
                && str.charAt(low) == str.charAt(high)) {
            set.add(str.substring(low, high + 1));
            // expand in both directions
            low--;
            high++;
        }
    }

    public static void allPalindromicSubStrings(String str) {
        List<String> set = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            // find all odd length palindrome with str[i] as mid point
            expand(str, i, i, set);

            // find all even length palindrome with str[i] and str[i+1]
            // as its mid points
            expand(str, i, i + 1, set);
        }

    }


    public static void main(String[] args) {
//        combine(4, 2);
        solve(new int[]{25, 10});
        solve(new int[]{2, 4, 5});
        solve(new int[]{2, 4});

        List<String> l1 = new LinkedList<>() {{
            add("p1");
            add("1");
            add("2");
        }};
        List<String> l2 = new LinkedList<>() {{
            add("p2");
            add("2");
            add("1");
        }};
        List<String> l3 = new LinkedList<>() {{
            add("item2");
            add("3");
            add("4");
        }};
        List<List<String>> lists = new LinkedList<>();
        lists.add(l1);
        lists.add(l2);
//        lists.add(l3);
        System.out.println(fetchItemsToDisplay(lists, 0, 0, 1, 0));
    }

    public static List<String> fetchItemsToDisplay(List<List<String>> items, int sortParameter, int sortOrder, int itemPerPage, int pageNumber) {
        // Write your code here
        Collections.sort(items, (o1, o2) -> {
            if (sortParameter != 0) {
                Integer a = Integer.parseInt(o1.get(sortParameter));
                Integer b = Integer.parseInt(o2.get(sortParameter));
                return sortOrder == 0 ? a.compareTo(b) : b.compareTo(a);
            }
            return sortOrder == 0 ? o1.get(sortParameter).compareTo(o2.get(sortParameter))
                    : o2.get(sortParameter).compareTo(o1.get(sortParameter));
        });
        List<String> retList = new LinkedList<>();
        for (List<String> item : items) {
            retList.add(item.get(0));
        }

        List<String> retItems = new LinkedList<>();
        for (int i = itemPerPage * pageNumber; i < retList.size(); i++) {
            if (retItems.size() < itemPerPage) {
                retItems.add(retList.get(i));
                continue;
            }
            break;
        }
        return retItems;

    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        int[] count = new int[7];

        for (int num : A) {
            count[num]++;
        }

        int min = Integer.MAX_VALUE;
        int temp;
        for (int i = 1; i < 7; i++) {
            temp = 2 * count[7 - i] + A.length - count[i] - count[7 - i];
            // check if what we calculated for moves is less than something we already found.
            min = temp < min ? temp : min;
        }
        return min;
    }

    static String winner(String erica, String bob) {
        Map<Character, Integer> scores = new HashMap<>(3);
        scores.put('E', 1);
        scores.put('M', 3);
        scores.put('H', 5);

        int ericasScore = 0, bobsScore = 0;
        for (Character c : erica.toCharArray()) {
            ericasScore += scores.getOrDefault(c, 0);
        }
        for (Character c : bob.toCharArray()) {
            bobsScore += scores.getOrDefault(c, 0);
        }

        if (ericasScore > bobsScore) {
            return "Erica";
        } else if (ericasScore < bobsScore) {
            return "Bob";
        }
        return "Tie";
    }

    static void solve(int[] arr) {
        String result = "-1";

        int prod = 1;

        for (int i : arr) {
            prod *= i;
        }
        float a = 1.2f;
        float b = 1.2f;
        int r = (int) Math.floor(a + b);
        result = String.format("%02d", prod % 100);
        System.out.println(result);
    }


}
