//============================================================================
// Given an array S of n integers, are there elements a, b, c in S such that
// a + b + c = 0?
// Find all unique triplets in the array which gives the sum of zero.
//
// Note:
// Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
// The solution set must not contain duplicate triplets.
// For example, given array S = {-1 0 1 2 -1 -4},
//
// A solution set is:
// (-1, 0, 1)
// (-1, -1, 2)
//
// Complexity:
// O(n^2) time, O(1) space
//============================================================================

#include <iostream>
#include <vector>
#include <algorithm>
#include <unordered_map>

using namespace std;

class Solution {
public:
    vector<vector<int> > threeSum(vector<int> &num) {
        return threeSum2(num);
    }

    vector<vector<int> > threeSum1(vector<int> &num) {
        vector<vector<int> > res;
        int N = num.size();
        if (N < 3) return res;
        sort(begin(num), end(num));
        for (int k = 0; k < N - 2; k++) {
            if (k > 0 && num[k - 1] == num[k]) continue;
            int i = k + 1, j = N - 1;
            while (i < j) {
                int sum = num[k] + num[i] + num[j];
                if (sum < 0) i++;
                else if (sum > 0) j--;
                else {
                    res.push_back(vector<int>({ num[k], num[i], num[j] }));
                    do { i++; } while (i < j && num[i - 1] == num[i]);
                    do { j--; } while (i < j && num[j] == num[j + 1]);
                }
            }
        }
        return res;
    }

    vector<vector<int> > threeSum2(vector<int> &num) {
        vector<vector<int> > res;
        int N = num.size();
        if (N < 3) return res;
        unordered_multimap<int, int> tb;
        for (int i = 0; i < N; i++) tb.insert(make_pair(num[i], i));
        for (int i = 0; i < N; i++) {
            int target = -num[i];
            for (auto it1 = tb.begin(); it1 != tb.end(); it1++) {
                int j = it1->second;
                if (i == j) continue;
                auto range = tb.equal_range(target - it1->first);
                for (auto it2 = range.first; it2 != range.second; it2++) {
                    int k = it2->second;
                    if (j == k) continue;
                    vector<int> path = { num[i], num[j], num[k] };
                    sort(begin(path), end(path));
                    if (find(begin(res), end(res), path) == end(res)) res.push_back(path);
                }
            }
        }
        return res;
    }
};

int main() {
    Solution sol;
    vector<int> p0;
    vector<vector<int> > p1;

    {
        p0 = { -1, 0, 1, 2, -1, -4 };
        p1 = sol.threeSum(p0);
        for (auto it1 : p1) {
            for (auto it2 : it1) cout << it2 << " ";
            cout << endl;
        }
        cout << endl;
    }

    {
        p0 = { -2, 0, 1, 1, 2 };
        p1 = sol.threeSum(p0);
        for (auto it1 : p1) {
            for (auto it2 : it1) cout << it2 << " ";
            cout << endl;
        }
        cout << endl;
    }

    return 0;
}