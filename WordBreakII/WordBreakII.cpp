
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

#include <iostream>
#include <string>
#include <unordered_set>
#include <vector>

using namespace std;

class Solution {
public:
    vector<string> wordBreak(string s, unordered_set<string> &dict) {
        int N = s.size();
        vector<vector<int> > dp(N, vector<int>());
        for (int j = 0; j < N; j++) {
            for (int i = 0; i <= j; i++) {
                if ((i == 0 || !dp[i - 1].empty()) && dict.count(s.substr(i, j - i + 1))) dp[j].push_back(i);
            }
        }
        vector<vector<string> > memo(N, vector<string>());
        return go(s, N - 1, dp, memo);
    }

    vector<string> go(string & s, int j, vector<vector<int> > & dp, vector<vector<string> > & memo) {
        if (!memo[j].empty()) return memo[j];
        for (int i : dp[j]) {
            if (i == 0) {
                memo[j].push_back(s.substr(i, j - i + 1));
            }
            else {
                auto ps = go(s, i - 1, dp, memo);
                for (auto & p : ps) memo[j].push_back(p + " " + s.substr(i, j - i + 1));
            }
        }
        return memo[j];
    }
};

int main() {
    Solution sol;
    string p0;
    unordered_set<string> p1;

    {
        p0 = "leetcode";
        p1.insert("leet");
        p1.insert("code");
        auto p2 = sol.wordBreak(p0, p1);
        for (auto it : p2) cout << it << endl;
    }

    {
        p0 = "catsanddog";
        p1.insert("cat");
        p1.insert("cats");
        p1.insert("and");
        p1.insert("sand");
        p1.insert("dog");
        auto p2 = sol.wordBreak(p0, p1);
        for (auto it : p2) cout << it << endl;
    }

    {
        p0 = "catsanddogcatsanddog";
        p1.insert("cat");
        p1.insert("cats");
        p1.insert("and");
        p1.insert("sand");
        p1.insert("dog");
        auto p2 = sol.wordBreak(p0, p1);
        for (auto it : p2) cout << it << endl;
    }

    return 0;
}