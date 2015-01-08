
//===============================================================================================================
//Find the contiguous subarray within an array (containing at least one number) which has the largest product.
//For example, given the array [2,3,-2,4],
//the contiguous subarray [2,3] has the largest product = 6.
//===============================================================================================================

class Solution {
public:
int maxProduct(int A[], int n) {
        if(n<1) return 0;
        int res, Pmax, Pmin;
        res = Pmax = Pmin = A[0];
        for(int i=1; i<n; i++) {
            int temp = max(max(Pmax*A[i],Pmin*A[i]),A[i]);//A
            Pmin = min(min(Pmax*A[i],Pmin*A[i]),A[i]);//B
            Pmax = temp;
            res = Pmax>res ? Pmax : res;
        }
        return res;
    }
};
