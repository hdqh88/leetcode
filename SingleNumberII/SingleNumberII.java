//============================================================================
// Given an array of integers, every element appears three times except for 
// one. Find that single one.
//
// Note:
// Your algorithm should have a linear runtime complexity. Could you implement 
// it without using extra memory?
//============================================================================

public class Solution {
    public int singleNumber(int[] A) {
        int res = 0;
        for (int j = 0; j < 32; j++) {
            int cnt = 0;
            for (int i = 0; i < A.length; i++) {
                if ((A[i] & (1 << j)) != 0) cnt++;
            }
            if (cnt % 3 == 1) res |= (1 << j);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] A = new int[]{2, 2, 3, 2};
        System.out.println(sol.singleNumber(A));
    }
}