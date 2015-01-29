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
        int first = 0, last = n - 1;
        while (first <= last) {
            int mid = first + (last - first)/2;
            if (A[mid] == target)
                return mid;
            if (A[mid] < target) 
                first = mid + 1;
            else 
                last = mid - 1;
        }
        return first;
    }
};

int main() {
    return 0;
}
