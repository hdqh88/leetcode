//============================================================================
// Spiral Matrix II
// Given an integer n, generate a square matrix filled with elements from 1 to
// n2 in spiral order.
//
// For example,
// Given n = 3,
//
// You should return the following matrix:
// [
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
// ]
//
// Complexity:
// O(n^2)
//============================================================================


#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<vector<int> > generateMatrix(int n) {
        vector<vector<int> > res;
        if (n <= 0) return res;
        for (int i = 0; i < n; i++) res.push_back(vector<int>(n, 0));
        for (int k = 0, v = 1; n > 0; k++, n -= 2) {
            int i = 0, j = 0;
            if (n == 1) {
                res[k + i][k + j] = v++;
                return res;
            }

            for (; j < n - 1; j++) res[k + i][k + j] = v++;
            for (; i < n - 1; i++) res[k + i][k + j] = v++;
            for (; j > 0; j--) res[k + i][k + j] = v++;
            for (; i > 0; i--) res[k + i][k + j] = v++;
        }
        return res;
    }
    
    
    
    // Hao
    vector<vector<int> > generateMatrix2(int n) {
        vector<vector<int> > matrix(n, vector<int>(n));
        int begin = 0;
        int end = n - 1;
        int num = 1;
        int i, j;
        while(begin < end){
            for(j = begin; j < end; j++)
                matrix[begin][j] = num++;
            for(i = begin; i < end; i++)
                matrix[i][end] = num++;
            for(j = end; j > begin; j--)
                matrix[end][j] = num++;
            for(i = end; i > begin; i--)
                matrix[i][begin] = num++;
            begin++;
            end--;
        }
        if(begin == end)
            matrix[begin][begin] = num;
        return matrix;
    }
};




int main() {
    Solution sol;
    int p0;

    {
        p0 = 3;
        auto p1 = sol.generateMatrix(p0);
        for (auto it1 : p1) {
            for (auto it2 : it1) cout << it2 << " ";
            cout << endl;
        }

    }

    return 0;
}
