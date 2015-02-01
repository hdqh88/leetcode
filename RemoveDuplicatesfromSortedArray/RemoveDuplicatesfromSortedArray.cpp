//============================================================================
// Remove Duplicates from Sorted Array
// Given a sorted array, remove the duplicates in place such that each element
// appear only once and return the new length.
//
// Do not allocate extra space for another array, you must do this in place
// with constant memory.
//
// For example,
// Given input array A = [1,1,2],
//
// Your function should return length = 2, and A is now [1,2].
//
// Complexity
// O(n) time
//============================================================================

class Solution {
public:
    int removeDuplicates(int A[], int n) {
        if (n < 2) return n;
        int j = 1;
        for (int i = 1; i < n; i++) if (A[j - 1] != A[i]) A[j++] = A[i];
        return j;
    }
    
   // Hao
   int removeDuplicates2(int A[], int n) {
       if(n <= 1)
            return n;
        int index = 0;
        for(int i = 1; i < n; i++){
            if(A[i] != A[index])
                A[++index] = A[i];
        }
        return index + 1;
   } 
};

int main() {
    return 0;
}
