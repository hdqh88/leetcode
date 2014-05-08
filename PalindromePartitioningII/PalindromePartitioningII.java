//============================================================================
// Palindrome Partitioning II
// Given a string s, partition s such that every substring of the partition 
// is a palindrome.
//
// Return the minimum cuts needed for a palindrome partitioning of s.
//
// For example, given s = "aab",
// Return 1 since the palindrome partitioning ["aa","b"] could be produced 
// using 1 cut.
//
// Complexity:
// O(n^2) time, O(n^2) space
//============================================================================


public class Solution {
    public int minCut(String s) {
        int N = s.length();
        boolean[][] dp1 = new boolean[N][N];
        int[] dp2 = new int[N];
        for (int i = 0; i < N; i++) dp2[i] = N;
        for (int j = 0; j < N; j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j-i < 2 || dp1[i+1][j-1])) {
                    dp1[i][j] = true;
                    dp2[j] = (i == 0) ? 0 : Math.min(dp2[j], dp2[i-1] + 1);
                }
            }
        }
        return dp2[N-1];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minCut("aab"));
        System.out.println(sol.minCut("a"));
    }
}