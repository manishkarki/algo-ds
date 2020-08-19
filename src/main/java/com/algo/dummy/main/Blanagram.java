package com.algo.dummy.main;

/**
 * @author mkarki
 */
public class Blanagram {

    public static boolean checkBlanagram(String word1, String word2) {
        // considering the constraints, avoiding any boilerPlate checks
        int[] counts = new int[26];

        for (char c : word1.toCharArray()) {
            int index = c - 97;
            counts[index]++;
        }

        for (char c : word2.toCharArray()) {
            int index = c - 97;
            counts[index]--;
        }

        int countReplacement = 0;
        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0) {
                countReplacement++;
            }
        }

        return countReplacement == 1;
    }

    public static void main(String[] args) {
        System.out.println(checkBlanagram("silent", "listen"));
        System.out.println(checkBlanagram("tangram", "anagram"));
        System.out.println(checkBlanagram("tangram", "pangram"));
        System.out.println(checkBlanagram("mangi", "mango"));
        System.out.println(checkBlanagram("lemon", "monle"));
        System.out.println(checkBlanagram("lemon", "demon"));
    }
}
