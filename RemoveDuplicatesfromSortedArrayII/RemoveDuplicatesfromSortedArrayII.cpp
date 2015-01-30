//============================================================================
// Remove Duplicates from Sorted Array II
// Follow up for "Remove Duplicates":
// What if duplicates are allowed at most twice?
//
// For example,
// Given sorted array A = [1,1,1,2,2,3],
//
// Your function should return length = 5, and A is now [1,1,2,2,3].
//
// Complexity
// O(n) time
//============================================================================

class Solution {
public:
    int removeDuplicates(int A[], int n) {
        int N = 2;
        if(n <= N)
            return n;
        int index = N;
        for(int i = N; i < n; i++)
            if(A[index - N] != A[i])
                A[index++] = A[i];
        return index;
    }
};

int main() {
    return 0;
}
