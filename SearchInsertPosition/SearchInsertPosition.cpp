//============================================================================
// Search Insert Position
//
// Given a sorted array and a target value, return the index if the target is
// found. If not, return the index where it would be if it were inserted in order.
//
// You may assume no duplicates in the array.
//
// Here are few examples.
// [1,3,5,6], 5 → 2
// [1,3,5,6], 2 → 1
// [1,3,5,6], 7 → 4
// [1,3,5,6], 0 → 0
// 
// Complexity
// log(n) time
//============================================================================

#include <iostream>
using namespace std;

class Solution {
public:
    int searchInsert(int A[], int n, int target) {
        int start = 0, end = n-1;
        while (start < end) {
            int middle = start + (end - start)/2;
            if (A[middle] < target) 
                start = middle + 1;
            else 
                end = middle;
        }
        if (A[end] < target) 
            return n;
        return end;
    }
};

int main() {
    return 0;
}
