//============================================================================
// Best Time to Buy and Sell Stock
// 
// Say you have an array for which the ith element is the price of a given 
// stock on day i.
//
// Design an algorithm to find the maximum profit. You may complete at most 
// two transactions.
//
// Note:
// You may not engage in multiple transactions at the same time (ie, you must 
// sell the stock before you buy again).
//
// Complexity:
// O(n)
//============================================================================

public class Solution {
    public int maxProfit(int[] prices) {
        int N = prices.length;
        if (N < 2)
            return 0;
        int[] ls = new int[N], rs = new int[N];
        int pmin = prices[0], pmax = prices[N - 1];
        for (int i = 1; i < N; i++) {
            ls[i] = Math.max(ls[i - 1], prices[i] - pmin);
            pmin = Math.min(pmin, prices[i]);
        }
        for (int i = N - 2; i >= 0; i--) {
            rs[i] = Math.max(rs[i + 1], pmax - prices[i]);
            pmax = Math.max(pmax, prices[i]);
        }

        int res = 0;
        for (int i = 0; i < N; i++) {
            res = Math.max(res, ls[i] + rs[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] prices = new int[] { 2, 1, 2, 0, 1 };
        System.out.println(sol.maxProfit(prices));
    }
}