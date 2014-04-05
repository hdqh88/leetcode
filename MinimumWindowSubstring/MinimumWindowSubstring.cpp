//============================================================================
// Given a string S and a string T, find the minimum window in S which will
// contain all the characters in T in complexity O(n).
//
// For example,
// S = "ADOBECODEBANC"
// T = "ABC"
// Minimum window is "BANC".
//
// Note:
// If there is no such window in S that covers all characters in T, return the
// empty string "".
//
// If there are multiple such windows, you are guaranteed that there will
// always be only one unique minimum window in S.
//
// Complexity:
// O(n)
//============================================================================

#include <algorithm>
#include <iostream>
#include <climits>

using namespace std;

class Solution {
public:
    string minWindow(string S, string T) {
        int toFind[256] = { 0 }, hasFound[256] = { 0 };
        for (char c : T) toFind[c]++;
        int mini = -1, minl = INT_MAX, cnt = 0;
        for (int begin = 0, end = 0; end < S.size(); end++) {
            if (toFind[S[end]] == 0) continue;
            hasFound[S[end]]++;
            if (hasFound[S[end]] <= toFind[S[end]]) cnt++;
            if (cnt == T.size()) {
                while (toFind[S[begin]] == 0 || hasFound[S[begin]] > toFind[S[begin]]) {
                    if (toFind[S[begin]] != 0) hasFound[S[begin]]--;
                    begin++;
                }
                int len = end - begin + 1;
                if (len < minl) minl = len, mini = begin;
            }
        }
        return mini == -1 ? "" : S.substr(mini, minl);
    }
};

int main() {

    {
        Solution sol;
        cout << sol.minWindow("ADOBECODEBANC", "ABC") << endl;
    }
    return 0;
}
