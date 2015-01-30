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
    
    
    
    int removeDuplicates2(int A[], int n){
        int N = 2;
        if(n < N)
            return n;
        int index = 0;
        int dup = 1;
        for(int i = 1; i < n; i++){
            if(A[index] != A[i]){
                A[++index] = A[i];
                dup = 1;
            }
            else if(dup < N){
                A[++index] = A[i];
                dup++;
            }
        }
        return index + 1;
    }
};

int main() {
    return 0;
}
