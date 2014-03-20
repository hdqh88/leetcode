//============================================================================
// 4Sum
// Given an array S of n integers, are there elements a, b, c, and d in S such
// that a + b + c + d = target?
// Find all unique quadruplets in the array which gives the sum of target.
// Note:
// Elements in a quadruplet (a,b,c,d) must be in non-descending order.
// (ie, a ≤ b ≤ c ≤ d)
// The solution set must not contain duplicate quadruplets.
// For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
// A solution set is:
// (-1,  0, 0, 1)
// (-2, -1, 1, 2)
// (-2,  0, 0, 2)
//
// Complexity: 
// O(n^3) time, O(1) space
//============================================================================

#include <iostream>
#include <vector>
#include <algorithm>
#include <unordered_map>

using namespace std;

class Solution {
public:
    vector<vector<int> > fourSum(vector<int> &num, int target) {
        return fourSum1(num, target);
    }

    vector<vector<int> > fourSum1(vector<int> &num, int target) {
        vector<vector<int> > res;
        int N = num.size();
        if (N < 4) return res;
        sort(begin(num), end(num));
        for (int i = 0; i < N - 3; i++) {
            if (i > 0 && num[i] == num[i - 1]) continue;
            for (int j = i + 1; j < N - 2; j++) {
                if (j > i + 1 && num[j] == num[j - 1]) continue;
                int r = j + 1, c = N - 1;
                while (r < c) {
                    int sum = num[i] + num[j] + num[r] + num[c];
                    if (sum < target) r++;
                    else if (sum > target) c--;
                    else {
                        res.push_back(vector<int>({ num[i], num[j], num[r], num[c] }));
                        do { r++; } while (r < c && num[r] == num[r - 1]);
                        do { c--; } while (r < c && num[c] == num[c + 1]);
                    }
                }
            }
        }
        return res;
    }

    vector<vector<int> > fourSum2(vector<int> &num, int target) {
        vector<vector<int> > res;
        int N = num.size();
        if (N < 4) return res;
        unordered_multimap<int, pair<int, int> > tb;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                tb.insert(make_pair(num[i] + num[j], make_pair(i, j)));
            }
        }
        for (auto it1 = tb.begin(); it1 != tb.end(); it1++) {
            auto range = tb.equal_range(target - it1->first);
            for (auto it2 = range.first; it2 != range.second; it2++) {
                int a = it1->second.first, b = it1->second.second, c = it2->second.first, d = it2->second.second;
                if (a == c || a == d || b == c || b == d) continue;
                vector<int> path = { num[a], num[b], num[c], num[d] };
                sort(begin(path), end(path));
                if (find(res.begin(), res.end(), path) == res.end()) res.push_back(path);
            }
        }
        return res;
    }
};

int main() {
    Solution sol;
    vector<int> p0;
    int p1;
    vector<vector<int> > p2;

    {
        p0 = { 1, 0, -1, 0, -2, 2 };
        p1 = 0;
        p2 = sol.fourSum(p0, p1);
        for (auto it1 : p2) {
            for (auto it2 : it1) cout << it2 << " ";
            cout << endl;
        }
        cout << endl;
    }

    return 0;
}