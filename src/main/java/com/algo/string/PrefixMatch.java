package com.algo.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mkarki
 */
public class PrefixMatch {
    class TrieNode {
        Map<Character, TrieNode> children;
        Character val;
        boolean isWord;

        public TrieNode(Character val) {
            this.val = val;
            children = new HashMap<>();
            isWord = false;
        }

        public Map<Character, TrieNode> getChildren() {
            return children;
        }

        public Character getVal() {
            return val;
        }

        public boolean isWord() {
            return isWord;
        }

        public void setWord(boolean word) {
            isWord = word;
        }
    }

    class Trie {
        private TrieNode root;

        public Trie() {
            this.root = new TrieNode((char) 0);
        }

        public void insert(String word) {
            int len = word.length();
            TrieNode crawl = root;

            for(int level = 0; level < len; level++) {
                Map<Character, TrieNode> children = crawl.getChildren();
                char ch = word.charAt(level);

                //if there is already a children for the given character, get it to crawl
                // else create a new one
                if(children.containsKey(ch)) {
                    crawl = children.get(ch);
                } else {
                    TrieNode temp = new TrieNode(ch);
                    children.put(ch, temp);
                }
            }
            //set is word for the last char
            crawl.setWord(true);
        }

        /**
         * Given a dictionary of words and an input string, find the longest prefix of the string which is also a word
         * in dictionary.
         * Examples:
         *
         * Let the dictionary contains the following words:
         * {are, area, base, cat, cater, children, basement}
         *
         * Below are some input/output examples:
         * --------------------------------------
         * Input String            Output
         * --------------------------------------
         * caterer                 cater
         * basemexy                base
         * child                   < Empty >
         * @param input
         * @return
         */
        public String getMatchingPrefix(String input) {
            String result = "";
            int len = input.length();
            //reference for traversing
            TrieNode crawl = root;
            int level, prevMatch = 0;
            for(level  = 0; level < len; level++) {
                char ch = input.charAt(level);
                Map<Character, TrieNode> child = crawl.getChildren();

                if(child.containsKey(ch)) {
                    result += ch;
                    crawl = child.get(ch);
                    if(crawl.isWord()) {
                        prevMatch = level+1;
                    }
                } else break;
            }
            if(crawl.isWord()) {
                return result.substring(0, prevMatch);
            }
            else return result;
        }

        public String getLongestPrefix(String []arr, int n) {
            constructTrie(arr, n);
            return walkTrie();
        }

        private String walkTrie() {
            String result = "";
            TrieNode crawl = root;
            System.out.println(crawl.getChildren().size());
            while(countChildren(crawl) == 1 && !crawl.isWord()) {
                result += crawl.getVal();
                crawl = crawl.getChildren().get(0);
            }
            return result;
        }

        private int countChildren(TrieNode node) {
            return node.children.size();
        }

        private void constructTrie(String[] arr, int n) {
            for(int i = 0; i < n; i++) {
                insert(arr[i]);
            }
        }
    }

    public static void main(String args[])
    {
        String arr[] = {"geeksforgeeks", "geeks",
                "geek", "geezer"};
        int n = arr.length;

        Trie trie = new PrefixMatch().new Trie();

        String ans = trie.getLongestPrefix(arr, n);

        if (ans.length() != 0)
            System.out.println("The longest common prefix is "+ans);
        else
            System.out.println("There is no common prefix");
    }


}
