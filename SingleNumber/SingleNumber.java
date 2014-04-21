//============================================================================
// Given an array of integers, every element appears twice except for one. 
// Find that single one.
//
// Note:
// Your algorithm should have a linear runtime complexity. Could you implement 
// it without using extra memory?
//============================================================================

public class Solution {
    public int singleNumber(int[] A) {
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            res ^= A[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] A = { 1, 1, 2, 3, 3, 4, 4 };
        System.out.println(sol.singleNumber(A));
    }
}