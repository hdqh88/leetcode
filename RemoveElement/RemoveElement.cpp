//============================================================================
// Remove Element
// Given an array and a value, remove all instances of that value in place
// and return the new length.
//
// The order of elements can be changed. It doesn't matter what you leave
// beyond the new length.
//
// Complexity
// O(n) time
//============================================================================

class Solution {
public:
    int removeElement(int A[], int n, int elem) {
        int i = 0, j = 0;
        while (i < n) {
            if (A[i] != elem) A[j++] = A[i];
            i++;
        }
        return j;
    }
    
    
    // Hao
    int removeElement2(int A[], int n, int elem) {
        int index = 0;
        for(int i = 0; i < n; i++){
            if(A[i] != elem)
                A[index++] = A[i];
        }
        return index;
    }
};

int main() {
    return 0;
}
