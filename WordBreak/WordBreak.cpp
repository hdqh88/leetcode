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

#include <iostream>
#include <vector>
#include <string>
#include <unordered_set>

using namespace std;

class Solution {
public:
    bool wordBreak(string s, unordered_set<string> &dict) {
        if (s.empty()) return false;
        int N = s.size();
        vector<bool> dp(N, false);
        for (int j = 0; j < N; j++) {
            for (int i = 0; i <= j; i++) {
                if ((i == 0 || dp[i - 1]) && dict.count(s.substr(i, j - i + 1))) {
                    dp[j] = true;
                    break;
                }
            }
        }
        return dp[N - 1];
    }
};

int main() {
    Solution sol;
    unordered_set<string> dict = { "leet", "code" };
    cout << sol.wordBreak("leetcode", dict) << endl;
    return 0;
}