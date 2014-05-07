//============================================================================
// Given a string s and a dictionary of words dict, add spaces in s to 
// construct a sentence where each word is a valid dictionary word.
//
// Return all such possible sentences.
//
// For example, given
// s = "catsanddog",
// dict = ["cat", "cats", "and", "sand", "dog"].
//
// A solution is ["cats and dog", "cat sand dog"].
//
// Complexity:
// O(n^2) time, O(n^2) space
//============================================================================

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        int N = s.length();
        List<List<Integer>> dp = new ArrayList<List<Integer>>();
        for (int i = 0; i < N; i++)
            dp.add(new ArrayList<Integer>());
        for (int j = 0; j < N; j++) {
            for (int i = 0; i <= j; i++) {
                if ((i == 0 || !dp.get(i - 1).isEmpty())
                        && dict.contains(s.substring(i, j + 1))) {
                    dp.get(j).add(i);
                }
            }
        }
        List<ArrayList<String>> memo = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < N; i++)
            memo.add(new ArrayList<String>());
        return go(s, N - 1, dp, memo);
    }

    private ArrayList<String> go(String s, int j, List<List<Integer>> dp,
            List<ArrayList<String>> memo) {
        if (!memo.get(j).isEmpty())
            return memo.get(j);
        for (Integer i : dp.get(j)) {
            if (i == 0) {
                memo.get(j).add(s.substring(i, j + 1));
            } else {
                ArrayList<String> ps = go(s, i - 1, dp, memo);
                for (String p : ps)
                    memo.get(j).add(p + " " + s.substring(i, j + 1));
            }
        }
        return memo.get(j);
    }

    private static void print(List<String> res) {
        for (String str : res)
            System.out.println(str);
        System.out.println();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        Set<String> dict;

        dict = new HashSet<String>(Arrays.asList("leet", "code"));
        print(sol.wordBreak("leetcode", dict));

        dict = new HashSet<String>(Arrays.asList("cat", "cats", "and", "sand",
                "dog"));
        print(sol.wordBreak("catsanddog", dict));

        dict = new HashSet<String>(Arrays.asList("cat", "cats", "and", "sand",
                "dog"));
        print(sol.wordBreak("catsanddogcatsanddog", dict));
    }
}