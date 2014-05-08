//============================================================================
// There are N gas stations along a circular route, where the amount of gas 
// at station i is gas[i].
//
// You have a car with an unlimited gas tank and it costs cost[i] of gas to 
// travel from station i to its next station (i+1). You begin the journey 
// with an empty tank at one of the gas stations.
//
// Return the starting gas station's index if you can travel around the 
// circuit once, otherwise return -1.
//
// Note:
// The solution is guaranteed to be unique.
//
// Complexity:
// O(n)
//============================================================================

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0, total = 0, res = 0;
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            sum += diff;
            total += diff;
            if (sum < 0) {
                sum = 0;
                res = i + 1;
            }
        }
        return total < 0 ? -1 : res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] gas = new int[] { 1, 2, 3, 2, 3, 1 };
        int[] cost = new int[] { 2, 2, 2, 2, 2, 2 };
        System.out.println(sol.canCompleteCircuit(gas, cost));
    }
}