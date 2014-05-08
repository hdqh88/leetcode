//============================================================================
// Palindrome Partitioning
// Given a string s, partition s such that every substring of the partition 
// is a palindrome.
//
// Return all possible palindrome partitioning of s.
//
// For example, given s = "aab",
// Return
//
//   [
//       ["aa","b"],
//       ["a","a","b"]
//   ]
//
// Complexity:
// Recursion + Memoization, O(n^2) time,  O(n^3) space
// DP, O(n^2) time, O(n^3) space
//============================================================================

public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        int N = s.length();
        boolean[][] dp1 = new boolean[N][N];
        ArrayList<ArrayList<ArrayList<String>>> dp2 = new ArrayList<ArrayList<ArrayList<String>>>();
        for (int j = 0; j < N; j++) {
            dp2.add(new ArrayList<ArrayList<String>>());
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j)
                        && (j - i < 2 || dp1[i + 1][j - 1])) {
                    dp1[i][j] = true;
                    if (i == 0) {
                        ArrayList<String> p = new ArrayList<String>();
                        p.add(s.substring(i, j + 1));
                        dp2.get(j).add(p);
                    } else {
                        for (ArrayList<String> p1 : dp2.get(i - 1)) {
                            ArrayList<String> p2 = new ArrayList<String>(p1);
                            p2.add(s.substring(i, j + 1));
                            dp2.get(j).add(p2);
                        }
                    }
                }
            }
        }

        return dp2.get(N - 1);
    }

    private static void print(Object... objs) {
        System.out.println(Arrays.deepToString(objs));
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        print(sol.partition("aab"));
        print(sol.partition("a"));
        print(sol.partition("abba"));
    }
}