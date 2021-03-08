package com.algo.tree;

import java.util.*;

/**
 * Given a list of pairs of equivalent words synonyms and a sentence text, Return all possible synonymous sentences sorted lexicographically.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input:
 * synonyms = [["happy","joy"],["sad","sorrow"],["joy","cheerful"]],
 * text = "I am happy today but was sad yesterday"
 * Output:
 * ["I am cheerful today but was sad yesterday",
 * "I am cheerful today but was sorrow yesterday",
 * "I am happy today but was sad yesterday",
 * "I am happy today but was sorrow yesterday",
 * "I am joy today but was sad yesterday",
 * "I am joy today but was sorrow yesterday"]
 * Example 2:
 * <p>
 * Input: synonyms = [["happy","joy"],["cheerful","glad"]], text = "I am happy today but was sad yesterday"
 * Output: ["I am happy today but was sad yesterday","I am joy today but was sad yesterday"]
 * Example 3:
 * <p>
 * Input: synonyms = [["a","b"],["c","d"],["e","f"]], text = "a c e"
 * Output: ["a c e","a c f","a d e","a d f","b c e","b c f","b d e","b d f"]
 * Example 4:
 * <p>
 * Input: synonyms = [["a","QrbCl"]], text = "d QrbCl ya ya NjZQ"
 * Output: ["d QrbCl ya ya NjZQ","d a ya ya NjZQ"]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= synonyms.length <= 10
 * synonyms[i].length == 2
 * synonyms[i][0] != synonyms[i][1]
 * All words consist of at most 10 English letters only.
 * text is a single space separated sentence of at most 10 words.
 *
 * @author mkarki
 */
public class SynonymousSentences {
    Map<Integer, List<String>> map = new HashMap();

    public class Graph {
        Set<String> vertices;
        Map<String, List<String>> adj;
        Map<String, Boolean> visited;
        int cmp = 0;

        public Graph(List<List<String>> synonyms) {
            vertices = new HashSet();
            adj = new HashMap();
            visited = new HashMap();

            for (List<String> synonym : synonyms) {
                for (String s : synonym) {
                    if (!adj.containsKey(s)) {
                        vertices.add(s);
                        adj.put(s, new ArrayList());
                        visited.put(s, false);
                    }
                }
            }

            for (List<String> l : synonyms) {
                adj.get(l.get(0)).add(l.get(1));
                adj.get(l.get(1)).add(l.get(0));
            }
        }

        private void dfs(String u) {
            visited.put(u, true);

            if (!map.containsKey(cmp))
                map.put(cmp, new ArrayList());

            map.get(cmp).add(u);

            for (String v : adj.get(u)) {
                if (!visited.get(v))
                    dfs(v);
            }
        }

        public void dfs() {
            for (String vertex : vertices) {
                if (!visited.get(vertex)) {
                    dfs(vertex);
                    cmp++;
                }
            }
        }
    }

    private void backTrack(List<String> list, String s, String[] strs, int index) {
        if (index == strs.length) {
            list.add(s.substring(1));
            return;
        }

        String curr = strs[index];

        for (Map.Entry<Integer, List<String>> m : map.entrySet()) {
            if (m.getValue().contains(curr)) {
                for (String s2 : m.getValue())
                    backTrack(list, s + " " + s2, strs, index + 1);
                return;
            }
        }

        backTrack(list, s + " " + curr, strs, index + 1);
    }

    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        List<String> ans = new ArrayList();
        String[] strs = text.split(" ");

        Graph g = new Graph(synonyms);

        g.dfs();

        for (Map.Entry<Integer, List<String>> m : map.entrySet()) {
            Collections.sort(m.getValue(), Comparator.naturalOrder());
        }

        backTrack(ans, "", strs, 0);
        return ans;
    }


    private Set<String> result = new HashSet<>();
    private Map<String, Integer> synonymLookup = new HashMap<>();

    private List<Set<String>> draftSynonymSet = new ArrayList<>();

    public List<String> generateSentencesII(List<List<String>> synonyms, String text) {
        for (List<String> synonym : synonyms) {
            boolean added = false;
            for (Set<String> draftSet : draftSynonymSet) {
                if (draftSet.contains(synonym.get(0)) || draftSet.contains(synonym.get(1))) {
                    draftSet.add(synonym.get(0));
                    draftSet.add(synonym.get(1));
                    added = true;
                    break;
                }
            }

            if (!added) {
                Set<String> newSynonym = new HashSet<>();
                newSynonym.add(synonym.get(0));
                newSynonym.add(synonym.get(1));
                draftSynonymSet.add(newSynonym);
            }
        }
        // till this point each item in synonyms belong to one of the items in the list ,
        // so that all synonyms for a word are collected in a single row of the the list

        // a lookup map for a word and it's synonym list's index from draftSynonymSet

        for (int i = 0; i < draftSynonymSet.size(); i++) {
            for (String synonym : draftSynonymSet.get(i)) {
                synonymLookup.put(synonym, i);
            }
        }

        // now the main implementation
        String[] textArray = text.split(" ");
        replaceSynonym(0, textArray.length, textArray);

        List<String> resultList = new ArrayList<>(result);
        Collections.sort(resultList);
        return resultList;

    }

    private void replaceSynonym(int startIndex, int numberOfWords, String[] textArray) {
        if (startIndex >= numberOfWords) {
            result.add(String.join(" ", textArray));
            return;
        }

        for (int i = startIndex; i < numberOfWords; i++) {
            if (synonymLookup.containsKey(textArray[i])) {
                //it is a word for replacement
                int synonymSetIndex = synonymLookup.get(textArray[i]);
                for (String draftSynonym : draftSynonymSet.get(synonymSetIndex)) {
                    textArray[i] = draftSynonym;
                    replaceSynonym(i + 1, numberOfWords, textArray);
                }
            }
            //end of string arr is reached
            if (i == numberOfWords - 1) {
                result.add(String.join(" ", textArray));
            }
        }
    }
}
