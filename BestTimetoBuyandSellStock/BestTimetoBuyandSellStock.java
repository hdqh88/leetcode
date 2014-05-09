//============================================================================
// Best Time to Buy and Sell Stock
//
// Say you have an array for which the ith element is the price of a given
// stock on day i.
//
// If you were only permitted to complete at most one transaction (ie, buy
// one and sell one share of the stock), design an algorithm to find the
// maximum profit.
//
// Complexity:
// O(n)
//============================================================================

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int minp = prices[0], res = 0;
        for (int i = 1; i < prices.length; i++) {
            res = Math.max(res, prices[i]- minp);
            minp = Math.min(minp, prices[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] prices = new int[] { 2, 1, 2, 0, 1 };
        System.out.println(sol.maxProfit(prices));
    }
}