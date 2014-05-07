//============================================================================
// Given a string s and a dictionary of words dict, determine if s can be 
// segmented into a space-separated sequence of one or more dictionary words.
//
// For example, given
// s = "leetcode",
// dict = ["leet", "code"].
//
// Return true because "leetcode" can be segmented as "leet code".
//
// Complexity:
// O(n^2) time, O(n) space
//============================================================================

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if (s.isEmpty()) return false;
        int N = s.length();
        boolean[] dp = new boolean[N];
        for (int j = 0; j < N; j++) {
            for (int i = 0; i <= j; i++) {
                if ((i == 0 || dp[i - 1])
                        && dict.contains(s.substring(i, j + 1))) {
                    dp[j] = true;
                    break;
                }
            }
        }
        return dp[N - 1];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        Set<String> dict;

        dict = new HashSet<String>(Arrays.asList("leet", "code"));
        System.out.println(sol.wordBreak("leetcode", dict));

        dict = new HashSet<String>(Arrays.asList("cat", "cats", "and", "sand",
                "dog"));
        System.out.println(sol.wordBreak("catsanddog", dict));

        dict = new HashSet<String>(Arrays.asList("cat", "cats", "and", "sand",
                "dog"));
        System.out.println(sol.wordBreak("catsanddogcatsanddog", dict));
    }
}