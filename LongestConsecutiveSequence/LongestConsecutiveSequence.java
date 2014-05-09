//============================================================================
// Longest Consecutive Sequence
// Given an unsorted array of integers, find the length of the longest 
// consecutive elements sequence.
//
// For example,
// Given [100, 4, 200, 1, 3, 2],
// The longest consecutive elements sequence is [1, 2, 3, 4]. Return its 
// length: 4.
//
// Your algorithm should run in O(n) complexity.
//============================================================================

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestConsecutive(int[] num) {
        if (num.length == 0) return 0;
        Map<Integer, Integer> tb = new HashMap<Integer, Integer>();
        int res = 1;
        for (int n : num) {
            if (tb.containsKey(n))
                continue;
            tb.put(n, 1);
            if (tb.containsKey(n - 1))
                res = Math.max(res, merge(tb, n - 1, n));
            if (tb.containsKey(n + 1))
                res = Math.max(res, merge(tb, n, n + 1));
        }
        return res;
    }

    int merge(Map<Integer, Integer> tb, int l, int r) {
        int nl = l - tb.get(l) + 1, nr = r + tb.get(r) - 1;
        int res = nr - nl + 1;
        tb.put(nl, res);
        tb.put(nr, res);
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] num;

        num = new int[] { 100, 4, 200, 1, 3, 2 };
        System.out.println(sol.longestConsecutive(num) + ",4");
        num = new int[] {0};
        System.out.println(sol.longestConsecutive(num) + ",1");
    }
}