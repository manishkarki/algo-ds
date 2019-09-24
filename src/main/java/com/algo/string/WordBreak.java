package com.algo.string;

import java.util.*;

/**
 * @author mkarki
 */
public class WordBreak {
    /**
     * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
     * add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
     * <p>
     * Note:
     * <p>
     * The same word in the dictionary may be reused multiple times in the segmentation.
     * You may assume the dictionary does not contain duplicate words.
     * Example 1:
     * <p>
     * Input:
     * s = "catsanddog"
     * wordDict = ["cat", "cats", "and", "sand", "dog"]
     * Output:
     * [
     * "cats and dog",
     * "cat sand dog"
     * ]
     * Example 2:
     * <p>
     * Input:
     * s = "pineapplepenapple"
     * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
     * Output:
     * [
     * "pine apple pen apple",
     * "pineapple pen apple",
     * "pine applepen apple"
     * ]
     * Explanation: Note that you are allowed to reuse a dictionary word.
     * Example 3:
     * <p>
     * Input:
     * s = "catsandog"
     * wordDict = ["cats", "dog", "sand", "and", "cat"]
     * Output:
     * []
     *
     * @param s
     * @param wordDict
     * @return
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        return backtrack(s, wordDict, new HashMap<>());
    }

    // backtrack returns an array including all substrings derived from s.
    private List<String> backtrack(String s, List<String> wordDict, Map<String, List<String>> wordMap) {
        if (wordMap.containsKey(s)) {
            return wordMap.get(s);
        }
        List<String> result = new ArrayList<>();
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                String next = s.substring(word.length());
                if (next.length() == 0) {
                    result.add(word);
                } else {
                    for (String sub : backtrack(next, wordDict, wordMap)) {
                        result.add(word + " " + sub);
                    }
                }
            }
        }
        wordMap.put(s, result);
        return result;
    }

    /**
     * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
     * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
     *
     * Note:
     *
     * The same word in the dictionary may be reused multiple times in the segmentation.
     * You may assume the dictionary does not contain duplicate words.
     * Example 1:
     *
     * Input: s = "leetcode", wordDict = ["leet", "code"]
     * Output: true
     * Explanation: Return true because "leetcode" can be segmented as "leet code".
     * Example 2:
     *
     * Input: s = "applepenapple", wordDict = ["apple", "pen"]
     * Output: true
     * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
     *              Note that you are allowed to reuse a dictionary word.
     * Example 3:
     *
     * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
     * Output: false
     * @param s
     * @param wordDict
     * @return
     */
    public boolean isWordBreakable(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return false;

        int n = s.length();

        // dp[i] represents whether s[0...i] can be formed by dict
        boolean[] dp = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                String sub = s.substring(j, i + 1);

                if (wordDict.contains(sub) && (j == 0 || dp[j - 1])) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
//        System.out.println(
//                wordBreak.wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple")));
        System.out.println(wordBreak.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
        System.out.println(wordBreak.isWordBreakable("leetcode", Arrays.asList("leet", "code")));
        System.out.println(wordBreak.isWordBreakable("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(wordBreak.isWordBreakable("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }
}
