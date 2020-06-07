package com.algo.leetcode;

import java.io.BufferedWriter;
import java.util.*;

class FoodFactory {
    public static int perfectTeam(String skills) {
        int pCount = 0, cCount = 0, mCount = 0, bCount = 0, zCount = 0;
        for (char c : skills.toLowerCase().toCharArray()) {
            if (c == 'c') {
                cCount++;
            } else if (c == 'p') {
                pCount++;
            } else if (c == 'm') {
                mCount++;
            } else if (c == 'b') {
                bCount++;
            } else if (c == 'z') {
                zCount++;
            }
        }
        List<Integer> counts = new ArrayList<>(Arrays.asList(pCount, cCount, mCount, bCount, zCount));
        return counts.get(0);
    }

}

class Test {
    static String rleDecode(String s) {
        //s4a3b2s1 => ssssaaabbs
        // s a
        //s44
        StringBuilder sb = new StringBuilder();

        int i = 0;
        // O(n)
        while (i < s.length()) {
            char c = s.charAt(i);// c= 3
            int count = 0;
            if (Character.isAlphabetic(c)) {//s
                int index = i + 1;
                // index : 1, i = 0
                while (index < s.length() && Character.isDigit(s.charAt(index))) {
                    count = count * 10 + s.charAt(index) - '0'; // 1
                    index++;// ++x and x++
                }
                while (count > 0) {
                    sb.append(c);
                    count--;
                }
                i = index;// i = 3
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(rleDecode("s14a3b2s1"));
        List<String> s = Arrays.asList("aabaab", "aaaabb");
        List<String> t = Arrays.asList("bbbabbc", "abbbbbb");
        System.out.println(areAlmostEquivalent(s, t));
        System.out.println(maxDistinctNum(Arrays.asList(1, 1, 1, 2, 3, 2), 2));
    }

    static int maxDistinctNum(List<Integer> ids, int m) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int size = 0;

        // Store the occurrence of ids 
        for (int i = 0; i < ids.size(); i++) {

            // If the key is not add it to map 
            if (map.containsKey(ids.get(i)) == false) {
                map.put(ids.get(i), 1);
                size++;
            } else map.put(ids.get(i), map.get(ids.get(i)) + 1);
        }

        for (Map.Entry<Integer, Integer> mp : map.entrySet()) {
            if (mp.getKey() <= m) {
                m -= mp.getKey();
                count++;
            }
            // Return the remaining size 
            else return size - count;
        }

        return size - count;
    }


    public static List<String> areAlmostEquivalent(List<String> s, List<String> t) {
        List<String> areEquivalents = new LinkedList<>();
        if (s == null || t == null || s.size() != t.size()) {
            return areEquivalents;
        }
        List<Map<Character, Integer>> counters = new LinkedList<>();
        //we need as many maps as the number of elements in each collection
        for (int i = 0; i < t.size(); i++) {
            counters.add(new HashMap<>());
        }
        for (int i = 0; i < s.size(); i++) {
            String s1 = s.get(i);
            for (Character c : s1.toCharArray()) {
                if (counters.get(i).get(c) == null) {
                    counters.get(i).put(c, 1);
                } else {
                    counters.get(i).put(c, counters.get(i).get(c) + 1);
                }
            }
        }

        for (int i = 0; i < t.size(); i++) {
            String s2 = t.get(i);
            for (Character c : s2.toCharArray()) {
                if (counters.get(i).get(c) == null) {
                    counters.get(i).put(c, 1);
                } else {
                    counters.get(i).put(c, counters.get(i).get(c) - 1);
                }
            }
        }

        for (Map<Character, Integer> counter : counters) {
            boolean flag = true;
            for (int value : counter.values()) {
                System.out.println(value);
                if (Math.abs(value) > 3) {
                    flag = false;
                    areEquivalents.add("NO");
                    break;
                }
            }
            if (flag) {
                areEquivalents.add("YES");
            }
        }
        return areEquivalents;
    }

}